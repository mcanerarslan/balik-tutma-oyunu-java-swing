
public class TestCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int menuNumber = 10;
		switch (menuNumber) {
			case 1 -> System.out.println("1");
			case 2 -> System.out.println("2");
			case 3 -> System.out.println("3");
			case 0 -> {
				System.out.println("Çıkış yapılıyor.");
				System.exit(0);
			}
			default -> System.out.println("Hatalı seçim. Lütfen tekrar deneyin.");
		}

	}

}
