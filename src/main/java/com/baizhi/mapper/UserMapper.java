package com.baizhi.mapper;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //分页展示用户
    List<User> queryPaging(@Param("page") Integer page,@Param("rows") Integer rows);
    //查询所有用户
    Integer selectCount();
    //添加用户
    void addUser(User user);
    //修改
    void updateUser(User user);
    //查询近七天用户
    List<User> selectUserSevenDay();
    //查询用户注册 月份走势图
    List<User>  selectUserMonth();
    //用户地图法分布图
    List<User> selectMap();

}
