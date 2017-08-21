package com.sky.service;

import com.sky.dao.GoodsMapper;
import com.sky.pojo.Goods;
import com.sky.pojo.GoodsExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/8/20 0020
 * Time: 20:19
 * To changeAmount this template use File | Settings | File Templates.
 */
@Service
public class GoodsService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Resource
   private GoodsMapper goodsMapper;

    public List<Goods> selectAll() {
        GoodsExample example = new GoodsExample();
        example.createCriteria().andStateEqualTo((byte) 0);
       return goodsMapper.selectByExample(example);
    }

    public Goods selectById(Integer id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    public void add(Goods goods) {
        goodsMapper.insertSelective(goods);
    }
}
