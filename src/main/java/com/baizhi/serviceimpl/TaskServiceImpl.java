package com.baizhi.serviceimpl;

import com.baizhi.mapper.TaskMapper;
import com.baizhi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskMapper taskMapper;

}
