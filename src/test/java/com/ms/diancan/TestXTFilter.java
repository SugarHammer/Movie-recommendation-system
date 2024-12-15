package com.ms.diancan;

import com.ms.diancan.entity.Recommend;
import com.ms.diancan.entity.User;
import com.ms.diancan.entity.XTFilterP;
import com.ms.diancan.entity.XTFilterU;
import com.ms.diancan.mapper.UserMapper;
import com.ms.diancan.mapper.XTFilterMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestXTFilter {

    @Resource
    XTFilterMapper xtFilterMapper;
    @Test
    public void AAA(){
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
        List<XTFilterP> recommendationPs = recommend.recommend(2, users);
        System.out.println("-----------------------");
        System.out.println("推荐结果如下：");
        for (XTFilterP P : recommendationPs) {
            if (P.buyNum != 0) {
                System.out.println("商品："+P.productId+" ,购买次数："+P.buyNum);
            }
        }

    }

    @Test
    public void BBB(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<User> ListUser = xtFilterMapper.findNotId(list);
        System.out.println(ListUser);
    }

}
