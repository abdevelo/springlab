package com.kbstar.app;

import com.kbstar.frame.TV; // com.kbstar.frame.*; 는 frame패키지 전체 import
import com.kbstar.tv.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String arg[]){
        // 2023 04 17
        // 아직 tv는 안 만들었지만 개발상의 인터페이스만을 활용해서 만든다
        // 따라서 tv만드는 브랜드가 바뀌어도 App상에서 코드를 수정해야 할 필요가 없음
//        TV tv = null;
//        tv.turnOn();

//        // 이제 STV를 키고 싶으면
//        TV tv = new STV();
//        tv.turnOn();
//        // 이번엔 LTV를 키고 싶으면
//        TV tv = new LTV();
//        tv.turnOn();
        
          //그래도~ 
        //LTV 랑 STV는 다시 바꿔써줘야하잖아?
        //그래서 나온 게 Spring 
        //코드상의 클래스의 dependecy를 전혀 없도록 해주는 프레임워크
        
        // 결론
        // 개발표준 + 클래스들의 의존관계 감소가 스프링의 역할

        // 2023 04 18
        //*******************이제 스프링(역제어)을 이용해보자 *********************//

        ApplicationContext factory =
                new ClassPathXmlApplicationContext("spring.xml");
        // 판떼기, 즉 xml 컨테이너를 만들어주는 코드 == spring.xml
        TV tv = (TV) factory.getBean("stv");
        //여기 명칭만 넣으면 해당하는 것을 bean에서 가져온다 === 역주입
        tv.turnOn();



    }
}
