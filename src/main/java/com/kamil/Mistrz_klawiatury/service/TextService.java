package com.kamil.Mistrz_klawiatury.service;

import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class TextService {
    public String endMinusStartTime(Long hiddenTimer) {
        Long currentTime = new Date().getTime();
        Long miliseconds = currentTime - hiddenTimer;
        Long minutes = miliseconds/1000/60;
        Long seconds = (miliseconds/1000)%60;
        return String.format("%d Minutes and %d Seconds",minutes,seconds);
    }
}
