package com.example.demo.controller;


import com.example.demo.mapper.UserProfileMapper;
import com.example.demo.model.UserProfile;
import org.springframework.web.bind.annotation.*;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserProfileController {

    // 빈 주입 방법 ( 생성자 주입 )
    public UserProfileMapper mapper;
    public UserProfileController(UserProfileMapper mapper){
        this.mapper = mapper;
    }

    private Map<String, UserProfile> userMap;

//    @PostConstruct
//    public void init() {
//        userMap = new HashMap<String, UserProfile>();
//        userMap.put("1", new UserProfile("1", "홍길동", "010-1111", "서울시 강남구 대치1동"));
//        userMap.put("2", new UserProfile("2", "홍길순", "010-1112", "서울시 강남구 대치2동"));
//        userMap.put("3", new UserProfile("3", "홍진만", "010-1113", "서울시 강남구 대치3동"));
//    }

    @GetMapping("/{id}")
    public UserProfile getUserProfile(@PathVariable("id") String id) {
        //return userMap.get(id);
        return mapper.getUserProfile(id);
    }

    @GetMapping("/all")
    public List<UserProfile> getUserProfileList() {
        //return new ArrayList<UserProfile>(userMap.values());
        return mapper.getUserProfileList();
    }

    @PutMapping("/{id}")
    public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
//        UserProfile userProfile = new UserProfile(id,name,phone,address);
//        userMap.put(id, userProfile);
        mapper.insertUserProfile(id,name,phone,address);
    }

    @PostMapping("/{id}")
    public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
//        UserProfile userProfile = userMap.get(id);
//        userProfile.setName(name);
//        userProfile.setPhone(phone);
//        userProfile.setAddress(address);
        mapper.updateUserProfile(id,name,phone,address);
    }
    @DeleteMapping("/{id}")
    public void deleteUserProfile(@PathVariable("id") String id){
//        userMap.remove(id);
        mapper.deleteUserProfile(id);
    }

}
