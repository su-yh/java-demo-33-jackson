package com.suyh3301.constants.enums;

import com.fasterxml.jackson.annotation.JsonValue;
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

    ;

    /**
     * 默认情况下jackson 序列化枚举时，是使用的枚举的名字，现在加上 {@link JsonValue} 注解后，就会以该值来进行序列化。
     */
    @JsonValue
    private final int code;

    AuditStatusEnums(int code) {
        this.code = code;
    }
}
