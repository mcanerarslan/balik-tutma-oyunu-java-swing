import java.util.Scanner;

public class ControlManager {
	static String input;

	static boolean getValidString(Scanner scanner) {
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

	static int getValidInt(Scanner scanner) {
		while (!scanner.hasNextInt()) {
			System.out.println("Lütfen geçerli bir sayı giriniz.");
			scanner.next(); // hatalı girişi temizle
		}
		int value = scanner.nextInt();
		scanner.nextLine(); // satır sonunu temizle
		return value;
	}

}

