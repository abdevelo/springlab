package com.kbstar.app;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserInsertTest {

    public static void main(String[] args) {
        ApplicationContext factory =
                new ClassPathXmlApplicationContext("spring.xml");
        // 판떼기 가져오기

        MyService<String, UserDTO> service =
                (MyService<String, UserDTO>) factory.getBean("uservice");

        UserDTO u = new UserDTO("id01", "pwd01", "lee");
        service.register(u);
    }

}
