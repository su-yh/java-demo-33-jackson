package com.suyh3301.constants.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.ser.std.JsonValueSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

/**
 * @author suyh
 * @since 2024-09-06
 */
@Getter
public enum AuditStatusEnums {
    @Schema(description = "0-正常")
    NORMAL(0),
    @Schema(description = "1-待处理")
    WAITING_PROCESS(1),
    @Schema(description = "3 成功")
    SUCCESS(3),
    @Schema(description = "4 拒绝")
    REJECTED(4),
    @Schema(description = "未知")
    @JsonIgnore
    UNKNOWN(-1),
    ;

    /**
     * 默认情况下jackson 序列化枚举时，是使用的枚举的名字，现在加上 {@link JsonValue} 注解后，就会以该值来进行序列化。
     * <p>
     * 我们还需要知道，该注解是有对应的序列化器的：{@link JsonValueSerializer}
     */
    @JsonValue
    private final int code;

    // 在测试的时候，并没有添加 这个注解也可以反序列化成功
    @JsonCreator
    AuditStatusEnums(int code) {
        this.code = code;
    }
}
