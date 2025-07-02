package com.suyh3303.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

/**
 * 自定义spring web 中对jackson 的定义处理
 */
@Component
public class SuyhDemoJacksonBuilderCustomizer implements Jackson2ObjectMapperBuilderCustomizer {

    @Override
    public void customize(Jackson2ObjectMapperBuilder builder) {
        builder.simpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance)
                .addSerializer(Long.TYPE, ToStringSerializer.instance);
        builder.modules(simpleModule);

        // 它的时机是在所有配置都完成之后，最后调用。
        builder.postConfigurer(mapper -> {
            // 可以复制一个 ObjectMapper 出来
            ObjectMapper objectMapper = mapper.copy();
        });
    }
}
