package com.kbstar.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;

@RestController
public class ChartImplController {
    @RequestMapping("/chart02")
    public Object chart02(){
        //[num,num,num,.....] 인 데이터의 형태 였음 --> chart01 참고
        //{'category':[], 'data':[]} 로 x축의 value들은 category에 담고 각 축 마다의 값인 y축값은 data에 담기

        JSONObject jo = new JSONObject();

        JSONArray jaCnt = new JSONArray();
        for ( int i=1; i<=12; i++) {
            Random r = new Random();
            int cnt = r.nextInt(10000)+1;
            jaCnt.add(cnt);
        }
        JSONArray jaYear = new JSONArray();
        for ( int i=2012; i<=2023 ;i++){
            jaYear.add(i);
        }
        jo.put("category",jaYear);
        jo.put("data",jaCnt);
        return jo;
    }

    @RequestMapping("/chart0301")
    public Object chart0301(){
        // 배열 in 배열 형태 [ [], [], .....]
        JSONArray ja = new JSONArray();
        for ( int i=1; i<=5; i++){
            Random r = new Random();
            int num = r.nextInt(20)+1;
            JSONArray jadata = new JSONArray();
            jadata.add("data" + num); // 데이터의 이름을 가상으로 만듦
            jadata.add(num);
            ja.add(jadata);
        }
        return ja;
    }


    @RequestMapping("/chart0302")
    public Object chart0302(){
        JSONObject jo = new JSONObject();
        JSONArray age = new JSONArray();
        for ( int i=1; i<=10; i++){
            age.add(i);
        }
        JSONArray ja = new JSONArray();
        for (int i=1; i<=10; i++){
            Random r = new Random();
            int num = r.nextInt(50000)+1;
            ja.add(num);
        }
        jo.put("age", age);
        jo.put("data",ja);
        return jo;
    }

    @RequestMapping("/chart0303")
    public Object chart0303(){
        JSONObject jo = new JSONObject();

        JSONArray china = new JSONArray();
        JSONArray usa = new JSONArray();
        JSONArray eu = new JSONArray();
        JSONArray india = new JSONArray();

        JSONArray jaY = new JSONArray();

        for ( int i=1; i<33; i++){
            jaY.add(i);
        }
        jo.put("yValue",jaY);

        for (int i=1; i<33; i++){
                Random r = new Random();
                int num = r.nextInt(100)+1;
            china.add(num);
        }

        for (int i=1; i<33; i++){
            Random r = new Random();
            int num = r.nextInt(100)+1;
            usa.add(num);
        }

        for (int i=1; i<33; i++){
            Random r = new Random();
            int num = r.nextInt(100)+1;
            eu.add(num);
        }

        for (int i=1; i<33; i++){
            Random r = new Random();
            int num = r.nextInt(100)+1;
            india.add(num);
        }
        jo.put("china",china);
        jo.put("usa",usa);
        jo.put("eu",eu);
        jo.put("india",india);

        return jo;
    }


}
