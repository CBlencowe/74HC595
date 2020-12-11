package com.example.HC595;

import java.util.ArrayList;
import java.util.List;

import com.example.HC595.objects.GpioData;
import com.example.HC595.service.shiftRegisterService;
import com.example.HC595.service.testService;
import com.example.HC595.service.impl.shiftRegisterServiceImpl;
import com.example.HC595.service.impl.testServiceImpl;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.PinState;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	// PIN(12)(GPIO18)(RaspiPin.GPIO_01)
	// PIN(16)(GPIO23)(RaspiPin.GPIO_04)
	// PIN(18)(GPIO24)(RaspiPin.GPIO_05)
	// PIN(22)(GPIO25)(RaspiPin.GPIO_06)
	// PIN(13)(GPIO27)(RaspiPin.GPIO_02)
	// PIN(11)(GPIO17)(RaspiPin.GPIO_00)
	// PIN(15)(GPIO22)(RaspiPin.GPIO_03)

	static GpioData GPIO18 = new GpioData.Buidler().withPin(RaspiPin.GPIO_01).withName("PIN-12").withState(PinState.LOW)
			.build();

	static GpioData GPIO23 = new GpioData.Buidler().withPin(RaspiPin.GPIO_04).withName("PIN-16").withState(PinState.LOW)
			.build();

	static GpioData GPIO24 = new GpioData.Buidler().withPin(RaspiPin.GPIO_05).withName("PIN-18").withState(PinState.LOW)
			.build();

	static GpioData GPIO25 = new GpioData.Buidler().withPin(RaspiPin.GPIO_06).withName("PIN-22").withState(PinState.LOW)
			.build();

	static GpioData GPIO17 = new GpioData.Buidler().withPin(RaspiPin.GPIO_00).withName("PIN-11").withState(PinState.LOW)
			.build();

	static GpioData GPIO27 = new GpioData.Buidler().withPin(RaspiPin.GPIO_03).withName("PIN-15").withState(PinState.LOW)
			.build();

	static GpioData GPIO22 = new GpioData.Buidler().withPin(RaspiPin.GPIO_02).withName("PIN-13").withState(PinState.LOW)
			.build();

	public static void main(String[] args) {
		// SpringApplication.run(Application.class, args); // TO RUN AS SPRING SERVICE -
		// LATER

		// GPIO18, GPIO23, GPIO24, GPIO25, GPIO27, GPIO17, GPIO22
		List<GpioData> pinDataList = new ArrayList<>();
		pinDataList.add(GPIO18);
		pinDataList.add(GPIO23);
		pinDataList.add(GPIO24);
		pinDataList.add(GPIO25);
		pinDataList.add(GPIO27);
		pinDataList.add(GPIO17);
		pinDataList.add(GPIO22);

		// Create GPIO controller instance
		final GpioController gpio = GpioFactory.getInstance();

		// GpioData DS = new GpioData.Buidler()
		// .withPin(RaspiPin.GPIO_01)
		// .withName("PIN-12")
		// .withState(PinState.LOW).build();

		// GpioData SHCP = new GpioData.Buidler()
		// .withPin(RaspiPin.GPIO_04)
		// .withName("PIN-16")
		// .withState(PinState.LOW).build();

		// GpioData STCP = new GpioData.Buidler()
		// .withPin(RaspiPin.GPIO_05)
		// .withName("PIN-18")
		// .withState(PinState.LOW).build();

		// shiftRegisterService shiftReg = new shiftRegisterServiceImpl(gpio, DS, SHCP,
		// STCP);
		// shiftReg.test();

		testService test = new testServiceImpl(gpio, pinDataList);
		try {
			test.test();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}

}
