package com.kbstar.ncp;

import com.kbstar.util.CFRcelebrityUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CFRcelebrityTests {

    @Value("${testdir}")
    String imgpath = "/Users/hyosunpark/uimg/"; //upload하는 dir 정보

    @Autowired
    CFRcelebrityUtil cfRcelebrityUtil;

    @Test
    void contextLoads() throws ParseException {

        log.info(imgpath);

        String imgname = "ma.jpg";
        JSONObject result =(JSONObject)cfRcelebrityUtil.getResult(imgpath,imgname);
        log.info("-------------------------");
        log.info(result.toJSONString());
        log.info("-------------------------");
    }
}
