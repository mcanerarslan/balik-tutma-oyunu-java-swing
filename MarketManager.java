
public class MarketManager extends PlayerBase {

	private double totalMassOfCaught;
	private double bestOfTheCaught;
	private int totalAmountOfCaught;
//	private double successRate = 0;
	private double playerMoney;
	private int inventorySlot;
	private int inventoryMaxSlot;

	private double currentlyTotalAmountOfCaught;
	private double currentlyTotalMassOfCaught;

	GameManager gm = new GameManager(totalMassOfCaught, bestOfTheCaught, totalAmountOfCaught, playerMoney,
			inventorySlot, inventoryMaxSlot, currentlyTotalAmountOfCaught, currentlyTotalMassOfCaught);

	public static void buyNewSlotLimit() {

	}

	public void sellAll() {
		if (currentlyTotalMassOfCaught > 0 && currentlyTotalAmountOfCaught > 0) {
			double earnedMoney = currentlyTotalMassOfCaught * 10;
			gm.setPlayerMoney(gm.getPlayerMoney() + earnedMoney);

			System.out.printf("Tüm balıkları sattın. Kazanç: %.2f ₺\n", earnedMoney);
			gm.setCurrentlyTotalAmountOfCaught(0);
			gm.setCurrentlyTotalMassOfCaught(0);
			gm.setInventorySlot(0); // envanteri boşalt
		} else {
			System.out.println("Satacak balığın yok.");
		}
	}

}
