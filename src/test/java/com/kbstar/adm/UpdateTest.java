package com.kbstar.adm;
import com.kbstar.dto.Adm;
import com.kbstar.dto.Cust;
import com.kbstar.service.AdmService;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UpdateTest {
    @Autowired
    AdmService service;
    @Test
    void contextLoads(){
        Adm obj = new Adm("admin01", "pwd01", 5);
        try {
            service.modify(obj);
        } catch (Exception e) {
            log.info("에러...");
            e.printStackTrace();
        }
    }
}
