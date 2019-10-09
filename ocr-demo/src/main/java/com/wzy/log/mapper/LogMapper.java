package com.wzy.log.mapper;

import com.wzy.log.entity.Log;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Package: com.wzy.log.mapper
 * @Author: Clarence1
 * @Date: 2019/9/17 15:41
 */
@Mapper
public interface LogMapper {

    /**
     * 保存日志记录
     * @param log
     * @return int
     */
    public int insertLog(Log log);

    /**
     * 获取日志列表前五条记录
     * @param userId
     * @return
     */
    List<Log> getLogsByUserId(Long userId);

}
