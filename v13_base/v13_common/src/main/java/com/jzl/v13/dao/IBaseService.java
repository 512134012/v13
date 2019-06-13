package com.jzl.v13.dao;

import java.util.List;

/**
 * 项目名：v13
 * HAPPY JAVA ！
 * Create by jiangzonglin on 2019-06-11 下午 3:58
 */
public interface IBaseService<T> {

    int deleteByPrimaryKey(Long id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKeyWithBLOBs(T record);

    int updateByPrimaryKey(T record);

    List<T> list();
}
