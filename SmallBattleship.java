
public class SmallBattleship extends Battleship {
	public static int numSmallShip;
	public SmallBattleship() {
		super();
		size = 1;
		super.setHealth(size);
        super.setSink(false);
	}
}
