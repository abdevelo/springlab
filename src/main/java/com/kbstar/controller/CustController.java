package com.kbstar.controller;

import com.github.pagehelper.PageInfo;
import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Controller
@Slf4j
@RequestMapping("/cust") // url에서 cust가 호출될 경우 담당할 controller를 만들어줘요
public class CustController {

    @Autowired
    CustService custService;
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    String dir = "cust/";
    @RequestMapping("") // RequestMapping에 아무것도 적지 않으니 상위 클래스에 적힌 127.0.0.1/cust 시에 자동으로 실행될 클래스에요.
    public String main(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"center");
//        logger.info("-------------------------------------------------"); logger 객체 생성 방법으로 할 시 사용
        Random r = new Random();
        int inx = r.nextInt(1000)+1;
        log.info(inx+""); // Slf4j로 import시 사용.반드시 string이어야만 함....!!
        return "index";
    }


    @RequestMapping("/add") // RequestMapping에 아무것도 적지 않으니 상위 클래스에 적힌 127.0.0.1/cust 시에 자동으로 실행될 클래스에요.
    public String add(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"add");
        return "index";
    }

    @RequestMapping("/get") // RequestMapping에 아무것도 적지 않으니 상위 클래스에 적힌 127.0.0.1/cust 시에 자동으로 실행될 클래스에요.
    public String get(Model model,String id){
        Cust cust = new Cust(id, "xxx", "james");
        model.addAttribute("gcust", cust);
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"get");
        return "index";
    }


    @RequestMapping("/all") // RequestMapping에 아무것도 적지 않으니 상위 클래스에 적힌 127.0.0.1/cust 시에 자동으로 실행될 클래스에요.
    public String all(Model model) throws Exception {
        List<Cust> list =null;
        try {
            list = custService.get();
        } catch (Exception e) {
            throw new Exception("시스템 장애:ER0001");
        }
        model.addAttribute("clist", list);
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"all");
        return "index";
    }

    @RequestMapping("/allpage")
    public String allpage(@RequestParam(required = false, defaultValue = "1") int pageNo, Model model) throws Exception {
        PageInfo<Cust> p;
        try {
            p = new PageInfo<>(custService.getPage(pageNo), 5); // 5:하단 네비게이션 개수
        } catch (Exception e) {
            throw new Exception("시스템 장애: ER0001");
        }
        model.addAttribute("cpage",p);
        model.addAttribute("target", "cust");
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"allpage");
        return "index";
    }
}
