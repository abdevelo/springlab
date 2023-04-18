package com.kbstar.tv;

import com.kbstar.frame.TV;

public class STV implements TV {

    @Override
    public void turnOn() {
        System.out.println("STV Turn On");
    }

    @Override
    public void turnOff() {
        System.out.println("LTV Turn On");
    }
}
