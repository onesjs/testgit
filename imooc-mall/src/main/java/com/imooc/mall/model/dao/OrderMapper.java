package com.imooc.mall.model.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.mall.model.pojo.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper extends BaseMapper<Order> {
   /* int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);*/
}