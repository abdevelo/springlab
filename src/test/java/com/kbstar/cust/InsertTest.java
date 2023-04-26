package com.kbstar.cust;
import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
@Slf4j
public class InsertTest {
    @Autowired
    CustService service;
    @Test
    void contextLoads(){
        Cust obj = new Cust("id01", "pwd01", "james");
        try {
            service.register(obj);
        } catch (Exception e) {
            log.info("등록 에러...");
            e.printStackTrace();
        }
    }

}
