import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int fishingRodType = 1; // Değiştirilebilir
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		GameManager gameManager = new GameManager();

		// İstatistik bilgileri
		double successRate = 0;
		double playerMoney = 0;

		outerLoop: // döngü dışına çıkmak için label etiket atadık.
		while (true) {
			MenuManager.printMainMenu();
			System.out.print("Bir seçim yapınız: ");

			int menuNumber = getValidInt(scanner);

			switch (menuNumber) {
			case 1:
				double number = random.nextInt(10) + 1;
				String tryAgain;

				do {
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
						System.out.println("Balığı çektin! " + String.format("%.2f", massOfFish) + " kg 🐠");

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

					System.out.println("╔════════════════════════════════════════════════╗");
					System.out.println("║ Tekrar oynamak ister misin? ([E]vet / [H]ayır) ║");
					System.out.println("╚════════════════════════════════════════════════╝");
					tryAgain = scanner.next().trim().toUpperCase();

				} while (tryAgain.equals("E") || tryAgain.equals("EVET"));

				break;

			case 2:
				MenuManager.playerStatus(gameManager.getTotalAmountOfCaught(), gameManager.getTotalMassOfCaught(), gameManager.getBestOfTheCaught(), gameManager.getInventorySlot(), gameManager.getInventoryMaxSlot());
				break outerLoop;

			case 3:
				MenuManager.marketMenuMain();
				menuNumber = scanner.nextInt();
				switch (menuNumber) {
				case 1: System.out.println("satıldı");
				case 2: System.out.println("Olta alındı");
				case 3:	System.out.println("Slot alındı");
				case 0: 
					System.out.println("GERİ DÖNÜLDÜ");
				
				}
				break outerLoop;

			case 0:
				System.out.println("Çıkış yapılıyor.");
				System.exit(0);

			default:
				System.out.println("Hatalı seçim. Lütfen tekrar deneyin.");
			}
		}
	}
	
	
	private static int getValidInt(Scanner scanner) {
		while (!scanner.hasNextInt()) {
			System.out.println("Lütfen geçerli bir sayı giriniz.");
			scanner.next(); // invalid input temizle
		}
		return scanner.nextInt();
	}
	

}