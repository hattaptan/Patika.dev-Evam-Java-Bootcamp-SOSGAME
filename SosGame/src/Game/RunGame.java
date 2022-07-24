package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Error.CheckError;




public class RunGame {
	//needed variable
	public static List<String> randomList = new ArrayList<>();
	public static CheckError checkError= new CheckError();
    public static Scanner scanner = new Scanner(System.in);
    public static PreventRecurrence preventRecurrence = new PreventRecurrence();
	public static String PlayerTurnWithS(char[][] table, String playerLetter, String computerLetter) {
		
		//scanner to take input from user
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter coordinates...");
		System.out.println();
		System.out.print("  Row : ");
		int row = scanner.nextInt() - 1;//row value is -1 because of array length
		checkError.checkRowColoum(row, table.length);// check is row from user in range or no
		row = checkError.returnValueRowOrColoum;
		
		System.out.println();
		System.out.print("  Column : ");
		int column = scanner.nextInt() - 1;//column value is -1 because of array length
		checkError.checkRowColoum(column, table.length);// check is row from user in range or no
		column = checkError.returnValueRowOrColoum;
		
		String point = "";

		char pLetter = playerLetter.charAt(0);//define player letter and convert to char 
		char cLetter = computerLetter.charAt(0);//define computer letter and convert to char
		
		if (table[row][column] != ' ') {// if coordinate not empty

			System.out.println("The Coordinates is not empty...");
			 point="pd";// if it is not empty, return "pd" and agains ask user for new place
			 return point;
			 
		} else {

			table[row][column] = pLetter;// if plaace that user select is available, put letter into place
			DisplayTable.getBoard(table);// display table
			System.out.println();

		try {//find SOS situation if there is SOS, return value will be point and user will get point
			//otherwise return "com" its mean computer turn
			if ((table[row + 1][column] == cLetter) && (table[row + 2][column] == pLetter))
			{
				point = "point";
				return point;
			}   else {
				point="com";
				 
			}
				
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
		try {//find SOS situation if there is SOS, return value will be point and user will get point
			//otherwise return "com" its mean computer turn
			if ((table[row][column + 1] == cLetter) && (table[row][column + 2] == pLetter))
			{
				point = "point";
				return point;
			}   else {
				point="com";
				 
			}
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}

		try {//find SOS situation if there is SOS, return value will be point and user will get point
			//otherwise return "com" its mean computer turn
			if ((table[row - 1][column] == cLetter) && (table[row - 2][column] == pLetter))
			{
				point = "point";
				return point;
			}   else {
				point="com";
				 
			}
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
		try {//find SOS situation if there is SOS, return value will be point and user will get point
			//otherwise return "com" its mean computer turn
			if ((table[row + 1][column - 1] == cLetter) && (table[row + 2][column - 2] == pLetter))
			{
				point = "point";
				return point;
			}   else {
				point="com";
				 
			}
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
		try {//find SOS situation if there is SOS, return value will be point and user will get point
			//otherwise return "com" its mean computer turn
			if ((table[row - 1][column + 1] == cLetter) && (table[row - 2][column + 2] == pLetter))
			{
				point = "point";
				return point;
			}   else {
				point="com";
				 
			}
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
		try {//find SOS situation if there is SOS, return value will be point and user will get point
			//otherwise return "com" its mean computer turn
			if ((table[row][column - 1] == cLetter) && (table[row][column - 2] == pLetter))
			{
				point = "point";
				return point;
			}   else {
				point="com";
				 
			}
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
		try {//find SOS situation if there is SOS, return value will be point and user will get point
			//otherwise return "com" its mean computer turn
			if ((table[row - 1][column - 1] == cLetter) && (table[row - 2][column - 2] == pLetter))
			{
				point = "point";
				return point;
			}   else {
				point="com";
				 
			}
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
		try {//find SOS situation if there is SOS, return value will be point and user will get point
			//otherwise return "com" its mean computer turn
			if ((table[row + 1][column + 1] == cLetter) && (table[row + 2][column + 2] == pLetter))
			{
				point = "point";
				return point;
			}   else {
				point="com";
				 
			}
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}

		}
		return point;
	}
    //if player select "O" letter
	public static String PlayerTurnWithO(char[][] table,  String playerLetter,String computerLetter) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter coordinates...");
		System.out.print("Row : ");
		int Row = scanner.nextInt() - 1;// take input from user
		checkError.checkRowColoum(Row, table.length);// check that input is it in range of game table
		Row = checkError.returnValueRowOrColoum;
		System.out.println();
		System.out.print("Coloum : ");
		int Column = scanner.nextInt() - 1;// take input from user
		checkError.checkRowColoum(Column, table.length);// check that input is it in range of game table
		Column = checkError.returnValueRowOrColoum;
		String point = "";

		char pLetter = playerLetter.charAt(0);
		char cLetter = computerLetter.charAt(0);
		
		if (table[Row][Column] != ' ') {// if coordinate not empty

			System.out.println("The Coordinates is not empty...");
			 

		} else {

			table[Row][Column] = pLetter;
			DisplayTable.getBoard(table);
			System.out.println();

		try {
			if ((table[Row][Column - 1] == cLetter) && (table[Row][Column + 1] == cLetter))
			{
				point = "point";
				return point;
			}   else {
				point="com";
			}
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
		try {
			if ((table[Row - 1][Column] == cLetter) && (table[Row + 1][Column] == cLetter))
				{
				point = "point";
				return point;
			}   else {
				point="com";
				}
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
		try {
			if ((table[Row - 1][Column - 1] == cLetter) && (table[Row + 1][Column + 1] == cLetter))
				{
				point = "point";
				return point;
			}   else {
				point="com";
				}
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
		try {
			if ((table[Row + 1][Column + 1] == cLetter) && (table[Row - 1][Column - 1] == cLetter))
				{
				point = "point";
				return point;
			}   else {
				point="com";
				}
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
		}
		return point;

	}

	public static String ComputerTurnWithS(char[][] table,  String playerLetter, String computerLetter) {
		String point = "";		
		Random random = new Random();

		
		//here is fo r when computer is choose a place randomly, if it is not empty computer will choose a place again
		// computer with random number maybe cant find empty place for  hours or days,
		// i prevent it in PreventRecurrence to put all empty place into a list and than in here 
		//shuffle that list. now i have a mixed ONLY empty place index of 2d array.
		
		randomList=preventRecurrence.isRepeat(table,randomList);
		//then choose first index of list, it is already like a random number. 
		String randNumber=randomList.get(0);
		
		char num1=randNumber.charAt(0);//get row
		char num2=randNumber.charAt(1);//get column
		
		int rows = Character.getNumericValue(num1);
		int columns = Character.getNumericValue(num2);
		 
		//after all clear the list, and again same operations. So after a turn i get  new empty place always.
		randomList.clear();
		
		// SO COMPUTER NEVER WİLL CHECK FULL PLACE OF 2D ARRAY.
		
		char pLetter = playerLetter.charAt(0);
		char cLetter = computerLetter.charAt(0);

		if (table[rows][columns] != ' ') {

			 
			point = "cd";

		} else {
			// SAME OPERATIONS WİTH PLAYER 
			table[rows][columns] = cLetter;// Put letter into game table
			DisplayTable.getBoard(table);
			System.out.println();
		
		try {
			if ((table[rows + 1][columns] == pLetter) && (table[rows + 2][columns] == cLetter))
			{
				point = "point";
				return point;
			}   else {
				point="player";
			}
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
		try {
			if ((table[rows][columns + 1] == pLetter) && (table[rows][columns + 2] == cLetter))
			{
				point = "point";
				return point;
			}   else {
				point="player";
			}
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}

		try {
			if ((table[rows - 1][columns] == pLetter) && (table[rows - 2][columns] == cLetter))
			{
				point = "point";
				return point;
			}   else {
				point="player";
			}
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
		try {
			if ((table[rows + 1][columns - 1] == pLetter) && (table[rows + 2][columns - 2] == cLetter))
			{
				point = "point";
				return point;
			}   else {
				point="player";
			}
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
		try {
			if ((table[rows - 1][columns + 1] == pLetter) && (table[rows - 2][columns + 2] == cLetter))
			{
				point = "point";
				return point;
			}   else {
				point="player";
			}
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
		try {
			if ((table[rows][columns - 1] == pLetter) && (table[rows][columns - 2] == cLetter))
			{
				point = "point";
				return point;
			}   else {
				point="player";
			}
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
		try {
			if ((table[rows - 1][columns - 1] == cLetter) && (table[rows - 2][columns - 2] == pLetter))
			{
				point = "point";
				return point;
			}   else {
				point="player";
			}
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
		try {
			if ((table[rows + 1][columns + 1] == cLetter) && (table[rows + 2][columns + 2] == pLetter))
			{
				point = "point";
				return point;
			}   else {
				point="player";
			}
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
		}
		return point;
	}

	 
	public static String ComputerTurnWithO(char[][] table, String playerLetter, String computerLetter) {

		String point = "";
		Random random = new Random();

		
        randomList=preventRecurrence.isRepeat(table,randomList);
		
		String randNumber=randomList.get(0);
		
		char num1=randNumber.charAt(0);
		char num2=randNumber.charAt(1);
 
		
		int Row = Character.getNumericValue(num1);
		int Column  =Character.getNumericValue(num2);
		
		randomList.clear();
		
		char pLetter = playerLetter.charAt(0);
		char cLetter = computerLetter.charAt(0);

		if (table[Row][Column] != ' ') {

			point = "cd"; 

		} else {
			
			table[Row][Column] = cLetter;
			DisplayTable.getBoard(table);
			System.out.println();
		try {
			if ((table[Row][Column - 1] == pLetter) && (table[Row][Column + 1] == pLetter))
			{
				point = "point";
				return point;
			}   else {
				point="player";
			}
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
		try {
			if ((table[Row - 1][Column] == 'S') && (table[Row + 1][Column] == 'S'))
			{
				point = "point";
				return point;
			}   else {
				point="player";
			}
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
		try {
			if ((table[Row - 1][Column - 1] == 'S') && (table[Row + 1][Column + 1] == 'S'))
			{
				point = "point";
				return point;
			}   else {
				point="player";
			}
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
		try {
			if ((table[Row + 1][Column + 1] == 'S') && (table[Row - 1][Column - 1] == 'S'))
			{
				point = "point";
				return point;
			}   else {
				point="player";
			}
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
		}
		return point;

	}

	
}
