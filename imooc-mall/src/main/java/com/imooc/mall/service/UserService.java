package com.imooc.mall.service;

import com.imooc.mall.model.pojo.User;

/**
 * 描述：     UserService
 */
public interface UserService {

    void addUser(String username,String password) throws Exception;
    User findUser(String username);
    void update(String signature,String username);
    User findAdminUser(String username) throws Exception;
}
