package com.flamingo.jruser.handler;

import com.flamingo.jruser.exception.UserException;
import com.flamingo.jruser.model.vo.ResultVO;
import com.flamingo.jruser.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 全局异常处理类，EmailException为自定义异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 自定义错误码反回http状态码为200
     * @param e
     * @return
     */
    @ExceptionHandler({UserException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResultVO userException(UserException e){
        return R.error(e.getCode(),e.getLocalizedMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResultVO argumentException(MethodArgumentNotValidException e){
        List<String> errors = e.getBindingResult()
                .getAllErrors()
                .stream()
                .map(err -> err.getDefaultMessage()).collect(Collectors.toList());
        return R.error(60002,"参数非法",errors);
    }

}
