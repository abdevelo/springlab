package com.kbstar.cart;

import com.kbstar.dto.Adm;
import com.kbstar.dto.Cart;
import com.kbstar.dto.Cust;
import com.kbstar.service.AdmService;
import com.kbstar.service.CartService;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.util.Date;

@SpringBootTest
@Slf4j
class InsertTest {
    @Autowired
    CartService service;
    @Test
    void contextLoads() {
        Cart obj = new Cart("id04", 100, 5);

        try {
            service.register(obj);
            log.info("등록정상");
        } catch (Exception e) {
            if(e instanceof DuplicateKeyException){
                log.info("아이디가 중복되었습니다===========================");
            }else {
                log.info("시스템 장애입니다.==============================");
                e.printStackTrace();
            }
        }
    }

}
