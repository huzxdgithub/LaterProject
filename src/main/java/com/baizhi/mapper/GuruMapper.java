package com.baizhi.mapper;

import com.baizhi.entity.Guru;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GuruMapper {
    //分页展示上师
    List<Guru>queryPaging(@Param("page") Integer page,@Param("rows") Integer rows);
    //查询所有上师
    Integer selectCount();
    //添加上师
    void addGuru(Guru guru);
    //删除上师
    void removeGuru(String[] id);
    //修改上师
    void updateGuru(Guru guru);

}
