package com.kbstar.controller;

import com.kbstar.dto.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/item") // url에서 cust가 호출될 경우 담당할 controller를 만들어줘요
public class ItemController {

    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    String dir = "item/";

    @RequestMapping("") // RequestMapping에 아무것도 적지 않으니 상위 클래스에 적힌 127.0.0.1/cust 시에 자동으로 실행될 클래스에요.
    public String main(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"center");
        return "index";
    }


    @RequestMapping("/add") // RequestMapping에 아무것도 적지 않으니 상위 클래스에 적힌 127.0.0.1/item 시에 자동으로 실행될 클래스에요.
    public String add(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"add");
        return "index";
    }

    @RequestMapping("/all") // RequestMapping에 아무것도 적지 않으니 상위 클래스에 적힌 127.0.0.1/item 시에 자동으로 실행될 클래스에요.
    public String all(Model model){
        List<Item> list = new ArrayList<>();
        list.add(new Item(100, "pants1", 1000, "a.jpg", new Date()));
        list.add(new Item(101, "pants2", 2000, "b.jpg", new Date()));
        list.add(new Item(102, "pants3", 3000, "c.jpg", new Date()));
        list.add(new Item(103, "pants4", 4000, "d.jpg", new Date()));
        list.add(new Item(104, "pants5", 5000, "e.jpg", new Date()));

        model.addAttribute("allitem", list);

        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"all");
        return "index";
    }
}
