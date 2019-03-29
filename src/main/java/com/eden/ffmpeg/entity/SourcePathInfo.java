package com.eden.ffmpeg.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @created by eden
 * @since 2019-03-29 上午 10:26:29
 */

@Entity
@Table(name = "t_source_path_info")
@Data
public class SourcePathInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column
    private String path;


    @Column(name = "create_time")
    private LocalDateTime createTime;
}
