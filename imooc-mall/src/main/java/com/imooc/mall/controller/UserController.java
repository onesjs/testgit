package com.imooc.mall.controller;

import com.imooc.mall.common.vo.Result;
import com.imooc.mall.model.pojo.User;
import com.imooc.mall.service.UserService;
import com.imooc.mall.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 描述：     用户控制器
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    //注册
    @PostMapping("/register")
    public Result register(@RequestParam String userName,@RequestParam String password) throws Exception {
        userService.addUser(userName,password);
        return Result.success(10000,"SUCCESS",null);
    }

    //登录
    @PostMapping("/login")
    public Result login(@RequestParam String userName, @RequestParam String password, HttpServletRequest request) throws Exception {
        User user = userService.findUser(userName);
        if (user==null){
            throw new Exception("用户不存在或密码错误!");
        }
        if (user.getPassword().equals(MD5Utils.MD5code(password))){
            user.setPassword(null);
            HttpSession session = request.getSession();
            session.setAttribute("user",user);

            return Result.success(10000,"SUCCESS",user);
        }
        else throw new Exception("用户不存在或密码错误!");

    }
    //退出登录
    @PostMapping("/user/logout")
    public Result logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return Result.success(10000,"SUCCESS",null);
    }

    //修改个性签名
    @PostMapping("/user/update")
    public Result update(@RequestParam String signature,HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String username = user.getUsername();
        userService.update(signature,username);
        return Result.success(10000,"SUCCESS",null);
    }

    //管理员登录
    @PostMapping("/adminLogin")
    public Result adminLogin(@RequestParam String userName, @RequestParam String password, HttpServletRequest request) throws Exception {
        User user = userService.findAdminUser(userName);
        if (user==null){
            throw new Exception("用户不存在或密码错误!");
        }
        if (user.getPassword().equals(MD5Utils.MD5code(password))){
            user.setPassword(null);
            HttpSession session = request.getSession();
            session.setAttribute("adminUser",user);

            return Result.success(10000,"SUCCESS",user);
        }
        else throw new Exception("用户不存在或密码错误!");
    }

    //管理员退出登录
    @PostMapping("/logout")
    public Result adminLogout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("adminUser");
        return Result.success(10000,"SUCCESS",null);
    }

    //大借口啊好

}
