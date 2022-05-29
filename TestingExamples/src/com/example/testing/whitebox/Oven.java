package com.example.testing.whitebox;

public class Oven {
	final int IDLE=0;
	final int SUSPENDED=1;
	final int COOKING=2;
	final int COMPLETED=3;
	
	int currentState;
	int power, time, dish_qty, food_wgt;
	boolean special_food=false;
	
	public void checkPower() {
		if (power < 100 || currentState != COOKING)
			power = 100;
		else if (power < 200 && time < 30)
			power = 300;
		else
			power = 200;
		
		if (dish_qty > 3 || (dish_qty > 0 && food_wgt > 1000) || special_food == true)
			time = 60;
	}
}
