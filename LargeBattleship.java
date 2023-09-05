
public class LargeBattleship extends Battleship {
    public static int numLargeShip;
	public LargeBattleship() {
		super();
        size = 3;
        super.setHealth(size);
        super.setSink(false);
	}
}
