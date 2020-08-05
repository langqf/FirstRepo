package com.md.test;

import com.md.BO.Student;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author EX_LANGQF
 * @Date 2019/7/5 17:26
 */
public class Test1 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Student stu1 = new Student("zm", 24);
        Student stu2 = new Student("my", 23);
        List<Student> stuList = new ArrayList<Student>();
        stuList.add(stu1);
        stuList.add(stu2);
        try {
            Object returnStr = null;
            Class<?> printStudent = Class.forName("com.md.service.PrintStudent");
            Object bean = printStudent.newInstance();
            String methodName = "printStu";
            Method[] printStus = printStudent.getMethods();
            for(Method m : printStus){
                if(m.getName().equals(methodName)){
                    returnStr  =  m.invoke(bean, stuList.toArray());
                }
            }
            System.out.println("returnStr = " + returnStr);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
