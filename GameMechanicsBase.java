
public class GameMechanicsBase {
	
	private double playerMoney;
	private double extraSlotPrice;
	protected final int MAX_SLOT_LIMIT = 10; // Sabit slot sınırı
	protected final int MAX_FISHING_ROD_TYPE = 4;
	protected final double BASE_SLOT_PRICE = 1000;
	protected final double PRICE_PER_KG = 0.69;
	
	public GameMechanicsBase(){
		playerMoney = 150;
		extraSlotPrice = 100;
	}

	public int getMaxSlotLimit() {
		return MAX_SLOT_LIMIT;
	}
	
	


}
