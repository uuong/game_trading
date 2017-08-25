package com.sky.service;

import com.sky.dao.GoodsMapper;
import com.sky.dao.OrderMapper;
import com.sky.dao.UserMapper;
import com.sky.pojo.Order;
import com.sky.pojo.OrderExample;
import com.sky.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/8/19 0019
 * Time: 15:03
 * To changeAmount this template use File | Settings | File Templates.
 */
@Service
public class OrderService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Resource
    private OrderMapper orderMapper;
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Resource
    private UserMapper userMapper;
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Resource
    private GoodsMapper goodsMapper;
    @Transactional
    public void changeAmount(Order order, User user) {
        orderMapper.insertSelective(order);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Transactional
    public void changeAmount(Order order, Integer bID, Integer sID, int amount) {
        orderMapper.insertSelective(order);

        int balance = userMapper.selectByPrimaryKey(sID).getBalance() + amount;
        userMapper.updateAmountByID(sID, balance);

        balance = userMapper.selectByPrimaryKey(bID).getBalance() - amount;
        userMapper.updateAmountByID(bID, balance);

        goodsMapper.updateByID(order.getGoodsId(),1);
    }

    public List<Order> selectByUid(Integer userId) {
        OrderExample example = new OrderExample();
        example.createCriteria().andSellerIdEqualTo(userId);
        example.or().andBuyIdEqualTo(userId);
       return orderMapper.selectByExample(example);
    }
}
