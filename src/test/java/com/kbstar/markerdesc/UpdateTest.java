package com.kbstar.markerdesc;
import com.kbstar.dto.Item;
import com.kbstar.dto.MarkerDesc;
import com.kbstar.service.ItemService;
import com.kbstar.service.MarkerDescService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
@Slf4j
public class UpdateTest {
    @Autowired
    MarkerDescService markerDescService;
    @Test
    void contextLoads(){

        MarkerDesc obj = new MarkerDesc(18, 134, "공차", 10000, "yang2.jpg");
        try {
            markerDescService.modify(obj);
            markerDescService.get(17);
        } catch (Exception e) {
            log.info("에러...");
            e.printStackTrace();
        }
    }
}
