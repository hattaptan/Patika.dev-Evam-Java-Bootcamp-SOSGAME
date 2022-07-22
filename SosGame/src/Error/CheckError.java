package Error;

import java.util.Scanner;

public class CheckError {
	 public int returnValue=0;
	 public int returnValueRowOrColoum=0;
	 public String newLetter="";

	 
	//chance number control 
	public boolean chanceNumControl(int chanceNum, Scanner scanner) {
		boolean ChanceNumFlag = false;
		while (ChanceNumFlag == false) {
			if (chanceNum >= 1 && chanceNum <= 10) {//if it is already between 1 and 10 return its own value
				return true;
			} else {
			//else show message and again select num
				System.out.println("Hopss!  "+chanceNum+"  is Invalid Range");
				System.out.print("Please Select a chance number ONLY between 1-2 : ");
				chanceNum = scanner.nextInt();

				if (chanceNum >= 1 && chanceNum <= 10) {
					ChanceNumFlag = true;

				}
			}
		}

		if (ChanceNumFlag == true) {
			return true;
		} else {
			return false;
		}

	}
	

	//check dimension of table
	public boolean chechkTableDimension(int tableWidthNum, Scanner scanner) 
	{
		boolean ChanceNumFlag = false;
		while (ChanceNumFlag == false) {
			if (tableWidthNum >= 3 && tableWidthNum <= 7) {
				returnValue=tableWidthNum;//if number from user is between 3-7, return that number. 
				return true;
			} else {
	
				System.out.println("Hopss!  "+tableWidthNum+"  is Invalid Range for table");
				System.out.print("Please Select a number for game table, ONLY between 3-7 (example : 5) : ");
				
				tableWidthNum = scanner.nextInt();
				System.out.println();
				if (tableWidthNum >= 3 && tableWidthNum <= 7) {
					returnValue=tableWidthNum;//until user enter right number
					ChanceNumFlag = true;

				}
			}
		}

		if (ChanceNumFlag == true) {
			return true;
		} else {
			return false;
		}

	}
	
	//if user enter invalid letter for game
	public boolean checkLetter(String letter) {
		return (letter.equalsIgnoreCase("s") || letter.equalsIgnoreCase("o"));
	}

	//in every turn check row and colum value of user 
	public boolean checkRowColoum(int rowOrColoum,int dimension) 
	{
		boolean ChanceNumFlag = false;
		while (ChanceNumFlag == false) {
			if (rowOrColoum >=0 && rowOrColoum < dimension) {
				returnValueRowOrColoum=rowOrColoum;
				return true;
			} else {
	
				System.out.println("Hopss!  "+(rowOrColoum+1)+"  is Invalid Range for table");
				System.out.print("Please Select a chance number ONLY between 1-"+dimension+" : ");
				Scanner scanner = new Scanner(System.in);
				rowOrColoum = scanner.nextInt()-1;
				System.out.println();
				if (rowOrColoum >= 0 && rowOrColoum < dimension) {
					
					returnValueRowOrColoum=rowOrColoum;
					System.out.println("Thankss.. "+(returnValueRowOrColoum+1)+" is right..");
					ChanceNumFlag = true;

				}
			}
		}

		if (ChanceNumFlag == true) {
			return true;
		} else {
			return false;
		}

	}
}
