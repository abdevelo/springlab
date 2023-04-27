package com.kbstar.service;
import com.kbstar.dto.Adm;
import com.kbstar.mapper.AdmMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class AdmService implements KBService<String, Adm>{
    /*
     * 등록 및 가입 진행
     * argument : Object
     * return : null
     * */
    @Autowired
    AdmMapper mapper;

    public AdmService(AdmMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void register(Adm adm) throws Exception {
        mapper.insert(adm);
    }

    @Override
    public void remove(String s) throws Exception {
        mapper.delete(s);
    }

    @Override
    public void modify(Adm adm) throws Exception {
        mapper.update(adm);
    }

    @Override
    public Adm get(String s) throws Exception {
        return mapper.select(s);
    }

    @Override
    public List<Adm> get() throws Exception {
        return mapper.selectall();
    }
}
