package com.ms.diancan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class XTFilterU {


    public XTFilterU(Integer userId){
        this.userId = userId;
    }

    public Integer userId;

    public List<XTFilterP> PList;



    public List<XTFilterP> getPList() {
        return PList;
    }

    public XTFilterU setPList(List<XTFilterP> PList) {
        this.PList = PList;
        return this;
    }



    public XTFilterU set(Integer productId, Integer buyNume) {
        this.PList.add(new XTFilterP(productId, buyNume));
        return this;
    }

    public XTFilterP find(Integer productId) {
        for (XTFilterP P : PList) {
            if (P.productId.equals(P)) {
                return P;
            }
        }
        return null;
    }

}
