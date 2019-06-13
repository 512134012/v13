package com.jzl.product_service.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jzl.v13.api.IProductService;
import com.jzl.v13.dao.BaseServiceImpl;
import com.jzl.v13.dao.IBaseDao;
import com.jzl.v13.entity.TProduct;
import com.jzl.v13.entity.TProductDesc;
import com.jzl.v13.mapper.TProductDescMapper;
import com.jzl.v13.mapper.TProductMapper;
import com.jzl.v13.pojo.TProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 项目名：v13
 * HAPPY JAVA ！
 * Create by jiangzonglin on 2019-06-11 下午 6:53
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl<TProduct> implements IProductService {

    @Autowired
    private TProductMapper tProductMapper;

    @Autowired
    private TProductDescMapper tProductDescMapper;

    @Override
    public IBaseDao<TProduct> getBaseDao() {
        return tProductMapper;
    }

    @Override
    public PageInfo<TProduct> page(Integer currentPage, Integer pageSize) {
        //1.设置参数
        PageHelper.startPage(currentPage, pageSize);
        //2.获取数据
        List<TProduct>list = list();
        //3.构建一个分页对象
        PageInfo<TProduct>pageInfo = new PageInfo<>(list,5);
        return pageInfo;
    }

    @Override
    @Transactional//事务控制
    public Long save(TProductVo tProductVo) {
        //1.保存商品的基本信息
        TProduct tProduct = tProductVo.gettProduct();
        tProduct.setFlag(true);
        //主键回填
        int count = tProductMapper.insert(tProduct);
        //2.保存商品的描述信息
        String productDesc = tProductVo.getProductDesc();
        TProductDesc tProductDesc = new TProductDesc();
        tProductDesc.setProductDesc(productDesc);
        tProductDesc.setProductId(tProduct.getId());//需要id回填
        tProductDescMapper.insert(tProductDesc);
        //3.返回商品的ID
        return tProduct.getId();
    }

    /**
     * 删除多个功能，假删除，将flag改为false
     * @param ids
     * @return
     */
    @Override
    public Long betchDel(List<Long> ids) {
        return tProductMapper.batchDel(ids);
    }

    /**
     * 删除单个功能，假删除，将flag改为false即为数据库0
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        TProduct tProduct = new TProduct();
        tProduct.setFlag(false);
        tProduct.setId(id);
        return tProductMapper.updateByPrimaryKeySelective(tProduct);
    }
}