package com.kbstar.dao;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.MyDao;

import java.util.List;

public class OracleDao implements MyDao<String, UserDTO> {


    @Override
    public void insert(UserDTO userDTO) {
        System.out.println("Inserted Oracle:"+userDTO);

    }

    @Override
    public void delete(String s) {
        System.out.println("Deleted Oracle:"+s);
    }

    @Override
    public UserDTO select(String s) {
        return null;
    }

    @Override
    public List<String> select() {
        return null;
    }
}
