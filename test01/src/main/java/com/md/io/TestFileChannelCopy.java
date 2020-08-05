package com.md.io;

import java.io.File;
import java.io.IOException;

/**
 * @Description TODO
 * @Author ex_langqf
 * @Date 2020/7/21 10:19
 */
public class TestFileChannelCopy {

    public static void main(String[] args) throws IOException {
        File soureFile = new File("E:/appsd/gradle-3.2-all.zip");
        File targetFile = new File("E:/appsd/gradle-3.2-all复制.zip");
        FileCopyUtils.copyFileByChannel(soureFile,targetFile);

    }

}
