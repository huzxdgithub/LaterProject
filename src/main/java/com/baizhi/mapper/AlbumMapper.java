package com.baizhi.mapper;

import com.baizhi.entity.Album;

import java.util.List;
import java.util.Map;

public interface AlbumMapper {
        //查询专辑分页展示
        List<Album>queryPaging(Integer page,Integer rows);
        //查询所有Album数量
        Integer selectCount();
        //添加专辑
        void addAlbum(Album album);
        //修改专辑
        void updateAlbum(Album album);
        //删除专辑
        void removeAlbum(String[] id);

}
