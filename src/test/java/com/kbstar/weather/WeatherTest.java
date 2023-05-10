package com.kbstar.weather;

import com.kbstar.util.WeatherUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.util.Calendar;

@Slf4j
@SpringBootTest
class WeatherTest {

    @Test
    void contextLoads() throws IOException, ParseException {

        String result = null;

        result = WeatherUtil.getWeather1("109");
        log.info("--------------------------------------------------------");
        log.info(result);
        log.info("--------------------------------------------------------");
    }


}
