package com.example.testing.whitebox;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OvenMCDCTest {
	Oven oven;
	
	@BeforeEach
	public void setOven() {
		oven = new Oven();
	}
	
	@Test
	public void checkPower_MCDCTest_1() {
		oven.power = 99;
		oven.currentState = oven.COOKING;
		oven.dish_qty = 4;
		oven.food_wgt = 900;
		oven.special_food = false;
		
		oven.checkPower();
		assertEquals(100, oven.power);
		assertEquals(60, oven.time);
	}	

	@Test
	public void checkPower_MCDCTest_2() {
		oven.power = 101;
		oven.currentState = oven.IDLE;
		oven.dish_qty = 1;
		oven.food_wgt = 1001;
		oven.special_food = false;
		
		oven.checkPower();
		assertEquals(100, oven.power);
		assertEquals(60, oven.time);
	}	
	
	@Test
	public void checkPower_MCDCTest_3() {
		oven.power = 101;
		oven.currentState = oven.COOKING;
		oven.time = 31;
		oven.dish_qty = 0;
		oven.food_wgt = 1200;
		oven.special_food = true;
		
		oven.checkPower();
		assertEquals(200, oven.power);
		assertEquals(60, oven.time);
	}

	@Test
	public void checkPower_MCDCTest_4() {
		oven.power = 201;
		oven.currentState = oven.COOKING;
		oven.time = 29;
		oven.dish_qty = 0;
		oven.food_wgt = 1300;
		oven.special_food = false;
		
		oven.checkPower();
		assertEquals(200, oven.power);
		assertEquals(29, oven.time);
	}	
	
	@Test
	public void checkPower_MCDCTest_5() {
		oven.power = 101;
		oven.currentState = oven.COOKING;
		oven.time = 29;
		oven.dish_qty = 1;
		oven.food_wgt = 850;
		oven.special_food = false;
		
		oven.checkPower();
		assertEquals(300, oven.power);
		assertEquals(29, oven.time);
	}	
}
