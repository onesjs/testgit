package com.imooc.mall.service;

import com.imooc.mall.common.vo.PageVo;
import com.imooc.mall.common.vo.CategoryVo;
import com.imooc.mall.model.pojo.Category;

import java.util.List;

/**
 * @author sjs
 * @date 2020/11/11 20:30
 */
public interface CategoryService{
    void add(CategoryVo categoryVo) throws Exception;
    void update(Category category);
    void delete(Integer id);
    List<CategoryVo> list();
    PageVo<Category> pageList(int pageNum, int pageSize);
}
