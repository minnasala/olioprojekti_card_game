package tehtavat;

import java.util.Arrays;
import java.util.Random;

public class ArrayShuffle {


	public static void main(String[] args) {
		
		int[] lista = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8};
		int kaannetyt = 0;
		
		Random rand = new Random();
		
		for (int i = 0; i < lista.length; i++) {
			int randomIndexToSwap = rand.nextInt(lista.length);
			int temp = lista[randomIndexToSwap];
			lista[randomIndexToSwap] = lista[i];
			lista[i] = temp;
		}
// seuraava rivi vain sekoituksen testaamista varten:		
		System.out.println(Arrays.toString(lista));
	} 
	
// tähän metodi joka sijoittaa kortit pelilaudalle:
	
	
// tämä metodi selvittää aina ennen korttien kääntämistä onko kortteja enää:
	if (ArrayUtils.isEmpty(lista)) {
	    break;
	} else {
	    continue;
	}
// tai vaihtoehto ois if matches = 8, break
	
	
	
	
// tähän metodi joka kääntää klikatut kortit
	// käännä kortti 1
	// kaannettykortti1 = lista(i)

	// joka kerta kun klikataan >
	kaannetyt ++;
	
	// käännä kortti 1
	// kaannettykortti1 = lista(y)
	
	// jos käännetyn kortti i:n ja kortti y:n arvot on yhtä suuret, poistetaan ne listasta.
	// muutoin jatketaan.
	//	if (i == y) {
	//	lista.remove(Integer.valueOf(i));
	//	} else {
	//		continue;
	//	}
	
	return kaannetyt;
}
