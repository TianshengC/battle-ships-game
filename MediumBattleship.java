
public class MediumBattleship extends Battleship {
	public static int numMediumShip;
	public MediumBattleship() {
		super();
		size = 2;
		super.setHealth(size);
        super.setSink(false);
	}

}
