package org.xiaojin.config;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.xiaojin.common.util.SmUtils;

/**
 * @author JayWatson
 * @version 1.0.0
 * @ClassName MyStringEncryptorConfig.java
 * @Description
 * @createTime 2024年05月13日 09:21:00
 */
@Configuration
@Slf4j
public class MyStringEncryptorConfig {

    private String key = System.getProperty("key", "1122334455667788");
    private String salt = System.getProperty("salt", "aabbccddeeffgghh");

    @Bean("jasyptStringEncryptor")
    public StringEncryptor jasyptStringEncryptor() {
        return new StringEncryptor() {
            @Override
            public String encrypt(String s) {
                String result = "";
                try {
                    result = SmUtils.sm4EncryptDataByCBC(s, key, salt);
                } catch (Exception e) {
                    throw new RuntimeException("-----jasypt加密失败------");
                }
                return result;
            }

            @Override
            public String decrypt(String s) {
                String result = "";
                log.debug("当前解密数据: " + s);
                try {
                    result = SmUtils.sm4DecryptDataByCBC(s, key, salt);
                } catch (Exception e) {
                    throw new RuntimeException("-----jasypt解密失败------");
                }
                return result;
            }
        };
    }
}
