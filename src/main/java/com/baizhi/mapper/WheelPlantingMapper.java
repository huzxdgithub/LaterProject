package com.baizhi.mapper;

import com.baizhi.entity.WheelPlanting;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface WheelPlantingMapper {
    //查询轮播图分页查询
    List<WheelPlanting> queryPaging(@Param("page") Integer page,@Param("rows") Integer rows);
    //查询轮播图总条数
    int selectCount();
    //添加轮播图
    void addWheelPlanting(WheelPlanting wheelPlanting);
    //批量删除轮播图
    void removeWheelPlanting(String [] id);
    //修改轮播图
    void updateWheelPlanting(WheelPlanting wheelPlanting);



}
