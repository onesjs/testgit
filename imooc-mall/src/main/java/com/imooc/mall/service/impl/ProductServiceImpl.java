package com.imooc.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imooc.mall.common.vo.PageParams;
import com.imooc.mall.common.vo.PageVo;
import com.imooc.mall.model.dao.ProductMapper;
import com.imooc.mall.model.pojo.Product;
import com.imooc.mall.service.ProductService;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;

import java.util.List;
import java.util.Objects;

/**
 * @author sjs
 * @date 2020/11/12 22:59
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    private String url = "http://localhost:9000";
    private String accessKey = "admin";
    private String secretKey = "12345678";
    private String bucketName = "pic";

    @Override
    public void add(Product product) {
        productMapper.insert(product);
    }

    @Override
    public void update(Product product) {
        productMapper.updateById(product);
    }

    @Override
    public void delete(int id) {
        productMapper.deleteById(id);
    }

    @Override
    public void delete(List<Integer> ids, int sellStatus) {
        List<Product> products = productMapper.selectBatchIds(ids);
        for (Product product : products){
            product.setStatus(sellStatus);
            productMapper.updateById(product);
        }
    }

    @Override
    public PageVo<Product> list(int pageNum, int pageSize) {
        PageVo<Product> page = new PageVo<>();
        List<Product> products = productMapper.selectList(null);
        page.setList(products);
        page.setTotal(products.size());
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        return page;
    }

    @Override
    public PageVo<Product> ProductList(PageParams pageParams) {
        PageVo<Product> page = new PageVo<>();
        QueryWrapper<Product> query = new QueryWrapper<>();
        String orderBy = pageParams.getOrderBy();
        String param = null;
        String order = null;
        Boolean flag = false;
        if (orderBy!=null){
            String[] split = orderBy.split(" ");
            param = split[0];
            order = split[1];
        }
        if (Objects.equals(order,"desc")){
            flag = true;
        }
        query.eq(pageParams.getCategoryId()!=null,"category_id",pageParams.getCategoryId())
                .like(pageParams.getKeyword()!=null,"name",pageParams.getKeyword())
                .orderByAsc(orderBy!=null& !flag,param)
                .orderByDesc(orderBy!=null& flag,param);
        List<Product> products = productMapper.selectList(query);
        page.setPageSize(pageParams.getPageSize());
        page.setPageNum(pageParams.getPageNum());
        page.setTotal(products.size());
        page.setList(products);
        return page;
    }

    @Override
    public Product selectDetail(int id) {
        Product product = productMapper.selectById(id);
        return product;
    }

    @Override
    public String uploadImage(MultipartFile file)throws Exception{
        // 初始化MinIO客户端
        MinioClient minioClient = new MinioClient(url, accessKey, secretKey);
//        // 检查bucket是否存在
//        boolean isExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
//        if (isExist) {
//            throw new Exception("Bucket already exists.");
//        } else {
//            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
//        }
        // 使用MinIO客户端上传文件
        InputStream stream = file.getInputStream();
        String fileName = file.getOriginalFilename();
        minioClient.putObject(bucketName, fileName, stream, new PutObjectOptions(stream.available(), -1));
        // 返回文件外链
        String objectUrl = minioClient.getObjectUrl(bucketName, fileName);
        return objectUrl;
    }
}
