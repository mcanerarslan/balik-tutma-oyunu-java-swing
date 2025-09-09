import java.util.Scanner;

public class MarketManager extends GameMechanicsBase {

// 	private double totalMassOfCaught;
// 	private double bestOfTheCaught;
// 	private int totalAmountOfCaught;
//  private double successRate = 0;
// 	private double playerMoney;
// 	private int inventorySlot;
// 	private int inventoryMaxSlot;
// 	private int currentlyTotalAmountOfCaught;
// 	private double currentlyTotalMassOfCaught;

	private GameManager gameManager;

	public MarketManager(GameManager gameManager) {
		this.gameManager = gameManager;
	}

	Scanner scanner = new Scanner(System.in);

	public void sellAll() {
		double mass = gameManager.getCurrentlyTotalMassOfCaught();
		int count = gameManager.getCurrentlyTotalAmountOfCaught();

		if (mass > 0 && count > 0) {
			double earnedMoney = mass * gameManager.PRICE_PER_KG;
			gameManager.increasePlayerMoney(earnedMoney); // önerilen metod
			System.out.printf("Tüm balıkları sattın. Kazanç: %.2f ₺\n", earnedMoney);

			gameManager.setCurrentlyTotalAmountOfCaught(0);
			gameManager.setCurrentlyTotalMassOfCaught(0);
			gameManager.setInventorySlot(0);

			ControlManager.waitForAction(scanner);
		} else {
			System.out.println("Satacak balığın yok.");
			ControlManager.waitForAction(scanner);
		}
	}

	public void buyExtraSlot() {

		int currentSlotSize = gameManager.getInventoryMaxSlot();
		final int maxSlotLimit = gameManager.MAX_SLOT_LIMIT;

		double currentExtraSlotPrice = gameManager.BASE_SLOT_PRICE + (gameManager.getInventoryMaxSlot() - 3) * 50;

		if (currentSlotSize >= maxSlotLimit) {
			System.out.println("Maksimum slot limitine ulaştınız. Daha fazla slot alınamaz.");

			ControlManager.waitForAction(scanner);
		} else if (gameManager.getPlayerMoney() < currentExtraSlotPrice) {
			System.out.println("Yetersiz bakiye. Slot satın alınamadı.");
			ControlManager.waitForAction(scanner);
		} else {
			gameManager.decreasePlayerMoney(currentExtraSlotPrice); // ücret alımı
			gameManager.setInventoryMaxSlot(currentSlotSize + 1); // slot artışı
			System.out.println("Yeni slot başarıyla alındı!");
			System.out.printf("Yeni envanter kapasiteniz: %d/%d\n", gameManager.getInventorySlot(),
					gameManager.getInventoryMaxSlot());
			ControlManager.waitForAction(scanner);
		}

	}

	public void upgradeFishingRod() {

		int currentFishingRodType = gameManager.getFishingRodType();
		final int maxFishingRodType = gameManager.MAX_FISHING_ROD_TYPE;

		double currentUpgradeRodPrice = (1000 + (gameManager.getFishingRodType() + 1) * 500)
				* gameManager.getFishingRodType();

		if (currentFishingRodType >= maxFishingRodType) {
			System.out.println("Maksimum olta türüne ulaştınız. Daha fazla yükseltme alınamaz.");
			ControlManager.waitForAction(scanner);
		} else if (gameManager.getPlayerMoney() < currentUpgradeRodPrice) {
			System.out.println("Yetersiz bakiye. Olta yükseltmesi satın alınamadı.");
			ControlManager.waitForAction(scanner);
		} else {
			gameManager.decreasePlayerMoney(currentUpgradeRodPrice); // ücret alımı
			gameManager.setFishingRodType(currentFishingRodType + 1); // olta artışı
			System.out.println("Yeni olta başarıyla alındı!");

			String rodName;
			switch (gameManager.getFishingRodType()) {
			case 1:
				rodName = "Basit";
				break;
			case 2:
				rodName = "Amatör";
				break;
			case 3:
				rodName = "Profesyonel";
				break;
			case 4:
				rodName = "Efsanevi";
				break;
			default:
				rodName = "Bilinmiyor";
				break;
			}
			System.out.printf("Yeni oltanız: %s\n", rodName);

			ControlManager.waitForAction(scanner);

		}

	}

	public double showBuyExtraSlotPrice() {
		double currentExtraSlotPrice = 100 + (gameManager.getInventoryMaxSlot() - 3) * 50;
		return currentExtraSlotPrice;
	}

	public double showUpgradeFishingRodPrice() {
		double currentUpgradeRodPrice = (1000 + (gameManager.getFishingRodType() + 1) * 500)
				* gameManager.getFishingRodType();
		return currentUpgradeRodPrice;
	}

	public double showTotalPriceForSell() {
		double price = gameManager.getCurrentlyTotalMassOfCaught() * gameManager.PRICE_PER_KG;
		return price;
	}

}
