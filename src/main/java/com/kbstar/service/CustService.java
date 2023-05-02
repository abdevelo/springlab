package com.kbstar.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kbstar.dto.Cust;
import com.kbstar.mapper.CustMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class CustService implements KBService<String, Cust> {
    @Autowired
    CustMapper mapper;

    public CustService(CustMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void register(Cust cust) throws Exception {
        mapper.insert(cust);
        log.info("Send Mail.........."+cust.getId());
    }
    @Override
    public void remove(String s) throws Exception {
        mapper.delete(s);
    }
    @Override
    public void modify(Cust cust) throws Exception {
        mapper.update(cust);
    }
    @Override
    public Cust get(String s) throws Exception {
        return mapper.select(s);
    }
    @Override
    public List<Cust> get() throws Exception {
        return mapper.selectall();
    }

    public Page<Cust> getPage(int pageNo) throws Exception {
        PageHelper.startPage(pageNo, 3); // 3: 한화면에 출력되는 개수
        return mapper.getpage();
    }
}
