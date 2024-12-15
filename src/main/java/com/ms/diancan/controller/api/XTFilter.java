package com.ms.diancan.controller.api;

import com.ms.diancan.entity.Product;
import com.ms.diancan.entity.Recommend;
import com.ms.diancan.entity.XTFilterP;
import com.ms.diancan.entity.XTFilterU;
import com.ms.diancan.mapper.ProductMapper;
import com.ms.diancan.mapper.XTFilterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class XTFilter {

    //   协同过滤算法电影推荐
    //   协同过滤算法电影推荐
    //   协同过滤算法电影推荐
    //   协同过滤算法电影推荐
    @Autowired
    private XTFilterMapper xtFilterMapper;

    @Autowired
    private ProductMapper productMapper;

    public List<Product> XTGLProduct(Integer uid){

        List<Product> productList = new ArrayList<>();

        System.out.println("-----------------------");

        List<XTFilterU> users = new ArrayList<>();

        List<Integer> allUserId = xtFilterMapper.findAllUserId();
        for (Integer userId : allUserId) {
//            System.out.println(userId);
            List<XTFilterP> pListByUserId = xtFilterMapper.findPListByUserId(userId);

            List<Integer> idList = new ArrayList<>();
            for (XTFilterP xtFilterP : pListByUserId) {
                idList.add(xtFilterP.getProductId());
            }
            List<Integer> pNotPIds = xtFilterMapper.findPNotPId(idList);
            for (Integer pNotPId : pNotPIds) {
                XTFilterP xtFilterP = new XTFilterP(pNotPId, 0);
                pListByUserId.add(xtFilterP);
            }

            XTFilterU xtFilterU = new XTFilterU();
            xtFilterU.setUserId(userId);
            xtFilterU.setPList(pListByUserId);
            users.add(xtFilterU);
//            users.add(new XTFilterU(userId).setPList(pListByUserId));
        }
        Recommend recommend = new Recommend();
        List<XTFilterP> recommendationPs = recommend.recommend(uid, users);
        System.out.println("-----------------------");
        System.out.println("推荐结果如下：");
        for (XTFilterP P : recommendationPs) {
            if (P.buyNum != 0) {
                System.out.println("商品："+P.productId+" ,购买次数："+P.buyNum);
                Product xtProductById = productMapper.findXTProductById(P.productId);
                productList.add(xtProductById);
            }
        }
        return productList;

    }
}
