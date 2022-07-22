package Game;

public class TableCreation {

	 
	    //ititialize game table 
		public static void initializeTable(char [][]table, int length){

	        for(int r = 0; r <length; r++){
	            for(int c = 0; c <length; c++){
	            	table[r][c] = ' ';// put empty character into each cell
	            }
	        }

	    }
		
}
