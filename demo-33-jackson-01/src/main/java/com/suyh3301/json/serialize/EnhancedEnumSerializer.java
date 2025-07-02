package com.suyh3301.json.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.std.EnumSerializer;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * 增加处理示例
 *
 * @author suyh
 * @since 2025-07-01
 */
@Slf4j
public class EnhancedEnumSerializer extends JsonSerializer<Enum<?>> {
    private final EnumSerializer defaultSerializer;

    public EnhancedEnumSerializer(EnumSerializer defaultSerializer) {
        this.defaultSerializer = defaultSerializer;
    }

    @Override
    public void serialize(Enum<?> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        log.debug("Enum serialize: {}, enum value: {}", EnhancedEnumSerializer.class.getSimpleName(), value);

        // TODO: suyh - 在这里可以添加自定义的逻辑处理
        // ...

        defaultSerializer.serialize(value, gen, serializers);
    }

    public static BeanSerializerModifier buildModifier() {
        return new Modifier();
    }

    // 注册器
    public static class Modifier extends BeanSerializerModifier {
        @Override
        public JsonSerializer<?> modifyEnumSerializer(
                SerializationConfig config,
                JavaType type,
                BeanDescription beanDesc,
                JsonSerializer<?> serializer) {
            if (serializer instanceof EnumSerializer) {
                return new EnhancedEnumSerializer((EnumSerializer) serializer);
            }
            return serializer;
        }
    }
}
