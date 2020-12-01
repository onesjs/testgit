package com.imooc.mall.common.vo;

import com.imooc.mall.model.pojo.Cart;
import com.imooc.mall.model.pojo.Product;

import java.util.Date;

/**
 * @author sjs
 * @date 2020/11/18 14:36
 */
public class CartVo {

   public CartVo(Cart cart, Product product){
        this.id=cart.getId();
        this.productId=cart.getProductId();
        this.userId=cart.getUserId();
        this.quantity=cart.getQuantity();
        this.selected=cart.getSelected();
        this.createTime=cart.getCreateTime();
        this.updateTime=cart.getUpdateTime();
        this.price=product.getPrice();
        this.productName=product.getName();
        this.productImage=product.getImage();
        this.totalPrice=product.getPrice()*product.getPrice();
    }

    public CartVo(){

    }
    private Integer id;

    private Integer productId;

    private Integer userId;

    private Integer quantity;

    private Integer selected;

    private Integer price;

    private Integer totalPrice;

    private String productName;

    private String productImage;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getSelected() {
        return selected;
    }

    public void setSelected(Integer selected) {
        this.selected = selected;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
}
