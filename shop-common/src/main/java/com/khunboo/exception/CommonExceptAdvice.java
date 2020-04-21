package com.khunboo.exception;

import com.khunboo.constant.ErrorCode;
import com.khunboo.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局统一异常处理
 */
@RestControllerAdvice
public class CommonExceptAdvice {

    Logger logger = LoggerFactory.getLogger(CommonExceptAdvice.class);

    @ExceptionHandler(value = SysException.class)
    public Result sysException(SysException ex){
        logger.error("自定义错误{}", ex);
        return new Result().error(301, ErrorCode.getValue(301));

    }

    @ExceptionHandler(value = NullPointerException.class)
    public Result nullPointerException(NullPointerException ex){
        logger.error("错误{}", ex);
        return new Result().error(302, ErrorCode.getValue(302));
    }

    @ExceptionHandler(value = RuntimeException.class)
    public Result runtimeException(RuntimeException ex){
        logger.error("运行错误{}", ex);
        return new Result().error(500, ex.getMessage());
    }
}
