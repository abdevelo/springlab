package com.kbstar.mapper;

import com.kbstar.dto.Sales;
import com.kbstar.frame.KBMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SalesMapper extends KBMapper<String, Sales> {
}
