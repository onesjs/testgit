package com.imooc.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imooc.mall.common.vo.CartVo;
import com.imooc.mall.controller.ProductController;
import com.imooc.mall.model.dao.CartMapper;

import com.imooc.mall.model.dao.ProductMapper;
import com.imooc.mall.model.pojo.Cart;
import com.imooc.mall.model.pojo.Product;
import com.imooc.mall.service.CartService;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sjs
 * @date 2020/11/18 13:06
 */

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartMapper cartMapper;

    @Autowired
    ProductMapper productMapper;

    @Override
    public List<CartVo> list(int id) {

        List<CartVo> cartVos = new ArrayList<>();
        QueryWrapper<Cart> query = new QueryWrapper<>();
        query.eq("user_id",id);
        List<Cart> carts = cartMapper.selectList(query);
        for (Cart cart:carts){
            Product product = productMapper.selectById(cart.getProductId());
            cartVos.add(new CartVo(cart,product));
        }
        return cartVos;
    }

    @Override
    public void add(int userId,int productId, int count) {
        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setProductId(productId);
        cart.setQuantity(count);
        cartMapper.insert(cart);
    }

    @Override
    public void update(int userId,int productId, int count) {
        QueryWrapper<Cart> query = new QueryWrapper<>();
        query.eq("user_id",userId)
                .eq("product_id",productId);
        Cart cart = cartMapper.selectOne(query);
        cart.setQuantity(count);
        cartMapper.updateById(cart);
    }

    @Override
    public void delete(int userId,int productId) {
        QueryWrapper<Cart> query = new QueryWrapper<>();
        query.eq("user_id",userId)
                .eq("product_id",productId);
        cartMapper.delete(query);
    }

    @Override
    public void select(int userId,int productId, int selected) {
        QueryWrapper<Cart> query = new QueryWrapper<>();
        query.eq("user_id",userId)
                .eq("product_id",productId);
        Cart cart = cartMapper.selectOne(query);
        cart.setSelected(selected);
        cartMapper.updateById(cart);
    }

    @Override
    public void selectAll(int userId,int selected) {
        QueryWrapper<Cart> query = new QueryWrapper<>();
        query.eq("user_id",userId);
        List<Cart> carts = cartMapper.selectList(query);
        for (Cart cart:carts){
            cart.setSelected(selected);
            cartMapper.updateById(cart);
        }

    }
}
