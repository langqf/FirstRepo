package com.security.random;

import java.util.Random;

/**
 * @Description TODO
 * @Author ex_langqf
 * @Date 2020/7/8 10:43
 */
public class TestRandom {
    public static void main(String[] args) {
        // Random 默认使用系统时间作为seed,seed不一样，随机数序列也不一样
        // Random seed一样时，随机数序列一样
        // Random 伪随机  不是密码学安全的
        Random rdm = new Random();
        System.out.println("------------随机整数------------");
        for(int i = 0 ; i < 3 ; i++){
            System.out.print(rdm.nextInt() + "、");
        }
        System.out.println();
        System.out.println("---------------------------");
        for(int i = 0 ; i < 3 ; i++){
            System.out.print(rdm.nextLong() + "、");
        }
        System.out.println();
        System.out.println("随机浮点数");
        for(int i = 0 ; i < 3 ; i++){
            System.out.print(rdm.nextFloat() + "、");
        }
        System.out.println();
        System.out.println("---------------------------");
        for(int i = 0 ; i < 3 ; i++){
            System.out.print(rdm.nextDouble() + "、");
        }
        Random rdm1 = new Random(12345);
        System.out.println();
        System.out.println("------------相同的seed,随机整数序列1------------");
        for(int i = 0 ; i < 3 ; i++){
            System.out.print(rdm1.nextInt() + "、");
        }
        Random rdm2 = new Random(12345);
        System.out.println();
        System.out.println("------------相同的seed,随机整数序列2------------");
        for(int i = 0 ; i < 3 ; i++){
            System.out.print(rdm2.nextInt() + "、");
        }
        System.out.println();
        Random rdm3 = new Random(12345);
        System.out.println();
        System.out.println("------------相同的seed,范围随机整数序列3------------");
        for(int i = 0 ; i < 3 ; i++){
            System.out.print(rdm3.nextInt(10) + "、");
        }
        Random rdm4 = new Random(12345);
        System.out.println();
        System.out.println("------------相同的seed,随机整数序列4------------");
        for(int i = 0 ; i < 3 ; i++){
            System.out.print(rdm4.nextInt(10) + "、");
        }
        System.out.println();
        System.out.println("------------生成10之内的整数------------");
        for(int i = 0 ; i < 10 ; i++){
            System.out.print(rdm.nextInt(10) + "、");
        }
    }
}
