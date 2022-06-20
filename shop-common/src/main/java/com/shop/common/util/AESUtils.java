package com.shop.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

/**
 * @Author: dcWang
 * @Date: 2022/6/17 15:58
 * @Description: AES加解密
 */
@Slf4j
public class AESUtils {

    /**
     * AES加密
     *
     * @param content 明文
     * @param key     秘钥
     * @return String
     */
    public static String encrypt(String content, String key) {
        // 将返回的加密过的 byte[] 转换成Base64编码字符串 ！！！！很关键
        try {
            return base64ToString(AES_ECB_Encrypt(content.getBytes(), key.getBytes()));
        } catch (Exception e) {
            log.error("加密失败!", e);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * AES解密
     *
     * @param content Base64编码的密文
     * @param key     秘钥
     * @return String
     */
    public static String decrypt(String content, String key) {
        // stringToBase64() 将 Base64编码的字符串转换成 byte[] !!!与base64ToString(）配套使用
        try {
            byte[] base64 = stringToBase64(content);
            byte[] bytes = AES_ECB_Decrypt(base64, key.getBytes());
            assert bytes != null;
            String result = new String(bytes);
            return result.replaceAll("\"", "");
        } catch (Exception e) {
            log.info("AES解密出错！！！");
            e.printStackTrace();
        }
        return null;
    }

    private static byte[] AES_ECB_Encrypt(byte[] content, byte[] keyBytes) {
        try {
            SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return cipher.doFinal(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static byte[] AES_ECB_Decrypt(byte[] content, byte[] keyBytes) {
        try {
            SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            return cipher.doFinal(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 字符串装换成 Base64
     */

    public static byte[] stringToBase64(String key) throws Exception {
        return Base64.decodeBase64(key.getBytes());
    }

    /**
     * Base64装换成字符串
     */
    public static String base64ToString(byte[] key) throws Exception {
        return new Base64().encodeToString(key);
    }

}
