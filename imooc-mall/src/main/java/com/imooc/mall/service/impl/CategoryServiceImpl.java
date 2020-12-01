package com.imooc.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imooc.mall.common.vo.PageVo;
import com.imooc.mall.common.vo.CategoryVo;
import com.imooc.mall.model.dao.CategoryMapper;
import com.imooc.mall.model.pojo.Category;
import com.imooc.mall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sjs
 * @date 2020/11/11 20:30
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    //新增目录
    @Override
    public void add(CategoryVo categoryVo) throws Exception {
        QueryWrapper<Category> query = new QueryWrapper<>();
        query.eq("name",categoryVo.getName());
        Category category1 = categoryMapper.selectOne(query);
        if (category1!=null){
            throw new Exception("该目录名称已使用");
        }
        Category category = new Category();
        category.setName(categoryVo.getName());
        category.setType(categoryVo.getType());
        category.setParentId(categoryVo.getParentId());
        category.setOrderNum(categoryVo.getOrderNum());
        categoryMapper.insert(category);
    }

    //更新目录
    @Override
    public void update(Category category) {
        categoryMapper.updateById(category);
    }

    //删除目录
    @Override
    public void delete(Integer id) {
        categoryMapper.deleteById(id);
    }

    //后台分类列表
    @Override
    public PageVo<Category> pageList(int pageNum, int pageSize){
        PageVo<Category> page = new PageVo<>();
        List<Category> list = categoryMapper.selectList(null);
        page.setPageSize(pageSize);
        page.setPageNum(pageNum);
        page.setTotal(list.size());
        page.setList(list);
        return page;
    }

    //前台分类列表
    @Override
    public List<CategoryVo> list() {

        QueryWrapper<Category> query = new QueryWrapper<>();
        query.eq("parent_id",0)
                .orderByAsc("order_num");
        List<Category> categories = categoryMapper.selectList(query);

        List<CategoryVo> categoryVos = select(categories);

        return categoryVos;
    }


    public List<CategoryVo> select(List<Category> categories) {
        List<CategoryVo> list = new ArrayList<>();

        for (Category category : categories){
            QueryWrapper<Category> query = new QueryWrapper<>();
            query.eq("parent_id",category.getId())
                    .orderByAsc("order_num");
            List<Category> sonList = categoryMapper.selectList(query);

            List<CategoryVo> select = select(sonList);
            CategoryVo categoryVo = new CategoryVo();
            categoryVo.setChildCategory(select);
            categoryVo.setId(category.getId());
            categoryVo.setName(category.getName());
            categoryVo.setType(category.getType());
            categoryVo.setOrderNum(category.getOrderNum());
            categoryVo.setParentId(category.getParentId());
            list.add(categoryVo);
        }
        return list;
    }
}
