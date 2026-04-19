import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.net.URL;

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

//	private static ImageIcon coinIcon = new ImageIcon("assets/coin.png");
	private static URL returnIcon = Main.class.getResource("assets/return.png");
	private static URL logoImg = Main.class.getResource("/assets/logo.png");
	private static URL backgroundMenuImg = Main.class.getResource("/assets/background-menu.png");
	private static URL backgroundGameImg = Main.class.getResource("assets/background-game.png");
	private static URL backgroundStatsImg = Main.class.getResource("assets/background-stats.png");
	private static URL backgroundMarketImg = Main.class.getResource("assets/background-market.png");
	private static URL backgroundFishingImg = Main.class.getResource("assets/background-fishingrod.png");
	private static URL backgroundSlotImg = Main.class.getResource("assets/background-slot.png");
	private static URL olta1Img = Main.class.getResource("assets/olta1.png");
	private static URL olta2Img = Main.class.getResource("assets/olta2.png");
	private static URL olta3Img = Main.class.getResource("assets/olta3.png");
	private static URL olta4Img = Main.class.getResource("assets/olta4.png");
	private static URL refreshIcon = Main.class.getResource("assets/refresh.png");
	private static URL deleteIcon = Main.class.getResource("assets/delete.png");
	private static URL buyIcon = Main.class.getResource("assets/buybutton.png");

	public static void main(String[] args) {

		int frameHeight = 500, frameWidth = 500;

		final Game game;
		if (SaveAndQuitTheGame.loadPlayerStats() != null) {
			game = SaveAndQuitTheGame.loadPlayerStats();
		} else {
			game = new Game(0.0, 0.0, 0, 100.0, 0, 3, 0, 0.0, 1);
		}

		Inventory inventory = new Inventory();

		JFrame frame = new JFrame("Fishing Village");

		JLabel backgroundMenu = new JLabel(new ImageIcon(backgroundMenuImg));
		backgroundMenu.setBounds(0, 0, 500, 500);

		JLabel welcomeLogo = new JLabel(new ImageIcon(logoImg));
		welcomeLogo.setBounds(150, 70, 200, 88);

		JLabel coderLabel = new JLabel("made by dyanesa <3",JLabel.RIGHT);
		coderLabel.setBounds(290, 450, 200, 30);
		coderLabel.setFont(new Font("Arial", Font.BOLD, 12));
		coderLabel.setForeground(Color.getHSBColor(209, 212, 194));

		JButton btn1 = new JButton("Oyunu Başlat");
		JButton btn2 = new JButton("İstatistikler");
		JButton btn3 = new JButton("Market");
		JButton btn4 = new JButton("Görevler");
		btn4.setEnabled(false); // butonu pasif eder
		JButton btn5 = new JButton("Oyundan Çık");

		int buttonYAxis = 280;
		JButton[] buttons = { btn1, btn2, btn3, btn4, btn5 };
		for (JButton button : buttons) {
			button.setOpaque(false);
			button.setBorderPainted(false);
			button.setFocusPainted(false);
			button.setContentAreaFilled(false);
			button.setFont(new Font("Arial", Font.BOLD, 20));
			button.setForeground(Color.white);
			button.setHorizontalAlignment(JButton.CENTER);
			button.setVerticalAlignment(JButton.CENTER);
			button.setBounds(150, buttonYAxis, 200, 30);
			buttonYAxis += 30;
			frame.add(button);
		}

		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame fishingAreaFrame = new JFrame("Nehir Kenarı");

				JLabel fishingArea = new JLabel(new ImageIcon(backgroundGameImg));
				fishingArea.setBounds(0, 0, frameWidth, frameHeight);
				
				JLabel fishingRodImage = new JLabel(new ImageIcon(olta1Img));
				fishingRodImage.setBounds(0, 0, 500, 500);

				JLabel infoAboutFish = new JLabel();
				infoAboutFish.setBounds(100, 120, 300, 30);
				infoAboutFish.setForeground(new Color(78, 52, 46));
				infoAboutFish.setFont(new Font("Arial", Font.BOLD, 24));
				infoAboutFish.setHorizontalAlignment(JLabel.CENTER);
				infoAboutFish.setVerticalAlignment(JLabel.CENTER);
				
				JLabel fishTypeJlJLabel = new JLabel();
				fishTypeJlJLabel.setBounds(50, 150, 400, 30);
				fishTypeJlJLabel.setForeground(new Color(45, 52, 54));
				fishTypeJlJLabel.setFont(new Font("Arial", Font.BOLD, 24));
				fishTypeJlJLabel.setHorizontalAlignment(JLabel.CENTER);
				fishTypeJlJLabel.setVerticalAlignment(JLabel.CENTER);

				JButton catchFishAgain = new JButton("Olta At");
				catchFishAgain.setBounds(375, 10, 120, 30);
				catchFishAgain.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						catchFishAgain.setEnabled(false);
						
						double massOfFish = game.startFishing();
						
						if (massOfFish == 0) {
							infoAboutFish.setText("Kova Doldu");
						} else {

							new Thread(() -> {
								try {
									fishingRodImage.setIcon(new ImageIcon(olta2Img));
									Thread.sleep(1500);

									SwingUtilities.invokeLater(
											() -> fishingRodImage.setIcon(new ImageIcon(olta3Img)));
									Thread.sleep(1500);

									SwingUtilities.invokeLater(
											() -> fishingRodImage.setIcon(new ImageIcon(olta4Img)));
									Thread.sleep(1000);

									SwingUtilities.invokeLater(() -> {
										catchFishAgain.setEnabled(true);
										infoAboutFish.setText(massOfFish + " kg büyüklüğünde");
										fishTypeJlJLabel.setText("\""+game.getRandomFishName(massOfFish)+"\"" +" tuttun.");
										});
								} catch (InterruptedException ex) {
									catchFishAgain.setEnabled(true);
									ex.printStackTrace();
								}
							}).start();

						}
					}
				});

				fishingAreaFrame.add(catchFishAgain);
				fishingAreaFrame.add(infoAboutFish);
				fishingAreaFrame.add(createBackButton(fishingAreaFrame, game));
				fishingAreaFrame.add(fishTypeJlJLabel);
				fishingAreaFrame.add(fishingRodImage);

				fishingAreaFrame.add(fishingArea);
				fishingAreaFrame.getContentPane().setBackground(new Color(63, 188, 242));
				fishingAreaFrame.setSize(frameWidth, frameHeight);
				fishingAreaFrame.setResizable(false);
				fishingAreaFrame.setLayout(null);
				fishingAreaFrame.setLocationRelativeTo(frame);
				fishingAreaFrame.setVisible(true);
			}
		});

		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame statsFrame = new JFrame("İstatistikler");
				statsFrame.setSize(frameWidth, frameHeight);

				JLabel storageArea = new JLabel(new ImageIcon(backgroundStatsImg));
				storageArea.setBounds(0, 0, frameWidth, frameHeight);
				
				JLabel label1 = new JLabel();
				label1.setText("Toplam Bakiye: " + game.showPlayerMoney());

				JLabel label2 = new JLabel();
				label2.setText("Toplam Tutulan Balık Adeti: " + game.getTotalAmountOfCaught());

				JLabel label3 = new JLabel();
				label3.setText("Toplam Tutulan Kütle: " + game.getTotalMassOfCaught());

				JLabel label4 = new JLabel();
				label4.setText("En Büyük Balık: " + game.getBestOfTheCaught());

				JLabel label5 = new JLabel();
				label5.setText("Slottaki Kilo: " + game.getCurrentlyTotalMassOfCaught());

				JLabel label6 = new JLabel();
				label6.setText("Olta Tipi: " + game.getInventoryFishingRodType());

				JLabel label7 = new JLabel();
				label7.setText("Envanter (Dolu/Max): " + game.getInventorySlot() + "/" + game.getInventoryMaxSlot());

				int labelYAxis = 90;
				JLabel[] labels = {label1,label2,label3,label4,label5,label6,label7};
				for(JLabel label:labels) {
					label.setOpaque(false);
					label.setHorizontalAlignment(JLabel.CENTER);
					label.setVerticalAlignment(JLabel.CENTER);
					label.setForeground(Color.white);
					label.setFont(new Font("Arial", Font.BOLD, 15));
					label.setBounds(100, labelYAxis, 300, 30);
					labelYAxis+=30;
					statsFrame.add(label);
				}
				
				JProgressBar slotBar = new JProgressBar(0, game.getInventoryMaxSlot());
				slotBar.setBounds(180, 300, 140, 30);
				slotBar.setValue(game.getInventorySlot());
				slotBar.setStringPainted(true);
				slotBar.setForeground(Color.white);
				
				JButton reloadButton = new JButton(new ImageIcon(refreshIcon));
				reloadButton.setBounds(458, 10, 32, 32);
				reloadButton.setOpaque(false);
				reloadButton.setBorderPainted(false);
				reloadButton.setFocusPainted(false);
				reloadButton.setContentAreaFilled(false);
				reloadButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						label1.setText("Toplam Bakiye: " + game.showPlayerMoney());
						label2.setText("Toplam Tutulan Balık Adeti: " + game.getTotalAmountOfCaught());
						label3.setText("Toplam Tutulan Kütle: " + game.getTotalMassOfCaught());
						label4.setText("En Büyük Balık: " + game.getBestOfTheCaught());
						label5.setText("Slottaki Kilo: " + game.getCurrentlyTotalMassOfCaught());
						label6.setText("Olta Tipi: " + game.getInventoryFishingRodType());
						label7.setText(
								"Envanter (Dolu/Max): " + game.getInventorySlot() + "/" + game.getInventoryMaxSlot());
						slotBar.setValue(game.getInventorySlot());


						System.out.println("İstatistikler Güncellendi. - Düzgün Çalışmıyor");
					}
				});

				JButton resetStatsButton = new JButton(new ImageIcon(deleteIcon));
				resetStatsButton.setBounds(10, 10, 32, 32);
				resetStatsButton.setOpaque(false);
				resetStatsButton.setBorderPainted(false);
				resetStatsButton.setFocusPainted(false);
				resetStatsButton.setContentAreaFilled(false);
				resetStatsButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						game.resetStats();
						label1.setText("Toplam Bakiye: " + game.showPlayerMoney());
						label2.setText("Toplam Tutulan Balık Adeti: " + game.getTotalAmountOfCaught());
						label3.setText("Toplam Tutulan Kütle: " + game.getTotalMassOfCaught());
						label4.setText("En Büyük Balık: " + game.getBestOfTheCaught());
						label5.setText("Slottaki Kilo: " + game.getCurrentlyTotalMassOfCaught());
						label6.setText("Olta Tipi: " + game.getInventoryFishingRodType());
						label7.setText(
								"Envanter (Dolu/Max): " + game.getInventorySlot() + "/" + game.getInventoryMaxSlot());
						slotBar.setValue(0);
						game.setInventoryFishingRodType(1);
						System.out.println("İstatistikler Sıfırlandı.");
					}
				});

				statsFrame.add(createBackButton(statsFrame, game));
				statsFrame.add(reloadButton);
				statsFrame.add(resetStatsButton);
				statsFrame.add(slotBar);

				statsFrame.add(storageArea);

				statsFrame.setResizable(false);
				statsFrame.setLayout(null);
				statsFrame.setLocationRelativeTo(frame);
				statsFrame.setVisible(true);

			}
		});

		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame marketFrame = new JFrame("Market");

				JLabel marketArea = new JLabel(new ImageIcon(backgroundMarketImg));
				marketArea.setBounds(0, 0, frameWidth, frameHeight);

				JLabel infoLabel = new JLabel();
				infoLabel.setBounds(50, 30, 400, 30);
				infoLabel.setFont(new Font("Arial", Font.BOLD, 15));
				infoLabel.setForeground(Color.orange);
				infoLabel.setVerticalAlignment(JLabel.CENTER);
				infoLabel.setHorizontalAlignment(JLabel.CENTER);

				JLabel marketMenuPlayerMoney = new JLabel("Para: " + game.showPlayerMoney() + "₺");
				marketMenuPlayerMoney.setBounds(410, 10, 200, 30);
				marketMenuPlayerMoney.setFont(new Font("Arial", Font.BOLD, 12));
				marketMenuPlayerMoney.setForeground(Color.yellow);

				JButton button1 = new JButton("Envanteri Sat");
				button1.setBounds(190, 70, 120, 30);
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
								marketMenuPlayerMoney.setText("Para: " + game.showPlayerMoney() + "₺");
								infoLabel.setText("Satış işlemi başarıyla gerçekleştirildi.");
								System.out.println("LOG - " + game.getCurrentlyTotalMassOfCaught() + " kilo balık "
										+ priceOfFish + " TL'ye satıldı");
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
				button2.setBounds(190, 100, 120, 30);
				button2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JFrame upgradeFishingRodFrame = new JFrame("Olta Kategorisi");

						JLabel sellerArea = new JLabel(new ImageIcon(backgroundFishingImg));
						sellerArea.setBounds(0, 0, frameWidth, frameHeight);

						JLabel infoLabel = new JLabel();
						infoLabel.setBounds(50, 55, 400, 30);
						infoLabel.setFont(new Font("Arial", Font.BOLD, 15));
						infoLabel.setForeground(Color.orange);
						infoLabel.setVerticalAlignment(JLabel.CENTER);
						infoLabel.setHorizontalAlignment(JLabel.CENTER);

						JLabel playerMoney = new JLabel("Para: " + game.showPlayerMoney() + "₺");
						playerMoney.setBounds(410, 10, 200, 30);
						playerMoney.setFont(new Font("Arial", Font.BOLD, 12));
						playerMoney.setForeground(Color.yellow);

						DefaultListModel<String> fishingRodType = new DefaultListModel<String>();
						fishingRodType.addElement("Başlangıç");
						fishingRodType.addElement("Amatör");
						fishingRodType.addElement("Profesyonel");
						fishingRodType.addElement("Efsanevi");

						JList<String> fishingRodList = new JList<>(fishingRodType);
						fishingRodList.setSelectedIndex(game.getInventoryFishingRodType()-1);
						fishingRodList.setSelectionBackground(Color.BLACK);
						fishingRodList.setSelectionForeground(Color.orange);
						fishingRodList.setBounds(290, 225, 75, 75);
						fishingRodList.setOpaque(false);
						fishingRodList.setBackground(new Color(0, 0, 0, 0));
						fishingRodList.setForeground(Color.white);
						fishingRodList.setFont(new Font("Arial", Font.BOLD, 12));
						// BİR TANESİNİ SEÇMEK İÇİN KULLANILIR
						fishingRodList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);


						JButton buyFishingRodButton = new JButton();
						buyFishingRodButton.setBounds(220, 320, 64, 64);
						buyFishingRodButton.setBorderPainted(false);
						buyFishingRodButton.setFocusPainted(false);
						buyFishingRodButton.setIcon(new ImageIcon(buyIcon));
						buyFishingRodButton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								int price = 0, selectedRodType = inventory.getFishingRodType();
								String selectedRodName = fishingRodList.getSelectedValue();
								if (fishingRodList.getSelectedIndex() != -1) {
									switch (fishingRodList.getSelectedValue()) {
									case "Başlangıç":
										price = 25;
										selectedRodType = 1;
										break;
									case "Amatör":
										price = 50;
										selectedRodType = 2;
										break;
									case "Profesyonel":
										price = 100;
										selectedRodType = 3;
										break;
									case "Efsanevi":
										price = 150;
										selectedRodType = 4;
										break;
									default:
										infoLabel.setText("Hata: Geçersiz seçim.");
										return;
									}

									if (selectedRodType == game.getInventoryFishingRodType()) {
										infoLabel.setText(selectedRodName + " zaten mevcut.");
										return;
									} else if (selectedRodType < game.getInventoryFishingRodType()) {
										infoLabel.setText("Daha iyi bir oltaya zaten sahipsiniz.");
										return;
									}

									if (game.getPlayerMoney() >= price) {
										game.setInventoryFishingRodType(selectedRodType);
										inventory.setFishingRodName(selectedRodName);
										game.setPlayerMoney(game.getPlayerMoney() - price);

										refreshMoney(playerMoney, game);
										refreshMoney(marketMenuPlayerMoney, game);

										infoLabel.setText(selectedRodName + " olta başarıyla satın alındı.");
										System.out.println("LOG - Yeni olta: " + selectedRodName);
									} else {
										infoLabel.setText("Bakiye yetersiz.");
									}

								} else {
									infoLabel.setText("Lütfen bir olta seçiniz.");
								}
							}
						});
						upgradeFishingRodFrame.add(infoLabel);
						upgradeFishingRodFrame.add(playerMoney);
						upgradeFishingRodFrame.add(fishingRodList);
						upgradeFishingRodFrame.add(buyFishingRodButton);
						upgradeFishingRodFrame.add(createBackButton(upgradeFishingRodFrame, game));
						upgradeFishingRodFrame.add(sellerArea);
						upgradeFishingRodFrame.setSize(frameWidth, frameHeight);
						upgradeFishingRodFrame.setLayout(null);
						upgradeFishingRodFrame.setResizable(false);
						upgradeFishingRodFrame.setLocationRelativeTo(frame);
						upgradeFishingRodFrame.setVisible(true);

					}
				});

				JButton button3 = new JButton("Depo Yükselt");
				button3.setBounds(190, 130, 120, 30);
				button3.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JFrame upgradeSlotFrame = new JFrame("Depo Kategorisi");

						JLabel sellerArea = new JLabel(new ImageIcon(backgroundSlotImg));
						sellerArea.setBounds(0, 0, frameWidth, frameHeight);

						JLabel infoLabel = new JLabel();
						infoLabel.setBounds(50, 30, 400, 30);
						infoLabel.setFont(new Font("Arial", Font.BOLD, 15));
						infoLabel.setVerticalAlignment(JLabel.CENTER);
						infoLabel.setHorizontalAlignment(JLabel.CENTER);
						infoLabel.setForeground(Color.orange);

						JLabel playerMoney = new JLabel("Para: " + game.showPlayerMoney() + "₺");
						playerMoney.setBounds(410, 10, 200, 30);
						playerMoney.setFont(new Font("Arial", Font.BOLD, 12));
						playerMoney.setForeground(Color.yellow);

						DefaultListModel<Integer> slots = new DefaultListModel<Integer>();
						slots.addElement(3);
						slots.addElement(5);
						slots.addElement(15);
						slots.addElement(25);
						slots.addElement(35);

						JList<Integer> slotList = new JList<Integer>(slots);
						slotList.setSelectedValue(game.getInventoryMaxSlot(), true);
						slotList.setSelectionBackground(Color.BLACK);
						slotList.setSelectionForeground(Color.orange);
						slotList.setBounds(310, 200, 25, 100);
						slotList.setOpaque(false);
						slotList.setBackground(new Color(0, 0, 0, 0));
						slotList.setFont(new Font("Arial", Font.BOLD, 16));
						slotList.setForeground(Color.white);
						slotList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);

						JButton buyExtraSlotButton = new JButton();
						buyExtraSlotButton.setBounds(220, 340, 64, 64);
						buyExtraSlotButton.setBorderPainted(false);
						buyExtraSlotButton.setFocusPainted(false);
						buyExtraSlotButton.setIcon(new ImageIcon(buyIcon));

						upgradeSlotFrame.addWindowListener(new java.awt.event.WindowAdapter() {

							@Override
							public void windowClosed(WindowEvent e) {
								marketMenuPlayerMoney.setText("Para: " + game.showPlayerMoney() + "₺");
							}

						});
						
						buyExtraSlotButton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								int price = 0, currentSlotSize = game.getInventoryMaxSlot();
								int selectedSlotSize = slotList.getSelectedValue();
								if (slotList.getSelectedIndex() != -1) {
									switch (slotList.getSelectedValue()) {
									case 3:
										price = 0;
										currentSlotSize = 3;
									case 5:
										price = 25;
										currentSlotSize = 5;
										break;
									case 15:
										price = 50;
										currentSlotSize = 15;
										break;
									case 25:
										price = 100;
										currentSlotSize = 25;
										break;
									case 35:
										price = 150;
										currentSlotSize = 35;
										break;
									default:
										infoLabel.setText("Hata: Geçersiz seçim.");
										return;
									}

									if (currentSlotSize == game.getInventoryMaxSlot()) {
										infoLabel.setText(selectedSlotSize + " zaten mevcut.");
										return;
									} else if (currentSlotSize < game.getInventoryMaxSlot()) {
										infoLabel.setText("Daha iyi bir depolamaya zaten sahipsiniz.");
										return;
									}

									if (game.getPlayerMoney() >= price) {
										game.setInventoryMaxSlot(currentSlotSize);
										game.setPlayerMoney(game.getPlayerMoney() - price);

										refreshMoney(playerMoney, game);
										refreshMoney(marketMenuPlayerMoney, game);

										infoLabel.setText(selectedSlotSize + " depo başarıyla satın alındı.");
										System.out.println("LOG - Yeni depo: " + selectedSlotSize);
									} else {
										infoLabel.setText("Bakiye yetersiz.");
									}

								} else {
									infoLabel.setText("Lütfen bir depo seçiniz.");
								}
							}
						});

						upgradeSlotFrame.add(playerMoney);
						upgradeSlotFrame.add(infoLabel);
						upgradeSlotFrame.add(createBackButton(upgradeSlotFrame, game));
						upgradeSlotFrame.add(slotList);
						upgradeSlotFrame.add(buyExtraSlotButton);
						upgradeSlotFrame.add(sellerArea);
						upgradeSlotFrame.setSize(frameWidth, frameHeight);
						upgradeSlotFrame.setLayout(null);
						upgradeSlotFrame.setResizable(false);
						upgradeSlotFrame.setLocationRelativeTo(frame);
						upgradeSlotFrame.setVisible(true);

					}
				});

				JButton button4 = new JButton("Yem Market");
				button4.setBounds(190, 160, 120, 30);
				button4.setEnabled(false);
				button4.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
					}
				});

				marketFrame.add(infoLabel);
				marketFrame.add(marketMenuPlayerMoney);
				marketFrame.add(button1);
				marketFrame.add(button2);
				marketFrame.add(button3);
				marketFrame.add(button4);
				marketFrame.add(createBackButton(marketFrame, game));
				marketFrame.add(marketArea);
				marketFrame.setSize(frameWidth, frameHeight);
				marketFrame.setLayout(null);
				marketFrame.setResizable(false);
				marketFrame.setLocationRelativeTo(frame);
				marketFrame.setVisible(true);
			}
		});

		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SaveAndQuitTheGame.savePlayerStats(game);
				System.exit(0);
			}
		});


		frame.add(coderLabel);
		frame.add(welcomeLogo);
		frame.add(backgroundMenu);
		frame.setSize(frameWidth, frameHeight);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	private static JButton createBackButton(JFrame frame, Game game) {
		JButton backButton = new JButton(new ImageIcon(returnIcon));
	    backButton.setBounds(218, 400, 64, 64);
	    backButton.setOpaque(false);
	    backButton.setContentAreaFilled(false);
	    backButton.setBorderPainted(false);
	    backButton.setFocusPainted(false);
	    backButton.addActionListener(e -> {
	        SaveAndQuitTheGame.savePlayerStats(game);
	        frame.dispose();
	    });
	    return backButton;
	}

	private static JLabel refreshMoney(JLabel label, Game game) {
		label.setText("Para: " + game.showPlayerMoney() + "₺");
		return label;

	}
}
