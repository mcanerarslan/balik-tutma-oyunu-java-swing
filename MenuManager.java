
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
		System.out.println("║ 1 - Envanteri Sat                          ║");
		System.out.println("║ 2 - Olta Yükseltmesi Al (yakında)          ║");
		System.out.println("║ 3 - Depo Kapasitesi Yükselt Al             ║");
		System.out.println("║ 0 - Geri Dön                               ║");
		System.out.println("╚════════════════════════════════════════════╝");
	}

	static void playerStatus(int totalAmountOfCaught, double totalMassOfCaught, double bestOfTheCaught,
			int inventorySlot, int inventoryMaxSlot,int currentlyTotalAmountOfCaught, double currentlyTotalMassOfCaught,double playerMoney) {
		System.out.println("╔════════════════════════════════════════════╗");
		System.out.println("║            OYUNCU İSTATİSTİKLERİ           ║");
		System.out.println("╠════════════════════════════════════════════╝");
		System.out.printf("║ Toplam Bakiye:\t\t%.2f\tTL\n", playerMoney);
		System.out.printf("║ Toplam Tutulan Balık Adeti:\t%d\tAdet\n", totalAmountOfCaught);
		System.out.printf("║ Toplam Tutulan Kütle:\t\t%.2f\tkg\n", totalMassOfCaught);
		System.out.printf("║ En Büyük Balık:\t\t%.2f\tkg\n", bestOfTheCaught);
//		System.out.printf("║ Slottaki Balık Adeti:\t\t%d\n", currentlyTotalAmountOfCaught);
		System.out.printf("║ Slottaki Balık Kilo:\t\t%.2f\tkg\n", currentlyTotalMassOfCaught);
		System.out.printf("║ Envanter Durumu (Dolu / Max):\t%d / %d\n", inventorySlot, inventoryMaxSlot);
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
