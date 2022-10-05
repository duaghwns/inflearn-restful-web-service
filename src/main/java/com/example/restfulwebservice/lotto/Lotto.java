package com.example.restfulwebservice.lotto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Lotto {

    private Long hoicha;
    private Long totSellamnt;
    private String returnValue;
    private LocalDate drwNoDate;
    @Max(2)
    private Integer drwNo1;
    @Max(2)
    private Integer drwNo2;
    @Max(2)
    private Integer drwNo3;
    @Max(2)
    private Integer drwNo4;
    @Max(2)
    private Integer drwNo5;
    @Max(2)
    private Integer drwNo6;
    @Max(2)
    private Integer bnusNo;
    private Integer firstPrzwnerCo;
    private Long firstAccumamnt;
}
