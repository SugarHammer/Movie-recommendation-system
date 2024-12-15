package com.ms.diancan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 电影种类类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductKind {
    private Integer id;              //电影种类id
    private String kindName;         //电影种类名

    public ProductKind(Integer id) {
        this.id = id;
    }
}
