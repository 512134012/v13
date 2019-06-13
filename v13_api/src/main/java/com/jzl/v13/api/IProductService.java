package com.jzl.v13.api;

import com.github.pagehelper.PageInfo;
import com.jzl.v13.dao.IBaseService;
import com.jzl.v13.entity.TProduct;
import com.jzl.v13.pojo.TProductVo;

import java.util.List;


/**
 * 项目名：v13
 * HAPPY JAVA ！
 * Create by jiangzonglin on 2019-06-11 下午 4:33
 */
public interface IProductService extends IBaseService<TProduct> {
    //单独扩展特殊的方法
    PageInfo<TProduct> page(Integer currentPage,Integer pageSize);
    //返回新增商品的id
    Long save(TProductVo tProductVo);

    Long betchDel(List<Long> ids);
}

