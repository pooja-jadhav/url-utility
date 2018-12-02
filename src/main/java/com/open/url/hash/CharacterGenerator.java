package main.java.com.open.url.hash;

import java.util.HashMap;
import java.util.Map;

public class CharacterGenerator {

	private static CharacterGenerator instance = new CharacterGenerator();
	private static Map<Integer, Character> mapChar; 
	
	private CharacterGenerator(){
		mapChar = init();
	}
	
	private static Map<Integer, Character> init(){
		Map<Integer,Character> map = new HashMap<Integer,Character>();
		for(int i=0; i < 10; i++){
			char b = (char)('0' + i);
			map.put(i, b);
		}
		
		char start = 'A';
		int a = (int)(start);
		
		for(int i=10; i < 36; i++){
			map.put(i, start);
			a = a+1;
			start = ((char)(start + 1));
		}
		
		start = 'a';
		 a = (int)(start);
		 
		for(int i=36; i < 62; i++){
			map.put(i, start);
			a = a+1;
			start = ((char)(start + 1));
		}
		return map;
	}
	
	public static CharacterGenerator getInstance(){
		return instance;
	}
	
	public char getCharacter(int val){
		return mapChar.get(val);
	}
	
	
}
