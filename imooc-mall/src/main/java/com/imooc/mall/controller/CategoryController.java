package com.imooc.mall.controller;

import com.imooc.mall.common.vo.PageVo;
import com.imooc.mall.common.vo.Result;
import com.imooc.mall.common.vo.CategoryVo;
import com.imooc.mall.model.pojo.Category;
import com.imooc.mall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sjs
 * @date 2020/11/11 20:30
 */
@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    //增加目录
    @PostMapping("/admin/category/add")
    public Result add(@RequestBody CategoryVo categoryVo) throws Exception {
        categoryService.add(categoryVo);
        return Result.success(10000,"SUCCESS",null);
    }

    //更新目录
    @PostMapping("/admin/category/update")
    public Result update(@RequestBody Category category){
        categoryService.update(category);
        return Result.success(10000,"SUCCESS",null);
    }

    //删除目录
    @PostMapping("/admin/category/delete")
    public Result delete(@RequestParam Integer id){
        categoryService.delete(id);
        return Result.success(10000,"SUCCESS",null);
    }

    //后台分类列表
    @GetMapping("/admin/category/list")
    public Result pageList(@RequestParam int pageNum,@RequestParam int pageSize){
        PageVo<Category> categoryIPage = categoryService.pageList(pageNum, pageSize);
        return Result.success(10000,"SUCCESS",categoryIPage);
    }

    //前台分类列表
    @GetMapping("/category/list")
    public Result list(){
        List<CategoryVo> list = categoryService.list();
        return Result.success(10000,"SUCCESS",list);
    }


}
