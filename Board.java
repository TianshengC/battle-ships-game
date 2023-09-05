import java.util.Random;

public class Board {
    // attributes
	private int row;
	private int column;
	public Square[][] squareArray; // this array is frequently used in other classes. So it is public.
    // constructor
	public Board(int row, int column) {
		setRow(row); setColumn(column);
		squareArray = new Square[row][column];
	}
    // setters and getters
	public void setRow(int row) {
		this.row = row;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public int getRow() {
		return row;
	}
	public int getColumn() {
		return column;
	}
    // generate the board
	public void boardStructure() {
		for(int i = 0; i < this.row; i++) {
			for(int j = 0; j < this.column; j++) {
				squareArray[i][j] = new Square(i, j);
				squareArray[i][j].setFired(false);
				squareArray[i][j].setShip(false);
			}
		}
	}
    // generate and place the battleship
	public void placeBattleship() {
		Random r = new Random();
		LargeBattleship.numLargeShip = 1;
		MediumBattleship.numMediumShip = 2;
		SmallBattleship.numSmallShip = 3;	
		int numTotal = SmallBattleship.numSmallShip + MediumBattleship.numMediumShip + LargeBattleship.numLargeShip; // total number of battleship
		Battleship[] shipArray = new Battleship[numTotal];
		for(int i = 0; i <= LargeBattleship.numLargeShip-1; i++) {// generate and place large ships
			shipArray[i] = new LargeBattleship();
			int shipOneRow; int shipOneColumn; int shipTwoRow; int shipTwoColumn; int shipThreeRow; int shipThreeColumn; // 3 coordinates for large ship
			boolean check = true;
			while(check){ // generate 3 coordinates and check whether it is overlapped on other battleships
				   shipOneRow = r.nextInt(this.row); // select the first coordinate
				   shipOneColumn = r.nextInt(this.column);
				   if(squareArray[shipOneRow][shipOneColumn].getShip()) {
					   continue; // If there is a battleship there, another new coordinate will be generated.
				   }else {
				       boolean vertOne = r.nextBoolean();
				       if(vertOne) { // Decide the second coordinate and direction of the battleship, horizontal or vertical.
					       shipTwoRow = shipOneRow + 1;
					       shipTwoColumn = shipOneColumn;
				       }else {
					       shipTwoRow = shipOneRow;
					       shipTwoColumn = shipOneColumn + 1;
				       }
				       if(shipTwoRow < this.row && shipTwoColumn < this.column) { // check whether the 2nd coordinate is out of boundary
				           if(!squareArray[shipTwoRow][shipTwoColumn].getShip()) { // check whether the 2nd coordinate has a ship and generate the 3rd coordinate
					           boolean vertTwo = r.nextBoolean();
					           if(vertTwo) {
					    	        shipThreeRow = shipOneRow - 1;
					    	        shipThreeColumn = shipOneColumn;
					           }else {
					    	        shipThreeRow = shipOneRow;
					    	        shipThreeColumn = shipOneColumn - 1;
					           }
					           if(shipThreeRow >= 0 && shipThreeColumn >= 0) { // check whether the 3rd coordinate is out of boundary  
					                if(!squareArray[shipThreeRow][shipThreeColumn].getShip()) { 
					    	              squareArray[shipOneRow][shipOneColumn].setShip(true); // place the battleship on 1st coordinate
						                  squareArray[shipTwoRow][shipTwoColumn].setShip(true); // place the battleship on 2nd coordinate
						                  squareArray[shipThreeRow][shipThreeColumn].setShip(true); // place the battleship on 3rd coordinate
						                  squareArray[shipOneRow][shipOneColumn].setBattleship(shipArray[i]); // set reference to the battleship on 1st coordinate
						                  squareArray[shipTwoRow][shipTwoColumn].setBattleship(shipArray[i]); // set reference to the battleship on 2nd coordinate
						                  squareArray[shipThreeRow][shipThreeColumn].setBattleship(shipArray[i]); // set reference to the battleship on 3rd coordinate
						                  check = false; // Stop the while loop because the battleship is generated and placed successfully.
					                }else {
					    	              continue; // Because the 3rd coordinate has a ship, another new coordinate will be generated.
					                }
					            }else{
					        	    continue; // Because the 3rd coordinate is out of boundary, another new coordinate will be generated.
					            }
				           }else {
				        	   continue; // Because the 2nd coordinate has a ship, another new coordinate will be generated.
				           }
				        }else {
					       continue; // Because the 2nd coordinate is out of boundary, another new coordinate will be generated.
				        }	
				   }
			  }
		}
		for(int i = LargeBattleship.numLargeShip; i <= LargeBattleship.numLargeShip + MediumBattleship.numMediumShip - 1; i++) { // generate and place medium ships
			shipArray[i] = new MediumBattleship();
		    int shipOneRow; int shipOneColumn; int shipTwoRow; int shipTwoColumn; // 2 coordinates for medium battleships
			boolean check = true;
		    while(check){ // generate 2 coordinates and check whether it is overlapped on other battleships
			   shipOneRow = r.nextInt(this.row); // select the first coordinate
			   shipOneColumn = r.nextInt(this.column);
			   if(squareArray[shipOneRow][shipOneColumn].getShip()) {
				   continue; // If there is a battleship there, another new coordinate will be generated.
			   }else {
			       boolean vert = r.nextBoolean();
			       if(vert) { // Decide the second coordinate and direction of the battleship, horizontal or vertical.
				       shipTwoRow = shipOneRow + 1;
				       shipTwoColumn = shipOneColumn;
			       }else {
				       shipTwoRow = shipOneRow;
				       shipTwoColumn = shipOneColumn + 1;
			       }
			       if(shipTwoRow < this.row && shipTwoColumn < this.column) { // check whether the 2nd coordinate is out of boundary
			           if(!squareArray[shipTwoRow][shipTwoColumn].getShip()) {// check whether the 2nd coordinate has a ship
			    	       squareArray[shipOneRow][shipOneColumn].setShip(true); // place the battleship on 1st coordinate
				           squareArray[shipTwoRow][shipTwoColumn].setShip(true); // place the battleship on 2nd coordinate
				           squareArray[shipOneRow][shipOneColumn].setBattleship(shipArray[i]); // set reference to the battleship on 1st coordinate
				           squareArray[shipTwoRow][shipTwoColumn].setBattleship(shipArray[i]); // set reference to the battleship on 2nd coordinate
			               check = false; // Stop the while loop because the battleship is generated and placed successfully.		    	   
			          }else {
			    	       continue; // Because the 2nd coordinate has a ship, another new coordinate will be generated.
			          }
			       }else {
			    	   continue; // Because the 2nd coordinate is out of boundary, another new coordinate will be generated.
			       }
			    }
		   }	
		}
		for(int i = LargeBattleship.numLargeShip + MediumBattleship.numMediumShip; i <= numTotal- 1; i++) { // generate and place small ships
			shipArray[i] = new SmallBattleship();
			int shipOneRow; int shipOneColumn; // 1 coordinate for small ships
			boolean check = true;
			while(check) { //generate and place small ships
			     shipOneRow = r.nextInt(this.row); // select the 1st coordinate
			     shipOneColumn = r.nextInt(this.column);
			     if(squareArray[shipOneRow][shipOneColumn].getShip()) {
				      continue; // If there is a battleship there, another new coordinate will be generated.
			     }else {
				      squareArray[shipOneRow][shipOneColumn].setShip(true); // place the battleship on 1st coordinate
				      squareArray[shipOneRow][shipOneColumn].setBattleship(shipArray[i]); // set reference to the battleship on 1st coordinate
				      check = false; // Stop the while loop because the battleship is generated and placed successfully.
			     }
		    }
		}
	}
    // toString, generate the board
	public String toString() {
		String output = "";
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				output += squareArray[i][j].toString();
			}
			output += "\n";
		}
		return output;
	}
}
