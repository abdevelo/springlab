package com.kbstar.controller;

import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import org.slf4j.Logger; // Logger를 import할 때는 slf4j인 것을 확인해요
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    CustService custService;
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName()); // 로그를 선언해줌으로써 System.out으로 console에 내용이 입력되는 것을 막아요


    @RequestMapping("/")
    public String main(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("center", "login");
        return "index";
    }
//    @RequestMapping("/loginimpl") //여기 이 클래스를 지정해줌으로써 login 화면에서 입력한 내용이 controller로 오도록 해요
//    public String loginimpl(Model model,String id, String pwd){
//        logger.info("----------------------"+"ID : "+id+"PWD : "+pwd); // 브라우저에서 입력된 id, pwd 값을 logger 가 기록해주고 logback.xml에서 설정한 대로 INFO로 콜솔창에 보여줘요
//        model.addAttribute("center", "login");
//        return "index";
//    }

    @RequestMapping("/loginimpl")
    public String loginimpl(Model model, Cust cust){
        logger.info("---------------------------"+ cust); // 브라우저에서 입력된 id, pwd 값을 logger 가 기록해주고 logback.xml에서 설정한 대로 INFO로 콜솔창에 보여줘요
        model.addAttribute("center", "login");
        return "index";
    }

    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("center", "register");
        return "index";
    }
    @RequestMapping("/registerimpl")
    public String registerimpl(Model model, Cust cust) throws Exception {
        //cust객체의 id,pwd,name이라는 필드가 input태그 name들의 요소와 일치하면 자동으로 dto가되서 들어온다
        try {
            custService.register(cust);
        } catch (Exception e) {
            throw new Exception("가입 오류");
        }
        model.addAttribute("rcust", cust);
        model.addAttribute("center", "registerok"); // center->registerok 로 바꿔 register완료된 후 registerok.jsp 화면이 나오도록
        return "index";
    }

    // url : /quics?page=bs01
    @RequestMapping("/quics")
    public String quics(String page){
        return page;
    }
}
