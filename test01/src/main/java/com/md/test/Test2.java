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
public class Test2 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String str = "/admin/workflow/route/route.do?routeCode=gceb_whiteList";
        System.out.println(str.substring(str.lastIndexOf("routeCode=") + "routeCode=".length()));
    }
}
