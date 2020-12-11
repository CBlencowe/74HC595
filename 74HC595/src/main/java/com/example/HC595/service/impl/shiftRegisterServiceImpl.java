package com.example.HC595.service.impl;

import com.example.HC595.objects.GpioData;
import com.example.HC595.service.shiftRegisterService;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPinDigitalOutput;

public class shiftRegisterServiceImpl implements shiftRegisterService {

    GpioPinDigitalOutput DS = null;
    GpioPinDigitalOutput SHCP = null;
    GpioPinDigitalOutput STCP = null;

    /**
     * DS, SHCP, STCP - GpioController instances
     * 
     * GPIO PIN DATA
     * pin - Pin - referse to the GPIO pin physically used
     * name - name of connection (Not sure if used???)
     * state - is the pin being set as HIGH(on) or LOW(off)
     */
    public shiftRegisterServiceImpl(GpioController gpio, GpioData ds, GpioData shcp, GpioData stcp) {
        DS = gpio.provisionDigitalOutputPin(ds.pin(), ds.name(), ds.state());
        SHCP = gpio.provisionDigitalOutputPin(shcp.pin(), shcp.name(), shcp.state());
        STCP = gpio.provisionDigitalOutputPin(stcp.pin(), stcp.name(), stcp.state());
    }

    @Override
    public void test() {
        System.out.println("shiftRegisterService Test");
        for (int i = 0; i < 8; i++) {
            
        }
    }
    
}