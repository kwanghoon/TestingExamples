package com.example.testing.whitebox;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OvenBCTest {
	
	Oven oven;
	
	@BeforeEach
	public void setOven() {
		oven = new Oven();
	}

	@Test
	public void checkPower_BCTest_1() {
		oven.power = 99;
		oven.currentState = oven.COOKING;
		oven.dish_qty = 1;
		oven.food_wgt = 1001;
		oven.special_food = false;
		
		oven.checkPower();
		assertEquals(100, oven.power);
		assertEquals(60, oven.time);
	}
	
	@Test
	public void checkPower_BCTest_2() {
		oven.power = 101;
		oven.currentState = oven.COOKING;
		oven.time = 28;
		oven.dish_qty = 1;
		oven.food_wgt = 1001;
		oven.special_food = false;
		
		oven.checkPower();
		assertEquals(300, oven.power);
		assertEquals(60, oven.time);
	}
	
	@Test
	public void checkPower_BCTest_3() {
		oven.power = 101;
		oven.currentState = oven.COOKING;
		oven.time = 31;
		oven.dish_qty = 0;
		oven.food_wgt = 1001;
		oven.special_food = false;
		
		oven.checkPower();
		assertEquals(200, oven.power);
		assertEquals(31, oven.time);
	}

}
