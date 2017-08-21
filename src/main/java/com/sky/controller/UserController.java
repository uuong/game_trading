package com.sky.controller;

import com.sky.pojo.User;
import com.sky.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/8/19 0019
 * Time: 15:58
 * To changeAmount this template use File | Settings | File Templates.
 */
@RequestMapping("user")
@Controller
public class UserController {
    @Resource
   private UserService userService;
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loginUser");

        User dbUser = userService.selectByID(user.getUserId());
        model.addAttribute("user",dbUser);
        return "user";
    }
}
