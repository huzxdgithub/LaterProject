package com.baizhi.contorller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.Dto.UserDto;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/User")
public class UserContorller {
    @Autowired
    UserService userService;
    //分页展示用户
    @RequestMapping("/queryPaging")
    public Map<String ,Object>  queryPaging(Integer page,Integer rows){
        Map<String, Object> map = userService.queryPaging(page, rows);
        return map;
    }
    //近七天用户走势图
    @RequestMapping("/selectUserSevenDay")
    public List<User> selectUserSevenDay(){
        return  userService.selectUserSevenDay();
    }
    //月份用户走势图
    @RequestMapping("/selectUserMonth")
    public UserDto  selectUserMonth(){
        UserDto userDto = userService.selectUserMonth();
        return userDto;
    }
    //用户地图分布走势图
    @RequestMapping("/selectMap")
    public List<User>selectMap(){
        List<User> users = userService.selectMap();
        return users;
    }
    //导出
    @RequestMapping("/Export")
    public void Export(HttpServletResponse response, HttpSession session){
        String realPath = session.getServletContext().getRealPath("/projectimg/img/");
        List<User> list = userService.selectAll();
        for (User row : list) {
            row.setPicturePath(realPath+row.getPicturePath());
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("标题用户", "用户"),
                User.class, list
        );
        try {
            response.setHeader("content-disposition","attachment;filename="+URLEncoder.encode("150.xls","UTF-8"));
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //导入
    @RequestMapping("/upload")
    public void Import(MultipartFile file){
        System.out.println(file);
        System.out.println(file.getOriginalFilename());
        try {
            ImportParams params = new ImportParams();
            params.setTitleRows(1);
            params.setHeadRows(1);
            List<User> users = ExcelImportUtil.importExcel(file.getInputStream(), User.class, params);
            for (User user : users) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
