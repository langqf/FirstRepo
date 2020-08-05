package com.example.util;

import java.io.InputStream;
import java.util.HashMap;

/**
 * @Description TODO
 * @Author ex_langqf
 * @Date 2020/7/13 17:40
 */
public class FileUtil {


    public static HashMap docMap;

    static {
        //设立白名单
        docMap = new HashMap<String,String>();
        docMap.put("89504E47","png");//png
        docMap.put("47494638","gif");//gif
        docMap.put("49492A00","tif");//tif
        docMap.put("D0CF11E0","xls_or_doc");//xls_or_doc
        docMap.put("25504446","pdf");//pdf
        docMap.put("52617221","rar");//rar
        docMap.put("504B0304","zip");//zip
        docMap.put("3C3F786D","xml");//xml
        docMap.put("0A0A3134","out");//out
    }

    /**
     * 获取头部类型
     * @param is
     * @return
     */
    public static String getFileType(InputStream is){
        String header = getFileHeader(is);
        System.out.println("文件头信息：" + header);
        return getFileTypeByHeader(header);
    }

    /**
     * 根据头部信息获取文件类型
     * @param header
     * @return
     */
    public static String getFileTypeByHeader(String header){
        return (String)docMap.get(header);
    }

    /**
     * 获取文件头部前四个字节
     * @param is
     * @return
     */
    public static String getFileHeader(InputStream is){
        String header = null;
        try{
            byte[] b = new byte[4];
            is.read(b,0,b.length);//读取前四个字节
            header = bytesToHexString(b);//转成十六进制
            header = header.toUpperCase();//转大写
        }catch(Exception e){
            e.printStackTrace();
        }
        return header;
    }

    /**
     * 将十进制byte数组转成16进制
     * @param bArr
     * @return
     */
    public static String bytesToHexString(byte[] bArr) {
        StringBuffer sb = new StringBuffer(bArr.length);
        String sTmp;

        for (int i = 0; i < bArr.length; i++) {
            sTmp = Integer.toHexString(0xFF & bArr[i]);
            if (sTmp.length() < 2)
                sb.append(0);
            sb.append(sTmp.toUpperCase());
        }
        return sb.toString();
    }
}
