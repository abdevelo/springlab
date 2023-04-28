package com.kbstar.cust;
import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class SelectOneTest {
    @Autowired
    CustService service;
    @Test
    void contextLoads(){
        Cust cust = null;
        try {
            cust = service.get("id77");
            log.info("----------------------------------------");
            log.info(cust.toString()); // 에러의 위치는 여기다. null값 자체를 가져오는 것은 에러가 아님.
            log.info("----------------------------------------");

        } catch (Exception e) {
            log.info("에러...");
            e.printStackTrace();
        }
    }
}
