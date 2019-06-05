package com.baizhi.serviceimpl;
import com.baizhi.aopcache.AddCache;
import com.baizhi.aopcache.DelCache;
import com.baizhi.entity.Guru;
import com.baizhi.mapper.GuruMapper;
import com.baizhi.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class GuruServiceImpl implements GuruService {
    @Autowired
    GuruMapper guruMapper;
    //分页展示上师
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    @AddCache
    public Map<String, Object> queryPaging(Integer page,Integer rows) {
       Map<String,Object> map= new ConcurrentHashMap<String,Object>();
        //放入当前页
        map.put("page",page);
        //放入总条数
        Integer totalCount = guruMapper.selectCount();
        map.put("records",totalCount);
        //放入最大页数
        if(totalCount%rows!=0){
            map.put("total",totalCount/rows+1);
        }else{
            map.put("total",totalCount/rows);
        }
        //放入数据
        List<Guru> gurus = guruMapper.queryPaging((page-1)*rows, rows);
        map.put("rows",gurus);
        return map;
    }
    //添加上师
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    @DelCache
    public String addGuru(Guru guru) {
        String s = UUID.randomUUID().toString();
        guru.setId(s);
        guru.setCreateDate(new Date());
        guruMapper.addGuru(guru);
        return s;

    }
    //删除上师
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    @DelCache
    public void removeGuru(String[] id) {
        guruMapper.removeGuru(id);
    }
    //修改上师
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    @DelCache
    public void updateGuru(Guru guru) {
        guru.setCreateDate(new Date());
        if(("").equals(guru.getPicturePath())){
            guru.setPicturePath(null);
        }
        guruMapper.updateGuru(guru);
    }
}
