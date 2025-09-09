import java.util.Scanner;

public class ControlManager {


	static boolean askYesOrNo(Scanner scanner) {
		String input;
		while (true) {
			input = scanner.nextLine().trim().toUpperCase();
			if (input.equals("E") || input.equals("EVET")) {
				return true;
			}
			if (input.equals("H") || input.equals("HAYIR")) {
				return false;
			}
			System.out.println("Lütfen sadece 'Evet', 'Hayır', 'E' veya 'H' giriniz.");
		}
	}

	static int askForInteger(Scanner scanner) {
		while (!scanner.hasNextInt()) {
			System.out.println("Lütfen geçerli bir sayı giriniz.");
			scanner.next(); // Geçersiz girişten gelen metni temizler
		}
		int value = scanner.nextInt();
		scanner.nextLine(); // sayıdan sonra gelen satırı temizler
		return value;
	}
	
	static void waitForAction(Scanner scanner) {
		System.out.println("\nDevam etmek için \"ENTER\" tuşana basın...");
	    scanner.nextLine();
	}

}

