package com.kbstar.service;

import com.kbstar.dto.MarkerDesc;
import com.kbstar.mapper.MarkerDescMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MarkerDescService implements KBService<Integer, MarkerDesc> {
    @Autowired
    MarkerDescMapper mapper;
    @Override
    public void register(MarkerDesc markerDesc) throws Exception {
        mapper.insert(markerDesc);

    }

    @Override
    public void remove(Integer integer) throws Exception {
        mapper.delete(integer);

    }

    @Override
    public void modify(MarkerDesc markerDesc) throws Exception {
        mapper.update(markerDesc);

    }

    @Override
    public MarkerDesc get(Integer integer) throws Exception {
        return mapper.select(integer);
    }

    @Override
    public List<MarkerDesc> get() throws Exception {
        return mapper.selectall();
    }

    public List<MarkerDesc> getMarkerDesc(int id) throws Exception {
        return mapper.getmarkerdesc(id);
    }
}
