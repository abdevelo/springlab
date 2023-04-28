package com.kbstar.markerdesc;
import com.kbstar.service.ItemService;
import com.kbstar.service.MarkerDescService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SelectOneTest {
    @Autowired
    MarkerDescService markerDescService;
    @Test
    void contextLoads(){
        try {
            markerDescService.get(12);
        } catch (Exception e) {
            log.info("에러...");
            e.printStackTrace();
        }
    }
}
