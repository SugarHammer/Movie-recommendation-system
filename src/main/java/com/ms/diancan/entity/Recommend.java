package com.ms.diancan.entity;

//import com.jun.entity.XTFilterP;
//import com.jun.entity.XTFilterU;
import com.ms.diancan.entity.XTFilterU;
import com.ms.diancan.entity.XTFilterP;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author junfeng.lin
 * @date 2021/3/18 13:42
 */
public class Recommend {


    /**
     * 在给定username的情况下，计算其他用户和它的距离并排序
     * @param userId
     * @return
     */
    private Map<Double, Integer> computeNearestNeighbor(Integer userId, List<XTFilterU> users) {
        Map<Double, Integer> distances = new TreeMap<>();

        XTFilterU u1 = new XTFilterU(userId);
        for (XTFilterU user:users) {
            if (userId.equals(user.userId)) {
                u1 = user;
            }
        }

        for (int i = 0; i < users.size(); i++) {
            XTFilterU u2 = users.get(i);

            if (!u2.userId.equals(userId)) {
                double distance = pearson_dis(u2.PList, u1.PList);
                distances.put(distance, u2.userId);
            }

        }
        System.out.println("该用户与其他用户的皮尔森相关系数 -> " + distances);
        return distances;
    }


    /**
     * 计算2个打分序列间的pearson距离
     * 选择公式四进行计算
     * @param rating1
     * @param rating2
     * @return
     */
    private double pearson_dis(List<XTFilterP> rating1, List<XTFilterP> rating2) {
        int n=rating1.size();
        List<Integer> rating1ScoreCollect = rating1.stream().map(A -> A.buyNum).collect(Collectors.toList());
        List<Integer> rating2ScoreCollect = rating2.stream().map(A -> A.buyNum).collect(Collectors.toList());

        double Ex= rating1ScoreCollect.stream().mapToDouble(x->x).sum();
        double Ey= rating2ScoreCollect.stream().mapToDouble(y->y).sum();
        double Ex2=rating1ScoreCollect.stream().mapToDouble(x->Math.pow(x,2)).sum();
        double Ey2=rating2ScoreCollect.stream().mapToDouble(y->Math.pow(y,2)).sum();
        double Exy= IntStream.range(0,n).mapToDouble(i->rating1ScoreCollect.get(i)*rating2ScoreCollect.get(i)).sum();
        double numerator=Exy-Ex*Ey/n;
        double denominator=Math.sqrt((Ex2-Math.pow(Ex,2)/n)*(Ey2-Math.pow(Ey,2)/n));
        if (denominator==0) return 0.0;
        return numerator/denominator;
    }


    public List<XTFilterP> recommend(Integer userId, List<XTFilterU> users) {
        //找到最近邻
        Map<Double, Integer> distances = computeNearestNeighbor(userId, users);
        Integer nearest = distances.values().iterator().next();
        System.out.println("最近邻 -> " + nearest);

        //找到最近邻看过，但是我们没看过的电影，计算推荐
        XTFilterU neighborRatings = new XTFilterU();
        for (XTFilterU user:users) {
            if (nearest.equals(user.userId)) {
                neighborRatings = user;
            }
        }
        System.out.println("最近邻看过的电影 -> " + neighborRatings.PList);

        XTFilterU userRatings = new XTFilterU();
        for (XTFilterU user:users) {
            if (userId.equals(user.userId)) {
                userRatings = user;
            }
        }
        System.out.println("用户看过的电影 -> " + userRatings.PList);

        //根据自己和邻居的电影计算推荐的电影
        List<XTFilterP> recommendationPs = new ArrayList<>();
        for (XTFilterP P : neighborRatings.PList) {
            if (userRatings.find(P.productId) == null) {
                recommendationPs.add(P);
            }
        }
        Collections.sort(recommendationPs);
        return recommendationPs;
    }
}


