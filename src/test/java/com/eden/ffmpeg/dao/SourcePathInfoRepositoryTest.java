package com.eden.ffmpeg.dao;

import com.eden.ffmpeg.FfmpegApplicationTests;
import com.eden.ffmpeg.entity.SourcePathInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * @created by eden
 * @since 2019-03-29 上午 10:42:40
 */
public class SourcePathInfoRepositoryTest extends FfmpegApplicationTests {
    @Autowired
    SourcePathInfoRepository repository;

    @Test
    public void  testFind(){
        Page<SourcePathInfo> pathInfos = repository.findAll(PageRequest.of(0, 2));
        System.err.println(pathInfos.get().collect(Collectors.toList()));

    }

    @Test
    public void  testSave(){
     SourcePathInfo sourcePathInfo = new SourcePathInfo();

     sourcePathInfo.setPath("安保部");
     sourcePathInfo.setCreateTime(LocalDateTime.now());
     repository.save(sourcePathInfo);


    }

}