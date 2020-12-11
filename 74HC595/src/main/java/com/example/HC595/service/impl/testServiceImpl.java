package com.example.HC595.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.example.HC595.objects.GpioData;
import com.example.HC595.service.testService;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPinDigitalOutput;

public class testServiceImpl implements testService {

    List<GpioPinDigitalOutput> pinList = new ArrayList<>();

    /**
     * DS, SHCP, STCP - GpioController instances
     * 
     * GPIO PIN DATA
     * pin - Pin - referse to the GPIO pin physically used
     * name - name of connection (Not sure if used???)
     * state - is the pin being set as HIGH(on) or LOW(off)
     */
    public testServiceImpl(GpioController gpio, List<GpioData> pinDataList) {
        for (int i = 0; i < pinDataList.size(); i++) {
            pinList.add(gpio.provisionDigitalOutputPin(pinDataList.get(i).pin(), pinDataList.get(i).name(), pinDataList.get(i).state()));
        }
    }

    @Override
    public void test() {
        System.out.println("shiftRegisterService Test");
        for (int i = 0; i < pinList.size(); i++) {
            pinList.get(i).high();
            System.out.println(pinList.get(i).getName());
            pinList.get(i).low();
        }
    }

}