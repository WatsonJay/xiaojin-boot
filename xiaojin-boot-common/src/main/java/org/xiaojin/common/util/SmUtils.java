package org.xiaojin.common.util;

import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.symmetric.SM4;

import java.nio.charset.StandardCharsets;

/**
 * @author admin
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
        return sm4.encryptHex(plainText, StandardCharsets.UTF_8);
    }

    public static String sm4EncryptDataByCBC(String plainText, String sm4Key, String iv) {
        SM4 sm4 = new SM4(Mode.CBC, Padding.ZeroPadding, sm4Key.getBytes(), iv.getBytes());
        return sm4.encryptHex(plainText, StandardCharsets.UTF_8);
    }
}
