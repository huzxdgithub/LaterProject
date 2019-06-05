package com.baizhi.contorller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.apache.commons.io.FileUtils;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

@RestController
@RequestMapping("/Chapter")
public class ChapterContorller {
    @Autowired
    ChapterService chapterService;
    //查询所有分页jqGrid展示
    @RequestMapping("/queryPaging")
    public   Map<String,Object>queryPaging(Integer page,Integer rows,String id){
        return  chapterService.queryPaging(page, rows, id);
    }
    //音频的增删改
    @RequestMapping("/edit")
    @ResponseBody
    public String edit(Chapter chapter,String oper,String[] id){
        if("add".equals(oper)){
            if(!("").equals(chapter.getAudioFrequency())){
                Map<String, Object> map = chapterService.addAudioFrequency(chapter);
                //返回添加id进而上传文件同时修改图片路径
                return (String) map.get("id");
            }
            return null;
        }
        if("del".equals(oper)){
            chapterService.removeAudioFrequency(id);
        }
        if("edit".equals(oper)){
            chapterService.updateAudioFrequency(chapter);
            if(("").equals(chapter.getAudioFrequency())||chapter.getAudioFrequency()==null){
                return null;
            }
            return chapter.getId();
        }
    return  null;
    }


        //下载音频
        @RequestMapping("downLoad")
        public void download(String filename, HttpSession session, HttpServletResponse response){
            chapterService.download(session,response,filename);
        }
        //上传
        @RequestMapping("/upload")
        @ResponseBody
        public void upload(HttpSession session, MultipartFile audioFrequency,String id){
                       chapterService.upload(session,audioFrequency,id);
        }
    }
    //这个下载有问题下载完成不能播放 狗B东西
/*    public ResponseEntity<byte[]> download(String filename, HttpSession session){
        //获取下载文件路径
        String realPath = session.getServletContext().getRealPath("/audiofrequency");
        //代表下载的目标文件
        File file= new File(realPath+"/"+filename);
        byte[] bytes=null;
        HttpHeaders httpHeaders=null;
        try {
            //把下载的文件转换为字节数组
            bytes = FileUtils.readFileToByteArray(file);
            //设置http协议请求头
            httpHeaders = new HttpHeaders();
            //解决下载过后文件名乱码问题
            String s = new String(filename.getBytes("UTF-8"), "iso-8859-1");
            //设置下载时打开的方式        以附件的形式进行下载
            httpHeaders.setContentDispositionFormData("attachment",s);
            //设置下载方式为二进制流的形式
            httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(bytes,httpHeaders, HttpStatus.CREATED);
    }*/

