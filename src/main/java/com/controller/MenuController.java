package com.controller;

import com.model.Menu;
import com.model.RespBean;
import com.model.User;
import com.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author duanbochao
 * @creat 2019/7/18
 */
@RestController
public class MenuController {

    @Autowired
    MenuService menuService;

    @RequestMapping("/getMenus")
    public RespBean getMenusByUid(HttpSession session){
        User user = (User) session.getAttribute("login");
        List<Menu> menus = menuService.getMenusByUserId(user.getId());
        if (menus!=null){
            return RespBean.ok(menus);
        }else {
            return RespBean.error();
        }
    }


    @RequestMapping("/getMenu")
    public ModelAndView getMenusByParentId(HttpSession session, Integer pid){
        User user = (User) session.getAttribute("login");
        ModelAndView mv = new ModelAndView();
        List<Menu> menu = menuService.getMenusByParentId(user.getId(), pid);
        System.out.println(menu);
        if (menu!=null){
            mv.setViewName("menu");
            mv.addObject("menus",menu);
            return mv;
        }
        return null;
    }

}
