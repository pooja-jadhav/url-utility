package test.java.com.open.url.hash;



import org.junit.Assert;

import main.java.com.open.url.hash.CharacterGenerator;

public class CharacterGeneratorTest {

//@Test
	public void testGetChar(){
	
		int c = CharacterGenerator.getInstance().getCharacter(61);
		Assert.assertEquals(c, 'z');
		
	}
}
