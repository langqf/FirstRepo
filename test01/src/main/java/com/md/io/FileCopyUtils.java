package com.md.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description TODO
 * @Author ex_langqf
 * @Date 2020/7/20 16:10
 */
public class FileCopyUtils {

    public static void copyFileBySystem(File source , File target) throws IOException {
        try(InputStream fis = new FileInputStream(source);
            OutputStream os = new FileOutputStream(target)
        ){
            byte[] bts = new byte[2048];
            int length;
            while((length = fis.read(bts)) > 0 ){
                os.write(bts, 0 , length);
            }
        }

    }

    public static void copyFileByChannel(File source , File target) throws IOException{
        try(FileChannel inputChannel = new FileInputStream(source).getChannel();
            FileChannel outputChannel = new FileOutputStream(target).getChannel()
        ){
            // size 大于2G的文件 需要循环copy
            for(long size = inputChannel.size(); size > 0;){
                System.out.println("源文件剩余可读取大小：" + size);
                long position = inputChannel.position();
                System.out.println("源文件当前position:" + position);
                // 返回传递大小
                long transfered = inputChannel.transferTo(position, size, outputChannel);
                inputChannel.position(position + transfered);
                size -= transfered;
            }
        }

    }

}
