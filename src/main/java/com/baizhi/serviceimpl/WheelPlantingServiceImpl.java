package com.baizhi.serviceimpl;
import com.baizhi.aopcache.AddCache;
import com.baizhi.aopcache.DelCache;
import com.baizhi.entity.WheelPlanting;
import com.baizhi.mapper.WheelPlantingMapper;
import com.baizhi.service.WheelPlantingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class WheelPlantingServiceImpl implements WheelPlantingService {
    @Autowired
    WheelPlantingMapper wheelPlantingMapper;
    @Override
    //分页查询轮播图 jqGrid展示
    @Transactional(propagation = Propagation.SUPPORTS)
    @AddCache
    public Map<String, Object> queryPaging(Integer page, Integer rows) {
        Map<String, Object> map = new ConcurrentHashMap<String ,Object>();
        //放入当前页号
        map.put("page",page);
        //放入轮播图总条数
        Integer totalCount=wheelPlantingMapper.selectCount();
        map.put("records",totalCount);
        //放入最大页数
        if(totalCount%rows==0){
            map.put("total",totalCount/rows);
        }else {
            map.put("total",totalCount/rows+1);
        }
        //放入数据
        List<WheelPlanting> wheelPlantings = wheelPlantingMapper.queryPaging(page, rows);
        map.put("rows",wheelPlantings);
        return map;
    }
    //添加轮播图
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    @DelCache
    public String addWheelPlanting(WheelPlanting wheelPlanting) {
        wheelPlanting.setCreateDate(new Date());
        String s = UUID.randomUUID().toString();
        wheelPlanting.setId(s);
         wheelPlantingMapper.addWheelPlanting(wheelPlanting);
        return s;
    }
    //批量删除轮播图
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    @DelCache
    public void removeWheelPlanting(String [] id) {
        wheelPlantingMapper.removeWheelPlanting(id);
    }
    //修改轮播图
    @Override
    @DelCache
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateWheelPlanting(WheelPlanting  wheelPlanting) {
        wheelPlanting.setCreateDate(new Date());
        if("".equals(wheelPlanting.getPicturePath())){
            wheelPlanting.setPicturePath(null);
        }
        wheelPlantingMapper.updateWheelPlanting(wheelPlanting);
    }

}
