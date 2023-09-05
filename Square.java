
public class Square {
    // attributes
	private int row;
    private int column;
    private boolean ship;
    private Battleship currentShip;
    private boolean fired;
    // constructor    
    public Square(int row, int column) {
	 setRow(row); setColumn(column);
    }
    // setters and getters
    public void setRow(int row) {
		this.row = row;
	}
	public void setColumn(int column) {
		this.column = column;	
    }
	public void setShip(boolean ship) {
		this.ship = ship;	
    }
	public void setBattleship(Battleship currentShip) {
		this.currentShip = currentShip;	
    }
	public void setFired(boolean fired) {
		this.fired = fired;	
    }
	public int getRow() {
		return row;
	}
	public int getColumn() {
		return column;
	}
	public boolean getShip() {
		return ship;
	}
	public Battleship getCurrentShip() {
		return currentShip;
	}
	public boolean getFired() {
		return fired;
	}
    // toString, check the status, including fired and ship, to decide the output.
	public String toString() {
		if(!this.fired) {
			String a =String.format("%3s", "-");
			return a;
		}else{
			if(!this.getShip()){
			    String b =String.format("%3s", "o");
			    return b;
		    }else{
			    String c =String.format("%3s", "x");
			    return c;
		    }
	    }
	}
}
