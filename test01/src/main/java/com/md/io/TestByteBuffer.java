package com.md.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description TODO
 * @Author ex_langqf
 * @Date 2020/7/20 17:55
 */
public class TestByteBuffer {
    public static void main(String[] args) throws IOException {
        try(FileChannel channel = new FileOutputStream("E:/appsd/byteBuffer.txt").getChannel()){
            ByteBuffer allocate1 = ByteBuffer.allocate(90);
            ByteBuffer allocate2 = ByteBuffer.allocate(200);
            allocate1.asCharBuffer().put("400");
            allocate2.asCharBuffer().put("Good good study. Day day up!");
            channel.write(new ByteBuffer[]{allocate1,allocate2});
        }

        try(FileChannel channel = new FileInputStream("E:/appsd/byteBuffer.txt").getChannel()){
            ByteBuffer allocate1 = ByteBuffer.allocate(144);
            ByteBuffer allocate2 = ByteBuffer.allocate(200);
            channel.read(new ByteBuffer[]{allocate1,allocate2});
            allocate1.rewind();
            allocate2.rewind();
            System.out.println("allocate1 = " + allocate1.asCharBuffer().toString());
            System.out.println("allocate2 = " + allocate2.asCharBuffer().toString());
        }
    }
}
