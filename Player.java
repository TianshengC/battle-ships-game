import java.util.Scanner;

public class Player {
    // attributes
	private String name;
	private int scores;
	private Board boardRef;
    // constructor
	public Player(String name, Board boardRef){
		this.setName(name);this.setBoardRef(boardRef);
		this.setScores(0);// the beginning of the score is 0.
	}
    // setters and getters
	public void setName(String name) {
		this.name = name;
	}
	public void setScores(int scores) {
		this.scores = scores;
	}
	public void setBoardRef(Board boardRef) {
		this.boardRef = boardRef;
	}
	public String getName() {
		return name;
	}
	public int getScores() {
		return scores;
	}
	public Board getBoardRef() {
		return boardRef;
	}
    // Player Action	
	public boolean takeTurns() {
		boolean noShip = false; // indicate whether there were battleships left
		int totalShip = SmallBattleship.numSmallShip + MediumBattleship.numMediumShip + LargeBattleship.numLargeShip; // total number of Ships
		int leftShip = totalShip; // In the beginning, there should be the same number of total battleships left on the board.
		Scanner s = new Scanner(System.in); // generate 2 scanner to get the input (2 integer)
		System.out.println(this.name + ", Please enter your guess in this format 'row(0-9) column(0-9)':");
		String guess = s.nextLine();
		Scanner in = new Scanner(guess);
		int x = in.nextInt();
		int y = in.nextInt();
		if(!this.boardRef.squareArray[x][y].getFired()) { // check whether that square has been fired before
			this.boardRef.squareArray[x][y].setFired(true); // If no fired before, change the status immediately and continue. 
			if(this.boardRef.squareArray[x][y].getShip()) { // check whether there is a battleship.
				System.out.println("You hit the ship successfully!");
				int tempHealth = this.boardRef.squareArray[x][y].getCurrentShip().getHealth() - 1; // reduce the health
				this.boardRef.squareArray[x][y].getCurrentShip().setHealth(tempHealth); // set the new health
				if(this.boardRef.squareArray[x][y].getCurrentShip().getHealth() == 0) { // check whether the ship will sink
					System.out.println("The ship sank! You get 1 score!");
					this.boardRef.squareArray[x][y].getCurrentShip().setSink(true); // set battleship sunk
					int tempScores = this.getScores() + 1;
					this.setScores(tempScores); // set player scores
					leftShip = totalShip - this.getScores(); // set the number of ship left
					if(leftShip == 0) { // If no ship left, takeTurn() will be true. The game will end.
						noShip = true;
					}
				}
			}else { // If the square has not been fired before and no ship there, the game will show a hint: miss. Fired status has been changed above.
				System.out.println("You miss!");		
			}
		}else { // If the square has been fired before and was fired by the player again, the game will show a hint: invalid. The player will lose his turn.
			System.out.println("(Invalid!)You have fired this coordinate before. You lose your turn.");
		}
		System.out.println("Ships have been sunk: " + this.getScores());
		System.out.println("Ships are left in the game: " + leftShip);
		return noShip;
	}
}
