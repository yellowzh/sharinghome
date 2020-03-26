package com.lnsf.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lnsf.dto.MenuDTO;
import com.lnsf.entity.MenuEntity;

import java.util.List;


/**
 *  服务类
 *
 * @author 黄润志
 * @since 2020-03-15 22:11
 */
public interface MenuService {
    /*根据权限查询菜单*/
    List<MenuEntity> getMenuList(String userPower);
    /*查询所有菜单*/
    List<MenuEntity> getAllMenuList();
    /*管理员菜单*/
    List<MenuEntity> getAdminMenuList();
    /*删除更新*/
    String deleteUpdate(Integer menuId);
    /*创建菜单*/
    MenuEntity create(MenuDTO dto);
    /*获取单个菜单*/
    MenuEntity getMenu(Integer menuId);
    /*判断菜单名称的唯一性*/
    boolean menuProcinceIsExist(String menuProcince);
    /*判断菜单的请求路径的唯一性*/
    boolean menuRequestIsExist(String menuRequest);

    void delete(Integer menuId);

    MenuEntity update(Integer menuId, MenuDTO dto);

    List<MenuEntity> page(MenuDTO dto, IPage<MenuEntity> page);

}
