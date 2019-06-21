package com.kk.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//全局控制器异常处理器
//@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})
    public ModelAndView handleArithmeticException(Exception e) {
        System.out.println(e);
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", e);
        return mv;
    }
}
