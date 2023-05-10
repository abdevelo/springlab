package com.kbstar.weather;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;

@Slf4j
@SpringBootTest
class CalanderTests {
    @Test
    void contextLoads() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        int day = c.get(Calendar.DATE);

        String month_str = month+""; // 일단 월을 2자리로 바꿔주고
        if (month_str.length() == 1 ) {
            month_str = "0" + month_str;
        }
        String today = ""+year+month_str+day+"0600";

        log.info("---------------------------------------------");
        log.info(today);
        log.info("---------------------------------------------");
    }
}
