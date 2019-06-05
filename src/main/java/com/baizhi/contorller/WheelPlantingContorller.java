package com.baizhi.contorller;

import com.baizhi.entity.WheelPlanting;
import com.baizhi.service.WheelPlantingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@Controller
@RequestMapping("WheelPlanting")
public class WheelPlantingContorller {
    @Autowired
    WheelPlantingService wheelPlantingService;
    @RequestMapping("queryWheelPlanting")
    @ResponseBody
    //分页查询轮播图 jqGrid
    public Map<String,Object> queryWheelPlanting(Integer page,Integer rows){
     return    wheelPlantingService.queryPaging(page,rows);
    }
    @RequestMapping("/edit")
    @ResponseBody
    //增删改jqGrid
    public String edit(WheelPlanting wheelPlanting, String oper,String [] id ){
        if(oper.equals("del")){
            wheelPlantingService.removeWheelPlanting(id);
        }
        if(oper.equals("edit")){
            wheelPlantingService.updateWheelPlanting(wheelPlanting);
            return wheelPlanting.getId();
        }

        if(oper.equals("add")){
            if(!"".equals(wheelPlanting.getPicturePath())){
                 return  wheelPlantingService.addWheelPlanting(wheelPlanting);
             }
        }
        return null;
    }
    //上传图片
    @RequestMapping("/upload")
    @ResponseBody
    public void upload(String id,MultipartFile picturePath,HttpSession session){
        String originalFilename = picturePath.getOriginalFilename();
        if(!"".equals(originalFilename)||originalFilename==null){
        try {
            String realPath = session.getServletContext().getRealPath("/projectimg/audioCollection");
            picturePath.transferTo(new File(realPath+"/"+originalFilename));
            WheelPlanting wheelPlanting = new WheelPlanting();
            String replace = id.replace("\"", "");
            wheelPlanting.setId(replace);
            wheelPlanting.setPicturePath(originalFilename);
            wheelPlantingService.updateWheelPlanting(wheelPlanting);
        } catch (IOException e) {
            e.printStackTrace();
        }
        }

    }
    //jqGrid查询所有部门
    @RequestMapping("/select")
    @ResponseBody
    public void optins(HttpServletResponse response){
        StringBuilder sb = new StringBuilder();
        response.setContentType("text/html;charset=utf-8");
        sb.append("<select>");
        sb.append("<option value=1>展示</option>");
        sb.append("<option value=2>不展示</option>");
        sb.append("</select>");
        try {
            PrintWriter writer = response.getWriter();
            writer.print(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
