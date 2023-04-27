package com.kbstar.cart;

import com.kbstar.service.AdmService;
import com.kbstar.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SelectOneTest {
    @Autowired
    CartService service;
    @Test
    void contextLoads() {

        try {
            service.get(100);
        } catch (Exception e) {
            log.info("시스템 장애입니다.==============================");
                e.printStackTrace();
            }
    }

}
