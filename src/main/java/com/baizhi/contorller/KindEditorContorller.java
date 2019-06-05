package com.baizhi.contorller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/KindEditor")
public class KindEditorContorller {
    @RequestMapping("/upload")
    public  Map<String,Object>  kindEditorUpload(MultipartFile img, HttpServletRequest request){
        String realPath = request.getSession().getServletContext().getRealPath("/projectimg/img");
        Map<String,Object> map=new HashMap<>();
        File file= new File(realPath);
        if(!file.exists()){
            file.mkdirs();
        }
        String url=null;
        try {
            String originalFilename = img.getOriginalFilename();
            long time = new Date().getTime();
            String s = time + "_" + originalFilename;
            img.transferTo(new File(realPath,s));

            //http
            String scheme = request.getScheme();
            //localhost
            InetAddress localHost = InetAddress.getLocalHost();
            String localhost = localHost.toString().split("/")[1];
            //port  8000
            int serverPort = request.getServerPort();
            //项目名称
            String contextPath = request.getContextPath();
            url=scheme+"://"+localhost+":"+serverPort+contextPath+"/projectimg/img/"+s;
            map.put("error",0);
        } catch (IOException e) {
            map.put("error",1);
            e.printStackTrace();
        }
        map.put("url",url);
        return map;
    }
    @RequestMapping("/getAll")
    public Map<String,Object> getAll(HttpServletRequest request){
        String realPath = request.getSession().getServletContext().getRealPath("/projectimg/img");
        Map<String,Object> map=new HashMap<String,Object>();
        File file=new File(realPath);
        String[] imgs = file.list();//获取所有的图片对象
        List<Object>list=new ArrayList<Object>();
        for (String img : imgs) {
            Map<String, Object> map1 = new HashMap<>();
            map1.put("is_dir",false);
            map1.put("has_file",false);
            //获取图片大小
            map1.put("filesize",new File(realPath,img).length());
            map1.put("dir_path","");
            map1.put("is_photo",true);
            //动态获取文件格式   返回值就是后缀名   img就是文件名称
            String extension = FilenameUtils.getExtension(img);
            map1.put("filetype",extension);
            map1.put("filename",img);
            String s = img.split("_")[0];//获取时间戳
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = simpleDateFormat.format(new Date(new Long(s)));
            map1.put("datetime",format);
            list.add(map1);
        }
        map.put("file_list",list);
        map.put("moveup_dir_path","");
        //http
        String scheme = request.getScheme();
        //localhost
        InetAddress localHost = null;
        try {
            localHost = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String localhost = localHost.toString().split("/")[1];
        //port  8000
        int serverPort = request.getServerPort();
        //项目名称
        String contextPath = request.getContextPath();

        String   url=scheme+"://"+localhost+":"+serverPort+contextPath+"/projectimg/img/";
        System.out.println(url);
        map.put("current_url",url);
        map.put("total_count",imgs.length);

        return map;
    }
}
