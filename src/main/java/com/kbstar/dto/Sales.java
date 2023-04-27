package com.kbstar.dto;

import lombok.*;
//import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Sales {
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String rdate; // 오라클에서는 date-> 자바에서는 string ex) s2023-01-02
    private int price;
    private String gender; //gender CHAR(1)
}

