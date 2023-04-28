package com.kbstar.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MarkerDesc {
    private int id;
    private int marker_id;
    private String item;
    private int price;
    private String imgname;
}
