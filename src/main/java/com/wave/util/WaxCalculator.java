package com.wave.util;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("wax")
public class WaxCalculator implements Calculator {

    public String getWax(int waterTemp) {
        String waxType = "Basecoat";

        if(waterTemp >= 75) {
            waxType = "Tropical";
        } else if (waterTemp >= 64 && waterTemp < 75) {
            waxType = "Warm";
        } else if (waterTemp >= 58 && waterTemp < 64) {
            waxType = "Cool";
        } else if (waterTemp < 64) {
            waxType = "Cold";
        }

        return waxType;
    }
}
