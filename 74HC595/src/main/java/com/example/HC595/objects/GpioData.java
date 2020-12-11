package com.example.HC595.objects;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;

public class GpioData {

    private Pin pin;
    private String name;
    private PinState state;

    /*
    * Getters
    */

    public Pin pin(){
        return pin;
    }

    public String name(){
        return name;
    }

    public PinState state(){
        return state;
    }

    public GpioData(Pin pin, String name, PinState state) {
        this.pin = pin;
        this.name = name;
        this.state = state;
    }

    public static class Buidler {
    
        private Pin pin;
        private String name;
        private PinState state;
        
        public Buidler withPin(Pin pin){
            this.pin = pin;
            return this;
        }

        public Buidler withName(String name){
            this.name = name;
            return this;
        }

        public Buidler withState(PinState state) {
            this.state = state;
            return this;
        }

        /*
        * Builder
        * 
        * pin - Pin - referse to the GPIO pin physically used
        * pinName - name of connection (Not sure if used???)
        * state - is the pin being set as HIGH(on) or LOW(off)
        */

        public GpioData build(){
            return new GpioData(pin, name, state);
        }
    }

}