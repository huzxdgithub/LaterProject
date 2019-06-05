package com.baizhi.service;

import com.baizhi.entity.Chapter;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public interface ChapterService {
    //分页展示jqGrid
    Map<String,Object>queryPaging(Integer page,Integer rows,String id);
    //添加音频
    Map<String,Object>addAudioFrequency(Chapter chapter);
    //删除音频
    void removeAudioFrequency(String []id);
    //修改音频
    Map<String,Object>updateAudioFrequency(Chapter chapter);
    //下载音频
    void  download(HttpSession session, HttpServletResponse response,String fileName);
    //上传音频
    void upload(HttpSession session, MultipartFile audioFrequency,String id);


}
