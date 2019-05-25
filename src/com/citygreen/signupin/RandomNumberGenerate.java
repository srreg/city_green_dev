package com.citygreen.signupin;

import java.util.Random;

public class RandomNumberGenerate {
	
public int randomNumber() {
		
		Random rnd = new Random();
		int random = 100000 + rnd.nextInt(999999);
		
		return random;
	}

}
