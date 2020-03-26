package com.lnsf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lnsf.entity.MenuEntity;
import com.lnsf.dto.MenuDTO;
import com.lnsf.dao.MenuMapper;
import com.lnsf.service.MenuService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.hutool.core.bean.BeanUtil;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 *  服务实现类
 *
 * @author 黄润志
 * @since 2020-03-15 22:11
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public MenuEntity getMenu(Integer menuId){
        return menuMapper.selectById(menuId);
    }

    @Override
    public List<MenuEntity> getMenuList(String userPower){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.le("user_power",userPower);
        wrapper.gt("user_power",-1);
        wrapper.eq("is_del",false);
        return menuMapper.selectList(wrapper);
    }
    /*查询所有菜单*/
    @Override
    public List<MenuEntity> getAllMenuList(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("is_del",false);
        return menuMapper.selectList(wrapper);
    }
    /*管理员菜单*/
    @Override
    public List<MenuEntity> getAdminMenuList(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_power",3);
        return menuMapper.selectList(wrapper);
    }
    /*删除更新*/
    @Override
    public String deleteUpdate(Integer menuId){
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setMenuId(menuId);
        menuEntity.setIsDel(true);
       int num = menuMapper.updateById(menuEntity);
       if (num>0){
           return "删除成功";
       }else {
           return "删除失败";
       }
    }
    /*添加*/
    @Override
    public MenuEntity create(MenuDTO dto) {
        if (null == dto) {
            throw new ServiceException("参数为空!");
        }
        MenuEntity entity = new MenuEntity();
        BeanUtil.copyProperties(dto, entity);
        menuMapper.insert(entity);
        return entity;
    }
    /*判断菜单名称的唯一性*/
    @Override
    public boolean menuProcinceIsExist(String menuProcince){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("menu_procince",menuProcince);
        wrapper.eq("is_del",false);
        MenuEntity menuEntity = menuMapper.selectOne(wrapper);
        if (null== menuEntity){
            return false;
        }else {
            return true;
        }
    }
    /*判断菜单的请求路径的唯一性*/
    @Override
    public boolean menuRequestIsExist(String menuRequest){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("menu_request",menuRequest);
        wrapper.eq("is_del",false);
        MenuEntity menuEntity = menuMapper.selectOne(wrapper);
        if (null== menuEntity){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void delete(Integer menuId) {
        if (null == menuId) {
            return;
        }
        menuMapper.deleteById(menuId);
    }
    /*更新*/
    @Override
    public MenuEntity update(Integer menuId, MenuDTO dto) {
        if (null == menuId) {
            return null;
        }
        MenuEntity existEntity = menuMapper.selectById(menuId);
        if (null == existEntity) {
            return null;
        }
        BeanUtil.copyProperties(dto, existEntity);
        menuMapper.updateById(existEntity);
        return existEntity;
    }

    @Override
    public List<MenuEntity> page(MenuDTO dto, IPage<MenuEntity> page) {
        return menuMapper.page(dto, page);
    }

}
