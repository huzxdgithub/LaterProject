package com.baizhi.contorller;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baizhi.ValidateUtis.ValidateImageCodeUtils;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/Admin")
public class AdminContorller {
        @Autowired
        private AdminService adminService;
        @RequestMapping("/login")
        @ResponseBody
        //登陆
        public String login(Admin admin, String code,HttpSession session){

            return adminService.login(admin,session,code);
        }
        //退出
        @RequestMapping("/logout")
        @ResponseBody
        public void logout(){
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
        }


    //验证码
    @RequestMapping("/validationCode")
    public void validate(HttpServletResponse response, HttpServletRequest request) {
       //绘制验证码
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        request.getSession().setAttribute("validationCode",securityCode);

        //绘制验证码图片
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        //写出    1.图片 2.图片的格式  3.输出流
        ServletOutputStream outputStream =null;
        try{
            outputStream=  response.getOutputStream();
            ImageIO.write(image,"png",outputStream);
        }catch ( Exception e){
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
