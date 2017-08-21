package com.sky.controller;

import com.sky.pojo.Goods;
import com.sky.pojo.Order;
import com.sky.pojo.User;
import com.sky.service.GoodsService;
import com.sky.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/8/19 0019
 * Time: 14:59
 * To changeAmount this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Resource
    private
    OrderService orderService;
    @Resource
    private
    GoodsService goodsService;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "order";
    }

    @RequestMapping("/{id}")
    public String order(@PathVariable Integer id, HttpSession session) {

        User user = (User) session.getAttribute("loginUser");
        Goods goods = goodsService.selectById(id);
        int uPrice = user.getBalance();
        int gPrice = goods.getPrice();
        if (uPrice < gPrice) {
            return "redirect:/";
        }

        Order order = new Order();
        order.setGoodsId(goods.getGoodsId());
        order.setAmount(gPrice);
        order.setSellerId(goods.getUserId());
        order.setBuyId(user.getUserId());

        orderService.changeAmount(order, user.getUserId(),goods.getUserId(),gPrice);
        return "order";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String recharge(Integer number, HttpSession session) {
       //支付接口

        User user = (User) session.getAttribute("loginUser");
        user.setBalance(user.getBalance() + number);
        // id = 1 系统充值
        Order order = new Order();

        order.setGoodsId(1);
        order.setAmount(number);
        order.setSellerId(1);
        order.setBuyId(user.getUserId());

        orderService.changeAmount(order, user);
        return "success";
    }
}
