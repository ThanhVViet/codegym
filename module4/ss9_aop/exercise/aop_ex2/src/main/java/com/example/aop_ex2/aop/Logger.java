package com.example.aop_ex2.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    @AfterReturning("execution(* com.example.aop_ex2.controller.BookController.save(..))")
    public void loggingCreateBook(){
        System.out.println("------------------------------------------------------------------");
        System.out.println("You just add a new book to library !!!!" );
        System.out.println("------------------------------------------------------------------");
    }
    @AfterReturning("execution(* com.example.aop_ex2.controller.BookController.borrowBook(..))")
    public void loggingBorrowBook(){
        System.out.println("------------------------------------------------------------------");
        System.out.println("You just borrow a book in the library !!!!" );
        System.out.println("------------------------------------------------------------------");
    }
    @AfterThrowing("execution(* com.example.aop_ex2.controller.BookController.borrowBook(..))")
    public void loggingErrorBorrowBook(){
        System.out.println("------------------------------------------------------------------");
        System.out.println("Can't borrow book now !!!!" );
        System.out.println("------------------------------------------------------------------");
    }
    @AfterReturning("execution(* com.example.aop_ex2.controller.BookController.returnBook(..))")
    public void loggingReturnBook(){
        System.out.println("------------------------------------------------------------------");
        System.out.println("You just return a book to the library !!!!" );
        System.out.println("------------------------------------------------------------------");
    }
    @AfterThrowing("execution(* com.example.aop_ex2.controller.BookController.returnBook(..))")
    public void loggingErrorReturnBook(){
        System.out.println("------------------------------------------------------------------");
        System.out.println("Wrong Id Borrow!!!!" );
        System.out.println("------------------------------------------------------------------");
    }

}
