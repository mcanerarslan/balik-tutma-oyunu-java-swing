
//
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class Main {

	public static void main(String[] args) {


		final Game game;
		if (SaveAndQuitTheGame.loadPlayerStats() != null) {
		    game = SaveAndQuitTheGame.loadPlayerStats();
		} else {
		    game = new Game(0.0, 0.0, 0, 100.0, 0, 3, 0, 0.0);
		}
		
		JFrame frame = new JFrame("Fishing Village");

		JButton btn1 = new JButton("Oyunu Başlat");
		btn1.setBounds(125, 200, 150, 30);

		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame fishingAreaFrame = new JFrame("Nehir Kenarı");

				JLabel denemeJLabel = new JLabel("");
				denemeJLabel.setBounds(10, 10, 200, 30);

				JButton catchFishAgain = new JButton("Olta At");
				catchFishAgain.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						double massOfFish = game.startFishing();
//						game.startFishing();
						if (massOfFish == 0) {
							denemeJLabel.setText("DOLU");
						} else {
							denemeJLabel.setText("KG: " + massOfFish);
						}
					}
				});
				catchFishAgain.setBounds(275, 10, 120, 30);

				fishingAreaFrame.add(createBackButton(fishingAreaFrame, game));
				fishingAreaFrame.add(catchFishAgain);
				fishingAreaFrame.add(denemeJLabel);

				fishingAreaFrame.setSize(400, 500);
				fishingAreaFrame.setLayout(null);
				fishingAreaFrame.setVisible(true);

//				
//				Game game = new Game();
//				game.startFishing();
//				System.out.println("-----------");
//				denemeJLabel.setText("KG: " + game.startFishing());
			}
		});

		JButton btn2 = new JButton("İstatistikler");
		btn2.setBounds(125, 230, 150, 30);
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame statsFrame = new JFrame("İstatistikler");
				statsFrame.setSize(400, 500);

				JLabel label1 = new JLabel();
				label1.setBounds(115, 50, 300, 30);
				label1.setText("Toplam Bakiye: " + game.getPlayerMoney());

				JLabel label2 = new JLabel();
				label2.setBounds(115, 80, 300, 30);
				label2.setText("Toplam Tutulan Balık Adeti: " + game.getTotalAmountOfCaught());

				JLabel label3 = new JLabel();
				label3.setBounds(115, 115, 300, 30);
				label3.setText("Toplam Tutulan Kütle: " + game.getTotalMassOfCaught());

				JLabel label4 = new JLabel();
				label4.setBounds(115, 150, 300, 30);
				label4.setText("En Büyük Balık: " + game.getBestOfTheCaught());

				JLabel label5 = new JLabel();
				label5.setBounds(115, 185, 300, 30);
				label5.setText("Slottaki Kilo: " + game.getCurrentlyTotalMassOfCaught());

				JLabel label6 = new JLabel();
				label6.setBounds(115, 220, 300, 30);
				label6.setText("Envanter (Dolu/Max): " + game.getInventorySlot() + "/" + game.getInventoryMaxSlot());

				JProgressBar slotBar = new JProgressBar(0, game.getInventoryMaxSlot());
				slotBar.setBounds(130, 245, 140, 30);
				slotBar.setValue(game.getInventorySlot());
				slotBar.setStringPainted(true);

				JButton reloadButton = new JButton("Güncelle");
				reloadButton.setBounds(300, 10, 90, 30);
				reloadButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						label1.setText("Toplam Bakiye: " + game.getPlayerMoney());
						label2.setText("Toplam Tutulan Balık Adeti: " + game.getTotalAmountOfCaught());
						label3.setText("Toplam Tutulan Kütle: " + game.getTotalMassOfCaught());
						label4.setText("En Büyük Balık: " + game.getBestOfTheCaught());
						label5.setText("Slottaki Kilo: " + game.getCurrentlyTotalMassOfCaught());
						label6.setText(
								"Envanter (Dolu/Max): " + game.getInventorySlot() + "/" + game.getInventoryMaxSlot());
						slotBar.setValue(game.getInventorySlot());

						System.out.println("İstatistikler Güncellendi. - Düzgün Çalışmıyor");
					}
				});

				JButton resetStatsButton = new JButton("Sıfırla");
				resetStatsButton.setBounds(10, 10, 90, 30);
				resetStatsButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
