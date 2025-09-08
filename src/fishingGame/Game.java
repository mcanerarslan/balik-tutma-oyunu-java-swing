package fishingGame;

import java.util.Random;
import java.util.Scanner;

public class Game {
	
	Random random = new Random();
	Scanner scanner = new Scanner(System.in);
//	TaskManager taskManager = new TaskManager(this);
	
	private Inventory inventory = new Inventory();

	private double totalMassOfCaught = 0;
	private double bestOfTheCaught = 0;
	private int totalAmountOfCaught = 0;
	private double playerMoney = 100;
	private int inventorySlot = 0;
	private int inventoryMaxSlot = 3;

	private int currentlyTotalAmountOfCaught;
	private double currentlyTotalMassOfCaught;
	
	public double startFishing() {
//			taskManager.checkTasks();
		double massOfFish = 0;
			if (getInventorySlot() < getInventoryMaxSlot()) {
//				System.out.println("Balık oltaya takılıyor... 🎣");
//				ControlManager.showFishingAnimation();
				double number = random.nextInt(100) + 1;
				massOfFish = number;
//				double massOfFish = number * inventory.getSuccessRate();
				System.out.printf("Balığı çektin! %.2f kg 🐠\n", massOfFish);

				addToTotalMassOfCaught(massOfFish);
				addCurrentlyTotalMassOfCaught(massOfFish);

				if (getBestOfTheCaught() < massOfFish) {
					setBestOfTheCaught(massOfFish);
					System.out.println("Şu ana kadarki en büyük balığını tuttun. Tebrikler!");
				}

				incrementInventorySlot(); // slottan bir yer azalıyor
				incrementTotalAmountOfCaught(); // genel adet artıyor
				incrementCurrentlyTotalAmountOfCaught(); // satış sonrası adet artıyor
			} else {
//				ControlManager.waitForAction(scanner, "Envanter Dolu. Markete giderek satabilirsin.");
				System.out.println("Envanter DOLDU GECİCİ HATA");
			}
			return massOfFish;

//			MenuManager.playAgainYesOrNo();

	}

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

	public int getInventorySlot() {
		return inventorySlot;
	}

	public void setInventorySlot(int inventorySlot) {
		this.inventorySlot = inventorySlot;
	}

	public void incrementInventorySlot() {
		this.inventorySlot++;
	}

	public int getInventoryMaxSlot() {
		return inventoryMaxSlot;
	}

	public void setInventoryMaxSlot(int inventoryMaxSlot) {
		this.inventoryMaxSlot = inventoryMaxSlot;
	}

	public int getCurrentlyTotalAmountOfCaught() {
		return currentlyTotalAmountOfCaught;
	}

	public void setCurrentlyTotalAmountOfCaught(int currentlyTotalAmountOfCaught) {
		this.currentlyTotalAmountOfCaught = currentlyTotalAmountOfCaught;
	}

	public void incrementCurrentlyTotalAmountOfCaught() {
		this.currentlyTotalAmountOfCaught++;
	}

	public double getCurrentlyTotalMassOfCaught() {
		return currentlyTotalMassOfCaught;
	}

	public void setCurrentlyTotalMassOfCaught(double currentlyTotalMassOfCaught) {
		this.currentlyTotalMassOfCaught = currentlyTotalMassOfCaught;
	}

	public void addCurrentlyTotalMassOfCaught(double mass) {
		this.currentlyTotalMassOfCaught += mass;
	}

	// market

	public double getPlayerMoney() {
		return playerMoney;
	}

	public void setPlayerMoney(double playerMoney) {
		this.playerMoney = playerMoney;
	}

	public void increasePlayerMoney(double value) {
		this.playerMoney += value;
	}

	public void decreasePlayerMoney(double value) {
		this.playerMoney -= value;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

}
