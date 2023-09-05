
public class Battleship {
    // attributes
	private boolean sink;
	private int health;
	protected int size;
    // constructor
	public Battleship() { // details of ships are defined in the subclass
    }
    // setters and getters
	public void setSink(boolean sink) {
		this.sink = sink;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public boolean getSink() {
		return sink;
	}
	public int getHealth() {
		return health;
	}
	public int getSize() {
		return size;
	}
}
