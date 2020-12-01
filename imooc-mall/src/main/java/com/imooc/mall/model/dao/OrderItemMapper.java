package com.imooc.mall.model.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.mall.model.pojo.Order;
import com.imooc.mall.model.pojo.OrderItem;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemMapper extends BaseMapper<OrderItem> {
    /*int deleteByPrimaryKey(Integer id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);*/
}