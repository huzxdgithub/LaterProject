package com.baizhi.serviceimpl;

import com.baizhi.aopcache.AddCache;
import com.baizhi.aopcache.DelCache;
import com.baizhi.entity.Album;
import com.baizhi.mapper.AlbumMapper;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    AlbumMapper albumMapper;
    @Override
    //专辑查询 分页展示jqgrid
    @AddCache
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map<String, Object> queryPaging(Integer page,Integer rows) {
        Map<String, Object> map = new ConcurrentHashMap<String ,Object>();
        //放入当前页号
        map.put("page",page);
        int totalCount = albumMapper.selectCount();
        //放入条数
        map.put("records",totalCount);
        //放入最大页
        if(totalCount%rows!=0){
            map.put("total",totalCount/rows+1);
        }else {
            map.put("total",totalCount/rows);
        }
        //放入数据
        List<Album> albums = albumMapper.queryPaging(page,rows);
        map.put("rows",albums);
        return map;
    }
    //添加专辑
    @Override
    @DelCache
    @Transactional(propagation = Propagation.REQUIRED)
    public String addAlbum(Album album) {
        String s = UUID.randomUUID().toString();
        album.setId(s);
        album.setCount(1);
        album.setCreateDate(new Date());
        albumMapper.addAlbum(album);
        return s;
    }
    //删除专辑
    @DelCache
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteAlbum(String[] id) {
        albumMapper.removeAlbum(id);
    }
    //修改专辑
    @DelCache
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public String updateAlbum(Album album) {
        album.setCreateDate(new Date());
        if("".equals(album.getPicturePath())){
            album.setPicturePath(null);
            albumMapper.updateAlbum(album);
            return null;
        }else{
            albumMapper.updateAlbum(album);
        }
        return album.getId();
    }
    @DelCache
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void upload(MultipartFile picturePath, HttpSession session, String id) {
        String originalFilename = picturePath.getOriginalFilename();
        if(!("").equals(originalFilename)||originalFilename==null){
            String realPath = session.getServletContext().getRealPath("/projectimg/audioCollection");
            try {
                picturePath.transferTo(new File(realPath+"/"+originalFilename));
                Album album = new Album();
                album.setId(id.replace("\"",""));
                album.setPicturePath(originalFilename);
                albumMapper.updateAlbum(album);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
