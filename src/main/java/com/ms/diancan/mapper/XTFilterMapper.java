package com.ms.diancan.mapper;

import com.ms.diancan.entity.User;
import com.ms.diancan.entity.XTFilterP;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface XTFilterMapper {

    User findAllUserInfo();

    List<Integer> findAllUserId();

    List<XTFilterP> findPListByUserId(Integer userId);

    List<User> findNotId(@Param(value = "list") List list);

    List<Integer> findPNotPId(@Param(value = "list") List list);



}
