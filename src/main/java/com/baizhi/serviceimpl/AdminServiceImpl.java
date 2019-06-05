package com.baizhi.serviceimpl;

import com.baizhi.aopcache.AddCache;
import com.baizhi.entity.Admin;
import com.baizhi.mapper.AdminMapper;
import com.baizhi.service.AdminService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class AdminServiceImpl implements AdminService {
    //登陆
    @Override
    public String login(Admin admin, HttpSession session, String code) {
        if (session.getAttribute("validationCode").equals(code)) {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(admin.getAdminName(),admin.getAdminPassword());
            try {
                subject.login(token);
                return "正确";
            } catch (UnknownAccountException e) {
                return "用户名错误";
            } catch (IncorrectCredentialsException e) {
                return "密码错误";
            }
        }
        return "验证码错误";
    }
}
