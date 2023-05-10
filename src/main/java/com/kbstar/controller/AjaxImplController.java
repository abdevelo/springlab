package com.kbstar.controller;


import com.kbstar.dto.Cart;
import com.kbstar.dto.Cust;
import com.kbstar.dto.Marker;
import com.kbstar.service.CartService;
import com.kbstar.service.CustService;
import com.kbstar.service.MarkerService;
import com.kbstar.util.FileUploadUtil;
import com.kbstar.util.WeatherUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
// 기존 controller : 화면을 return
// RestController : object을 return
public class AjaxImplController {

    @Autowired
    MarkerService markerService;
    @Autowired
    CustService custService;
    @Autowired
    CartService cartService;
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
    public Object checkid(String id) throws Exception {
        int result = 0;
        Cust cust = null;
        cust = custService.get(id);
        if ( cust != null){
            result=1;
        }
        return result;  // result =1 ->  사용할 수 없는 아이디
    }

    @RequestMapping("/chart05")
    public Object chart05(String year) {
        JSONArray ja = new JSONArray();
        for(int i=1;i<=12; i++){
            Random r = new Random();
            int num = r.nextInt(100)+1;
            ja.add(num);
        }
        return ja;
    }


    @RequestMapping("/markers")
    public Object markers(String loc) throws Exception {
        List<Marker> list = null;
        try {
            list = markerService.getLoc(loc);
        } catch (Exception e) {
            throw new Exception("시스템 장애");
        }
        JSONArray ja = new JSONArray();
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


    @RequestMapping("/addcart")
    public Object addcart(Cart cart) throws Exception {
        cartService.register(cart);
        return "";
    }

    @Value("${uploadimgdir}")
    String imgdir;

    @RequestMapping("/saveimg")
    public String saveimg(MultipartFile file){
        String filename = file.getOriginalFilename(); // 이미지 이름을 가져옴
        FileUploadUtil.saveFile(file, imgdir); // 파일을 저장
        return filename;
    }

    @RequestMapping("/weather2")
    public Object weather2() throws Exception {
        return WeatherUtil.getWeather3("108");
    }

}
