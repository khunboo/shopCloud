package com.khunboo.exception;

import com.khunboo.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局统一异常处理
 */
@ControllerAdvice
public class CommonExceptAdvice {

    Logger logger = LoggerFactory.getLogger(CommonExceptAdvice.class);

    @ResponseBody
    @ExceptionHandler(value = SysException.class)
    public Result sysException(SysException ex){
        logger.error("自定义错误{}", ex);
        return new Result(201, "运行出错啦", null);

    }

    @ResponseBody
    @ExceptionHandler(value = NullPointerException.class)
    public Result nullPointerException(NullPointerException ex){
        logger.error("错误{}", ex);
        return new Result(202, "空指针异常啦", null);
    }
}
