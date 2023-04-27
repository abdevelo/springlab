package com.kbstar.service;

import com.kbstar.dto.Marker;
import com.kbstar.mapper.MarkerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkerService implements KBService<Integer, Marker> {

    @Autowired
    MarkerMapper mapper; // Marke의 DB와 연결된 dao 사용하겠다고 쓰기.

    /**
     * 등록 & 가입 진행
     * argument : object
     * return : null
     *
     * @param marker
     **/
    @Override
    public void register(Marker marker) throws Exception {
        mapper.insert(marker); // dao에 insert하겠다. dto데이터를
    }

    @Override
    public void remove(Integer integer) throws Exception {
        mapper.delete(integer); // int id값 넣으면 삭제하겠다. dao에서
    }

    @Override
    public void modify(Marker marker) throws Exception {
        mapper.update(marker);  // dao에 update하겠다. dto데이터를
    }

    @Override
    public Marker get(Integer integer) throws Exception {
        return  mapper.select(integer); // int id값 넣으면 조회해주겠다.. dao에서;
    }

    @Override
    public List<Marker> get() throws Exception {
        return  mapper.selectall(); // 전체조회해주겠다.. dao에서;
    }

}
