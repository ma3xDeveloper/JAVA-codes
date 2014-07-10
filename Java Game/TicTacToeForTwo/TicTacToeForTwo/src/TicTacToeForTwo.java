import java.util.Scanner;

public class TicTacToeForTwo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char[][] arrMemory = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arrMemory[i][j] = ' ';
			}
		}
		int player = 1;
		int rowMatrix = 0;
		int colMatrix = 0;

		System.out
				.println("Hello, sailors... \nThis is a game that will test your mind and \nability to survive deep in the dangerous sea. \nBe ready! ");
		System.out.println(" ");
		System.out.println("-----| Entering Player names |-----");
		System.out.println(" ");

		System.out.println("Please, enter Player 1: ");
		String firstPlayer = input.nextLine();
		System.out.println("Please, enter Player 2: ");
		String secondPlayer = input.nextLine();
		System.out.println(" ");
		System.out.println("-----| Now fight! |-----");
		System.out.println();
		boolean firstPlayerSign = false;
		printTable(arrMemory);
		// boolean secondPlayerSign = false; // this might be useless

		// a while loop to run the game:

		while (true) {

			// which player's turn is?
			if (player % 2 == 1) {
				System.out.println("Player: " + firstPlayer);
				firstPlayerSign = true;

			} else {
				System.out.println("Player: " + secondPlayer);
				firstPlayerSign = false;

			}
			// checked input converted to method:
			System.out.print("Enter ROW, ");
			rowMatrix = inputValue(input);
			System.out.print("Enter COLUMN, ");
			colMatrix = inputValue(input);

			// while (true) {
			// System.out.print(" please choose COLUMN (1,2 or 3): ");
			// //colMatrix = input.nextInt();
			// char colMatrixChar = input.next().charAt(0);
			// if (colMatrixChar == '1' || colMatrixChar == '2' || colMatrixChar
			// == '3') {
			// colMatrix = Integer.parseInt(""+(char)(colMatrixChar));
			// break;
			// } else {
			// System.out.println("Invalid input!");
			// }
			// }
			// // // Exported as method see below!
			
			//Check for already marked position:

			System.out.println();
			if (arrMemory[rowMatrix - 1][colMatrix - 1] != ' ') {
				System.out.println(" ");
				System.out
						.println("Nooo, sailor! This field is already used. Please choose another one! ");
				System.out.print("Enter ROW, ");
				rowMatrix = inputValue(input);
				System.out.print("Enter Column, ");
				colMatrix = inputValue(input);
			}
			if (firstPlayerSign) {
				arrMemory[rowMatrix - 1][colMatrix - 1] = 'O';
			} else {
				arrMemory[rowMatrix - 1][colMatrix - 1] = 'X';
			}
			
			printTable(arrMemory);

			// GameOver checks:
			if (gameOverWinner(arrMemory)) {
				if (player % 2 == 1) {
					System.out
							.println("CONGRATULATIONS, "
									+ firstPlayer
									+ "! \nYou are the WINNER! \nYou are a real sea wolf! \n:)");
				} else {
					System.out
							.println("CONGRATULATIONS, "
									+ secondPlayer
									+ "! \nYou are the WINNER! \nYou are a real sea wolf! \n:)");
				}
				break;
			}
			if (gameOverFullBoard(arrMemory)) {
				System.out.println("The board is full!");
				break;
			}

			player++;
		} // end of the while loop.
		System.out.println("GAME OVER!");
	}

	private static boolean gameOverFullBoard(char[][] arrMemory) {
		boolean fullBoardCheck = true;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (arrMemory[i][j] == ' ') {
					fullBoardCheck = false;
				}
			}
		}
		return fullBoardCheck;
	}

	private static int inputValue(Scanner input) {
		int valueKeeper = 0;
		while (true) {
			System.out.print("please choose 1,2 or 3: ");
			// //rowMatrix = input.nextInt(); //to be substituted with the block
			// below:
			char firstChar = input.next().charAt(0);
			if (firstChar == '1' || firstChar == '2' || firstChar == '3') {
				valueKeeper = Integer.parseInt("" + (char) (firstChar));
				break;
			} else {
				System.out.println("Invalid input!");
			}
		}
		return valueKeeper;
	}

	private static boolean gameOverWinner(char[][] arrMemory) {
		boolean found = false;

		if ((arrMemory[0][0] == arrMemory[0][1]
				&& arrMemory[0][0] == arrMemory[0][2] && (arrMemory[0][0] == 'O' || arrMemory[0][0] == 'X'))) {
			found = true;
		}
		if ((arrMemory[1][0] == arrMemory[1][1]
				&& arrMemory[1][0] == arrMemory[1][2] && (arrMemory[1][0] == 'O' || arrMemory[1][0] == 'X'))) {
			found = true;
		}
		if ((arrMemory[2][0] == arrMemory[2][1]
				&& arrMemory[2][0] == arrMemory[2][2] && (arrMemory[2][0] == 'O' || arrMemory[2][0] == 'X'))) {
			found = true;
		}
		if ((arrMemory[0][0] == arrMemory[1][0]
				&& arrMemory[0][0] == arrMemory[2][0] && (arrMemory[0][0] == 'O' || arrMemory[0][0] == 'X'))) {
			found = true;
		}
		if ((arrMemory[0][1] == arrMemory[1][1]
				&& arrMemory[0][1] == arrMemory[2][1] && (arrMemory[0][1] == 'O' || arrMemory[0][1] == 'X'))) {
			found = true;
		}
		if ((arrMemory[0][2] == arrMemory[1][2]
				&& arrMemory[0][2] == arrMemory[2][2] && (arrMemory[0][2] == 'O' || arrMemory[0][2] == 'X'))) {
			found = true;
		}
		if ((arrMemory[0][0] == arrMemory[1][1]
				&& arrMemory[0][0] == arrMemory[2][2] && (arrMemory[0][0] == 'O' || arrMemory[0][0] == 'X'))) {
			found = true;
		}
		if ((arrMemory[0][2] == arrMemory[1][1]
				&& arrMemory[0][2] == arrMemory[2][0] && (arrMemory[0][2] == 'O' || arrMemory[0][2] == 'X'))) {
			found = true;
		}
		return found;
	}

	private static void printTable(char[][] arrMemory) {
		// TODO Auto-generated method stub
		char[][] arrTable = new char[8][8];
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (row % 2 == 0) {
					if (col % 2 == 0) {
						arrTable[row][col] = '=';
					} else {
						arrTable[row][col] = '-';
					}
				} else {
					if (col % 2 == 0) {
						arrTable[row][col] = '|';
					}
				}
			}
		}

		// here must be transition for one matrix to the other
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arrTable[i * 2 + 1][j * 2 + 1] = arrMemory[i][j];
			}
		}
		arrTable[1][7] = arrTable[7][1] = '1';
		arrTable[3][7] = arrTable[7][3] = '2';
		arrTable[5][7] = arrTable[7][5] = '3';
		arrTable[7][7] = '#';

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(arrTable[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

}
