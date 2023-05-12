package com.kbstar.controller;

import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import com.kbstar.util.WeatherUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger; // Logger를 import할 때는 slf4j인 것을 확인해요
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@Controller
public class MainController {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    CustService custService;
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName()); // 로그를 선언해줌으로써 System.out으로 console에 내용이 입력되는 것을 막아요

    @Value("${adminserver}")
    String adminserver;

    @RequestMapping("/")
    public String main(Model model) throws IOException, ParseException {
        //날씨 정보 util 에서 받아오기
//        String result = WeatherUtil.getWeather1("108");
//        model.addAttribute("weatherinfo", result);

        model.addAttribute("adminserver", adminserver);
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("center", "login");
        return "index";
    }

    @RequestMapping("/custinfo")
    public String custinfo(Model model, String id) throws Exception {
        Cust cust = null;
        try {
            cust = custService.get(id);
        } catch (Exception e) {
            throw new Exception("시스템 장애");
        }
        model.addAttribute("custinfo", cust);
        model.addAttribute("center", "custinfo");
        return "index";
    }


    @RequestMapping("/custinfoimpl")
    public String custinfoimpl(Model model, Cust cust) throws Exception {
        try {
            log.info("------------------------------------------" + cust.getPwd());
            cust.setPwd(encoder.encode(cust.getPwd())); //수정 전 비밀번호 암호화 잊지말기
            custService.modify(cust);
        } catch (Exception e) {
            throw new Exception("시스템 장애");
        }
        return "redirect:/custinfo?id=" + cust.getId(); // 0502 해당 id custinfo페이지로 리다이렉트
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpSession session) {
        //세션에있는 정보를 없애는 게 logout
        if (session != null) {
            session.invalidate();
        }
        return "index";
    }

    //    @RequestMapping("/loginimpl") //여기 이 클래스를 지정해줌으로써 login 화면에서 입력한 내용이 controller로 오도록 해요
//    public String loginimpl(Model model,String id, String pwd){
//        logger.info("----------------------"+"ID : "+id+"PWD : "+pwd); // 브라우저에서 입력된 id, pwd 값을 logger 가 기록해주고 logback.xml에서 설정한 대로 INFO로 콜솔창에 보여줘요
//        model.addAttribute("center", "login");
//        return "index";
//    }
    @RequestMapping("/loginimpl")
    public String loginimpl(Model model, String id, String pwd, HttpSession session) {
        Cust cust = null;
        String nextPage = "loginfail";
        try {
            cust = custService.get(id);
            if (cust != null && encoder.matches(pwd, cust.getPwd())) {
                nextPage = "loginok";
                session.setMaxInactiveInterval(100000);// 한 session의 제한시간
                session.setAttribute("logincust", cust); //session에 logincust라는 이름으로 cust를 넣어줌 --> login을 메모리에 제한시간만큼 유지
            }
        } catch (Exception e) {
            throw new RuntimeException("시스템 장애 잠시 후 다시 로그인 하세요.");
        }
        model.addAttribute("center", nextPage);
        return "index";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("center", "register");
        return "index";
    }

    @RequestMapping("/registerimpl")
    public String registerimpl(Model model, Cust cust, HttpSession session) throws Exception {
        //cust객체의 id,pwd,name이라는 필드가 input태그 name들의 요소와 일치하면 자동으로 dto가되서 들어온다
        try {
            cust.setPwd(encoder.encode(cust.getPwd())); // 0502 화면에서 입력한 pwd를 가져와서 암호화 후 다시 cust객체의 pwd에 입력
            custService.register(cust);
            session.setMaxInactiveInterval(100000);// 한 session의 제한시간
            session.setAttribute("logincust", cust);
        } catch (Exception e) {
            throw new Exception("가입 오류");
        }
        model.addAttribute("rcust", cust);
        model.addAttribute("center", "registerok"); // center->registerok 로 바꿔 register완료된 후 registerok.jsp 화면이 나오도록
        return "index";
    }

    // url : /quics?page=bs01
    @RequestMapping("/quics")
    public String quics(String page) {
        return page;
    }


    @RequestMapping("/pic")
    public String pic(Model model) {
        model.addAttribute("center", "pic");
        return "index";
    }

    @RequestMapping("/websocket")
    public String websocket(Model model) {
        model.addAttribute("adminserver", adminserver);
        model.addAttribute("center", "websocket");
        return "index";
    }

    @RequestMapping("/cfr1")
    public String cfr1(Model model) {
        model.addAttribute("center", "cfr1");
        return "index";
    }

    @RequestMapping("/cfr2")
    public String cfr2(Model model) {
        model.addAttribute("center", "cfr2");
        return "index";
    }

    @RequestMapping("/ocr1")
    public String ocr1(Model model) {
        model.addAttribute("center", "ocr1");
        return "index";
    }

    @RequestMapping("/ocr2")
    public String ocr2(Model model) {
        model.addAttribute("center", "ocr2");
        return "index";
    }

}