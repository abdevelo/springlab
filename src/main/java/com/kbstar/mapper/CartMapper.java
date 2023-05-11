package com.kbstar.mapper;

import com.kbstar.dto.Cart;
import com.kbstar.frame.KBMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper
public interface CartMapper extends KBMapper<Integer, Cart> {
    //CRUD 밖에 없는 곳에 cart에만 필요한 기능을 추가

    public List<Cart> getMyCart(String cid);
    // cust_id로 고객별 장바구니를 조회하려고 함
}
