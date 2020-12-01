package com.imooc.mall.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imooc.mall.common.vo.PageParams;
import com.imooc.mall.common.vo.PageVo;
import com.imooc.mall.model.pojo.Product;
import io.minio.errors.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author sjs
 * @date 2020/11/12 22:58
 */
public interface ProductService {

    void add(Product product);
    void update(Product product);
    void delete(int id);
    void delete(List<Integer> ids, int sellStatus);
    PageVo<Product> list (int pageNum, int pageSize);
    PageVo<Product> ProductList(PageParams pageParams);
    Product selectDetail(int id);
    String uploadImage(MultipartFile file) throws Exception;
}
