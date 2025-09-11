import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class SaveAndQuitTheGame {

	public static final String saveFilePath = System.getProperty("user.dir") + File.separator + "save" + File.separator
			+ "savegame.txt";

	public SaveAndQuitTheGame() {
		File file = new File(saveFilePath);
		
		if(!file.exists()) {
            System.out.println("Log - Kayıt bulunamadı, yeni oyun başlatılıyor.");
            
    		String directoryPath = System.getProperty("user.dir") + File.separator + "save";
    		File directory = new File(directoryPath);

    		if (!directory.exists()) {
    			directory.mkdir();
    		}

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
	}
	
	public static String getSaveFilePath() {
		return saveFilePath;
	}
	
	public static void savePlayerStats(Game stats) {
		
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

	        System.out.println("Log - Oyuncu verileri başarıyla kaydedildi.");
	    } catch (IOException e) {
	        System.err.println("HATA - Kaydederken sorun oluştu: " + e.getMessage());
	    }
	}
	
    public static Game loadPlayerStats() {
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

            return new Game(totalMass, bestFish, amount, money, slot, maxSlot,currentlyAmount,currentlyTotalMass);

        } catch (IOException | NumberFormatException e) {
            System.err.println("HATA - Kayıt okunamadı: " + e.getMessage());
            return null;
        }
    }


	
	

}