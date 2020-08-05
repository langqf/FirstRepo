package com.md.service;

import com.md.BO.Student;

/**
 * @Description TODO
 * @Author EX_LANGQF
 * @Date 2019/7/5 17:25
 */
public class PrintStudent {
    public void printStu(Student stu){
        System.out.println(stu.getName() + "  " + stu.getAge());
    }
}