//						game.setPlayerMoney(100);
//						game.setTotalAmountOfCaught(0);
//						game.setTotalMassOfCaught(0);
//						game.setBestOfTheCaught(0);
//						game.setCurrentlyTotalAmountOfCaught(0);
//						game.setCurrentlyTotalMassOfCaught(0);
//						game.setInventorySlot(0);
//						game.setInventoryMaxSlot(3);

						game.resetStats();

						label1.setText("Toplam Bakiye: " + game.getPlayerMoney());
						label2.setText("Toplam Tutulan Balık Adeti: " + game.getTotalAmountOfCaught());
						label3.setText("Toplam Tutulan Kütle: " + game.getTotalMassOfCaught());
						label4.setText("En Büyük Balık: " + game.getBestOfTheCaught());
						label5.setText("Slottaki Kilo: " + game.getCurrentlyTotalMassOfCaught());
						label6.setText(
								"Envanter (Dolu/Max): " + game.getInventorySlot() + "/" + game.getInventoryMaxSlot());
						slotBar.setValue(0);
						System.out.println("İstatistikler Sıfırlandı.");
					}
				});

				statsFrame.add(label1);
				statsFrame.add(label2);
				statsFrame.add(label3);
				statsFrame.add(label4);
				statsFrame.add(label5);
				statsFrame.add(label6);

				statsFrame.add(createBackButton(statsFrame, game));
				statsFrame.add(reloadButton);
				statsFrame.add(resetStatsButton);

				statsFrame.add(slotBar);
				statsFrame.setLayout(null);
				statsFrame.setVisible(true);
			}
		});

		JButton btn3 = new JButton("Market");
		btn3.setBounds(125, 260, 150, 30);
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame marketFrame = new JFrame("Market");

				JLabel infoLabel = new JLabel();
				infoLabel.setBounds(100, 10, 400, 30);

				JButton button1 = new JButton("Envanteri Sat");
				button1.setBounds(140, 150, 120, 30);
				button1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int secim = JOptionPane.showConfirmDialog(marketFrame,
								"Bu işlemi yapmak istediğinizden emin misiniz?", "Onay", JOptionPane.YES_NO_OPTION);
						if (secim == JOptionPane.YES_OPTION) { // Cevap evet ise
							infoLabel.setText("Satış işlemi başarıyla gerçekleştirildi.");
						} else {
							infoLabel.setText("Satiş işlemi iptal edildi.");
						}

					}
				});

				JButton button2 = new JButton("Olta Yükselt");
				button2.setBounds(140, 180, 120, 30);
				button2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JFrame upgradeFishingRodFrame = new JFrame("Olta Kategorisi");

						upgradeFishingRodFrame.add(createBackButton(upgradeFishingRodFrame, game));
						upgradeFishingRodFrame.setSize(400, 500);
						upgradeFishingRodFrame.setLayout(null);
						upgradeFishingRodFrame.setVisible(true);

					}
				});

				JButton button3 = new JButton("Depo Yükselt");
				button3.setBounds(140, 210, 120, 30);
				button3.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JFrame upgradeSlotFrame = new JFrame("Depo Kategorisi");

						upgradeSlotFrame.add(createBackButton(upgradeSlotFrame, game));
						upgradeSlotFrame.setSize(400, 500);
						upgradeSlotFrame.setLayout(null);
						upgradeSlotFrame.setVisible(true);

					}
				});

				marketFrame.add(infoLabel);
				marketFrame.add(button1);
				marketFrame.add(button2);
				marketFrame.add(button3);
				marketFrame.add(createBackButton(marketFrame, game));
				marketFrame.setSize(400, 500);
				marketFrame.setLayout(null);
				marketFrame.setVisible(true);
			}
		});

		JButton btn4 = new JButton("Görevler");
		btn4.setBounds(125, 290, 150, 30);

		JButton btn5 = new JButton("Oyundan Çık");
		btn5.setBounds(125, 320, 150, 30);
		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SaveAndQuitTheGame.savePlayerStats(game);
				System.exit(0);
			}
		});

//		ImageIcon backgroundImage = new ImageIcon("arka_plan.jpg");
//		JLabel backgroundLabel = new JLabel(backgroundImage);
//		frame.setContentPane(backgroundLabel);

		frame.add(btn1);
		frame.add(btn2);
		frame.add(btn3);
		frame.add(btn4);
		frame.add(btn5);
		frame.setSize(400, 500);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	private static JButton createBackButton(JFrame frame, Game game) {
		JButton backButton = new JButton("Geri Dön");
		backButton.setBounds(125, 400, 150, 30);
		backButton.addActionListener(e -> {
			SaveAndQuitTheGame.savePlayerStats(game);
			frame.dispose();// pencereyi kapatır
		});
		return backButton;
	}

}
