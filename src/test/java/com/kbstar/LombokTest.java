package com.kbstar;

import com.kbstar.dto.Cust;
import org.junit.jupiter.api.Test;
// *** import 시에 org.slf4j인 것을 확인 ***
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LombokTest {
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    @Test
    void contextLoads() {
        Cust cust = new Cust("id01", "pwd01", "이말숙");
        logger.info(cust.toString());
        // info내용은 화면에 출력이 되지 않음 unlike System.out.println
    }
}
