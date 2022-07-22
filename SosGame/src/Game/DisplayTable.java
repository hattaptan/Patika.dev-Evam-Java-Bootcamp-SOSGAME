package Game;



public class DisplayTable {

	//method to only display table on screen
	public static void getBoard(char[][] table) {

		int count=0;
		
		String star = "*-*-";
		int h = table.length;
		int w = table.length;

		for (int j = 0; j < w; j++) {//write numbers at the top of table
			if (j == 0) {
				System.out.print("     " + (j + 1));
			} else {
				System.out.print("   " + (j + 1));
			}

		}
		System.out.println();

		for (int i = 0; i < h; i++) {

			for (int j = 0; j < w; j++) {// write star for table 
				if (j == 0) {
					System.out.print("   " + star);   
					count++;
				}
			 
                    if (j==w-1) {
						 
						System.out.print(star.substring(0,1));
					}else {				
					System.out.print(star);
					}
				
			}
			//System.out.print("***");
			System.out.println();
			System.out.print((i + 1) + "  | "); //write | to create a cell
			for (int j = 0; j < w; j++) {

				System.out.print(table[i][j] + " | ");    
			}                                              
			System.out.println();
		}
		System.out.print("   ");
		for (int i = 0; i < table.length+1; i++) {

            if (i==w) {
				 
				System.out.print(star.substring(0,1));
			}else {				
			System.out.print(star);
			}
		
			
			 
		}
		 
		System.out.println();
		
	 
	}

}
