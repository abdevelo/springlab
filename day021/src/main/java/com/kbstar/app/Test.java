package com.kbstar.app;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.MyService;
import com.kbstar.service.BankingService;

import java.security.Provider;

public class Test {
    public static void main(String arg[]){
        MyService<String, UserDTO> service = new BankingService();
        UserDTO user = new UserDTO("id01","pwd01","james");
        service.register(user);
    }
}
