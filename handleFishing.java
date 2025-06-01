import java.util.Random;
import java.util.Scanner;

public class handleFishing extends GameManager {
	private double totalMassOfCaught;
	private double bestOfTheCaught;
	private int totalAmountOfCaught0;
//	private double successRate = 0;
	private double playerMoney;
	private int inventorySlot;
	private int inventoryMaxSlot;
	
	public handleFishing(GameManager gm) {
		inventorySlot = gm.getInventorySlot();
		inventoryMaxSlot = gm.getInventorySlot();
	}

    public static void startFishing() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Olta tipini seç (1-4): ");
        int fishingRodType = scanner.nextInt();

        double number = random.nextInt(10) + 1;
        double successRate;

        switch (fishingRodType) {
            case 1 -> successRate = number * 0.3;
            case 2 -> successRate = number * 0.5;
            case 3 -> successRate = number * 0.7;
            case 4 -> successRate = number * 0.9;
            default -> {
                System.out.println("Hatalı olta tipi.");
            }
        }

        if (getInventorySlot() < getInventoryMaxSlot()) {
            System.out.println("Balık oltaya takılıyor... 🎣");
            double changeOfMass = random.nextDouble(10) + 1;
            double massOfFish = successRate * changeOfMass;
            System.out.printf("Balığı çektin! %.2f kg 🐠\n", massOfFish);

            addToTotalMassOfCaught(massOfFish);
            if (getBestOfTheCaught() < massOfFish) {
                setBestOfTheCaught(massOfFish);
                System.out.println("Şu ana kadarki en büyük balığını tuttun. Tebrikler!");
            }
            incrementInventorySlot();
            incrementTotalAmountOfCaught();
        } else {
            System.out.println("Envanterin dolu.");
        }

        MenuManager.playAgainYesOrNo();
    }
	}
