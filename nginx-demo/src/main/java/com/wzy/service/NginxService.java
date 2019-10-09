package com.wzy.service;

import com.wzy.util.FtpUtil;
import com.wzy.util.IDUtils;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Package: com.wzy.service
 * @Author: Clarence1
 * @Date: 2019/10/4 21:34
 */
@Service
@Slf4j
public class NginxService {

    public Object uploadPicture(MultipartFile uploadFile) {
        //1、给上传的图片生成新的文件名
        //1.1获取原始文件名
        String oldName = uploadFile.getOriginalFilename();
        //1.2使用IDUtils工具类生成新的文件名，新文件名 = newName + 文件后缀
        String newName = IDUtils.genImageName();
        assert oldName != null;
        newName = newName + oldName.substring(oldName.lastIndexOf("."));
        //1.3生成文件在服务器端存储的子目录
        String filePath = new DateTime().toString("/yyyyMMdd/");

        //2、把图片上传到图片服务器
        //2.1获取上传的io流
        InputStream input = null;
        try {
            input = uploadFile.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //2.2调用FtpUtil工具类进行上传
        return FtpUtil.putImages(input, filePath, newName);
    }

}
