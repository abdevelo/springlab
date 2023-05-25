package com.kbstar;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
@SpringBootTest
class EncTests2 {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Test
    void contextLoads() {
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES"); // 알고리즘 이름. 이거셍 따라 형태가 바뀜.
        pbeEnc.setPassword("mykey");

        //암호화
       String phone = "01099998888";
        String addr = "서울시 성동구 성수동 172-5";

        String encPhone = pbeEnc.encrypt(phone);
        log.info("--------------------------------Enc String : " + encPhone);
        String encAddr = pbeEnc.encrypt(addr);
        log.info("--------------------------------Enc String : " + encAddr);

        //복호화
        phone = pbeEnc.decrypt(encPhone);
        log.info("--------------------------------Enc String : " + phone);
        addr = pbeEnc.decrypt(encAddr);
        log.info("--------------------------------Enc String : " + addr);

    }

}