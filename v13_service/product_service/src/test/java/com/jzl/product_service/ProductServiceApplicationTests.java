package com.jzl.product_service;

import com.github.pagehelper.PageInfo;
import com.jzl.v13.api.IProductService;
import com.jzl.v13.entity.TProduct;
import com.jzl.v13.pojo.TProductVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceApplicationTests {

    @Autowired
    private IProductService productService;

    @Test
    public void contextLoads() {
        List<Long> ids = new ArrayList<>();
        ids.add(2L);
        ids.add(3L);
        productService.betchDel(ids);
    }

}

