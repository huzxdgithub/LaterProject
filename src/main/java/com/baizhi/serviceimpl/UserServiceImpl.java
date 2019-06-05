package com.baizhi.serviceimpl;

import com.baizhi.Dto.UserDto;
import com.baizhi.aopcache.AddCache;
import com.baizhi.aopcache.DelCache;
import com.baizhi.entity.User;
import com.baizhi.mapper.UserMapper;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    //分页展示用户
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    @AddCache
    public Map<String, Object> queryPaging(Integer page, Integer rows) {
       Map<String ,Object> map= new ConcurrentHashMap<String,Object>();
        //放入当前页
        map.put("page",page);
        //放入总条数
        Integer totalCount = userMapper.selectCount();
        map.put("records",totalCount);
        if(totalCount%rows!=0){
            map.put("total",totalCount/rows+1);
        }else{
            map.put("total",totalCount/rows);
        }
        List<User> users = userMapper.queryPaging((page - 1) * rows, rows);
        map.put("rows",users);
        return map;
    }
    //添加用户
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    @DelCache
    public String addUser(User user) {
        user.setCreateDate(new Date());
        userMapper.addUser(user);
        return null;
    }
    //修改用户
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    @DelCache
    public String updateUser(User user) {
        user.setCreateDate(new Date());
        userMapper.updateUser(user);
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    @AddCache
    public List<User> selectAll() {
        return userMapper.queryPaging(0, 100);
    }
    //查询最近七天注册的用户 返回页面走势图
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    @AddCache
    public List<User> selectUserSevenDay() {
        return  userMapper.selectUserSevenDay();
    }
    //查询月份用户走势图
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public UserDto  selectUserMonth() {
        List<User> users = userMapper.selectUserMonth();
        UserDto userDto = new UserDto();
        List<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        for (User user : users) {
            System.out.println(user);
            strings.add(user.getMonth1()+"月份");
            integers.add(user.getValue());
        }
        userDto.setName(strings);
        userDto.setValue(integers);
        return userDto;
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    @AddCache
    public List<User> selectMap() {
        List<User> users = userMapper.selectMap();
        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }
}
