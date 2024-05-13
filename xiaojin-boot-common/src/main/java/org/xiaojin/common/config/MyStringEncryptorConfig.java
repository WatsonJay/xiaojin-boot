package org.xiaojin.common.config;

import com.ulisesbocchio.jasyptspringboot.properties.JasyptEncryptorConfigurationProperties;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author admin
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

    public StringEncryptor jasyptStringEncryptor(JasyptEncryptorConfigurationProperties properties) {
        return new StringEncryptor() {
            @Override
            public String encrypt(String s) {
                return null;
            }

            @Override
            public String decrypt(String s) {
                return null;
            }
        };
    }
}
