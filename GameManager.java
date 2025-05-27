
public class GameManager {

	private double totalMassOfCaught = 0;
	private double bestOfTheCaught = 0;
	private int totalAmountOfCaught = 0;
//	private double successRate = 0;
	private int inventorySlot = 0;
	private double playerMoney = 0;
	private int inventoryMaxSlot = 3;
	
	
	
	
	
	
	
	

	public double getTotalMassOfCaught() {
		return totalMassOfCaught;
	}

	public void setTotalMassOfCaught(double totalMassOfCaught) {
		this.totalMassOfCaught = totalMassOfCaught;
	}

	public void addToTotalMassOfCaught(double mass) {
		this.totalMassOfCaught += mass;
	}

	public double getBestOfTheCaught() {
		return bestOfTheCaught;
	}

	public void setBestOfTheCaught(double bestOfTheCaught) {
		this.bestOfTheCaught = bestOfTheCaught;
	}

	public int getTotalAmountOfCaught() {
		return totalAmountOfCaught;
	}

	public void setTotalAmountOfCaught(int totalAmountOfCaught) {
		this.totalAmountOfCaught = totalAmountOfCaught;
	}

	public void incrementTotalAmountOfCaught() {
		this.totalAmountOfCaught++;
	}

//	public double getSuccessRate() {
//		return successRate;
//	}
//
//	public void setSuccessRate(double successRate) {
//		this.successRate = successRate;
//	}

	public int getInventorySlot() {
		return inventorySlot;
	}

	public void setInventorySlot(int inventorySlot) {
		this.inventorySlot = inventorySlot;
	}

	public void incrementInventorySlot() {
		this.inventorySlot++;
	}

	public double getPlayerMoney() {
		return playerMoney;
	}

	public void setPlayerMoney(double playerMoney) {
		this.playerMoney = playerMoney;
	}

	public int getInventoryMaxSlot() {
		return inventoryMaxSlot;
	}

	public void setInventoryMaxSlot(int inventoryMaxSlot) {
		this.inventoryMaxSlot = inventoryMaxSlot;
	}

}
