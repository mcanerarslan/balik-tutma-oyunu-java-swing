
public class MenuManager{

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

	static void marketMenuMain(double playerMoney,double first,double second,double third) {
		System.out.println("╔════════════════════════════════════════════╗");
		System.out.printf("║             MARKET - %.2f TL             ║\n",playerMoney);
		System.out.println("╠════════════════════════════════════════════╣");
		System.out.printf("║ 1 - Envanteri Sat\t(%.2f TL)\t     ║\n",first);
		System.out.printf("║ 2 - Olta Yükselt\t(%.2f TL)\t     ║\n",second);
		System.out.printf("║ 3 - Depo Yükselt\t(%.2f TL)\t     ║\n",third);
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
