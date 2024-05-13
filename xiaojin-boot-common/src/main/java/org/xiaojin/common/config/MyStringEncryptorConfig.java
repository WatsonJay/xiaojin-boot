package org.xiaojin.common.config;

import com.ulisesbocchio.jasyptspringboot.properties.JasyptEncryptorConfigurationProperties;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.xiaojin.common.util.SmUtils;

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

    @Bean("jasyptStringEncryptor")
    public StringEncryptor jasyptStringEncryptor() {
        return new StringEncryptor() {
            @Override
            public String encrypt(String s) {
                return SmUtils.sm4EncryptDataByCBC(s, key, salt);
            }

            @Override
            public String decrypt(String s) {
                return SmUtils.sm4DecryptDataByCBC(s, key, salt);
            }
        };
    }
}
