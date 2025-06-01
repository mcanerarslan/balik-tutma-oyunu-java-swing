
public class MenuManager{

	int selectedMenuNumber;

	public MenuManager() {

	}

	static void printMainMenu() {
		System.out.println("╔════════════════════════════════════════════╗");
		System.out.println("║                  ANA MENÜ                  ║");
		System.out.println("╠════════════════════════════════════════════╣");
		System.out.println("║ 1 - Oyunu Başlat                           ║");
		System.out.println("║ 2 - İstatistikler                          ║");
		System.out.println("║ 3 - Market                                 ║");
		System.out.println("║ 0 - Oyunu Durdur                           ║");
		System.out.println("╚════════════════════════════════════════════╝");
	}

	static void marketMenuMain() {
		System.out.println("╔════════════════════════════════════════════╗");
		System.out.println("║                   MARKET                   ║");
		System.out.println("╠════════════════════════════════════════════╣");
		System.out.println("║ 1 - Envanteri Komple Sat                   ║");
		System.out.println("║ 2 - Olta Satın Al                          ║");
		System.out.println("║ 3 - Envanter Slotu Satın Al                ║");
		System.out.println("║ 0 - Geri Dön                               ║");
		System.out.println("╚════════════════════════════════════════════╝");
	}

	static void playerStatus(int totalAmountOfCaught, double totalMassOfCaught, double bestOfTheCaught,
			int inventorySlot, int inventoryMaxSlot,double currentlyTotalAmountOfCaught, double currentlyTotalMassOfCaught) {
		System.out.println("╔════════════════════════════════════════════╗");
		System.out.println("║            OYUNCU İSTATİSTİKLERİ           ║");
		System.out.println("╚════════════════════════════════════════════╝");
		System.out.println("Toplam Tutulan Balık Adeti: \t" + totalAmountOfCaught);
		System.out.println("Toplam Balık Kilogramı: \t" + totalMassOfCaught);
		System.out.println("En Büyük Balık: \t\t" + bestOfTheCaught);
		System.out.println("Envanter Durumu (Dolu / Max): \t" + inventorySlot + "/" + inventoryMaxSlot);
		System.out.println("Güncel Tutulan Balık Adeti: \t" + currentlyTotalAmountOfCaught);
		System.out.println("Güncel Balık Kilogramı: \t" + currentlyTotalMassOfCaught);
		System.out.println("╚════════════════════════════════════════════╝");
	}

	void startTheGame() {

	}
	
	static void playAgainYesOrNo() {
		System.out.println("╔════════════════════════════════════════════════╗");
		System.out.println("║ Tekrar oynamak ister misin? ([E]vet / [H]ayır) ║");
		System.out.println("╚════════════════════════════════════════════════╝");
	}
	
	public static void fakeClearConsole() {
	    for (int i = 0; i < 50; i++) {
	        System.out.println();
	    }
	}

}
