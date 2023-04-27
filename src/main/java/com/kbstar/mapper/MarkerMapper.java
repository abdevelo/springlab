package com.kbstar.mapper;

import com.kbstar.dto.Marker;
import com.kbstar.frame.KBMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//  스프링컨테이너 덕분이다~
@Repository
@Mapper
public interface MarkerMapper extends KBMapper<Integer, Marker> {
}
