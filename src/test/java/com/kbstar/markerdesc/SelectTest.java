package com.kbstar.markerdesc;
import com.kbstar.dto.Item;
import com.kbstar.dto.MarkerDesc;
import com.kbstar.service.ItemService;
import com.kbstar.service.MarkerDescService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class SelectTest {
    @Autowired
    MarkerDescService markerDescService;
    @Test
    void contextLoads(){
        List<MarkerDesc> list = null;
        try {
            list=markerDescService.get();
        } catch (Exception e) {
            log.info("에러...");
            e.printStackTrace();
        }
    }
}
