package com.imooc.mall.common.vo;

import com.imooc.mall.model.pojo.Category;

import java.util.Date;
import java.util.List;

/**
 * @author sjs
 * @date 2020/11/12 7:46
 */
public class CategoryVo {

    private Integer id;

    private String name;

    private Integer type;

    private Integer parentId;

    private Integer orderNum;

    private List<CategoryVo> childCategory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public List<CategoryVo> getChildCategory() {
        return childCategory;
    }

    public void setChildCategory(List<CategoryVo> childCategory) {
        this.childCategory = childCategory;
    }
}
