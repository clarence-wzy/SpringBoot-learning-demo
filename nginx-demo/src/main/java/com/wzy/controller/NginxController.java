package com.wzy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wzy.service.NginxService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: com.wzy.controller
 * @Author: Clarence1
 * @Date: 2019/10/4 20:17
 */
@RestController
@Slf4j
public class NginxController {

    @Autowired
    private NginxService nginxService;

    /**
     * 可上传图片、视频，只需在nginx配置中配置可识别的尾缀
     */
    @PostMapping("/upload")
    public String pictureUpload(@RequestParam(value = "file") MultipartFile uploadFile) {
        long begin = System.currentTimeMillis();
        String json = "";
        try {
            Object result = nginxService.uploadPicture(uploadFile);
            // 浏览器擅长处理json格式的字符串，为了减少因为浏览器内核不同导致的bug，建议用json
            json = new ObjectMapper().writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        log.info("定时任务结束，共耗时：[" + (end-begin) + "]毫秒");
        return json;
    }

    @PostMapping("/uploads")
    public Object picturesUpload(@RequestParam(value = "file") MultipartFile[] uploadFile) {
        long begin = System.currentTimeMillis();
        Map<Object, Object> map = new HashMap<>(10);

        int count = 0;
        for (MultipartFile file : uploadFile) {
            Object result = nginxService.uploadPicture(file);
            map.put(count, result);
            count++;
        }
        long end = System.currentTimeMillis();
        log.info("定时任务结束，共耗时：[" + (end-begin) + "]毫秒");
        return map;
    }

}
