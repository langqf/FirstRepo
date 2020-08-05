package com.security.random;


import com.sun.media.jfxmedia.logging.Logger;
import org.apache.commons.codec.digest.DigestUtils;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

/**
 * @Description TODO
 * @Author ex_langqf
 * @Date 2020/7/9 15:11
 */
public class TestMD5 {

    public static void main(String[] args) throws Exception{
        TestMD5 testMD5 = new TestMD5();
        System.out.println(testMD5.EncoderByMd5("PubTest#2017"));
        testMD5.setPassword("PubTest#2017".getBytes(),"monitor4a");
    }

    public String EncoderByMd5(String password){
        String EncryptedPassword = "";
        try{
            // 返回实现MD5摘要算法的MessageDigest对象
            MessageDigest md5Digest = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            // 使用指定的 byte 数组更新摘要
            md5Digest.update(password.getBytes("UTF-8"));
            byte[] md5Result = md5Digest.digest();
            // 使用base64再次加密
            EncryptedPassword = base64en.encode(md5Result);
        }catch(NoSuchAlgorithmException e){
            LOGGER.error("MD5 encryption failed",e);
        }catch (UnsupportedEncodingException e){
            LOGGER.error("MD5 encryption failed",e);
        }
        return EncryptedPassword;
    }

    public void setPassword(byte[] password, String userId) throws Exception {
        // 生成随机盐值
        byte[] saltBytes = generateSalt();
        // 盐值转16进制
        String salt = byte2Hex(generateSalt());
        // 合并 密码和salt值
        byte[] input = appendArrays(password, saltBytes);
        // 返回实现SHA-256摘要算法的MessageDigest对象
        MessageDigest msgDigest = MessageDigest.getInstance("SHA-256");
        // 使用指定的 byte 数组更新摘要
        msgDigest.update(input);
        byte[] hashBytes = msgDigest.digest();
        // 将 加密结果 转换成16进制
        String hashVal = byte2Hex(hashBytes);
        // 保存数据库
        saveHashVal(userId, hashVal, salt);
    }

    // 生成随机盐值
    public byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        return bytes;
    }

    // 密码+salt值 合并
    public byte[] appendArrays(byte[] password, byte[] salt) {
        int newLength = password.length + salt.length;
        byte[] newArrays = Arrays.copyOf(password,newLength);
        for(int i = password.length ; i < newArrays.length; i++){
            newArrays[i] = salt[i - password.length];
        }
        return newArrays;
    }

    // 保存数据
    public static void saveHashVal(String userId, String hashVal, String salt){
        /*Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtils.getConnection();
            String sql = "INSERT INTO UserTable ( userId, hashVal, salt ) VALUES ( ?, ?, ?) ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.setString(2, hashVal);
            pstmt.setString(3, salt);
            rs = pstmt.executeQuery();
        }catch(Exception e){
            LOGGER.error("Save Hash value failed.",e);
        }finally {
            JDBCUtils.release(rs, pstmt, conn);
        }*/
    }

    // 将 byte[] 转换成16进制表示
    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }
}
