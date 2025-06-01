import java.util.Scanner;

public class MarketManager extends GameMechanicsBase {

	private double totalMassOfCaught;
	private double bestOfTheCaught;
	private int totalAmountOfCaught;
//	private double successRate = 0;
	private double playerMoney;
	private int inventorySlot;
	private int inventoryMaxSlot;

	private int currentlyTotalAmountOfCaught;
	private double currentlyTotalMassOfCaught;

	private GameManager gameManager;
	
	public MarketManager(GameManager gameManager) {
		this.gameManager = gameManager;
	}

	public static void buyNewSlotLimit() {

	}

	public void sellAll() {
		double mass = gameManager.getCurrentlyTotalMassOfCaught();
		int count = gameManager.getCurrentlyTotalAmountOfCaught();

		if (mass > 0 && count > 0) {
			double earnedMoney = mass * 10;
			gameManager.increasePlayerMoney(earnedMoney); // önerilen metod
			System.out.printf("Tüm balıkları sattın. Kazanç: %.2f ₺\n", earnedMoney);

			gameManager.setCurrentlyTotalAmountOfCaught(0);
			gameManager.setCurrentlyTotalMassOfCaught(0);
			gameManager.setInventorySlot(0);
			
			ControlManager.waitForAction();
		} else {
			System.out.println("Satacak balığın yok.");
			ControlManager.waitForAction();
		}
	}
	
	public void buyExtraSlot() {
		
		int currentSlotSize = gameManager.getInventoryMaxSlot();
		final int maxSlotLimit = gameManager.MAX_SLOT_LIMIT;
		
		double currentExtraSlotPrice = 100+(gameManager.getInventoryMaxSlot()-3)*50;
		
		if(currentSlotSize>=maxSlotLimit) {
			System.out.println("Maksimum slot limitine ulaştınız. Daha fazla slot alınamaz.");
		}else if(gameManager.getPlayerMoney()< currentExtraSlotPrice) {
			System.out.println("Yetersiz bakiye. Slot satın alınamadı.");
		}else {
			gameManager.decreasePlayerMoney(currentExtraSlotPrice); //ücret alımı
			gameManager.setInventoryMaxSlot(currentSlotSize+1); //slot artışı
			System.out.println("Yeni slot başarıyla alındı!");
			System.out.printf("Yeni envanter kapasiteniz: %d/%d\n",gameManager.getInventorySlot(), gameManager.getInventoryMaxSlot());
		}
		
		ControlManager.waitForAction();
		
	}
	
	public void upgradeFishingRod() {
		
	}
	
	public double showBuyExtraSlotPrice() {
		double currentExtraSlotPrice = 100+(gameManager.getInventoryMaxSlot()-3)*50;
		return currentExtraSlotPrice;
	}

}
