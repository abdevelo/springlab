package com.kbstar.item;
import com.kbstar.dto.Cust;
import com.kbstar.dto.Item;
import com.kbstar.service.CustService;
import com.kbstar.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
@Slf4j
public class UpdateTest {
    @Autowired
    ItemService service;
    @Test
    void contextLoads(){

        Item obj = new Item(104,"드레스",20000,"b.jpg",new Date());
        try {
            service.modify(obj);
            service.get(104);
        } catch (Exception e) {
            log.info("에러...");
            e.printStackTrace();
        }
    }
}
