package com.security.random;


import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * @Description TODO
 * @Author ex_langqf
 * @Date 2020/7/9 11:28
 */
public class TestSecureRandom {
    public static void main(String[] args){
        /* nextBytes（byte[]）方法 没有setSeed时，第一次会setSeed
         try {
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            // Declaring the string variable
            String str = "Tajmahal";
            // Declaring the byte Array
            // converting string into byte
            byte[] b = str.getBytes();
            // printing the byte array
            System.out.println("Byte array before operation : " + Arrays.toString(b));
            // generating user-specified number of random bytes
            // using nextBytes() method
            sr.nextBytes(b);
            // printing the new byte array
            System.out.println("Byte array after operation : " + Arrays.toString(b));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }*/

        /* nextBytes（byte[]）方法 之前有setSeed时，后续不会setSeed
         / creating the object of SecureRandom
        SecureRandom sr2 = new SecureRandom(new byte[] { 1, 2, 3, 4 });

        // Declaring the string variable
        String str = "Tajmahal";

        // Declaring the byte Array b
        byte[] b = str.getBytes();

        // printing the byte array
        System.out.println("Byte array before operation : " + Arrays.toString(b));

        // generating user-specified number of random bytes
        // using nextBytes() method
        sr2.nextBytes(b);

        // printing the new byte array
        System.out.println("Byte array after operation : " + Arrays.toString(b));
*/
        // 生成用户指定大小的随机字节数
        /*SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        System.out.println("Byte array after operation : " + Arrays.toString(bytes));
*/
        SecureRandom sr = null;
        try {
             sr = SecureRandom.getInstanceStrong();
            // 获取高强度安全随机数生成器
        }catch (NoSuchAlgorithmException e) {
            sr = new SecureRandom();// 获取普通的安全随机数生成器
        }
        // 用安全随机数填充buffer
        byte[] buffer = new byte[16];
        sr.nextBytes(buffer);
        System.out.println(Arrays.toString(buffer));

    }

    // 使用强随机函数 SecureRandom
    void generateSecretToken() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        random.setSeed(12);
    }
}
