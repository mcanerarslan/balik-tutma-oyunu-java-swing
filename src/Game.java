
//
import java.util.Random;
import java.util.Scanner;

public class Game {

	Random random = new Random();
	Scanner scanner = new Scanner(System.in);

	private Inventory inventory = new Inventory();

	private double totalMassOfCaught = 0;
	private double bestOfTheCaught = 0;
	private int totalAmountOfCaught = 0;
	private double playerMoney = 100;
	private int inventorySlot = 0;
	private int inventoryMaxSlot = 3;

	private int currentlyTotalAmountOfCaught;
	private double currentlyTotalMassOfCaught;

	public Game(double totalMassOfCaught, double bestOfTheCaught, int totalAmountCaught, double playerMoney,
			int inventorySlot, int inventoryMaxSlot, int currentlyTotalAmountOfCaught,
			double currentlyTotalMassOfCaught, int fishingRodType) {
		this.totalMassOfCaught = totalMassOfCaught;
		this.bestOfTheCaught = bestOfTheCaught;
		this.totalAmountOfCaught = totalAmountCaught;
		this.playerMoney = playerMoney;
		this.inventorySlot = inventorySlot;
		this.inventoryMaxSlot = inventoryMaxSlot;
		this.currentlyTotalAmountOfCaught = currentlyTotalAmountOfCaught;
		this.currentlyTotalMassOfCaught = currentlyTotalMassOfCaught;
		inventory.setFishingRodType(fishingRodType);
	}

	public double startFishing() {
		double massOfFish = 0;
		if (getInventorySlot() < getInventoryMaxSlot()) {

			double number = random.nextInt(100) + 1;
			massOfFish = number * inventory.getFishingRodType();
			System.out.printf("🐠 %.2f kg\n", massOfFish);

			addToTotalMassOfCaught(massOfFish);
			addCurrentlyTotalMassOfCaught(massOfFish);

			if (getBestOfTheCaught() < massOfFish) {
				setBestOfTheCaught(massOfFish);
				System.out.println("Şu ana kadarki en büyük balığını tuttun.");
			}
			incrementInventorySlot(); // slottan bir yer azalıyor
			incrementTotalAmountOfCaught(); // genel adet artıyor
			incrementCurrentlyTotalAmountOfCaught(); // satış sonrası adet artıyor
		} else {
			System.out.println("HATA - Envanter Dolu!");
		}
		return massOfFish;
	}

	public String getRandomFishName(double mass) {
		if (mass <= 0)
			return "Çöp";
		if (mass < 5)
			return "Gümüş Balığı";
		if (mass < 15)
			return "Sazan";
		if (mass < 40)
			return "Levrek";
		if (mass < 80)
			return "Mersin Balığı";
		if (mass < 130)
			return "Kılıç Balığı";
		if (mass < 190)
			return "Dev Yayın Balığı";
		if (mass < 240)
			return "Piraiba";
		if (mass >= 240)
			return "Mavi Yüzgeçli Orkinos";
		return "Türü bilinmeyen balık";
	}

	public void resetStats() {
		this.totalMassOfCaught = 0;
		this.bestOfTheCaught = 0;
		this.totalAmountOfCaught = 0;
		this.playerMoney = 1000;
		this.inventorySlot = 0;
		this.inventoryMaxSlot = 3;
		this.currentlyTotalAmountOfCaught = 0;
		this.currentlyTotalMassOfCaught = 0;
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

	public String showPlayerMoney() {
		String money = String.format("%.2f", playerMoney);
		return money;
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

	public int getInventoryFishingRodType() {
		return inventory.getFishingRodType();
	}

	public void setInventoryFishingRodType(int fishingRodType) {
		inventory.setFishingRodType(fishingRodType);
	}
}
