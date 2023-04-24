package com.kbstar.controller;

import com.kbstar.dto.Cust;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/map")
public class MapController {

    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    String dir = "map/";

    @RequestMapping("")
    public String main(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"center");
        return "index";
    }

    @RequestMapping("/map01")
    public String map01(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"map01");
        return "index";
    }

    @RequestMapping("/map02")
    public String map02(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"map02");
        return "index";
    }

    @RequestMapping("/map03")
    public String map03(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"map03");
        return "index";
    }


    @RequestMapping("/map04")
    public String map04(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"map04");
        return "index";
    }

    @RequestMapping("/map05")
    public String map05(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"map05");
        return "index";
    }
}
