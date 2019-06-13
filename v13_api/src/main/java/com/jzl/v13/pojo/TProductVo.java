package com.jzl.v13.pojo;

import com.jzl.v13.entity.TProduct;

import java.io.Serializable;

/**
 * 项目名：v13
 * HAPPY JAVA ！
 * Create by jiangzonglin on 2019-06-12 下午 5:43
 */
public class TProductVo implements Serializable {

    private TProduct tProduct;//商品的基本信息

    private String productDesc;//商品的描述信息

    public TProduct gettProduct() {
        return tProduct;
    }

    public void settProduct(TProduct tProduct) {
        this.tProduct = tProduct;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
}
