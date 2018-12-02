package main.java.com.open.url.hash;

public class HashManager {

	private int hashSize = 7;
	public HashManager(){
		
	}
	public HashManager(int size){
		hashSize = size;
	}
	
	
	public String generateHash(){
		HashGenerator hashGenerator = new HashGenerator();
		int[] randoms = hashGenerator.generateRandom(hashSize);
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<randoms.length; i++){
			char c = CharacterGenerator.getInstance().getCharacter(randoms[i]);
			sb.append(c);
		}
		
		return sb.toString();
	}



}
