package com.zhumian.groceryshop.aspect;

import com.zhumian.groceryshop.base.vo.BaseResponse;
import com.zhumian.groceryshop.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Object handlerBusinessException(BusinessException e){
        log.error(e.getMessage(), e);
        return new BaseResponse<>(false, e.getMessage());
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Object handlerGlobalException(RuntimeException e){
        log.error(e.getMessage(), e);
        return new BaseResponse<>(false, "系统内部异常");
    }
}
