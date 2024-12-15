package com.ms.diancan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class XTFilterP implements Comparable<XTFilterP> {

//    public Integer userId;

    public Integer productId;

    public Integer buyNum;

//    @Override
    public int compareTo(XTFilterP o) {
        return buyNum > o.buyNum ? -1 : 1;
    }

}
