package com.baizhi.mapper;

import com.baizhi.entity.Chapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChapterMapper {
    //分页jqGrid展示
    List<Chapter> queryPaging(@Param("page") Integer page,@Param("rows") Integer rows,@Param("id") String id);
    //查询总条数
    Integer   selectCount(@Param("id") String id);
    //添加音频
    void addAudioFrequency(Chapter chapter);
    //删除音频
    void removeAudioFrequency(String [] id);
    //修改音频
    void updateAudioFrequency(Chapter chapter);

}
