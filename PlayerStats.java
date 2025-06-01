
public class PlayerStats extends GameManager {

	private double totalMassOfCaught;
	private double bestOfTheCaught;
	private int totalAmountOfCaught;
	private int inventorySlot;
	private double playerMoney;
	private int inventoryMaxSlot;

	public PlayerStats(GameManager gm) {
		super(gm.getTotalMassOfCaught(), gm.getBestOfTheCaught(), gm.getTotalAmountOfCaught(), 
				gm.getPlayerMoney(),gm.getInventorySlot(), gm.getInventoryMaxSlot());
		
	    this.totalMassOfCaught = gm.getTotalMassOfCaught();
	    this.bestOfTheCaught = gm.getBestOfTheCaught();
	    this.totalAmountOfCaught = gm.getTotalAmountOfCaught();
	    this.playerMoney = gm.getPlayerMoney();
	    this.inventorySlot = gm.getInventorySlot();
	    this.inventoryMaxSlot = gm.getInventoryMaxSlot();
	}
	
	
	public PlayerStats(double totalMass, double bestFish, int amount, double money, int slot, int maxSlot) {
	    super(totalMass, bestFish, amount, money, slot, maxSlot);
	}


	public static void saveStats() {
		
	}

}
