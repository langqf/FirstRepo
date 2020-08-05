package com.security.random;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description TODO
 * @Author ex_langqf
 * @Date 2020/7/13 14:34
 */
public class TestTyrCatchWithResource {

    void readData() {
        File file = new File("xxx/xxx");
        FileInputStream fis = null;
        BufferedReader br = null;
        try {
            fis = new FileInputStream(file);
            br = new BufferedReader(new InputStreamReader(fis));
            String data = br.readLine();
        }catch (IOException e) {
            LOGGER.error("读取数据失败!",e);
        }finally {
            try{
                if(br != null){
                    br.close();
                    fis.close();
                }
            }catch(Exception e){
                LOGGER.error("关闭输入流错误！", e);
            }
        }
    }

    void readDataWithResource() {
        File file = new File("xxx/xxx");
        try (FileInputStream fis = new FileInputStream(file);
                BufferedReader br = new BufferedReader(new InputStreamReader(fis))) {
             String data = br.readLine();
        } catch (IOException e) {
            LOGGER.error("读取数据失败!",e);
        }
    }

}
