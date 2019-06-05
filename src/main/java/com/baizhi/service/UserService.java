package com.baizhi.service;

import com.baizhi.Dto.UserDto;
import com.baizhi.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    //分页展示用户
        Map<String,Object> queryPaging(Integer page,Integer rows);
    //添加用户
    String addUser(User user);
    //修改用户
    String updateUser(User user);
    List<User> selectAll();
    //查询近七天用户走势图
    List<User> selectUserSevenDay();
    //查询用户月份走势图
     UserDto selectUserMonth();
    //查询用户地图分布图
    List<User>selectMap();
}
