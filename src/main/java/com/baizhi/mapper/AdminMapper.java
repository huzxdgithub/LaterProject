package com.baizhi.mapper;

import com.baizhi.Dto.Role;
import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    //登陆
    Admin login(@Param("adminName")String adminName);
    List<Role>  selectAllRoleAndJurisdiction(@Param("id") Integer id);
}
