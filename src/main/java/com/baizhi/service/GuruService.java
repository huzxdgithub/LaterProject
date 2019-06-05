package com.baizhi.service;

import com.baizhi.entity.Guru;

import java.util.Map;

public interface GuruService {
    //分页展示上师
    Map<String ,Object> queryPaging(Integer page,Integer rows);
    //添加上师
    String addGuru(Guru guru);
    //删除上师
    void removeGuru(String[] id);
    //修改上师
    void updateGuru(Guru guru);

}
