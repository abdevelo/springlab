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
public class UpdateTest {
    @Autowired
    CustService service;
    @Test
    void contextLoads(){
        Cust obj = new Cust("id01","pwd01","홍말숙11");
        try {
            service.modify(obj);
        } catch (Exception e) {
            log.info("에러...");
            e.printStackTrace();
        }
    }
}
