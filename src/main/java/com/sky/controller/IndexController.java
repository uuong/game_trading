package com.sky.controller;

import com.sky.pojo.Goods;
import com.sky.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/8/18 0018
 * Time: 11:46
 * To changeAmount this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Resource
    private GoodsService goodsService;

    @RequestMapping("index")
    public String index2() {
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        List<Goods> list = goodsService.selectAll();
        model.addAttribute("lists", list);
        list.iterator();
        return "index";
    }
}
