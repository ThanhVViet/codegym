package com.codegym.spring_data_jpa.aop;

import com.codegym.spring_data_jpa.dto.StudentDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.FileWriter;

@Aspect
@Component
public class Logger {
    static int count =0;
    static int count1 =0;

    @Before("execution(* com.codegym.spring_data_jpa.controller.StudentController.showList(..))")
    public void countRequest(){
        count++;
        System.out.println("------------------------------------------------------------------");
        System.out.println("the number of request to showList: " + count);
        System.out.println("------------------------------------------------------------------");
    }
    @AfterReturning("execution(* com.codegym.spring_data_jpa.controller.StudentController.save(..))")
    public void loggingException(JoinPoint joinPoint){
        System.out.println("------------------------------------------------------------------");
         Object[] args = joinPoint.getArgs();
        StudentDto studentDto = (StudentDto) args[0];
        System.out.println("success : " + studentDto.getName() + ": "+ studentDto.getGender());
        System.out.println("------------------------------------------------------------------");
    }
    @Around("execution(* com.codegym.spring_data_jpa.controller.StudentController.save(..))")
    public Object loggingAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("------------------------------------------------------------------");
        System.out.println("-----------code before");

       Object object= proceedingJoinPoint.proceed();
        System.out.println("-----------code after");

        System.out.println("------------------------------------------------------------------");
        return object;
    }
}
