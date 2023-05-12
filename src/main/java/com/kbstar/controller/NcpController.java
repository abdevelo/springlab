package com.kbstar.controller;

import com.kbstar.dto.Ncp;
import com.kbstar.util.CFRcelebrityUtil;
import com.kbstar.util.CFRfaceUtil;
import com.kbstar.util.FileUploadUtil;
import com.kbstar.util.OCRutil;
import com.sun.tools.jconsole.JConsoleContext;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class NcpController {

    @Value("${uploadimgdir}")
    String imgpath = "/Users/hyosunpark/uimg/";
    @RequestMapping("/cfr1impl")
    public String cfr1impl(Model model, Ncp ncp) throws ParseException {
        // 1. 이미지를 서버에 저장
        FileUploadUtil.saveFile(ncp.getImg(),imgpath); // ncp의 이미지를 가져와서 imgpath에 저장해라
        // 2. 저장한 이미지를 ncp 에 물어본다
        String imgname = ncp.getImg().getOriginalFilename();
        JSONObject result =(JSONObject) CFRcelebrityUtil.getResult(imgpath,imgname);
        JSONArray faces = (JSONArray) result.get("faces");
        JSONObject obj = (JSONObject) faces.get(0);
        JSONObject celebrity = (JSONObject) obj.get("celebrity");
        String value = (String) celebrity.get("value");

        log.info(result.toJSONString());
        // 3. 결과를 받는다
        model.addAttribute("result",value);
        model.addAttribute("center","cfr1");
        return "index";
    }

    @RequestMapping("/cfr2impl")
    public String cfr2impl(Model model, Ncp ncp) throws ParseException {
        // 1. 이미지를 서버에 저장
        FileUploadUtil.saveFile(ncp.getImg(),imgpath); // ncp의 이미지를 가져와서 imgpath에 저장해라
        // 2. 저장한 이미지를 ncp 에 물어본다
        String imgname = ncp.getImg().getOriginalFilename();
        JSONObject result =(JSONObject) CFRfaceUtil.getResult(imgpath,imgname);
        JSONArray faces = (JSONArray) result.get("faces");
        JSONObject obj = (JSONObject) faces.get(0);

        JSONObject gender = (JSONObject) obj.get("gender");
        String gender_value = (String) gender.get("value");
        log.info("-----------------------------------------");
        log.info(gender_value);
        log.info("-----------------------------------------");

        JSONObject age = (JSONObject) obj.get("age");
        String age_value = (String) age.get("value");

        JSONObject pose = (JSONObject) obj.get("pose");
        String pose_value = (String) pose.get("value");

        JSONObject emotion = (JSONObject) obj.get("emotion");
        String emotion_value = (String) emotion.get("value");

        Map<String, String> map = new HashMap<>();
        map.put("emotion", emotion_value);
        map.put("pose", pose_value);
        map.put("age", age_value);
        map.put("gender", gender_value);


        // 3. 결과를 받는다
        model.addAttribute("result", map);
        model.addAttribute("center","cfr2");
        return "index";
    }

    @RequestMapping("/mycfr")
    public String mycfr(Model model, String imgname ) throws ParseException {

        // 1. 저장한 이미지의 이름 넣기
        JSONObject result =(JSONObject) CFRfaceUtil.getResult(imgpath,imgname);
        JSONArray faces = (JSONArray) result.get("faces");
        JSONObject obj = (JSONObject) faces.get(0);

        JSONObject gender = (JSONObject) obj.get("gender");
        String gender_value = (String) gender.get("value");

        JSONObject age = (JSONObject) obj.get("age");
        String age_value = (String) age.get("value");

        JSONObject pose = (JSONObject) obj.get("pose");
        String pose_value = (String) pose.get("value");

        JSONObject emotion = (JSONObject) obj.get("emotion");
        String emotion_value = (String) emotion.get("value");

        Map<String, String> map = new HashMap<>();
        map.put("emotion", emotion_value);
        map.put("pose", pose_value);
        map.put("age", age_value);
        map.put("gender", gender_value);


        // 3. 결과를 받는다
        model.addAttribute("result", map);
        model.addAttribute("center","pic");
        return "index";
    }


    @RequestMapping("/ocrimpl1")
    public String ocrimpl1(Model model, Ncp ncp){
        // 1. 이미지를 서버에 저장
        FileUploadUtil.saveFile(ncp.getImg(),imgpath); // ncp의 이미지를 가져와서 imgpath에 저장해라
        // 2. 저장한 이미지를 ncp 에 물어본다
        String imgname = ncp.getImg().getOriginalFilename();
        JSONObject result =(JSONObject) OCRutil.getResult(imgpath,imgname);

        Map map = OCRutil.getData(result);

        model.addAttribute("result",map);
        model.addAttribute("center","ocr1");
        return "index";
    }

    @RequestMapping("/ocrimpl2")
    public String ocrimpl2(Model model, Ncp ncp){
        // 1. 이미지를 서버에 저장
        FileUploadUtil.saveFile(ncp.getImg(),imgpath); // ncp의 이미지를 가져와서 imgpath에 저장해라
        // 2. 저장한 이미지를 ncp 에 물어본다
        String imgname = ncp.getImg().getOriginalFilename();
        JSONObject result =(JSONObject) OCRutil.getResult(imgpath,imgname);

        Map map = OCRutil.getData2(result);

        model.addAttribute("result",map);
        model.addAttribute("center","ocr2");
        return "index";
    }
}
