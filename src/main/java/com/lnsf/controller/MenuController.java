package com.lnsf.controller;

import com.lnsf.entity.UserInfoEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lnsf.entity.MenuEntity;
import com.lnsf.service.MenuService;
import java.util.List;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lnsf.dto.MenuDTO;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;



/**
 *  前端控制器
 *
 * @author 黄润志
 * @since 2020-03-15 22:11
 */

@Api(tags = "")
@RestController
@RequestMapping("/api")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation("根据id查询菜单")
    @GetMapping("/getMenuById")
    public MenuEntity getMenuById(Integer menuId){
        return menuService.getMenu(menuId);
    }
    @ApiOperation("获取菜单列表")
    @GetMapping(path = "/getMenuList")
    public List<MenuEntity> getMenuList(HttpSession session){
        //获取当前用户
        UserInfoEntity user = (UserInfoEntity) session.getAttribute("user");
        if (null==user){
            return null;
        }else {
            return menuService.getMenuList(user.getUserPower());
        }

    }
    @ApiOperation("管理员端页面跳转")
    @GetMapping(path = "/getMenu")
    public ModelAndView getMenu(){
        //获取当前用户
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("admin/power");
        return model_html;
    }
    @ApiOperation("菜单管理获取所有菜单列表")
    @GetMapping(path = "/getAllMenu")
    public List<MenuEntity> getAllMenu(){
        //获取当前用户
        return menuService.getAllMenuList();
    }
    @ApiOperation("删除")
    @GetMapping("/deleteUpdate")
    public String deleteUpdate(Integer menuId) {
        return menuService.deleteUpdate(menuId);
    }

    @ApiOperation("新增")
    @PostMapping(path = "/createMenu")
    public MenuEntity createMenu(@RequestBody MenuDTO dto){
        return menuService.create(dto);
    }

    @ApiOperation("更新")
    @PostMapping("/updateMenu")
    public MenuEntity update(Integer menuId,@RequestBody @Valid MenuDTO dto) {
        return menuService.update(menuId, dto);
    }
    @ApiOperation(value = "验证菜单名称唯一性", notes = "验证菜单名称",httpMethod = "GET")
    @ResponseBody
    @RequestMapping("doOnlyMenu-exist")
    public Boolean menuProcinceIsExist(String menuProcince){
        System.out.println("验证菜单名称："+menuProcince);
        Boolean menuIsExist = menuService.menuProcinceIsExist(menuProcince);
        System.out.println(menuIsExist);
        return menuIsExist;
    }
    @ApiOperation(value = "验证字菜单请求路径唯一性", notes = "验证字菜单请求路径",httpMethod = "GET")
    @ResponseBody
    @RequestMapping("doOnlyReqmenu-exist")
    public Boolean menuRequestIsExist(String menuRequest){
        System.out.println("验证字菜单请求路径："+menuRequest);
        Boolean menuRequestIsExist = menuService.menuRequestIsExist(menuRequest);
        System.out.println(menuRequestIsExist);
        return menuRequestIsExist;
    }

//    @ApiOperation("分页查询")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "query", dataType = "String", name = "menuProcince", value = "菜单名称"),
//            @ApiImplicitParam(paramType = "query", dataType = "String", name = "menuRequest", value = "url地址"),
//            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "menuPcode", value = "菜单父编号"),
//            @ApiImplicitParam(paramType = "query", dataType = "String", name = "userPower", value = "权限"),
//            @ApiImplicitParam(paramType = "query", dataType = "Boolean", name = "isDel", value = "标志位"),
//            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "page", value = "分页页码"),
//            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "size", value = "每页数量"),
//            @ApiImplicitParam(paramType = "query", dataType = "String", name = "ascs", value = "升序字段，多个用逗号隔开"),
//            @ApiImplicitParam(paramType = "query", dataType = "String", name = "descs", value = "降序字段，多个用逗号隔开")
//    })
//    @GetMapping(path = "/page")
//    public PageResult page(MenuDTO dto) {
//        IPage<MenuEntity> page = PageFactory.convertPageByParameters();
//        List<MenuEntity> list = menuService.page(dto, page);
//        return PageFactory.buildPageResult(page, list);
//    }

}
