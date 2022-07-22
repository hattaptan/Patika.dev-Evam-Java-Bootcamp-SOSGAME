package Test;

import java.io.Console;
import java.util.*;

import Error.CheckError;
import Game.DisplayTable;
import Game.RunGame;
import Game.TableCreation;

public class Main {

	// needed variables
	public static boolean first = false;
	public static int whowillStart = 0;
	public static char[][] table;
	public static int computerScore = 0;
	public static int playerScore = 0;
	public static String playerLetter = "";
	public static String computerLetter = "";
	public static Scanner scanner = new Scanner(System.in);
	public static int weight;
	public static int height;
	public static char player_Letter;  
	public static char computer_Letter;
	public static Random random = new Random();
	public static int tableDimension;
	public static TableCreation tableCreation = new TableCreation();
	public static CheckError errorControl = new CheckError();
	public static RunGame runGame = new RunGame();
	public static boolean finishGame = true;

	public static void main(String[] args) {

		//information to show player
		System.out.println("********Welcome To Tic-Tac-Toe********");
		System.out.println("You will choose where to play using coordinates(1-3)");

		//a random number to make a decision for who will start game 
		int randomNumToStart = random.nextInt(2) + 1;
		System.out.println("A random number will be chosen, if you're lucky you start first...");
		System.out.print(" Choose one of the numbers 1 or 2  : ");
		int randomStartNum = scanner.nextInt();
		randomStartNum = 2;// bu satırı en son sil.

		 
        System.out.println();
		if (randomStartNum == 2) {// number to choose first player ( computer or user)
			System.out.println("Congratulations, you are in luck, you start the game.");
			whowillStart = 1;
		} else {
			System.out.println("luck favors the computer, the computer will start first.");
			whowillStart = 2;
		}
		System.out.println();
         //take an iinput from user for table dimension
		System.out.print("Please enter a number for area dimension ONLY between 3-7 (Number like 4) : ");
		tableDimension = scanner.nextInt();
		System.out.println();
		errorControl.chechkTableDimension(tableDimension, scanner);
		tableDimension = errorControl.returnValue;

		int tableHeight = tableDimension;

		weight = tableDimension;
		height = tableHeight;

		System.out.print("Please Select Letter ( -S-  or -O- ) :  ");

		String Letter = scanner.next();

		//check invalid character for letters of  SOS
		while (errorControl.checkLetter(Letter) == false) {

			System.out.println("Invalid letter, Please enter only ( -S-  or -O- ) ..!");
			Letter = scanner.next();
			errorControl.checkLetter(Letter);
		}

		Letter = Letter.toUpperCase();
		Letter = Letter.substring(0, 1);

		if (Letter.equals("S")) {// according to input give letter to player or computer

			playerLetter = "S";
			computerLetter = "O";

		} else {
			playerLetter = "O";
			computerLetter = "S";

		}
		player_Letter = playerLetter.charAt(0);
		computer_Letter = computerLetter.charAt(0);
		table = new char[tableHeight][tableHeight];

		// initialize game tablo
		tableCreation.initializeTable(table, tableDimension);

		//shot game table on screen
		DisplayTable.getBoard(table);
		//if letter is S 
		if (Letter.equalsIgnoreCase("s")) {//if player choose S letter

			String player = "";
			String computer = "";
			if (whowillStart == 1) {//decide who will start
				
				//return a value from RunGame class, player get point or it is computer turn
				// if return value is point, player will get point, if it is "com", game turn will switch to computer
				player = runGame.PlayerTurnWithS(table, Character.toString(player_Letter),
						Character.toString(computer_Letter));
			}
			if (whowillStart == 2) {
				//return a value from RunGame class, computer get point or it is player turn
				// if return value is point, player will get point, if it is "player", game turn will switch to player
				computer = runGame.ComputerTurnWithO(table, Character.toString(player_Letter),
						Character.toString(computer_Letter));
			}
			while (finishGame) {
				if (player.equalsIgnoreCase("point")) {
					playerScore += 3;//if return is point, player get 3 point
					 
					DisplayTable.getBoard(table);
					System.out.println("Player Score: " + playerScore + "  Compuer Score : " + computerScore);
					//return a value from RunGame class, player get point or it is computer turn
					player = runGame.PlayerTurnWithS(table, Character.toString(player_Letter),
							Character.toString(computer_Letter));
					if (!isFinish()) {//if game is finish or no
						finishGame = false;
						break;
					}
				}
				if (player.equalsIgnoreCase("com")) {
					if (!isFinish()) {//if game is finish or no
						finishGame = false;
						break;
					}
					computer = runGame.ComputerTurnWithO(table, Character.toString(player_Letter),
							Character.toString(computer_Letter));
					

				}
				if (computer.equalsIgnoreCase("cd")) {
					player = "";
					if (!isFinish()) {//if game is finish or no
						finishGame = false;
						break;
					}
					computer = runGame.ComputerTurnWithO(table, Character.toString(player_Letter),
							Character.toString(computer_Letter));

				}
				if (computer.equalsIgnoreCase("player")) {
					//return a value from RunGame class, player get point or it is computer turn
					if (!isFinish()) {//if game is finish or no
						finishGame = false;
						break;
					}
					player = runGame.PlayerTurnWithS(table, Character.toString(player_Letter),
							Character.toString(computer_Letter));
					System.out.println("Player Score: " + playerScore + "  Compuer Score : " + computerScore);

				}
				if (player.equalsIgnoreCase("pd")) {//if player choose a not empty place, than player will have 
					computer = "";//                 a message to choose a empty place
					//return a value from RunGame class, player get point or it is computer turn
					if (!isFinish()) {//if game is finish or no
						finishGame = false;
						break;
					}
					player = runGame.PlayerTurnWithS(table, Character.toString(player_Letter),
							Character.toString(computer_Letter));

				}
				if (computer.equalsIgnoreCase("point")) {
					computerScore += 3;
					
					DisplayTable.getBoard(table);
					
					computer = runGame.ComputerTurnWithO(table, Character.toString(player_Letter),
							Character.toString(computer_Letter));
					if (!isFinish()) {//if game is finish or no
						finishGame = false;
						break;
					}
					System.out.println("Player Score: " + playerScore + "  Compuer Score : " + computerScore);

				}

				if (!(player.equals("pd") || computer.equals("cd"))) {
					//System.out.println("Player Score: " + playerScore + "  Compuer Score : " + computerScore);
				}

				if (!isFinish()) {

					finishGame = false;
				}
			}
		} else {//if player choose "O" letter

			String player = "";
			String computer = "";

			if (whowillStart == 1) {// same work with choose "S" letter operations

				player = runGame.PlayerTurnWithO(table, Character.toString(player_Letter),
						Character.toString(computer_Letter));
			} else {
				computer = runGame.ComputerTurnWithS(table, Character.toString(player_Letter),
						Character.toString(computer_Letter));
			}

			while (finishGame) {

				if (!isFinish()) {
					finishGame = false;
					break;
				}

				if (player.equalsIgnoreCase("point")) {
					playerScore += 3;
					System.out.println("Player Score: " + playerScore + "  Compuer Score : " + computerScore);
					if (!isFinish()) {//if game is finish or no
						finishGame = false;
						break;
					}
					player = runGame.PlayerTurnWithO(table, Character.toString(player_Letter),
							Character.toString(computer_Letter));
				}
				if (player.equalsIgnoreCase("com")) {
					if (!isFinish()) {//if game is finish or no
						finishGame = false;
						break;
					}
					computer = runGame.ComputerTurnWithS(table, Character.toString(player_Letter),
							Character.toString(computer_Letter));
					if (!isFinish()) {//if game is finish or no
						finishGame = false;
						break;
					}
				}
				if (computer.equalsIgnoreCase("cd")) {
					if (!isFinish()) {//if game is finish or no
						finishGame = false;
						break;
					}
					computer = runGame.ComputerTurnWithS(table, Character.toString(player_Letter),
							Character.toString(computer_Letter));
					if (!isFinish()) {//if game is finish or no
						finishGame = false;
						break;
					}
				}
				if (computer.equalsIgnoreCase("player")) {
					if (!isFinish()) {//if game is finish or no
						finishGame = false;
						break;
					}
					player = runGame.PlayerTurnWithO(table, Character.toString(player_Letter),
							Character.toString(computer_Letter));
					if (!isFinish()) {//if game is finish or no
						finishGame = false;
						break;
					}
				}
				if (player.equalsIgnoreCase("pd")) {
					if (!isFinish()) {//if game is finish or no
						finishGame = false;
						break;
					}
					player = runGame.PlayerTurnWithO(table, Character.toString(player_Letter),
							Character.toString(computer_Letter));
					if (!isFinish()) {//if game is finish or no
						finishGame = false;
						break;
					}
				}
				if (computer.equalsIgnoreCase("point")) {//if return valuse is "point" computer get 3 point
					computerScore += 3;
					System.out.println("Player Score: " + playerScore + "  Compuer Score : " + computerScore);
					
					player = runGame.PlayerTurnWithO(table, Character.toString(player_Letter),
							Character.toString(computer_Letter));
					if (!isFinish()) {//if game is finish or no
						finishGame = false;
						break;
					}
				}

				if (!isFinish()) {
					finishGame = false;
					break;
				}

			}
		}

	}

	public static boolean isFinish() {// check is game finish or no
		int counter = 0;
		boolean finishFlag = true;
		for (int i = 0; i < table.length; i++) {

			for (int j = 0; j < table.length; j++) {

				if (table[i][j] == ' ') {
					counter++;
				}
			}
		}

		if (counter == 0) {// if there is no empty place on game table write result of score and finish game
			System.out.println();
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			if (playerScore > computerScore) {
				System.out.println();
				System.out.println("You Winn the game");
				System.out.println("Player Score: " + playerScore + "  Compuer Score : " + computerScore);
			} else if (playerScore == computerScore) {
				System.out.println("game ended in a draw");
				System.out.println("Player Score: " + playerScore + "  Compuer Score : " + computerScore);
			} else {
				System.out.println("Computer Winnn The game :D");
				System.out.println("Player Score: " + playerScore + "  Compuer Score : " + computerScore);
			}

			finishFlag = false;
		}
		return finishFlag;
	}
	 
	// initializes table and fills it with black spaces
	public static void initializeTable(int h, int w) {

		for (int r = 0; r < h; r++) {
			for (int c = 0; c < w; c++) {
				table[r][c] = ' ';
			}
		}

	}

}