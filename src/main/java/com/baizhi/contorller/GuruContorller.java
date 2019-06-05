package com.baizhi.contorller;

import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Map;
@Controller
@RequestMapping("/GuRu")
public class GuruContorller {

    @Autowired
    GuruService guruService;
    //分页展示上师
    @RequestMapping("queryPaging")
    @ResponseBody
    public Map<String, Object> queryPaging(Integer page, Integer rows) {
        Map<String, Object> map = guruService.queryPaging(page, rows);
        return map;
    }

    //增删改上师
    @RequestMapping("/edit")
    @ResponseBody
    public String edit(Guru guru, String oper, String[] id) {
        if (!("").equals(guru.getPicturePath())) {
            if (oper.equals("add")) {
                String s = guruService.addGuru(guru);
                return s;
            }
        }
        if (oper.equals("del")) {
            guruService.removeGuru(id);
        }
        if (oper.equals("edit")) {
            guruService.updateGuru(guru);
            if(("").equals(guru.getPicturePath())||guru.getPicturePath()==null){
                 return null;
            }
            return guru.getId();
        }
        return null;
    }
    @RequestMapping("/upload")
    @ResponseBody
    public void upload(MultipartFile picturePath, String id, HttpSession session){
        String originalFilename = picturePath.getOriginalFilename();
        if(!("").equals(originalFilename)){
            String realPath = session.getServletContext().getRealPath("/projectimg/audioCollection");
            try {
                picturePath.transferTo(new File(realPath+"/"+originalFilename));
                Guru guru = new Guru();
                guru.setPicturePath(originalFilename);
                guru.setId(id.replace("\"",""));

                guruService.updateGuru(guru);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
