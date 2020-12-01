package com.imooc.mall.controller;

import com.imooc.mall.common.vo.PageParams;
import com.imooc.mall.common.vo.Result;
import com.imooc.mall.common.vo.PageVo;
import com.imooc.mall.model.pojo.Product;
import com.imooc.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author sjs
 * @date 2020/11/12 22:59
 */
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    //增加商品
    @PostMapping("/admin/product/add")
    public Result add(@RequestBody Product product){
        productService.add(product);
        return Result.success(10000,"SUCCESS",null);
    }

    //上传图片
    @PostMapping("/admin/upload/file")
    public Result upload(MultipartFile file) throws Exception {
        if (file.isEmpty()){
            throw new Exception("文件空空如也！！");
        }
        String uploadImage = productService.uploadImage(file);
        return Result.success(10000,"SUCCESS",uploadImage);
    }


    //更新商品
    @PostMapping("/admin/product/update")
    public Result update(@RequestBody Product product){
        productService.update(product);
        return Result.success(10000,"SUCCESS",null);

    }

    //删除商品
    @PostMapping("/admin/product/delete")
    public Result delete(int id){
        productService.delete(id);
        return Result.success(10000,"SUCCESS",null);

    }

    //批量上下架商品
    @PostMapping("/admin/product/batchUpdateSellStatus")
    public Result delete(@RequestParam List<Integer> ids,@RequestParam int sellStatus){
        productService.delete(ids, sellStatus);
        return Result.success(10000,"SUCCESS",null);
    }

    //商品列表(后台
    @GetMapping("/admin/product/list")
    public Result list(int pageNum, int pageSize){
        PageVo<Product> list = productService.list(pageNum, pageSize);
        return Result.success(10000,"SUCCESS",list);
    }


    //商品列表(前台
    @GetMapping("/product/list")
    public Result list(PageParams pageParams) {
        PageVo<Product> productPageVo = productService.ProductList(pageParams);
        return Result.success(10000,"SUCCESS",productPageVo);
    }


    //商品详情
    @GetMapping("/product/detail")
    public Result detail(int id){
        Product product = productService.selectDetail(id);
        return Result.success(10000,"SUCCESS",product);
    }

}
