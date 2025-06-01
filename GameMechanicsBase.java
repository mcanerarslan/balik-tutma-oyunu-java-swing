
public class GameMechanicsBase {
	
	private double playerMoney;
	private double extraSlotPrice;
	protected final int MAX_SLOT_LIMIT = 10; // Sabit slot sınırı
	
	GameMechanicsBase(){
		playerMoney = 150;
		extraSlotPrice = 100;
	}

	public int getMaxSlotLimit() {
		return MAX_SLOT_LIMIT;
	}
	
	


}
