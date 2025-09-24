//
public class Inventory {
	
	private int fishingRodType;
	
	private String fishingRodName,fishBaitName;
	
	public Inventory() {
		fishingRodType = 1;
		this.fishingRodName = "Başlangıç";
		this.fishBaitName = null;
	}

	public int getFishingRodType() {
		return fishingRodType;
	}

	public void setFishingRodType(int fishingRodType) {
		this.fishingRodType = fishingRodType;
	}

	public String getFishingRodName() {
		return fishingRodName;
	}

	public void setFishingRodName(String fishingRodName) {
		this.fishingRodName = fishingRodName;
	}

	public String getFishBaitName() {
		return fishBaitName;
	}

	public void setFishBaitName(String fishBaitName) {
		this.fishBaitName = fishBaitName;
	}
	
}
