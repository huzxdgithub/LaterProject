package com.baizhi.serviceimpl;

import com.baizhi.mapper.CountMapper;
import com.baizhi.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountServiceImpl implements CountService {
    @Autowired
    CountMapper countMapper;
}
