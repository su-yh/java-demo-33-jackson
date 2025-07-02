package com.suyh3301.util;

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
    @BeforeAll
    public static void setUpAll() {
    }

    @AfterAll
    public static void tearDownAll() {
    }

    @Test
    public void testJacksonSerializable() {
        JacksonEntity entity = new JacksonEntity();
        entity.setAuditStatus(AuditStatusEnums.SUCCESS);
        Assertions.assertNotNull(entity);
        String jsonValue = JsonUtils.serializable(entity);
        log.info("serializable jsonValue: {}", jsonValue);
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