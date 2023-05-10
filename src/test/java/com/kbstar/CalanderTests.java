package com.kbstar;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Slf4j
@SpringBootTest
class CalanderTests {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Test
    void contextLoads() {
        String rawPassword = "pwd01";
        String encPassword = encoder.encode(rawPassword);
        log.info("--------------------------------------------------------");
        log.info("-----암호화 된 비번 : " + encPassword);
        boolean result = encoder.matches("pwd01",encPassword);
        log.info("-----일치여부 : "+result);
        log.info("--------------------------------------------------------");
    }


}
