package com.kbstar.controller;


import com.kbstar.dto.Cust;
import com.kbstar.dto.Marker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
// 기존 controller : 화면을 return
// RestController : object을 return
public class AjaxImplController {
    @RequestMapping("/getservertime")
    public Object getservertime() {
        Date date = new Date();
        return date;
    }

    @RequestMapping("/getdata")
    public Object getdata() {

        List<Cust> list = new ArrayList<>();
        list.add(new Cust("id01", "pwd01", "james1"));
        list.add(new Cust("id02", "pwd02", "james2"));
        list.add(new Cust("id03", "pwd03", "james3"));
        list.add(new Cust("id04", "pwd04", "james4"));
        list.add(new Cust("id05", "pwd05", "james5"));

        // Parsing : Java Object --> JSON
        // JSON(JavaScript Object Notation)
        // [{},{},{}, ... ]
        JSONArray ja = new JSONArray();
        for (Cust obj : list) {
            JSONObject jo = new JSONObject();
            Random r = new Random();
            int i = r.nextInt(100) + 1;
            jo.put("id", obj.getId());
            jo.put("pwd", obj.getPwd());
            jo.put("name", obj.getName() + i);
            ja.add(jo);
        }
        return ja;
    }


    @RequestMapping("/checkid")
    public Object checkid(String id) {
        int result = 0;
        if (id.equals("qqqq") || id.equals("aaaa") || id.equals("ssss")) {
            result = 1;
        }
        return result;
    }

    @RequestMapping("/markers")
    public Object markers(String loc) {
        //분기가 필요
        List<Marker> list = new ArrayList<>();
        if (loc.equals("s")) {
            list.add(new Marker(100, "담미온", "http://www.nate.com", 37.5456390, 127.0534580, "a.jpg", "s"));
            list.add(new Marker(101, "제주국수", "http://www.naver.com", 38.5456390, 127.0534580, "b.jpg", "s"));
            list.add(new Marker(102, "교대이층", "http://www.google.com", 37.5456390, 129.0534580, "c.jpg", "s"));
        } else if (loc.equals("b")) {
            list.add(new Marker(103, "해운대", "http://www.nate.com", 35.1883491, 129.2233197, "a.jpg", "b"));
            list.add(new Marker(104, "고기국수", "http://www.naver.com", 35.1883491, 129.2233197, "b.jpg", "b"));
            list.add(new Marker(105, "부산역전", "http://www.google.com", 35.1883491, 129.2233197, "c.jpg", "b"));
        } else if (loc.equals("j")) {
            list.add(new Marker(106, "올레시장", "http://www.nate.com", 33.2501708, 126.5636786, "a.jpg", "j"));
            list.add(new Marker(107, "제주공항", "http://www.naver.com", 33.2501708, 126.5636786, "b.jpg", "j"));
            list.add(new Marker(108, "서귀포시장", "http://www.google.com", 33.2501708, 126.5636786, "c.jpg", "j"));
        }

        JSONArray ja = new JSONArray();
        //db에서 맛집 정보를 select 해온다
        for (Marker obj : list) {
            JSONObject jo = new JSONObject();
            Random r = new Random();
            int i = r.nextInt(100) + 1;
            jo.put("id", obj.getId());
            jo.put("title", obj.getTitle());
            jo.put("target", obj.getTarget());
            jo.put("lat", obj.getLat());
            jo.put("lng", obj.getLng());
            jo.put("img", obj.getImg());
            jo.put("loc", obj.getLoc());
            ja.add(jo);
        }
        return ja;
    }
}
