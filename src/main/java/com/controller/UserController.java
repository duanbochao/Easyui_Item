package com.controller;

import com.model.Menu;
import com.model.RespBean;
import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author duanbochao
 * @creat 2019/7/17
 */

@RestController
public class UserController {

   @Autowired
    UserService userService;

   @RequestMapping("/login")
   public RespBean login(User user, HttpSession session){
       User loginUser = userService.loadUserByUsername(user);
       if (loginUser!=null){
           session.setAttribute("login",loginUser);
           return RespBean.ok(loginUser);
       }else {
           return  RespBean.error();
       }

   }



}
