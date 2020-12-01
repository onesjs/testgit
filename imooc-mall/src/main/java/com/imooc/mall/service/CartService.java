package com.imooc.mall.service;

import com.imooc.mall.common.vo.CartVo;


import java.util.List;

/**
 * @author sjs
 * @date 2020/11/18 13:06
 */
public interface CartService {
    List<CartVo> list(int id);
    void add(int userId,int productId,int  count);
    void update(int userId,int productId,int  count);
    void delete(int userId,int productId);
    void select(int userId,int productId,int selected);
    void selectAll(int userId,int selected);

}
