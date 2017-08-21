package com.sky.controller;

import com.sky.pojo.Goods;
import com.sky.pojo.User;
import com.sky.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/8/19 0019
 * Time: 14:43
 * To changeAmount this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String getId(@PathVariable("id") Integer id, Model model) {
        Goods goods = goodsService.selectById(id);
        model.addAttribute("goods", goods);
        return "goods_item";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "goods_post";
    }

    @RequestMapping(path = "/edit", method = RequestMethod.POST)
    public String post(Goods goods , HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        goods.setUserId(user.getUserId());
        goodsService.add(goods);
        return "goods_post";
    }

    @RequestMapping(path = "/edit",method = RequestMethod.DELETE)
    public String delete(int id) {
        return "goods_item";
    }

    @RequestMapping(path = "/edit",method = RequestMethod.PUT)
    public String update(Goods goods) {
        return "goods_item";
    }
}
