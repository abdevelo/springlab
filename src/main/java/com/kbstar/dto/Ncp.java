package com.kbstar.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.format.annotation.DateTimeFormat;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Ncp {
    private MultipartFile img;
}

