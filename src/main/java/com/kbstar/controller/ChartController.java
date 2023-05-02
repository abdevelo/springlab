package com.kbstar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chart")
public class ChartController {

    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    String dir = "chart/";

    @RequestMapping("")
    public String main(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"center");
        return "index";
    }

    @RequestMapping("/chart01")
    public String chart01(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"chart01");
        return "index";
    }

    @RequestMapping("/chart02")
    public String chart02(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"chart02");
        return "index";
    }

    @RequestMapping("/chart03")
    public String chart03(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"chart03");
        return "index";
    }


    @RequestMapping("/chart04")
    public String chart04(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"chart04");
        return "index";
    }

    @RequestMapping("/chart05")
    public String chart05(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"chart05");
        return "index";
    }
}
