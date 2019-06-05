package com.baizhi.contorller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baizhi.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Count")
public class CountContorller {
    @Autowired
    CountService countService;

    public static void main(String[] args) {
        String str="{\"abc\":\"bbb\"}";
        Object o = JSONArray.toJSON(str);
        System.out.println(o);
        Object o1 = JSONObject.toJSON(str);
        System.out.println(o1);
    }
}
