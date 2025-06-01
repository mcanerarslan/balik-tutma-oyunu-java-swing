import java.lang.classfile.Superclass;

public class PlayerStats extends GameManager {

	private double totalMassOfCaught;
	private double bestOfTheCaught;
	private int totalAmountOfCaught;
	private int inventorySlot;
	private double playerMoney;
	private int inventoryMaxSlot;
	
	private double currentlyTotalAmountOfCaught;
	private double currentlyTotalMassOfCaught;

	public PlayerStats(GameManager gm) {
		super(gm.getTotalMassOfCaught(), gm.getBestOfTheCaught(), gm.getTotalAmountOfCaught(), 
				gm.getPlayerMoney(),gm.getInventorySlot(), gm.getInventoryMaxSlot(),gm.getCurrentlyTotalAmountOfCaught(),gm.getCurrentlyTotalMassOfCaught());
		
	    this.totalMassOfCaught = gm.getTotalMassOfCaught();
	    this.bestOfTheCaught = gm.getBestOfTheCaught();
	    this.totalAmountOfCaught = gm.getTotalAmountOfCaught();
	    this.playerMoney = gm.getPlayerMoney();
	    this.inventorySlot = gm.getInventorySlot();
	    this.inventoryMaxSlot = gm.getInventoryMaxSlot();
	    this.currentlyTotalAmountOfCaught = gm.getCurrentlyTotalAmountOfCaught();
	    this.currentlyTotalMassOfCaught = gm.getCurrentlyTotalMassOfCaught();
	}
	
	
	public PlayerStats(double totalMass, double bestFish, int amount, double money, int slot, int maxSlot,double currentlyTotalMass, double currentlyAmount) {
	    super(totalMass, bestFish, amount, money, slot, maxSlot,currentlyTotalMass,currentlyAmount);
	}


	public static void saveStats() {
		
	}

}
