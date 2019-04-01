package com.eden.ffmpeg.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @created by eden
 * @since 2019-03-26 下午 5:29:46
 */

@Data
public class RequestParam implements Serializable {

    /**
     * rtsp原播放地址
     */
    @NotNull
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
    public static String resolveRTMPPath(String suffixFileName, String rtmpPrefix) {
        StringBuilder path = new StringBuilder();
        path.append(rtmpPrefix).append(suffixFileName);
        return path.toString();
    }
}
