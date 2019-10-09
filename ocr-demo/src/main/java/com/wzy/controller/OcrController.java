package com.wzy.controller;

import com.baidu.aip.ocr.AipOcr;
import com.wzy.util.JsonChange;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package: com.wzy.controller
 * @Author: Clarence1
 * @Date: 2019/9/14 23:41
 */
@RestController
public class OcrController {

    @PostMapping(value = "/ocr")
    public Map<Object, Object> ocr(MultipartFile file) throws Exception {
        AipOcr client = new AipOcr("17247027", "1OBVubcETaoDCUxRCfeQeDjN", "G4hsARotv6iweCuDvozOeHaoNqXGOTRG");
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>(4);
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");

        // 参数为二进制数组
        byte[] buf = file.getBytes();
        JSONObject res = client.basicGeneral(buf, options);

        Map map = JsonChange.json2map(res.toString());
        return map;
    }

    @PostMapping(value = "/ocrStr")
    public String ocr1(MultipartFile file) throws Exception {
        AipOcr client = new AipOcr("17247027", "1OBVubcETaoDCUxRCfeQeDjN", "G4hsARotv6iweCuDvozOeHaoNqXGOTRG");
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>(4);
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");

        String str = "";
        // 参数为二进制数组
        byte[] buf = file.getBytes();
        JSONObject res = client.basicGeneral(buf, options);

        Map map = JsonChange.json2map(res.toString());
        //  提取并打印出识别的文字
        List list = (List) map.get("words_result");
        int len = ((List) map.get("words_result")).size();
        for(int i=0; i<len; i++) {
            str = str + ((Map) list.get(i)).get("words") + "\n";
        }

        return str;
    }

}
