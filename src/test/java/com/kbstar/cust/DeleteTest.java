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
public class DeleteTest {
    @Autowired
    CustService service;
    @Test
    void contextLoads(){

        try {
            service.remove("id03");
        } catch (Exception e) {
            log.info("에러...");
            e.printStackTrace();
        }
    }
}
