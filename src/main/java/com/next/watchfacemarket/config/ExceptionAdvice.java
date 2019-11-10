package com.next.watchfacemarket.config;

import com.next.watchfacemarket.log.KayleLog;
import com.next.watchfacemarket.protocol.response.BaseResponse;
import com.next.watchfacemarket.utils.JSONUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author: Jie.He, Leisurehejie@sina.com
 * @Date: 2019/11/10 2:13 下午
 */
@ControllerAdvice
public class ExceptionAdvice {

    private static KayleLog logger = new KayleLog(ExceptionAdvice.class);

    /**
     * Handle all uncaught exceptions.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exception(Exception exception) {
        if (exception instanceof FatalException) {
            logger.warn(exception.getMessage(), exception);
        } else {
            logger.warn("Uncaught exception", exception);
        }
        BaseResponse resp = new BaseResponse();
        resp.setErrMsg("Unexpected exception.");
        return new ResponseEntity<>(JSONUtil.toJSONString(resp), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
