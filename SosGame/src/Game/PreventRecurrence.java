package Game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PreventRecurrence {
	
	public List isRepeat(char[][] table,List randomList) {
		
		 
		
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table.length; j++) {
				
				
				//Here i put all empty place index into a list for computer. 
				//I prevent the computer from selecting the full places.
				if (table[i][j]==' ') {
					String numberStr=String.valueOf(i) + String.valueOf(j);
					
					randomList.add(numberStr);
				}
				
			}
		}
		
		Collections.shuffle(randomList);//Here i shuffle list for make random effect
		
		
	
		return randomList;
	}

}
