package com.lnsf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lnsf.entity.CommentEntity;
import com.lnsf.dto.CommentDTO;
import com.lnsf.dao.CommentMapper;
import com.lnsf.entity.HousesEntity;
import com.lnsf.entity.OrderListEntity;
import com.lnsf.entity.UserInfoEntity;
import com.lnsf.service.CommentService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.hutool.core.bean.BeanUtil;
import com.lnsf.service.HousesService;
import com.lnsf.service.OrderListService;
import com.lnsf.service.UserInfoService;
import com.lnsf.vo.CommentListVO;
import com.lnsf.vo.CommentVO;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 *  服务实现类
 *
 * @author 黄润志
 * @since 2020-03-10 19:32
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private OrderListService orderListService;
    @Autowired
    private HousesService housesService;
    /*查看评论列表*/
    @Override
    public CommentListVO list(Integer houserId){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("house_id",houserId);
        wrapper.eq("is_del",false);
        List<CommentEntity> commentEntityList = commentMapper.selectList(wrapper);
        CommentListVO commentListVO = new CommentListVO();
        List<CommentVO> commentVOs = new ArrayList<>();
        float num=0;
        double fenshu=0;
        double nums=0;
        for (CommentEntity c:commentEntityList) {
            CommentVO commentVO = new CommentVO();
            commentVO.setCommentContent(c.getCommentContent());
            if (null==c.getCommentPhoto()){
                commentVO.setIsPhoto(false);
            }else {
                commentVO.setIsPhoto(true);
                commentVO.setCommentPhoto(c.getCommentPhoto());
            }
            commentVO.setCommentPower(c.getCommentPower());
            commentVO.setCreateTime(c.getCreateTime());
            /*查询用户头像名字放进去*/
            UserInfoEntity entity = userInfoService.getUserById(c.getUserId());
            commentVO.setUsername(entity.getUsername());
            commentVO.setUserPhoto(entity.getUserBackup2());
            fenshu+=c.getCommentPower();
            num++;
            commentVOs.add(commentVO);
        }
        if (num!=0) {
           nums = fenshu / num;
        }
        commentListVO.setCommentVO(commentVOs);
        commentListVO.setCount(nums);
        /*判断是否有数据*/
        if (nums==0){
            commentListVO.setIsData(false);
        }else {
            commentListVO.setIsData(true);
        }
        return commentListVO;
    }

    @Override
    public CommentEntity getComment(Long commentId){
        return commentMapper.selectById(commentId);
    }


    @Override
    public CommentEntity create(CommentDTO dto) {
        if (null == dto) {
            throw new ServiceException("参数为空!");
        }
        CommentEntity entity = new CommentEntity();
        BeanUtil.copyProperties(dto, entity);
        commentMapper.insert(entity);
        /*更新房源分数*/
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("house_id",dto.getHouseId());
        wrapper.eq("is_del",false);
        List<CommentEntity> commentEntityList = commentMapper.selectList(wrapper);
        float num=0;
        double fenshu=0;
        double nums=0;
        for (CommentEntity c:commentEntityList) {
            fenshu+=c.getCommentPower();
            num++;
        }
        if (num!=0) {
            nums = fenshu / num;
        }
        HousesEntity housesEntity = new HousesEntity();
        housesEntity.setHousesId(dto.getHouseId());
        housesEntity.setHousesFarction(nums);
        housesService.updateHouses(housesEntity);
        /*更新订单评价状态*/
        OrderListEntity orderListEntity=orderListService.getOrderList(dto.getOrderId());
        orderListEntity.setIsComment(true);
        orderListService.updateById(orderListEntity);
        return entity;
    }

    @Override
    public String deletUpdate(Long commentId) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setCommentId(commentId);
        commentEntity.setIsDel(true);
       int num = commentMapper.updateById(commentEntity);
       if (num>0){
           return "删除成功";
       }else {
           return "删除失败";
       }
    }

    @Override
    public CommentEntity update(Long commentId, CommentDTO dto) {
        if (null == commentId) {
            return null;
        }
        CommentEntity existEntity = commentMapper.selectById(commentId);
        if (null == existEntity) {
            return null;
        }
        BeanUtil.copyProperties(dto, existEntity);
        commentMapper.updateById(existEntity);
        return existEntity;
    }

    @Override
    public IPage<CommentEntity> getHousesCommentPage(Integer housesId,Integer page) {
        IPage<CommentEntity> ipage = new Page<>(page, 8);
        CommentEntity commentEntity = new CommentEntity();
        QueryWrapper<CommentEntity> wrapper = new QueryWrapper<>(commentEntity);
        IPage<CommentEntity> pages =null;
        if (housesId==-1){
            wrapper.eq("is_del",false);
            wrapper.isNull("reply_id");
            wrapper.orderByDesc("create_time");
            pages= commentMapper.selectPage(ipage,wrapper);
        }else {
            wrapper.eq("is_del",false);
            wrapper.eq("house_id",housesId);
            wrapper.isNull("reply_id");
            wrapper.orderByDesc("create_time");
            pages=commentMapper.selectPage(ipage,wrapper);
        }
        return pages;
    }
    /*查看评论的回复*/
    public List<CommentEntity> commentReplayList(Long commentId){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("reply_id",commentId);
        wrapper.eq("is_del",false);
       return  commentMapper.selectList(wrapper);
    }

}
