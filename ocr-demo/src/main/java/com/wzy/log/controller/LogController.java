package com.wzy.log.controller;

import com.wzy.log.entity.Log;
import com.wzy.log.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Package: com.wzy.log.controller
 * @Author: Clarence1
 * @Date: 2019/9/17 16:16
 */
@RestController
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping(value = "/log/{userId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Log> getLogsByUserId(@PathVariable("userId") Long userId) {
        return logService.getLogsByUserId(userId);
    }

}
