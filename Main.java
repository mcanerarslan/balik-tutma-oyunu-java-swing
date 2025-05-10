import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int fishingRodType = 1; // Değiştirilebilir
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);

		// İstatistik bilgileri
		double totalMassOfCaught = 0;
		double bestOfTheCaught = 0;
		int totalAmountOfCaught = 0;
		double successRate = 0;
		int inventorySlot = 0;
		double playerMoney = 0;
		int inventoryMaxSlot = 3;

		outerLoop: // döngü dışına çıkmak için label etiket atadık.
		while (true) {
			mainMenu();
			System.out.print("Bir seçim yapınız: ");

			int menuNumber = -1;
			if (scanner.hasNextInt()) {
				menuNumber = scanner.nextInt();
			} else {
				System.out.println("Lütfen geçerli bir sayı giriniz.");
				scanner.next(); // hatalı girdiyi temizle
				continue;
			}

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

					if (inventorySlot < inventoryMaxSlot) {
						System.out.println("Balık oltaya takılıyor... 🎣");
						double changeOfMass = random.nextDouble(10) + 1;
						double massOfFish = successRate * changeOfMass;
						System.out.println("Balığı çektin! " + String.format("%.2f", massOfFish) + " kg 🐠");

						totalMassOfCaught += massOfFish;
						if (bestOfTheCaught < massOfFish) {
							bestOfTheCaught = massOfFish;
							System.out.println("Şu ana kadarki en büyük balığını tuttun. Tebrikler!");
						}
						inventorySlot++;
						totalAmountOfCaught++;
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
				System.out.println("╔════════════════════════════════════════════╗");
				System.out.println("║            OYUNCU İSTATİSTİKLERİ           ║");
				System.out.println("╚════════════════════════════════════════════╝");
				System.out.println("Toplam Tutulan Balık Adeti: \t" + totalAmountOfCaught);
				System.out.println("Toplam Balık Kilogramı: \t" + totalMassOfCaught);
				System.out.println("En Büyük Balık: \t\t" + bestOfTheCaught);
				System.out.println("Envanter Durumu (Dolu / Max): \t" + inventorySlot + "/" + inventoryMaxSlot);
				break outerLoop;

			case 3:
				marketMenuMain();
				break outerLoop;

			case 0:
				System.out.println("Çıkış yapılıyor.");
				System.exit(0);

			default:
				System.out.println("Hatalı seçim. Lütfen tekrar deneyin.");
			}
		}
	}

	public static void mainMenu() {
		System.out.println("╔════════════════════════════════════════════╗");
		System.out.println("║                  ANA MENÜ                  ║");
		System.out.println("╠════════════════════════════════════════════╣");
		System.out.println("║ 1 - Oyunu Başlat                           ║");
		System.out.println("║ 2 - İstatistikler                          ║");
		System.out.println("║ 3 - Market                                 ║");
		System.out.println("║ 0 - Oyunu Durdur                           ║");
		System.out.println("╚════════════════════════════════════════════╝");
	}

	public static void marketMenuMain() {
		System.out.println("╔════════════════════════════════════════════╗");
		System.out.println("║                   MARKET                   ║");
		System.out.println("╠════════════════════════════════════════════╣");
		System.out.println("║ 1 - Envanteri Komple Sat                   ║");
		System.out.println("║ 2 - Olta Satın Al                          ║");
		System.out.println("║ 3 - Envanter Slotu Satın Al                ║");
		System.out.println("║ 0 - Geri Dön                               ║");
		System.out.println("╚════════════════════════════════════════════╝");
	}

}