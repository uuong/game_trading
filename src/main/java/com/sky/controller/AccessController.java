package com.sky.controller;

import com.sky.pojo.User;
import com.sky.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/8/18 0018
 * Time: 12:26
 * To changeAmount this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("access")
public class AccessController {
    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping(path = "/reg",method = RequestMethod.POST)
    public String reg(User user) {
        if (userService.isAdd(user.getUsername())) {
           userService.add(user);
            return "success" ;
        }
        return  "not";
    }

    @RequestMapping(path = "/reg",method = RequestMethod.GET)
    public String reg() {
        return  "reg";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String login(User user, HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return "redirect:/";
        }
        User authUserInfo = userService.selectByUsername(user.getUsername());
        if (authUserInfo == null) {
            return "redirect:/";
        }
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(token);
            session.setAttribute("loginUser", authUserInfo);
        } catch (AuthenticationException e) {
            token.clear();
            return "redirect:/";
        }
        return "redirect:/user";
        //User u = userService.login(user);
        //if (u == null) {
        //    return "密码错误";
        //}
        //session.setAttribute("loginUser",u);
        //return "success";
    }

    //@RequestMapping(method = RequestMethod.DELETE)
    //public String logout(HttpSession session) {
    //    session.removeAttribute("loginUser");
    //    // TODO: 2017/8/19 0019 退出界面 等待跳转
    //    return "redirect:/";
    //}
}
