package com.kbstar.ncp;

import com.kbstar.util.CFRcelebrityUtil;
import com.kbstar.util.CFRfaceUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class CFRfaceTests {

    @Value("${uploadimgdir}")
    String imgpath = "/Users/hyosunpark/uimg/"; //upload하는 dir 정보
    @Test
    void contextLoads() throws ParseException {
        String imgname = "ma.jpg";
        JSONObject result =(JSONObject) CFRfaceUtil.getResult(imgpath,imgname);
        log.info("-------------------------");
        log.info(result.toJSONString());
        log.info("-------------------------");
    }
}
