package main.java.com.open.url.hash;

import java.util.Random;

public class HashGenerator {
// 	128	64 32 16	8 4 2 1
//	0	0  
//each character needs 7 bits - 64 max value represents ranges from 0 - 62 
	
	
	
	public int[] generateRandom(int size){
		Random random = new Random();
		int number = 0;
		byte[] byteArray = new byte[size];
		int[] randVals = new int[byteArray.length];
		random.nextBytes(byteArray);
		
		for (int i=0; i<byteArray.length; i++){
			number = Math.abs(byteArray[i]);
			while (number > 61){
				number = (number & 0x3F);
				//number = generateRandom();
			}
			randVals[i] = number;
		}
		return randVals;
	}
	
	private int generateRandom(){
		Random random = new Random();
		byte[] byteArray = new byte[1];
		random.nextBytes(byteArray);
		return byteArray[0];   
	}
}
