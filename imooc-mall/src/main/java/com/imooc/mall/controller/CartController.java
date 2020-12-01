package com.imooc.mall.controller;

import com.imooc.mall.common.vo.CartVo;
import com.imooc.mall.common.vo.Result;
import com.imooc.mall.model.pojo.Cart;
import com.imooc.mall.model.pojo.Product;
import com.imooc.mall.model.pojo.User;
import com.imooc.mall.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author sjs
 * @date 2020/11/18 13:06
 */

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/list")
    public Result list(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        List<CartVo> list = cartService.list(user.getId());
        return Result.success(10000,"SUCCESS",list);
    }

    @PostMapping("/add")
    public Result add(HttpServletRequest request,int productId,int  count){
        User user = (User) request.getSession().getAttribute("user");
        cartService.add(user.getId(),productId,count);
        List<CartVo> list = cartService.list(user.getId());
        return Result.success(10000,"SUCCESS",list);
    }

    @PostMapping("/update")
    public Result update(HttpServletRequest request,int productId,int  count){
        User user = (User) request.getSession().getAttribute("user");
        cartService.update(user.getId(),productId,count);
        List<CartVo> list = cartService.list(user.getId());
        return Result.success(10000,"SUCCESS",list);
    }


    @PostMapping("/delete")
    public Result delete(HttpServletRequest request,int productId){
        User user = (User) request.getSession().getAttribute("user");
        cartService.delete(user.getId(),productId);
        List<CartVo> list = cartService.list(user.getId());
        return Result.success(10000,"SUCCESS",list);
    }

    @PostMapping("/select")
    public Result select(HttpServletRequest request,int productId,int selected){
        User user = (User) request.getSession().getAttribute("user");
        cartService.select(user.getId(),productId,selected);
        List<CartVo> list = cartService.list(user.getId());
        return Result.success(10000,"SUCCESS",list);
    }

    @PostMapping("/selectAll")
    public Result selectAll(HttpServletRequest request,int selected){
        User user = (User) request.getSession().getAttribute("user");
        cartService.selectAll(user.getId(),selected);
        List<CartVo> list = cartService.list(user.getId());
        return Result.success(10000,"SUCCESS",list);
    }


}
