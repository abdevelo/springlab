package com.kbstar.markerdesc;
import com.kbstar.dto.MarkerDesc;
import com.kbstar.service.MarkerDescService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class SelectDescTest {
    @Autowired
    MarkerDescService markerDescService;
    @Test
    void contextLoads(){
        try {
            markerDescService.getMarkerDesc(134);
        } catch (Exception e) {
            log.info("에러...");
            e.printStackTrace();
        }
    }
}
