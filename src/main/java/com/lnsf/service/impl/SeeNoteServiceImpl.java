package com.lnsf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lnsf.entity.SeeNoteEntity;
import com.lnsf.dto.SeeNoteDTO;
import com.lnsf.dao.SeeNoteMapper;
import com.lnsf.service.SeeNoteService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.hutool.core.bean.BeanUtil;
import com.lnsf.util.DateUtil;
import com.lnsf.vo.SeeListVO;
import com.lnsf.vo.SeeVo;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  服务实现类
 *
 * @author 黄润志
 * @since 2020-03-26 15:11
 */
@Service
public class SeeNoteServiceImpl implements SeeNoteService {

    @Autowired
    private SeeNoteMapper seeNoteMapper;

    @Override
    public SeeListVO SeeVo(){
        List<SeeVo> seeVos = new ArrayList<>();
        String day = DateUtil.dayago();
        QueryWrapper wrapper1 = new QueryWrapper();
        wrapper1.ge("create_time",day);
        wrapper1.orderByDesc("create_time");
        List<SeeNoteEntity> seeNoteEntitie1 = seeNoteMapper.selectList(wrapper1);
        QueryWrapper wrapper2 = new QueryWrapper();
        wrapper2.ge("create_time",day);
        wrapper2.groupBy("houses_id");
        List<SeeNoteEntity> seeNoteEntities2 = seeNoteMapper.selectList(wrapper2);
        List<Date> dates = new ArrayList<>();
        for (SeeNoteEntity see: seeNoteEntities2) {
            List<Integer> date = new ArrayList<>();
            SeeVo seeVo = new SeeVo();
            seeVo.setName(see.getHousesTitle());
            for (SeeNoteEntity seedate:seeNoteEntitie1) {
                if (seedate.getHousesId()==see.getHousesId()){
                   date.add(seedate.getSeeNum());
                }
            }
            seeVo.setData(date);
            seeVos.add(seeVo);
        }
        QueryWrapper wrapper3 = new QueryWrapper();
        wrapper3.ge("create_time",day);
        wrapper3.groupBy("create_time");
        List<SeeNoteEntity> seeNoteEntities3 = seeNoteMapper.selectList(wrapper3);
        for (SeeNoteEntity se: seeNoteEntities3) {
            dates.add(se.getCreateTime());
        }
        SeeListVO seeListVO = new SeeListVO();
        seeListVO.setSeeVos(seeVos);
        seeListVO.setDates(dates);
        return seeListVO;
    }
    @Override
    public SeeNoteEntity create(SeeNoteDTO dto) {
        if (null == dto) {
            throw new ServiceException("参数为空!");
        }
        SeeNoteEntity entity = new SeeNoteEntity();
        BeanUtil.copyProperties(dto, entity);
        seeNoteMapper.insert(entity);
        return entity;
    }

}
