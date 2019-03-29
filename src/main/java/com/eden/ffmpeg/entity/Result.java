package com.eden.ffmpeg.entity;

import lombok.Data;

/**
 * @created by eden
 * @since 2019-03-27 上午 10:43:49
 */

@Data
public class Result {
    private String sourcePath;

    private String targetPath;

    private String targetSuffix;

    public Result() {
    }

    public Result(String targetPath, String targetSuffix) {
        this.targetPath = targetPath;
        this.targetSuffix = targetSuffix;
    }

    /**
     * create  result static method
     * @param targetPath
     * @param targetSuffix
     * @return
     */
    public static Result of(String targetPath, String targetSuffix){
        return new Result(targetPath,targetSuffix);
    }
}
