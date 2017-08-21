package com.sky.service;

import com.sky.dao.UserMapper;
import com.sky.pojo.User;
import com.sky.pojo.UserExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/8/18 0018
 * Time: 12:27
 * To changeAmount this template use File | Settings | File Templates.
 */
@Service
public class UserService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Resource
    private UserMapper UserMapper;

    public User selectByID(Integer id) {
        return UserMapper.selectByPrimaryKey(id);
    }
    public User selectByUsername(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<User> users = UserMapper.selectByExample(example);
        return users.isEmpty() ? null : users.get(0);
    }

    public int add(User user) {
        return UserMapper.insertSelective(user);
    }

    public boolean isAdd(String name) {
        UserExample u = new UserExample();
        u.createCriteria().andUsernameEqualTo(name);
       List<User> result =  UserMapper.selectByExample(u);
       return result.isEmpty();
    }

    public User login(User user) {
        UserExample u = new UserExample();
        u.createCriteria().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
        List<User> result =    UserMapper.selectByExample(u);
        return result.isEmpty() ? null :result.get(0);
    }
}
