package com.baizhi.service;

import com.baizhi.entity.WheelPlanting;

import java.util.Map;

public interface WheelPlantingService {
    //分页展示轮播图 jqgrid展示
    Map<String,Object> queryPaging(Integer page,Integer rows);
    //添加轮播图
    String addWheelPlanting(WheelPlanting wheelPlanting);
    //批量删除轮播图
    void removeWheelPlanting(String []id);
    //修改轮播图
    void updateWheelPlanting(WheelPlanting wheelPlanting);
}
