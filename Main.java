import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

//import javax.swing.Timer;

public class Main {

	public static void main(String[] args) {

		final Game game;
		if (SaveAndQuitTheGame.loadPlayerStats() != null) {
			game = SaveAndQuitTheGame.loadPlayerStats();
		} else {
			game = new Game(0.0, 0.0, 0, 100.0, 0, 3, 0, 0.0, 1);
		}

		JFrame frame = new JFrame("Fishing Village");

		JLabel welcomeTextJLabel = new JLabel("Fishing Village");
		welcomeTextJLabel.setBounds(105, 75, 250, 40);
		welcomeTextJLabel.setFont(new Font("Arial", Font.BOLD, 30));
		welcomeTextJLabel.setForeground(Color.white);

		JButton btn1 = new JButton("Oyunu Başlat");
		btn1.setBounds(125, 200, 150, 30);
//		btn1.setBackground(new Color(165, 42, 42));
//		btn1.setForeground(Color.white);

		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame fishingAreaFrame = new JFrame("Nehir Kenarı");

				JLabel fishingArea = new JLabel(new ImageIcon("assets/background-game.jpg"));
				fishingArea.setBounds(0, 0, 400, 500);

				JLabel infoAboutFish = new JLabel();
				infoAboutFish.setBounds(10, 10, 200, 30);
				infoAboutFish.setForeground(Color.BLUE);
				infoAboutFish.setFont(new Font("Arial", Font.BOLD, 24));

				JLabel fishingRodImage = new JLabel(new ImageIcon("assets/olta1.png"));
				fishingRodImage.setBounds(30, -20, 400, 500);

				JButton catchFishAgain = new JButton("Olta At");
				catchFishAgain.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						double massOfFish = game.startFishing();
						if (massOfFish == 0) {
							infoAboutFish.setText("Kova Doldu");
						} else {

							infoAboutFish.setText("KG: " + massOfFish);
						}
					}
				});
				catchFishAgain.setBounds(275, 10, 120, 30);

				fishingAreaFrame.add(catchFishAgain);
				fishingAreaFrame.add(infoAboutFish);
				fishingAreaFrame.add(createBackButton(fishingAreaFrame, game));
				fishingAreaFrame.add(fishingRodImage);

				fishingAreaFrame.add(fishingArea);
				fishingAreaFrame.getContentPane().setBackground(new Color(63, 188, 242));
				fishingAreaFrame.setSize(400, 500);
				fishingAreaFrame.setResizable(false);
				fishingAreaFrame.setLayout(null);
				fishingAreaFrame.setVisible(true);
			}
		});

		JButton btn2 = new JButton("İstatistikler");
		btn2.setBounds(125, 230, 150, 30);
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame statsFrame = new JFrame("İstatistikler");
				statsFrame.setSize(400, 500);

				JLabel storageArea = new JLabel(new ImageIcon("assets/background-stats.jpg"));
				storageArea.setBounds(0, 0, 400, 500);

				JLabel label1 = new JLabel();
				label1.setBounds(115, 50, 300, 30);
				label1.setText("Toplam Bakiye: " + game.getPlayerMoney());
				label1.setForeground(Color.white);

				JLabel label2 = new JLabel();
				label2.setBounds(115, 80, 300, 30);
				label2.setText("Toplam Tutulan Balık Adeti: " + game.getTotalAmountOfCaught());
				label2.setForeground(Color.white);

				JLabel label3 = new JLabel();
				label3.setBounds(115, 115, 300, 30);
				label3.setText("Toplam Tutulan Kütle: " + game.getTotalMassOfCaught());
				label3.setForeground(Color.white);

				JLabel label4 = new JLabel();
				label4.setBounds(115, 150, 300, 30);
				label4.setText("En Büyük Balık: " + game.getBestOfTheCaught());
				label4.setForeground(Color.white);

				JLabel label5 = new JLabel();
				label5.setBounds(115, 185, 300, 30);
				label5.setText("Slottaki Kilo: " + game.getCurrentlyTotalMassOfCaught());
				label5.setForeground(Color.white);

				JLabel label6 = new JLabel();
				label6.setBounds(115, 220, 300, 30);
				label6.setText("Envanter (Dolu/Max): " + game.getInventorySlot() + "/" + game.getInventoryMaxSlot());
				label6.setForeground(Color.white);

				JProgressBar slotBar = new JProgressBar(0, game.getInventoryMaxSlot());
				slotBar.setBounds(130, 245, 140, 30);
				slotBar.setValue(game.getInventorySlot());
				slotBar.setStringPainted(true);

				JLabel label7 = new JLabel();
				label7.setBounds(115, 280, 300, 30);
				label7.setText("Olta Tipi: " + game.getInventoryFishingRodType());
				label7.setForeground(Color.white);

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
						label7.setText("Olta Tipi: " + game.getInventoryFishingRodType());

						System.out.println("İstatistikler Güncellendi. - Düzgün Çalışmıyor");
					}
				});

				JButton resetStatsButton = new JButton("Sıfırla");
				resetStatsButton.setBounds(10, 10, 90, 30);
				resetStatsButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						game.resetStats();
						label1.setText("Toplam Bakiye: " + game.getPlayerMoney());
						label2.setText("Toplam Tutulan Balık Adeti: " + game.getTotalAmountOfCaught());
						label3.setText("Toplam Tutulan Kütle: " + game.getTotalMassOfCaught());
						label4.setText("En Büyük Balık: " + game.getBestOfTheCaught());
						label5.setText("Slottaki Kilo: " + game.getCurrentlyTotalMassOfCaught());
						label6.setText(
								"Envanter (Dolu/Max): " + game.getInventorySlot() + "/" + game.getInventoryMaxSlot());
						slotBar.setValue(0);
						game.setInventoryFishingRodType(1);
						System.out.println("İstatistikler Sıfırlandı.");
					}
				});

				statsFrame.add(label1);
				statsFrame.add(label2);
				statsFrame.add(label3);
				statsFrame.add(label4);
				statsFrame.add(label5);
				statsFrame.add(label6);
				statsFrame.add(label7);

				statsFrame.add(createBackButton(statsFrame, game));
				statsFrame.add(reloadButton);
				statsFrame.add(resetStatsButton);
				statsFrame.add(slotBar);

				statsFrame.add(storageArea);

				statsFrame.setResizable(false);
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

						JLabel infoLabel = new JLabel();
						infoLabel.setBounds(100, 10, 400, 30);

						DefaultListModel<String> fishingRodType = new DefaultListModel<String>();
						fishingRodType.addElement("Başlangıç");
						fishingRodType.addElement("Amatör");
						fishingRodType.addElement("Profesyonel");
						fishingRodType.addElement("Efsanevi");

						JList<String> fishingRodList = new JList<>(fishingRodType);
						fishingRodList.setBounds(150, 150, 100, 75);
						fishingRodList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION); // BİR TANESİNİ
																										// SEÇMEK İÇİN
																										// KULLANILIR

						JButton buyFishingRodButton = new JButton("Satın Al");
						buyFishingRodButton.setBounds(150, 230, 100, 30);
						buyFishingRodButton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								if (fishingRodList.getSelectedIndex() != -1) {
									infoLabel.setText(fishingRodList.getSelectedValue());
									switch (fishingRodList.getSelectedValue()) {
									case "Başlangıç":
										game.setInventoryFishingRodType(1);
										System.out.println("Başlangıç " + game.getInventoryFishingRodType());
										break;
									case "Amatör":
										game.setInventoryFishingRodType(2);
										System.out.println("Amatör " + game.getInventoryFishingRodType());
										break;
									case "Profesyonel":
										game.setInventoryFishingRodType(3);
										System.out.println("Profesyonel " + game.getInventoryFishingRodType());
										break;
									case "Efsanevi":
										game.setInventoryFishingRodType(4);
										System.out.println("Efsanevi " + game.getInventoryFishingRodType());
										break;
									default:
										System.out.println("HATA OLUŞTU TEKRAR DENEYİN");
									}
								} else {
									infoLabel.setText("Lütfen Doğru Seçim Yapınız");
								}
							}
						});

						upgradeFishingRodFrame.add(infoLabel);
						upgradeFishingRodFrame.add(fishingRodList);
						upgradeFishingRodFrame.add(buyFishingRodButton);
						upgradeFishingRodFrame.add(createBackButton(upgradeFishingRodFrame, game));
						upgradeFishingRodFrame.setSize(400, 500);
						upgradeFishingRodFrame.setLayout(null);
						upgradeFishingRodFrame.setResizable(false);
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
						upgradeSlotFrame.setResizable(false);
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
				marketFrame.setResizable(false);
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

		frame.add(welcomeTextJLabel);
		frame.add(btn1);
		frame.add(btn2);
		frame.add(btn3);
		frame.add(btn4);
		frame.add(btn5);
		frame.setSize(400, 500);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(63, 188, 242));
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
