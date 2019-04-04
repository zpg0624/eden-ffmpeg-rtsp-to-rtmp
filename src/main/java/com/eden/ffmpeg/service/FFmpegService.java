package com.eden.ffmpeg.service;

import com.eden.ffmpeg.entity.RequestParam;
import lombok.extern.slf4j.Slf4j;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.job.FFmpegJob;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @created by eden
 * @since 2019-03-27 上午 9:28:47
 */

@Service
@Slf4j
public class FFmpegService {

    @Value("${video.ffmpeg.path}")
    private String ffmpegPath;

    @Value("${video.ffprobe.path}")
    private String ffprobePath;

    @Value("${video.rtmp.prefix}")
    private String rtmpPrefix;

    public String getRtmpPrefix() {
        return rtmpPrefix;
    }

//    @Autowired
//    SourcePathInfoRepository repository;

    @Async
    public void execute(RequestParam param, String rtmpPath) {
        try {
            FFmpeg ffmpeg = new FFmpeg(ffmpegPath);
            FFprobe ffprobe = new FFprobe(ffprobePath);
            FFmpegBuilder builder = new FFmpegBuilder()
                    .setInput(param.getRtspSourcePath())
                    .addOutput(rtmpPath)
                    .setFormat("flv")
                    .setVideoCodec("libx264")     // Video using x264
                    .setVideoFrameRate(24, 1)     // at 24 frames per second
                    .setVideoResolution(640, 480) // at 640x480 resolution
                    .setStrict(FFmpegBuilder.Strict.EXPERIMENTAL) // Allow FFmpeg to use experimental specs
                    .done();
            FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);
            FFmpegJob job = executor.createJob(builder);
            job.run();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("ffmpeg execute command failed:{}", e);
        }
    }


//    public List<Result> getRtspUrls(Integer count) {
//        Page<SourcePathInfo> pathInfos = repository.findAll(PageRequest.of(0, count));
//        List<Result> results = pathInfos.get()
//                .map(rstp -> Result.of(rstp.getPath(), UUID.randomUUID().toString()))
//                .collect(Collectors.toList());
//        return results;
//    }
}
