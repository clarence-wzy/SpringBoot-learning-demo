package com.wzy.log.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Package: com.wzy.log.mapper.entity
 * @Author: Clarence1
 * @Date: 2019/9/17 15:43
 */
@Data
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    private String logId;
    private String type;
    private String title;
    private String remoteAddr;
    private String requestUri;
    private String method;
    private String params;
    private String exception;
    private Long userId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date operateDate;

    private String timeout;

}
