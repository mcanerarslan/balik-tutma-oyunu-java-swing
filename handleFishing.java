import java.util.Random;

public class handleFishing extends GameManager {

	void test
	{
		Random random = new Random();
		double number = random.nextInt(10) + 1;
		GameManager gameManager = new GameManager();
		MenuManager menuManager = new MenuManager();
		String backToMenu;
		double successRate;
		int fishingRodType;

		switch (fishingRodType) {
		case 1 -> successRate = number * 0.3;
		case 2 -> successRate = number * 0.5;
		case 3 -> successRate = number * 0.7;
		case 4 -> successRate = number * 0.9;
		default -> System.out.println("Hatalı olta tipi.");
		}

		if (gameManager.getInventorySlot() < gameManager.getInventoryMaxSlot()) {
			System.out.println("Balık oltaya takılıyor... 🎣");
			double changeOfMass = random.nextDouble(10) + 1;
			double massOfFish = successRate * changeOfMass;
			System.out.printf("Balığı çektin! %.2f kg 🐠\n", massOfFish);

			gameManager.addToTotalMassOfCaught(massOfFish);
			if (gameManager.getBestOfTheCaught() < massOfFish) {
				gameManager.setBestOfTheCaught(massOfFish);
				System.out.println("Şu ana kadarki en büyük balığını tuttun. Tebrikler!");
			}
			gameManager.incrementInventorySlot();
			gameManager.incrementTotalAmountOfCaught();
		} else {
			System.out.println("Envanterin dolu.");
			break;
		}

		menuManager.playAgainYesOrNo();

	}
}
