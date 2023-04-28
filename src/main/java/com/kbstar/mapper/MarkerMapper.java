package com.kbstar.mapper;

import com.kbstar.dto.Marker;
import com.kbstar.frame.KBMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
@Mapper
public interface MarkerMapper extends KBMapper<Integer, Marker> {
    public List<Marker> getloc(String loc);
}
