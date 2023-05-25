package com.kbstar.controller;
import java.io.IOException;

import com.kbstar.VerifyRecaptcha;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReCaptchaController {

    @ResponseBody
    @PostMapping(value = "VerifyRecaptcha")
    public ResponseEntity<?> VerifyRecaptcha(String recaptcha) throws IOException {
        VerifyRecaptcha.setSecretKey("6Lc80jUmAAAAAAr4Pe5jcwbyiHkS09sZD07zfbKD");
        return ResponseEntity.status(HttpStatus.OK).body(VerifyRecaptcha.verify(recaptcha));
    }

}
