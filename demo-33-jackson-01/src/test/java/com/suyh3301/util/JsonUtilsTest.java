package com.suyh3301.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.suyh3301.Application3301;
import com.suyh3301.constants.enums.AuditStatusEnums;
import com.suyh3301.entity.JacksonEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

/**
 * @author suyh
 * @since 2025-07-02
 */
//@ActiveProfiles("suyh")
@ExtendWith(SpringExtension.class)
@SpringBootTest(
        classes = Application3301.class,
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Slf4j
public class JsonUtilsTest {
    @Resource
    private ObjectMapper objectMapper;

    @BeforeAll
    public static void setUpAll() {
    }

    @AfterAll
    public static void tearDownAll() {
    }

    @Test
    public void testJacksonSerializable() {
        {
            String jsonValue = JsonUtils.serializable(AuditStatusEnums.NORMAL, objectMapper);
            log.info("serializable jsonValue: {}", jsonValue);
            Assertions.assertNotNull(jsonValue);
            Assertions.assertEquals(AuditStatusEnums.NORMAL.getCode() + "", jsonValue);
        }

        {
            String jsonValue = JsonUtils.serializable(AuditStatusEnums.UNKNOWN, objectMapper);
            log.info("serializable jsonValue: {}", jsonValue);
            if (jsonValue != null) {
                Assertions.assertEquals("null", jsonValue);
            } else {
                Assertions.assertNull(null);
            }

        }

        // 直接使用jsonUtils ######################################
        {
            String jsonValue = JsonUtils.serializable(AuditStatusEnums.NORMAL);
            log.info("serializable jsonValue: {}", jsonValue);
            Assertions.assertNotNull(jsonValue);
            Assertions.assertEquals(AuditStatusEnums.NORMAL.getCode() + "", jsonValue);
        }

        {
            String jsonValue = JsonUtils.serializable(AuditStatusEnums.UNKNOWN);
            log.info("serializable jsonValue: {}", jsonValue);
            Assertions.assertEquals(AuditStatusEnums.UNKNOWN.getCode() + "", jsonValue);
        }
    }

    @Test
    public void testJacksonDeserialize() {
        String jsonValue = "{\n" +
                "    \"id\" : \"32\",\n" +
                "    \"aaaa\": \"bbb\",\n" +
                "    \"auditStatus\": 3,\n" +
                "    \"uuid\" : \"134b0850361f468ca8eec8976fffe7fc\"\n" +
                "}";
        JacksonEntity vo = JsonUtils.deserialize(jsonValue, JacksonEntity.class);
        Assertions.assertNotNull(vo);
        log.info("deserialize, enums value: {}", vo.getAuditStatus());
        Assertions.assertEquals(AuditStatusEnums.SUCCESS, vo.getAuditStatus());
    }

}