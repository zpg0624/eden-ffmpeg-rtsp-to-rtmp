package com.eden.ffmpeg.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @created by eden
 * @since 2019-03-26 下午 5:29:46
 */

@Data
public class RequestParam implements Serializable {

    private final static String FFMPEG_PATH = "D:\\video\\ffmpeg\\bin/ffmpeg";
    private final static String FFPROBE_PATH = "D:\\video\\ffmpeg\\bin/ffprobe";
    public final static String RTMP_PREFIX = "rtmp://localhost:1935/live/";

    private String ffmpegPath = FFMPEG_PATH;

    private String ffprobePath = FFPROBE_PATH;

    /**
     * rtsp原播放地址
     */
    private String rtspSourcePath;

    /**
     * 转换后地址后缀
     */
    private String targetFileNameSuffix;


    private Integer count;

    /**
     * @param suffixFileName
     * @return
     */
    public static String resolveRTMPPath(String suffixFileName) {
        StringBuilder path = new StringBuilder();
        path.append(RTMP_PREFIX).append(suffixFileName);
        return path.toString();
    }
}
