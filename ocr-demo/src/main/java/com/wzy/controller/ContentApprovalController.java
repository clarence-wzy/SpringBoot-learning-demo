package com.wzy.controller;

import com.baidu.aip.contentcensor.AipContentCensor;
import com.wzy.log.annotation.ControllerLog;
import com.wzy.util.JsonChange;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * @Package: com.wzy.controller
 * @Author: Clarence1
 * @Date: 2019/9/16 19:22
 */
@RestController
@RequestMapping(value = "/content")
public class ContentApprovalController {

    public static final String APP_ID = "17258144";
    public static final String API_KEY = "aLqkiDK57CHjVNaj3kff5aI6";
    public static final String SECRET_KEY = "eOEiyU5rsHhxXVfuRDZGOCeYwzbMoNVH";

    private AipContentCensor client = new AipContentCensor(APP_ID, API_KEY, SECRET_KEY);

    @ControllerLog(description = "图片内容审核")
    @PostMapping(value = "/image")
    public Map<Object, Object> image(MultipartFile file) throws Exception {
        // 设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 参数为二进制数组
        byte[] buf = file.getBytes();
        JSONObject res = client.imageCensorUserDefined(buf, null);
        System.out.println(res.toString(2));

        Map map = JsonChange.json2map(res.toString());
        String str = (String) map.get("conclusion");
        System.out.println(str);

        return map;
    }

    @ControllerLog(description = "文字内容审核")
    @GetMapping(value = "/text")
    public Map<Object, Object> text(@RequestParam("str") String str) throws Exception {
        JSONObject res = client.antiSpam(str, null);
//        System.out.println(res.toString(2));

        Map map = JsonChange.json2map(res.toString());

        Map map1 = (Map) map.get("result");
        int spam = (Integer) map1.get("spam");
        //  spam参数，0表示非违禁，1表示违禁，2表示建议人工复审
        //  例如“一夜情”违禁
        System.out.println(spam);

        return map;
    }

}
