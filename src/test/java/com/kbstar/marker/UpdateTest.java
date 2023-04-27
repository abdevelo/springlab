package com.kbstar.marker;

import com.kbstar.dto.Adm;
import com.kbstar.dto.Marker;
import com.kbstar.service.MarkerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * 4.27 정인보 update 테스트 완료
 * 테스트 id : 108 / 양꼬치집
 * 수정완료한 정보 : LAT 및 LNG
 */
@Slf4j // 로그 찍을거야
@SpringBootTest
class UpdateTest {
    @Autowired
    MarkerService service;
    @Test
    void contextLoads() {
    // cust 객체 만들어서 아규먼트 넣어본다. 테스트 ok
        Marker obj = new Marker(108,"양꼬치집","http://www.google.com", 33.4996002, 126.5273787,"yang.jpg", "J");
        try {
            service.modify( new Marker(108,"양꼬치집","http://www.google.com",  38.2222, 126.5555,"yang.jpg", "J") );
            log.info("------- Marker(맛집추천) 정보 정상 수정완료 -------");
        } catch (Exception e) { // 오류 예외처리(자동)
            //throw new RuntimeException(e)
                log.info("-------  Marker(맛집추천) 조회 에러 발생 -------");
           // e.printStackTrace(); // 에러 자세히
        }
    }

}
