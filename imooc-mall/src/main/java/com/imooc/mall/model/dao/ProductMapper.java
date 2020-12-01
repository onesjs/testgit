package com.imooc.mall.model.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.mall.model.pojo.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper extends BaseMapper<Product> {
   /* int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);*/
}