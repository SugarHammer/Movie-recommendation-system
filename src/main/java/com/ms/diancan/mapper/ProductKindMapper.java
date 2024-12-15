package com.ms.diancan.mapper;

import com.ms.diancan.entity.ProductKind;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 
 * @createTime 2020-03-17 21:15
 */
@Mapper
public interface ProductKindMapper {

    /**
     * 保存ProductKind
     * @param productKind
     */
    void saveProductKind(ProductKind productKind);

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
