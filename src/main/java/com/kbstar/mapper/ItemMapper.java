package com.kbstar.mapper;


import com.github.pagehelper.Page;
import com.kbstar.dto.Item;
import com.kbstar.frame.KBMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ItemMapper extends KBMapper<Integer, Item> {
    Page<Item> getpage() throws Exception; //0502 + itemmapper.xml 에 getpage를 id로 만든 sql문 있음
}