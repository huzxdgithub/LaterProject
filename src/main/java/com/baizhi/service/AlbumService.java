package com.baizhi.service;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface AlbumService {
    //查询专辑 分页jqgrid展示
    Map<String ,Object> queryPaging(@Param("page") Integer page, @Param("rows") Integer rows);
    //添加专辑
    String addAlbum(Album album);
    //删除专辑
    void deleteAlbum(String [] id);
    //修改专辑
    String updateAlbum(Album album);
    //Album上传
    void upload(MultipartFile picturePath, HttpSession session, String id);
}
