package com.kbstar.service;

import com.kbstar.dao.UserDAO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.MyDao;
import com.kbstar.frame.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("uservice")
// 클래스 명 위에 annotation함으로써
// 다른 클래스에서 읽힐 수 있도록 함
public class UserService implements MyService<String, UserDTO> {
    @Autowired
    UserDAO dao; //자동적으로 컴포넌트 스캔을 해서 사용

    
//    @Autowired
//    @Qualifier("udao")
//    MyDao<String, UserDTO> dao;
    //day022 와 달리 이 클래스에서는 생성자를 쓰지 않고 annotation만으로 IoC

    @Override

    public void register(UserDTO userDTO) {
        dao.insert(userDTO);
        System.out.println("send Mail...");
    }

    @Override
    public void remove(String s) {
        dao.delete(s);

    }

    @Override
    public void modify(UserDTO userDTO) {
        dao.update(userDTO);

    }

    @Override
    public UserDTO get(String s) {
        // id를 넣으면 회원 정보를 가져와라
        return dao.select(s);
    }

    @Override
    public List<UserDTO> get() {
        // 전체를 다 가져와라
        return dao.select();
    }
}
