package com.suyh3303.runner;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author suyh
 * @since 2025-07-02
 */
@Component
public class TestRunner implements ApplicationRunner {
    @Resource
    private ObjectMapper objectMapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        DataVo vo = new DataVo();
        vo.id = Long.MAX_VALUE;
        vo.uid = Long.MAX_VALUE / 100;
        String res = objectMapper.writeValueAsString(vo);
        System.out.println("res: " + res);
    }

    public static class DataVo {
        public Long id;
        public long uid;
    }
}
