package test.java.com.open.url.hash;

import java.util.HashSet;

import main.java.com.open.url.hash.HashGenerator;

import org.junit.Assert;
import org.junit.Test;

public class HashGeneratorTest {

	//@Test
	public void generateHash(){
		HashGenerator gn = new HashGenerator();
		HashSet<String> hs = new HashSet<String>();
		String test = null;
		
		for (int i = 0 ; i < 10; i++){
		int[] val = gn.generateRandom(7);
		StringBuilder sb = new StringBuilder();
		
		for (int in: val){
			sb.append(in);
		}
		if(test == null){
			test = sb.toString();
		}
		hs.add(sb.toString());
		}
		
		Assert.assertEquals(false, hs.contains(test));
		
	}
}
