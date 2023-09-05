import java.util.Scanner;

public class PlayGame {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to Battleship!");
		Board boardOne = new Board(10, 10); // generate two boards
		Board boardTwo = new Board(10, 10);
		boardOne.boardStructure(); // generate the structure of board
		boardTwo.boardStructure();
		boardOne.placeBattleship(); // generate and place battleships
		boardTwo.placeBattleship();	
		System.out.println("Player One, please enter your name:");
		String nameOne = s.nextLine();
		Player playerOne = new Player(nameOne, boardOne); // generate a player object and assign the rival's board
		System.out.println("Player " +playerOne.getName() + " was created successfully.");
		System.out.println("Player Two, please enter your name:");
		String nameTwo = s.nextLine();
		Player playerTwo = new Player(nameTwo, boardTwo); // generate another player object and assign the rival's board
		System.out.println("Player " +playerTwo.getName() + " was created successfully.");
		System.out.println("Let's start the game.");
		boolean checkOne = false; // indicate whether there are battleships left on boardOne
		boolean checkTwo = false; // indicate whether there are battleships left on boardTwo
		while(!checkOne && !checkTwo) {
			checkOne = playerOne.takeTurns(); // If no ships left on boardOne, the checkOne will be true.
			System.out.println(boardOne);
			if(checkOne) {
				compareScore(playerOne.getScores(), playerOne.getName(), playerTwo.getScores(), playerTwo.getName());
				break;
			}
			checkTwo = playerTwo.takeTurns(); // If no ships left on boardTwo, the checkTwo will be true.
			System.out.println(boardTwo);
			if(checkTwo) {
				compareScore(playerOne.getScores(), playerOne.getName(), playerTwo.getScores(), playerTwo.getName());
				break;
			}
		}
	}
    // This method is for deciding which player has a higher score and output the result when no battleships left.
	public static void compareScore(int scoreOne, String playerOneName, int scoreTwo, String playerTwoName){
		if(scoreOne > scoreTwo) {
		     System.out.println("Congratulation! " + playerOneName + " Win!");
	    }else if(scoreOne < scoreTwo){
		     System.out.println("Congratulation! " + playerTwoName + " Win!");
	    }else if(scoreOne == scoreTwo) {
		     System.out.println("Draw");
	    }	
	}
}
