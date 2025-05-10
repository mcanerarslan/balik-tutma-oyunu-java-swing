
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int fishingRodType = 1; // değişecek

		Random random = new Random();
		Scanner scanner = new Scanner(System.in);

		// istatistik bilgileri
		double totalMassOfCaught = 0;
		double bestOfTheCaught = 0;
		int totalAmountOfCaught = 0;
		double successRate = 0;
		int inventorySlot = 0;
		double playerMoney = 0;

		int menuNumber = 0;

		// oyun düzenleri
		int inventoryMaxSlot = 3;

		mainMenu();
		menuNumber = scanner.nextInt();
//		MenuManager.startMenuSelect(menuNumber);

		if (menuNumber == 1) {
			double number = random.nextInt(10) + 1;
			String tryAgain = "";

			do {
				switch (fishingRodType) {
				case 1 -> successRate = number * 0.3;
				case 2 -> successRate = number * 0.5;
				case 3 -> successRate = number * 0.7;
				case 4 -> successRate = number * 0.9;
				default -> System.out.println("hata var");
				}

				// balık tutma kısmı
				if (fishingRodType == 1 || fishingRodType == 2 || fishingRodType == 3 || fishingRodType == 4) {

					if (inventoryMaxSlot > inventorySlot) {

						System.out.println("Balık oltaya takılıyor... 🎣");

						double changeOfMass = random.nextDouble(10) + 1;
						double massOfFish = successRate * changeOfMass;
						// System.out.printf("Şans Sayısı: %.0f | Çarpan: %.2f | Kütle: %.2f kg\n",
						// number, changeOfMass, massOfFish);

//						try {
//							Thread.sleep(2000); // 2 saniye bekle
//						} catch (InterruptedException e) {
//							e.printStackTrace(); // Hata olursa çıktısını al
//						}
						System.out.println("Balığı çektin! " + String.format("%.2f", massOfFish) + " kg 🐠");

						// en iyisi mi ve total kütle hesabı
						totalMassOfCaught += massOfFish;

						if (bestOfTheCaught < massOfFish) {
							bestOfTheCaught = massOfFish;
							System.out.println("Şuana kadarki en büyük balığını tuttun. tebrikler");
						}
						++inventorySlot; // envanter artışı
						++totalAmountOfCaught;
					} else {
						System.out.println("Envanterin dolu");
						break;
					}
				}
				System.out.println("╔════════════════════════════════════════════════╗");
				System.out.println("║ Tekrar oynamak ister misin? ([E]vet / [H]ayır) ║");
				System.out.println("╚════════════════════════════════════════════════╝");
				tryAgain = scanner.next().trim().toUpperCase();
				if(tryAgain.equalsIgnoreCase("H")) {
					returnMainMenu();
				}
				
			} while (tryAgain.equalsIgnoreCase("E"));
			mainMenu();
			menuNumber = scanner.nextInt();
		}
		
		if(menuNumber ==2) {
		    System.out.println("╔════════════════════════════╗");
		    System.out.println("║        İSTATİSTİKLER       ║");
		    System.out.println("╚════════════════════════════╝");
			System.out.println("* Tutulan Balık Adeti: "+totalAmountOfCaught);
			System.out.println("* Tutulan Balık Kilogramı: "+totalMassOfCaught);
			System.out.println("* Tutulan En iyi Kilogram: "+bestOfTheCaught);
			System.out.println("* Envanter: "+inventorySlot+"/"+inventoryMaxSlot);
		}
		if(menuNumber == 0) {
			System.out.println("Çıkış yapılıyor.");
			System.exit(1);
		}

	}
	
	public static void mainMenu() {
	    System.out.println("╔══════════════════════════════════════╗");
	    System.out.println("║              	ANA MENÜ               ║");
	    System.out.println("╠══════════════════════════════════════╣");
	    System.out.println("║ 1 - Oyunu Başlat                     ║");
	    System.out.println("║ 2 - İstatistikler                    ║");
	    System.out.println("║ 3 - Market                           ║");
	    System.out.println("║ 0 - Oyunu Durdur                     ║");
	    System.out.println("╚══════════════════════════════════════╝");
	}
	
	public static void returnMainMenu() {
		System.out.println("Menüye dönülüyor.");
		mainMenu();
		
	}

}
