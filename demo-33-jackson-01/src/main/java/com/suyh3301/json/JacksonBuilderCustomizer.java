package com.suyh3301.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.suyh3301.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

/**
 * @author suyh
 * @since 2025-07-02
 */
@Component
@Slf4j
public class JacksonBuilderCustomizer implements Jackson2ObjectMapperBuilderCustomizer {

    @Override
    public void customize(Jackson2ObjectMapperBuilder builder) {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance)
                .addSerializer(Long.TYPE, ToStringSerializer.instance);
        builder.modules(simpleModule);

        // 它的时机是在所有配置都完成之后，最后调用。
        builder.postConfigurer(mapper -> {
            log.info("init json utils.");
            ObjectMapper utilMapper = mapper.copy();
            // 同步 JsonUtils 与web 中使用的jackson 一致
            JsonUtils.initMapper(utilMapper);

            // 如果对spring 中的jackson 的特别的处理，可以对原来的mapper 追加配置。
            // mapper.registerModules();
        });
    }
}
