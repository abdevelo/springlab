package com.kbstar.markerdesc;
import com.kbstar.dto.Item;
import com.kbstar.dto.MarkerDesc;
import com.kbstar.service.ItemService;
import com.kbstar.service.MarkerDescService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

@SpringBootTest
@Slf4j
public class InsertTest {
    @Autowired
    MarkerDescService markerDescService;
    @Test
    void contextLoads(){
        MarkerDesc obj = new MarkerDesc(18, 134, "치킨", 10000, "yang2.jpg");
        try {
            markerDescService.register(obj);
            markerDescService.get();
        } catch (Exception e) {
            if( e instanceof DuplicateKeyException) {
                log.info("ID가 중복 되었습니다.-----------------------------------------------------");
            }else {
                log.info("시스템 장애입니다.-----------------------------------------------------");
            }
        }
    }
}
