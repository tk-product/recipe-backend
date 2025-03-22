package com.example.recipe.common.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.nio.charset.StandardCharsets;

@Configuration
public class MessageConfig {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages"); // messages.propertiesの場所
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name()); // UTF-8を使用
        messageSource.setCacheSeconds(3600); // キャッシュ有効時間（秒）
        return messageSource;
    }
}
