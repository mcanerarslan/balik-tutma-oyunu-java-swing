import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaveAndQuitTheGame {
	
	private static final String saveFilePath = System.getProperty("user.dir")+ File.separator + "save" + File.separator + "savegame.txt";


    public static PlayerStats loadPlayerStats() {
        File file = new File(saveFilePath);

        if (!file.exists()) {
            System.out.println("Log - Kayıt bulunamadı, yeni oyun başlatılıyor.");
            return null;
        }

        try (Scanner reader = new Scanner(file)) {
            double totalMass = Double.parseDouble(reader.nextLine());
            double bestFish = Double.parseDouble(reader.nextLine());
            int amount = Integer.parseInt(reader.nextLine());
            double money = Double.parseDouble(reader.nextLine());
            int slot = Integer.parseInt(reader.nextLine());
            int maxSlot = Integer.parseInt(reader.nextLine());
            int currentlyAmount = Integer.parseInt(reader.nextLine());
            double currentlyTotalMass = Double.parseDouble(reader.nextLine());
            int fishingRodType = Integer.parseInt(reader.nextLine());

            return new PlayerStats(totalMass, bestFish, amount, money, slot, maxSlot,currentlyAmount,currentlyTotalMass,fishingRodType);

        } catch (IOException | NumberFormatException e) {
            System.err.println("HATA - Kayıt okunamadı: " + e.getMessage());
            return null;
        }
    }
	
	public void createFile() {

		String directoryPath = System.getProperty("user.dir") + File.separator + "save";
		File directory = new File(directoryPath);

		if (!directory.exists()) {
			directory.mkdir();
		}

		File file = new File(saveFilePath);

		try {
			if (file.createNewFile()) {
				System.out.println("Log - Dosya oluşturuldu: " + file.getAbsolutePath());
			} else {
				System.out.println("Log - Dosya zaten var. " + file.getAbsolutePath());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// public static void readFile() {
	// 	File file = new File(saveFilePath);

	// 	// try-with-resources bloğu kullanılarak dosya güvenli şekilde okunur
	// 	try (Scanner reader = new Scanner(file)) {
	// 		if (!reader.hasNextLine()) {
	// 			System.out.println("Log - Dosyanın içerisi boş.");
	// 			return;
	// 		}
	// 		while (reader.hasNextLine()) {
	// 			// Dosyada bir sonraki satır var mı kontrol edilir, varsa yazdırılır
	// 			String line = reader.nextLine();
	// 			System.out.println(line);
	// 		}
	// 	} catch (FileNotFoundException e) {
	// 		// Daha açıklayıcı hata mesajı
	// 		System.err.println("Dosya bulunamadı: " + file.getAbsolutePath());
	// 	}
	// }

	// public static void writeFile(String info) {

	// 	try {
	// 		BufferedWriter writer = new BufferedWriter(new FileWriter(
	// 				System.getProperty("user.dir") + File.separator + "save" + File.separator + "savegame.txt"));
	// 		writer.write(info);
	// 		System.out.println("Log - Dosyaya yazıldı.");
	// 		writer.close();
	// 	} catch (IOException e) {
	// 		System.err.println("Log - Dosya yazılırken hata oluştu: " + e.getMessage());
	// 	}

	// }
	
	public static String getSaveFilePath() {
		return saveFilePath;
	}
	
	public static void savePlayerStats(PlayerStats stats) {
		
	    File directory = new File(System.getProperty("user.dir") + File.separator + "save");
	    if (!directory.exists()) {
	        directory.mkdir();
	    }

	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(getSaveFilePath()))) {
	        writer.write(stats.getTotalMassOfCaught() + "\n");
	        writer.write(stats.getBestOfTheCaught() + "\n");
	        writer.write(stats.getTotalAmountOfCaught() + "\n");
	        writer.write(stats.getPlayerMoney() + "\n");
	        writer.write(stats.getInventorySlot() + "\n");
	        writer.write(stats.getInventoryMaxSlot() + "\n");
	        writer.write(stats.getCurrentlyTotalAmountOfCaught() + "\n");
	        writer.write(stats.getCurrentlyTotalMassOfCaught() + "\n");
	        writer.write(stats.getFishingRodType() + "\n");

	        System.out.println("Log - Oyuncu verileri başarıyla kaydedildi.");
	    } catch (IOException e) {
	        System.err.println("HATA - Kaydederken sorun oluştu: " + e.getMessage());
	    }
	}

}
