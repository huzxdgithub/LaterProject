package com.baizhi.contorller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
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
@RequestMapping("/Album")
public class AlbumContorller {
    @Autowired
    AlbumService albumService;
    @RequestMapping("/queryPaging")
    @ResponseBody
    //查询专辑
    public Map<String ,Object> selectAlbum(Integer page, Integer rows){
      return   albumService.queryPaging(page,rows);
    }
    //jqGrid增删改专辑
    @RequestMapping("/edit")
    @ResponseBody
    public String edit(Album album,String[] id,String oper){
        if(!"".equals(album.getPicturePath())){
            if(oper.equals("add")){
                String s = albumService.addAlbum(album);
                  return s;
            }
        }if(oper.equals("del")){
                albumService.deleteAlbum(id);
        }if(oper.equals("edit")){
            return albumService.updateAlbum(album);
        }

        return null;
    }
    //上传并修改图片路径
    @RequestMapping("/upload")
    @ResponseBody
    public void upload(MultipartFile picturePath, HttpSession session,String id){
        albumService.upload(picturePath,session,id);
    }
}
