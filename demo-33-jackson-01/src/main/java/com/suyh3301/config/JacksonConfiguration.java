package com.suyh3301.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.suyh3301.json.JacksonBuilderCustomizer;
import com.suyh3301.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * 这种方式不好。
 *
 * @see JacksonBuilderCustomizer
 */
//@Configuration
@Slf4j
@Deprecated
public class JacksonConfiguration {

    @Bean("objectMapper")
    @Primary
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        log.info("ObjectMapper configuration: use JacksonConfiguration");
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        // 使用core中的配置进行jackson设置
        JsonUtils.initMapper(objectMapper);
        return objectMapper;
    }
}
