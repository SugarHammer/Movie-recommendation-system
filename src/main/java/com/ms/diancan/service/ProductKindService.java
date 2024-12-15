package com.ms.diancan.service;

import com.ms.diancan.entity.Product;
import com.ms.diancan.entity.ProductKind;

/**
 * @author 
 * @createTime 2020-03-17 21:13
 */
public interface ProductKindService {

    /**
     * 添加电影的种类
     * @param productKind
     */
    void addProductKind(ProductKind productKind);

    /**
     * 修改电影的种类名字
     */
    void updateProductKind(ProductKind productKind);

    /**
     * 删除电影种类
     */
    void deleteProductKind(ProductKind productKind);

    /**
     * 批量删删除电影种类
     */
    void batchDeletekind(Integer[] kindIds);


}
