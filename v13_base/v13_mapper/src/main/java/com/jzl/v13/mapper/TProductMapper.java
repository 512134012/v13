package com.jzl.v13.mapper;

import com.jzl.v13.dao.IBaseDao;
import com.jzl.v13.entity.TProduct;

import java.util.List;

public interface TProductMapper extends IBaseDao<TProduct> {

    Long batchDel(List<Long> ids);

}