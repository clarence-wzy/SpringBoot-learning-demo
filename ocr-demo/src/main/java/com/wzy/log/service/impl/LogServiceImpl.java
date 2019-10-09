package com.wzy.log.service.impl;

import com.wzy.log.entity.Log;
import com.wzy.log.mapper.LogMapper;
import com.wzy.log.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package: com.wzy.log.service
 * @Author: Clarence1
 * @Date: 2019/9/17 15:56
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public int insertLog(Log log) {
        return logMapper.insertLog(log);
    }

    @Override
    public List<Log> getLogsByUserId(Long userId) {
        return logMapper.getLogsByUserId(userId);
    }

}
