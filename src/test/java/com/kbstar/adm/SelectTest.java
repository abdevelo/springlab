package com.kbstar.adm;
import com.kbstar.dto.Adm;
import com.kbstar.dto.Cust;
import com.kbstar.service.AdmService;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class SelectTest {
    @Autowired
    AdmService service;
    @Test
    void contextLoads(){
        List<Adm> list = null;
        try {
            list = service.get();
        } catch (Exception e) {
            log.info("에러...");
            e.printStackTrace();
        }
    }
}
