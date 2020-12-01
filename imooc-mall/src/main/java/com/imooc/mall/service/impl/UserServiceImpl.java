package com.imooc.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imooc.mall.model.dao.UserMapper;
import com.imooc.mall.model.pojo.User;
import com.imooc.mall.service.UserService;
import com.imooc.mall.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 描述：     UserService实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    //添加用户
    @Override
    public void addUser(String username, String password) throws Exception {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("username",username);
        if (userMapper.selectOne(query)==null){
            User user = new User();
            user.setUsername(username);
            user.setPassword(MD5Utils.MD5code(password));
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            user.setRole(1);
            user.setPersonalizedSignature("祝你今天好心情");
            userMapper.insert(user);
        }
        else throw new Exception("此用户已注册");
    }

    //查找用户
    @Override
    public User findUser(String username) {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("username",username);
        User user = userMapper.selectOne(query);
        return user;
    }

    //修改签名
    @Override
    public void update(String signature, String username) {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("username",username);
        User user = userMapper.selectOne(query);
        user.setPersonalizedSignature(signature);
        user.setUpdateTime(new Date());
        userMapper.updateById(user);
    }

    @Override
    public User findAdminUser(String username) throws Exception {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("username",username);
        User user = userMapper.selectOne(query);
        if (user.getRole()==2){
            return user;
        }
        throw new Exception("权限不够，无法登陆");
    }
}
