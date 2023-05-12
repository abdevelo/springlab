package com.kbstar.ncp;

import com.kbstar.util.CFRfaceUtil;
import com.kbstar.util.OCRutil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class OCRTests {

    @Value("${uploadimgdir}")
    String imgpath = "/Users/hyosunpark/uimg/";
    @Test
    void contextLoads() throws ParseException {
        JSONObject jo = (JSONObject) OCRutil.getResult(imgpath,"passport.png");
        log.info(jo.toJSONString());

        Map map = OCRutil.getData2(jo);
        log.info(map.values().toString());
    }
}
