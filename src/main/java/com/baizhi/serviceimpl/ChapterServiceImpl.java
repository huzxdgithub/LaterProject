package com.baizhi.serviceimpl;

import com.baizhi.entity.Chapter;
import com.baizhi.mapper.ChapterMapper;
import com.baizhi.service.ChapterService;
import org.apache.commons.io.FileUtils;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    ChapterMapper chapterMapper;
    //分页jqGrid展示,章节列表
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map<String, Object> queryPaging(Integer page, Integer rows, String id) {
        Map<String,Object> map=new  ConcurrentHashMap<String ,Object>();
        //放入当前页
        map.put("page",page);
        //放入总条数
        Integer totalCount=chapterMapper.selectCount(id);
        map.put("records",totalCount);
        if(totalCount%rows!=0){
            map.put("total",totalCount/rows+1);
        }else{
            map.put("total",totalCount/rows);
        }
        page=(page-1)*rows;
        List<Chapter> chapters = chapterMapper.queryPaging(page, rows, id);
        map.put("rows",chapters);
        return map;
    }
    //添加音频   添加完成返回ID 做上传操作上传的同时修改音频路径
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String, Object> addAudioFrequency(Chapter chapter) {
        HashMap<String, Object> map = new HashMap<String,Object>();
        String s = UUID.randomUUID().toString();
        chapter.setId(s);
        chapter.setCreateDate(new Date());
        chapterMapper.addAudioFrequency(chapter);
        map.put("id",s);
        return map;
    }
    //删除音频
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void removeAudioFrequency(String[] id) {
        chapterMapper.removeAudioFrequency(id);

    }
    //修改音频
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String, Object> updateAudioFrequency(Chapter chapter) {
        if(("").equals(chapter.getAudioFrequency())){
            chapter.setAudioFrequency(null);
        }
        chapterMapper.updateAudioFrequency(chapter);
        return null;
    }
    //下载
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void download(HttpSession session, HttpServletResponse response, String fileName) {
        String realPath = session.getServletContext().getRealPath("/audiofrequency");
        PrintWriter writer=null;
        try {
            byte[] bytes = FileUtils.readFileToByteArray(new File(realPath + "/" + fileName));
            response.setHeader("content-disposition","attachment;filename="+URLEncoder.encode(fileName,"UTF-8"));
            writer = response.getWriter();
            writer.print(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer!=null) writer.flush();
            if(writer!=null) writer.close();
        }

    }
    //上传
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void upload(HttpSession session, MultipartFile audioFrequency, String id) {
        /**
         * 获取音频时长的jar
         *<groupId>org</groupId>
         * <artifactId>jaudiotagger</artifactId>
         * <version>2.0.3</version>
         * */
        String originalFilename = audioFrequency.getOriginalFilename();
        if (!("").equals(originalFilename)||originalFilename==null){
            System.out.println("修改上传路径");
            String realPath = session.getServletContext().getRealPath("/audiofrequency");
            try {
                audioFrequency.transferTo(new File(realPath+"/"+originalFilename));
                Chapter chapter = new Chapter();

                chapter.setId(id.replace("\"",""));
                //获取文件名
                chapter.setAudioFrequency(originalFilename);
                //获取文件大小
                chapter.setSize(audioFrequency.getSize()/1024/1024+"MB");
                //创建时间
                chapter.setCreateDate(new Date());
                AudioFile read = AudioFileIO.read(new File(realPath + "/" + originalFilename));
                AudioHeader audioHeader = read.getAudioHeader();
                //获取时长
                String muent = audioHeader.getTrackLength() / 60 + "分";
                String seconds = audioHeader.getTrackLength() % 60 + "秒";
                chapter.setDuration(muent+seconds);
                //调用业务
                System.out.println(chapter);
                chapterMapper.updateAudioFrequency(chapter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
