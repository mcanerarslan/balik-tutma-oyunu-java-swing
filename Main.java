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
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {

		final Game game;
		if (SaveAndQuitTheGame.loadPlayerStats() != null) {
			game = SaveAndQuitTheGame.loadPlayerStats();
		} else {
			game = new Game(0.0, 0.0, 0, 100.0, 0, 3, 0, 0.0, 1);
		}

		JFrame frame = new JFrame("Fishing Village");

		JLabel welcomeTextJLabel = new JLabel(new ImageIcon("assets/background-menu2.jpg"));
//		JLabel welcomeTextJLabel = new JLabel(new ImageIcon("assets/test.gif"));
		welcomeTextJLabel.setBounds(0, 0, 400, 500);

		JButton btn1 = new JButton("Oyunu Başlat");
		btn1.setBounds(125, 220, 150, 30);
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

							// hazır şablon kendin öğren mantığını
							new Thread(() -> {
								try {
//									fishingRodImage.setIcon(new ImageIcon("assets/olta2.png"));
//									Thread.sleep(1500);
//
//									SwingUtilities.invokeLater(
//											() -> fishingRodImage.setIcon(new ImageIcon("assets/olta3.png")));
//									Thread.sleep(1500);

									SwingUtilities.invokeLater(
											() -> fishingRodImage.setIcon(new ImageIcon("assets/olta1.png")));
									Thread.sleep(1000);

									SwingUtilities.invokeLater(() -> infoAboutFish.setText(massOfFish + " kg"));
								} catch (InterruptedException ex) {
									ex.printStackTrace();
								}
							}).start();

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
		btn2.setBounds(125, 250, 150, 30);
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
				label1.setFont(new Font("Arial", Font.BOLD, 15));

				JLabel label2 = new JLabel();
				label2.setBounds(115, 80, 300, 30);
				label2.setText("Toplam Tutulan Balık Adeti: " + game.getTotalAmountOfCaught());
				label2.setForeground(Color.white);
				label2.setFont(new Font("Arial", Font.BOLD, 15));

				JLabel label3 = new JLabel();
				label3.setBounds(115, 115, 300, 30);
				label3.setText("Toplam Tutulan Kütle: " + game.getTotalMassOfCaught());
				label3.setForeground(Color.white);
				label3.setFont(new Font("Arial", Font.BOLD, 15));

				JLabel label4 = new JLabel();
				label4.setBounds(115, 150, 300, 30);
				label4.setText("En Büyük Balık: " + game.getBestOfTheCaught());
				label4.setForeground(Color.white);
				label4.setFont(new Font("Arial", Font.BOLD, 15));

				JLabel label5 = new JLabel();
				label5.setBounds(115, 185, 300, 30);
				label5.setText("Slottaki Kilo: " + game.getCurrentlyTotalMassOfCaught());
				label5.setForeground(Color.white);
				label5.setFont(new Font("Arial", Font.BOLD, 15));

				JLabel label6 = new JLabel();
				label6.setBounds(115, 220, 300, 30);
				label6.setText("Envanter (Dolu/Max): " + game.getInventorySlot() + "/" + game.getInventoryMaxSlot());
				label6.setForeground(Color.white);
				label6.setFont(new Font("Arial", Font.BOLD, 15));

				JProgressBar slotBar = new JProgressBar(0, game.getInventoryMaxSlot());
				slotBar.setBounds(130, 245, 140, 30);
				slotBar.setValue(game.getInventorySlot());
				slotBar.setStringPainted(true);

				JLabel label7 = new JLabel();
				label7.setBounds(115, 280, 300, 30);
				label7.setText("Olta Tipi: " + game.getInventoryFishingRodType());
				label7.setForeground(Color.white);
				label7.setForeground(Color.white);
				label7.setFont(new Font("Arial", Font.BOLD, 15));

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
		btn3.setBounds(125, 280, 150, 30);
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame marketFrame = new JFrame("Market");

				JLabel marketArea = new JLabel(new ImageIcon("assets/background-market.jpg"));
				marketArea.setBounds(0, 0, 400, 500);

				JLabel infoLabel = new JLabel();
				infoLabel.setBounds(100, 30, 400, 30);
				infoLabel.setFont(new Font("Arial", Font.BOLD, 15));
				infoLabel.setForeground(Color.orange);

				JLabel playerMoney = new JLabel("Para: " + game.getPlayerMoney() + "₺");
				playerMoney.setBounds(310, 10, 200, 30);
				playerMoney.setFont(new Font("Arial", Font.BOLD, 12));
				playerMoney.setForeground(Color.yellow);

				JButton button1 = new JButton("Envanteri Sat");
				button1.setBounds(140, 70, 120, 30);
				button1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int secim = JOptionPane.showConfirmDialog(marketFrame,
								"Bu işlemi yapmak istediğinizden emin misiniz?", "Onay", JOptionPane.YES_NO_OPTION);
						if (secim == JOptionPane.YES_OPTION) { // Cevap evet ise

							if (game.getCurrentlyTotalAmountOfCaught() != 0
									|| game.getCurrentlyTotalMassOfCaught() != 0) {
								double priceOfFish = game.getCurrentlyTotalMassOfCaught() * 0.90;
								game.increasePlayerMoney(priceOfFish);
								playerMoney.setText("Para: " + game.getPlayerMoney() + "₺");
								infoLabel.setText("Satış işlemi başarıyla gerçekleştirildi.");
								System.out.println("LOG - "+game.getCurrentlyTotalMassOfCaught() + " kilo balık "+priceOfFish+" TL'ye satıldı");
								game.setCurrentlyTotalAmountOfCaught(0);
								game.setCurrentlyTotalMassOfCaught(0);
								game.setInventorySlot(0);
							} else {
								infoLabel.setText("Mevcut balık bulunamadı.");
								System.out.println("HATA - Envanter Boş");
							}
						} else {
							infoLabel.setText("Satiş işleminden vazgeçildi.");
						}

					}
				});

				JButton button2 = new JButton("Olta Yükselt");
				button2.setBounds(140, 100, 120, 30);
				button2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JFrame upgradeFishingRodFrame = new JFrame("Olta Kategorisi");

						JLabel sellerArea = new JLabel(new ImageIcon("assets/background-fishingrod.jpg"));
						sellerArea.setBounds(0, 0, 400, 500);

						JLabel infoLabel = new JLabel();
						infoLabel.setBounds(100, 30, 400, 30);
						infoLabel.setFont(new Font("Arial", Font.BOLD, 15));
						infoLabel.setForeground(Color.orange);

						JLabel playerMoney = new JLabel("Para: " + game.getPlayerMoney() + "₺");
						playerMoney.setBounds(310, 10, 200, 30);
						playerMoney.setFont(new Font("Arial", Font.BOLD, 12));
						playerMoney.setForeground(Color.yellow);

						DefaultListModel<String> fishingRodType = new DefaultListModel<String>();
						fishingRodType.addElement("Başlangıç");
						fishingRodType.addElement("Amatör");
						fishingRodType.addElement("Profesyonel");
						fishingRodType.addElement("Efsanevi");

						JList<String> fishingRodList = new JList<>(fishingRodType);
						fishingRodList.setBounds(240, 225, 100, 75);
						fishingRodList.setOpaque(false);
						fishingRodList.setBackground(new Color(0, 0, 0, 0));
						fishingRodList.setForeground(Color.white);
						fishingRodList.setFont(new Font("Arial", Font.BOLD, 12));
						fishingRodList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION); // BİR TANESİNİ
																										// SEÇMEK İÇİN
																										// KULLANILIR

						JButton buyFishingRodButton = new JButton();
						buyFishingRodButton.setBounds(170, 320, 64, 64);
						buyFishingRodButton.setBorderPainted(false);
						buyFishingRodButton.setIcon(new ImageIcon("assets/buybutton.png"));
						buyFishingRodButton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								if (fishingRodList.getSelectedIndex() != -1) {
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
										return;
									}
									infoLabel.setText(
											fishingRodList.getSelectedValue() + " olta başarıyla satın alındı.");
								} else {
									infoLabel.setText("Lütfen Doğru Seçim Yapınız");
									return;
								}

							}
						});

						upgradeFishingRodFrame.add(infoLabel);
						upgradeFishingRodFrame.add(playerMoney);
						upgradeFishingRodFrame.add(fishingRodList);
						upgradeFishingRodFrame.add(buyFishingRodButton);
						upgradeFishingRodFrame.add(createBackButton(upgradeFishingRodFrame, game));
						upgradeFishingRodFrame.add(sellerArea);
						upgradeFishingRodFrame.setSize(400, 500);
						upgradeFishingRodFrame.setLayout(null);
						upgradeFishingRodFrame.setResizable(false);
						upgradeFishingRodFrame.setVisible(true);

					}
				});

				JButton button3 = new JButton("Depo Yükselt");
				button3.setBounds(140, 130, 120, 30);
				button3.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JFrame upgradeSlotFrame = new JFrame("Depo Kategorisi");

						JLabel sellerArea = new JLabel(new ImageIcon("assets/background-slot.jpg"));
						sellerArea.setBounds(0, 0, 400, 500);
						
						JLabel infoLabel = new JLabel();
						infoLabel.setBounds(100, 30, 400, 30);
						infoLabel.setFont(new Font("Arial", Font.BOLD, 15));
						infoLabel.setForeground(Color.orange);

						JLabel playerMoney = new JLabel("Para: " + game.getPlayerMoney() + "₺");
						playerMoney.setBounds(310, 10, 200, 30);
						playerMoney.setFont(new Font("Arial", Font.BOLD, 12));
						playerMoney.setForeground(Color.yellow);

						DefaultListModel<Integer> slots = new DefaultListModel<Integer>();
						slots.addElement(5);
						slots.addElement(15);
						slots.addElement(25);
						slots.addElement(35);

						JList<Integer> slotList = new JList<Integer>(slots);
						slotList.setBounds(175, 150, 50, 100);
						slotList.setOpaque(false);
						slotList.setBackground(new Color(0, 0, 0, 0));
						slotList.setFont(new Font("Arial", Font.BOLD, 16));
						slotList.setForeground(Color.white);
						slotList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
						
						JButton buyExtraSlotButton = new JButton();
						buyExtraSlotButton.setBounds(170, 340, 64, 64);
						buyExtraSlotButton.setBorderPainted(false);
						buyExtraSlotButton.setIcon(new ImageIcon("assets/buybutton.png"));

						upgradeSlotFrame.add(playerMoney);
						upgradeSlotFrame.add(infoLabel);
						upgradeSlotFrame.add(createBackButton(upgradeSlotFrame, game));
						upgradeSlotFrame.add(slotList);
						upgradeSlotFrame.add(buyExtraSlotButton);
						upgradeSlotFrame.add(sellerArea);
						upgradeSlotFrame.setSize(400, 500);
						upgradeSlotFrame.setLayout(null);
						upgradeSlotFrame.setResizable(false);
						upgradeSlotFrame.setVisible(true);

					}
				});

				marketFrame.add(infoLabel);
				marketFrame.add(playerMoney);
				marketFrame.add(button1);
				marketFrame.add(button2);
				marketFrame.add(button3);
				marketFrame.add(createBackButton(marketFrame, game));
				marketFrame.add(marketArea);
				marketFrame.setSize(400, 500);
				marketFrame.setLayout(null);
				marketFrame.setResizable(false);
				marketFrame.setVisible(true);
			}
		});

		JButton btn4 = new JButton("Görevler");
		btn4.setBounds(125, 310, 150, 30);
		btn4.setEnabled(false); // butonu pasif eder

		JButton btn5 = new JButton("Oyundan Çık");
		btn5.setBounds(125, 340, 150, 30);
		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SaveAndQuitTheGame.savePlayerStats(game);
				System.exit(0);
			}
		});

		frame.add(btn1);
		frame.add(btn2);
		frame.add(btn3);
		frame.add(btn4);
		frame.add(btn5);
		frame.add(welcomeTextJLabel);
		frame.setSize(400, 500);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	private static JButton createBackButton(JFrame frame, Game game) {
		JButton backButton = new JButton("Geri Dön");
		backButton.setBounds(125, 425, 150, 30);
		backButton.addActionListener(e -> {
			SaveAndQuitTheGame.savePlayerStats(game);
			frame.dispose();// pencereyi kapatır
		});
		return backButton;
	}

}
