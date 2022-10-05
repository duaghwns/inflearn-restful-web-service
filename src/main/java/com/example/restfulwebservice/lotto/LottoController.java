package com.example.restfulwebservice.lotto;

import com.example.restfulwebservice.user.UserNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LottoController {

    String lottoApiUrl = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=";
    @GetMapping("https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo={hoicha}")
    public Lotto getLottoInfo(@PathVariable long hoicha){

        Lotto lotto = service.findOne(hoicha);

        if (lotto == null) {
            throw new UserNotFoundException(String.format("Lotto[$s] not found", hoicha));
        }
        return lotto;
    }
}
