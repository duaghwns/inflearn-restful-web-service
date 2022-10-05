package com.example.restfulwebservice.lotto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Lotto {
    private long hoicha;
    private long totSellamnt;
    private String returnValue;
    private LocalDate drwNoDate;
    private int drwNo1;
    private int drwNo2;
    private int drwNo3;
    private int drwNo4;
    private int drwNo5;
    private int drwNo6;
    private int bnusNo;
    private int firstPrzwnerCo;
    private long firstAccumamnt;
}
