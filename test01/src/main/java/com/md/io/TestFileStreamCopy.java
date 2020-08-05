package com.md.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Description TODO
 * @Author ex_langqf
 * @Date 2020/7/20 16:09
 */
public class TestFileStreamCopy {
    public static void main(String[] args) {
        File soureFile = new File("E:/appsd/test00001.txt");
        File targetFile = new File("E:/appsd/test00001复制.txt");
        if(!soureFile.getParentFile().exists()){
            if(!soureFile.getParentFile().mkdir()){
                System.out.println("创建父目录失败");
            }
        }
        /*try{
            if(soureFile.createNewFile()){
                System.out.println("源文件创建成功!");
            }else{
                System.out.println("创建源文件失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        try(FileWriter fileWriter = new FileWriter(soureFile)) {
            fileWriter.write("abcdefghijklmnopqrstuvwxyz!");
        } catch (IOException e) {
            System.out.println("问文件中写入数据失败!");
        }
        // 复制文件
        try {
            FileCopyUtils.copyFileBySystem(soureFile,targetFile);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("问文件中写入数据失败!");
        }
    }
}
