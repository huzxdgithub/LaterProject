package com.baizhi.contorller;

import com.baizhi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Task")
public class TaskContorller {
    @Autowired
    TaskService taskService;
}
