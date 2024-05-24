package org.xiaojin.common.util;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.symmetric.SM4;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author JayWatson
 * @version 1.0.0
 * @ClassName SmUtils.java
 * @Description TODO
 * @createTime 2024年05月13日 16:27:00
 */
public class SmUtils {
    /**
     *　SM4工具类
     */
    public static String sm4EncryptDataByEBC(String plainText, String sm4Key) {
        SM4 sm4 = new SM4(Mode.ECB, Padding.ZeroPadding, sm4Key.getBytes());
        return sm4.encryptHex(plainText, CharsetUtil.CHARSET_UTF_8);
    }

    public static String sm4EncryptDataByCBC(String plainText, String sm4Key, String iv) {
        SM4 sm4 = new SM4(Mode.CBC, Padding.ZeroPadding, sm4Key.getBytes(), iv.getBytes());
        return sm4.encryptHex(plainText, CharsetUtil.CHARSET_UTF_8);
    }

    public static String sm4DecryptDataByEBC(String cipherText, String sm4Key) {
        SM4 sm4 = new SM4(Mode.ECB, Padding.ZeroPadding, sm4Key.getBytes());
        return sm4.decryptStr(cipherText, CharsetUtil.CHARSET_UTF_8);
    }

    public static String sm4DecryptDataByCBC(String cipherText, String sm4Key, String iv) {
        SM4 sm4 = new SM4(Mode.CBC, Padding.ZeroPadding, sm4Key.getBytes(), iv.getBytes());
        return sm4.decryptStr(cipherText, CharsetUtil.CHARSET_UTF_8);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String type = "";
        String str = "";
        System.out.println("选择需要的模式：1加密,2解密");
        type = sc.nextLine();
        switch (type) {
            case "1":
                System.out.println("要加密的字符串：");
                str = sc.nextLine();
                String encCode = sm4EncryptDataByCBC(str, System.getProperty("key", "1122334455667788"),
                        System.getProperty("salt", "aabbccddeeffgghh"));
                System.out.println("加密后的字符串为:" + encCode);
                break;
            case "2":
                System.out.println("要解密的字符串：");
                str = sc.nextLine();
                String decCode = sm4DecryptDataByCBC(str, System.getProperty("key", "1122334455667788"),
                        System.getProperty("salt", "aabbccddeeffgghh"));
                System.out.println("解密后的字符串为:" + decCode);
                break;
            default:
                System.out.println("无模式");
        }
    }
}
