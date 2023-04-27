package com.kbstar.dto;

import lombok.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Item {
    private int id; //sequence 값
    private String name;
    private int price;
    private String imgname;
    private Date rdate; // 현재 날짜
}
