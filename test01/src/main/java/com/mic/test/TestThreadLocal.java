package com.mic.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestThreadLocal {

    private static final ThreadLocal<MyContext> contextHolder = new ThreadLocal<>();

    private static final ThreadLocal<SimpleDateFormat> dateFormatHolder = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));


    private static  SimpleDateFormat  sA = null;
    private static  SimpleDateFormat  sB = null;
    private static  SimpleDateFormat  sC = null;

    public static void main(String[] args) {
        new Thread(() ->{
            contextHolder.set(new MyContext("userA", "request-1"));
            try{
                MyContext ctx = contextHolder.get();
                System.out.println("Thread 1： " + ctx.getUserId() + ", " + ctx.getRequestId());
                SimpleDateFormat simpleDateFormat = dateFormatHolder.get();
                sA = simpleDateFormat;
                System.out.println(simpleDateFormat + " sdf1 code: " + simpleDateFormat.hashCode());
                System.out.println(System.identityHashCode(simpleDateFormat));
                String formattedDate = simpleDateFormat.format(new Date());
                System.out.println("Thread 1 Date ： " + formattedDate);
                System.out.println(simpleDateFormat ==  dateFormatHolder.get());
            }finally {
                contextHolder.remove();
                dateFormatHolder.remove();
            }
        }).start();
        try {
            Thread.sleep(2000);
            SimpleDateFormat simpleDateFormat = dateFormatHolder.get();
            sB = simpleDateFormat;
            System.out.println(simpleDateFormat + " sdf main code:  " + simpleDateFormat.hashCode());
            System.out.println(System.identityHashCode(simpleDateFormat));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            dateFormatHolder.remove();
        }
        new Thread(() ->{
            contextHolder.set(new MyContext("userB", "request-2"));
            try{
                MyContext ctx = contextHolder.get();
                System.out.println("Thread 2： " + ctx.getUserId() + ", " + ctx.getRequestId());
                SimpleDateFormat simpleDateFormat = dateFormatHolder.get();
                sC = simpleDateFormat;
                System.out.println(simpleDateFormat + " sdf2: code " + simpleDateFormat.hashCode());
                System.out.println(System.identityHashCode(simpleDateFormat));
                String formattedDate = simpleDateFormat.format(new Date());
                System.out.println("Thread 2 Date ： " + formattedDate);
            }finally {
                contextHolder.remove();
                dateFormatHolder.remove();
            }

        }).start();

        System.out.println(sA ==  sB);
        System.out.println(sA ==  sC);
        System.out.println(sB ==  sC);
    }

    static class MyContext{
        private String userId;
        private String requestId;

        public MyContext(String userId, String requestId) {
            this.userId = userId;
            this.requestId = requestId;
        }

        public String getUserId() {
            return userId;
        }

        public String getRequestId() {
            return requestId;
        }

    }
}
