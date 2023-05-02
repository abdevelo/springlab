package com.kbstar.controller;

import com.github.pagehelper.PageInfo;
import com.kbstar.dto.Item;
import com.kbstar.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/item") // url에서 cust가 호출될 경우 담당할 controller를 만들어줘요
public class ItemController {

    @Autowired
    ItemService itemService;
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    String dir = "item/";

    @RequestMapping("") // RequestMapping에 아무것도 적지 않으니 상위 클래스에 적힌 127.0.0.1/cust 시에 자동으로 실행될 클래스에요.
    public String main(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"center");
        return "index";
    }
    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"add");
        return "index";
    }
    @RequestMapping("/all")
    public String all(Model model) throws Exception {
        List<Item> list = null;
        try {
            list = itemService.get();
        } catch (Exception e) {
            throw new Exception("시스템 장애:ER0002");
        }
        model.addAttribute("allitem", list);
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"all");
        return "index";
    }
    @RequestMapping("/allpage")
    public String allpage(@RequestParam(required = false, defaultValue = "1") int pageNo, Model model) throws Exception {
        //pageNo를 받을 때 요청값이 없으면 '1'페이지로 디폴트로 정하겠음
        PageInfo<Item> p;
        try {
            p = new PageInfo<>(itemService.getPage(pageNo), 5);
            // pageno가 p로
            // navigatePages:하단 네비게이션 개수(1,2,3,4,5,,next)
        } catch (Exception e) {
            throw new Exception("시스템 장애:ER0001");
        }
        model.addAttribute("ipage", p);
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"allpage");
        return "index";
    }
}