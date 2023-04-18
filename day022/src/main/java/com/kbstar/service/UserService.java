package com.kbstar.service;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.MyDao;
import com.kbstar.frame.MyService;

import java.util.List;

public class UserService implements MyService<String, UserDTO> {
    //UserService는 MyDao를 사용하지만
    //코드 내에서 그 관계가 표기되도록 의존성을 만들지 않고 (= 객체를 바로 생성하지 않고)
    // 인터페이스만으로 코드를 작성..
    // 따라서 앞으로 UserSerivce코드를 수정할 일은 X
    MyDao<String, UserDTO> dao;

    public UserService(MyDao<String, UserDTO> dao) {
        this.dao = dao;
    }

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
