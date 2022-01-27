package com.eden.ffmpeg.controller;

import com.eden.ffmpeg.entity.RequestParam;
import com.eden.ffmpeg.entity.ResponseMsg;
import com.eden.ffmpeg.entity.Result;
import com.eden.ffmpeg.service.FFmpegService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @created by eden
 * @since 2019-03-27 上午 9:50:52
 */

@RestController
@Slf4j
public class FfmpegController {


    @Autowired
    FFmpegService fFmpegService;


    /**
     * 获取rtsp地址
     *
     * @param param
     * @return
     */
    @PostMapping("rtsps")
    public ResponseMsg getRtsps(@RequestBody RequestParam param) {
        log.info("request rtsp utls param is {}", param.toString());
        List<Result> rtsps = fFmpegService.getRtspUrls(param.getCount());
        return ResponseMsg.success(rtsps);
    }


    /**
     * 执行rtsp转换到rtmp命令
     *
     * @param params
     * @return
     */
    @PostMapping("ffmpeg")
    public ResponseMsg executeCommand(@RequestBody List<RequestParam> params) {
        log.info("request ffmpeg param is {}", params.toString());
        List<Result> results = params.stream()
                .map(param -> Optional.ofNullable(param.getRtspSourcePath())
                        .map(path -> executePath(param))
                        .orElseThrow(IllegalArgumentException::new)
                )
                .collect(Collectors.toList());
        return ResponseMsg.success(results);
    }


    private Result executePath(RequestParam param) {
        Result result = new Result();
        result.setSourcePath(param.getRtspSourcePath());
        String suffix = new String(Base64.getEncoder().encode(param.getRtspSourcePath().getBytes()));
        String rtmpPath = RequestParam.resolveRTMPPath(suffix, fFmpegService.getRtmpPrefix());
        //异步执行
        fFmpegService.execute(param, rtmpPath);
        result.setTargetPath(fFmpegService.getRtmpPrefix());
        result.setTargetSuffix(suffix);
        return result;
    }
}
