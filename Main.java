import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Random random = new Random();
		Scanner scanner = new Scanner(System.in);

		GameManager gameManager;
		PlayerStats stats;

		PlayerStats loadedStats = SaveAndQuitTheGame.loadPlayerStats();

		if (loadedStats != null) {
			gameManager = new GameManager(loadedStats.getTotalMassOfCaught(), loadedStats.getBestOfTheCaught(),
					loadedStats.getTotalAmountOfCaught(), loadedStats.getPlayerMoney(), loadedStats.getInventorySlot(),
					loadedStats.getInventoryMaxSlot(), loadedStats.getCurrentlyTotalAmountOfCaught(), // adet
					loadedStats.getCurrentlyTotalMassOfCaught(), // kütle
					loadedStats.getFishingRodType()
			);
		} else {
			gameManager = new GameManager(0.0, 0.0, 0, 100.0, 0, 3, 0, 0.0,1); // varsayılan değerler
		}

		stats = new PlayerStats(gameManager);

		MarketManager marketManager = new MarketManager(gameManager);
		// İstatistik bilgileri
		double successRate = 0;

		outerLoop: // döngü dışına çıkmak için label etiket atadık.
		while (true) {
			MenuManager.fakeClearConsole();
			MenuManager.printMainMenu();
			System.out.print("Bir seçim yapınız: ");

			int menuNumber = ControlManager.getValidInt(scanner);

			switch (menuNumber) {
			case 1:
				MenuManager.fakeClearConsole();
				double number = random.nextInt(10) + 1;
				String backToMenu;

				do {
					switch (gameManager.getFishingRodType()) {
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
						gameManager.addCurrentlyTotalMassOfCaught(massOfFish);

						if (gameManager.getBestOfTheCaught() < massOfFish) {
							gameManager.setBestOfTheCaught(massOfFish);
							System.out.println("Şu ana kadarki en büyük balığını tuttun. Tebrikler!");
						}

						gameManager.incrementInventorySlot(); // slottan bir yer azalıyor
						gameManager.incrementTotalAmountOfCaught(); // genel adet artıyor
						gameManager.incrementCurrentlyTotalAmountOfCaught(); // satış sonrası adet artıyor

					} else {
						ControlManager.waitForAction();
						break;
					}

					MenuManager.playAgainYesOrNo();

				} while (ControlManager.getValidString(scanner));

				break;

			case 2:
				MenuManager.fakeClearConsole();
				MenuManager.playerStatus(gameManager.getTotalAmountOfCaught(), gameManager.getTotalMassOfCaught(),
						gameManager.getBestOfTheCaught(), gameManager.getInventorySlot(),
						gameManager.getInventoryMaxSlot(), gameManager.getCurrentlyTotalAmountOfCaught(),
						gameManager.getCurrentlyTotalMassOfCaught(), gameManager.getPlayerMoney());
				System.out.println("\n[ q ] tuşuna basarak menüye dönebilirsiniz.");
				do {
					backToMenu = scanner.nextLine().trim().toLowerCase();
				} while (!backToMenu.equals("q"));
				break;

			case 3:
				MenuManager.fakeClearConsole();
				MenuManager.marketMenuMain(gameManager.getPlayerMoney(),marketManager.showTotalPriceForSell(),marketManager.showUpgradeFishinRodPrice(),marketManager.showBuyExtraSlotPrice());
				menuNumber = scanner.nextInt();
				switch (menuNumber) {
				case 1:
					marketManager.sellAll();
					break;
				case 2:
					marketManager.upgradeFishingRod();
					break;
				case 3:
					marketManager.buyExtraSlot();
					break;
				case 0:
					break;
				default:
					System.out.println("Geçersiz seçim.");
				}
				break;

			case 99:
				gameManager.resetStats();
				break;

			case 44:
				marketManager.sellAll();
				break;

			case 0:
				System.out.println("Çıkış yapılıyor.");
				stats = new PlayerStats(gameManager); // güncel verilerle yeni PlayerStats oluştur
				SaveAndQuitTheGame.savePlayerStats(stats);
				scanner.close();
				System.exit(0);

			default:
				System.out.println("Hatalı seçim. Lütfen tekrar deneyin.");
			}
		}
	}

}