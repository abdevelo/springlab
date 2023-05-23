package com.example.demo.mapper;

import com.example.demo.model.UserProfile;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserProfileMapper{
    @Select("SELECT * FROM UserProfile WHERE id=#{id}")
    UserProfile getUserProfile(@Param("id") String id);

    @Select("SELECT * FROM UserProfile")
    List<UserProfile> getUserProfileList();


    @Insert("INSERT INTO UserProfile VALUES(#{id},#{name},#{phone},#{address})")
    int insertUserProfile(@Param("id") String id,
                       @Param("name") String name,
                       @Param("phone")String phone,
                       @Param("address")String address);

    @Update("UPDATE UserProfile SET name=#{name}, phone=#{phone}," +
            "address=#{address} WHERE id=#{id}")
    int updateUserProfile(@Param("id") String id,
                        @Param("name") String name,
                        @Param("phone")String phone,
                        @Param("address")String address);

    @Delete("DELETE FROM UserProfile WHERE id=#{id}")
    int deleteUserProfile(@Param("id") String id);
}
