public class PlayerStats extends GameManager {

	private double totalMassOfCaught;
	private double bestOfTheCaught;
	private int totalAmountOfCaught;
	private int inventorySlot;
	private double playerMoney;
	private int inventoryMaxSlot;
	
	private int currentlyTotalAmountOfCaught;
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
	
	
	public PlayerStats(double totalMass, double bestFish, int amount, double money, int slot, int maxSlot, int currentlyAmount,double currentlyTotalMass) {
	    super(totalMass, bestFish, amount, money, slot, maxSlot,currentlyAmount,currentlyTotalMass);
	}


	public void printStats() {
		System.out.println("Toplam Tutulan Balık Adeti: \t" + totalAmountOfCaught);
		System.out.println("Toplam Balık Kilogramı: \t" + totalMassOfCaught);
		System.out.println("En Büyük Balık: \t\t" + bestOfTheCaught);
		System.out.println("Envanter Durumu (Dolu / Max): \t" + inventorySlot + "/" + inventoryMaxSlot);
		System.out.println("Güncel Tutulan Balık Adeti: \t" + currentlyTotalAmountOfCaught);
		System.out.println("Güncel Balık Kilogramı: \t" + currentlyTotalMassOfCaught);
	}

}
