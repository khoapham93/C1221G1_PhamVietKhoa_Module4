package com.khoapham.logger;

import com.khoapham.model.Books;
import com.khoapham.util.ReadAndWriteFile;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Aspect
public class Logging {

    private String filePath = "D:\\CODEGYM\\Module_4\\ss9_aop_exception_handling\\bai_tap\\borrow_book\\src\\main\\java\\com\\khoapham\\util\\logBorrowReturn.csv";
    private String filePathAll = "D:\\CODEGYM\\Module_4\\ss9_aop_exception_handling\\bai_tap\\borrow_book\\src\\main\\java\\com\\khoapham\\util\\logAll.csv";

    @Pointcut("execution(* com.khoapham.controller.BookBorrowController.*Book(..))")
    public void allChangeBookStatus() {
    }

    @Pointcut("execution(* com.khoapham.controller.BookBorrowController.*(..))")
    public void allAfterCallMethod() {
    }

    @AfterReturning("allChangeBookStatus()")
    public void afterReturningChangeBookStatus(JoinPoint joinPoint) {
        List<String> logging = new ArrayList<>();

        String method = joinPoint.getSignature().getName();

        if (method.equals("borrowBook")) {
            Object[] objects = joinPoint.getArgs();
            Books book = (Books) objects[0];

            String args = book.getName();
            logging.add("[Time]: " + LocalDateTime.now() + " End method: " + method + " Book: " + args);
        } else {
            Object[] objects = joinPoint.getArgs();
            String args = (String) objects[0];
            logging.add("[Time]: " + LocalDateTime.now() + " End method: " + method + " Code: " + args);
        }

        ReadAndWriteFile.writeListStringToCSV(filePath, logging);

        System.out.print("[Time]: " + LocalDateTime.now());
        System.out.println(" End method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning("allAfterCallMethod()")
    public void afterReturningAllMethod(JoinPoint joinPoint) {
        List<String> logging = new ArrayList<>();

        String method = joinPoint.getSignature().getName();

        if (method.equals("borrowBook")) {
            Object[] objects = joinPoint.getArgs();
            Books book = (Books) objects[0];

            String args = book.getName();
            logging.add("[Time]: " + LocalDateTime.now() + " End method: " + method + " Book: " + args);
        } else if (method.equals("returnBook")) {
            Object[] objects = joinPoint.getArgs();
            String args = (String) objects[0];
            logging.add("[Time]: " + LocalDateTime.now() + " End method: " + method + " Code: " + args);
        } else {
            logging.add("[Time]: " + LocalDateTime.now() + " End method: " + method);
        }

        ReadAndWriteFile.writeListStringToCSV(filePathAll, logging);

        System.out.print("[Time]: " + LocalDateTime.now());
        System.out.println(" End method: " + joinPoint.getSignature().getName());
    }
}
