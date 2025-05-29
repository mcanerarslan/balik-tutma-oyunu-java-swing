# Balık Tutma Oyunu 🎣 (Java)

Bu proje, Java programlama dili kullanılarak geliştirilen bir **balık tutma simülasyonudur**. Menü tabanlı yapısıyla oyunculara balık tutma, marketten alışveriş yapma ve karakterlerini geliştirme gibi bir deneyim sunmayı planlıyorum.

> ⚠️ **Bu proje hâlâ geliştirme aşamasındadır.** Java konusundaki bilgi ve becerilerimi ilerlettikçe, projeyi geliştirmeye ve yeni özellikler eklemeye devam ediyorum.

## Özellikler (Planlanan ve Mevcut)

- Menü yönetimi (başlangıç, market, oyun ekranı)
- Balık tutma mekanikleri
- Oyuncu bakiyesi ve envanteri
- Marketten ekipman satın alma
- Seviye sistemi ve skor takibi
- Modüler ve nesne tabanlı yapı

## Sınıf Açıklamaları

- `Main.java` — Uygulamanın giriş noktası, oyun ve menü akışını başlatır.
- `MenuManager.java` — Menü arayüzlerini ve kullanıcı seçimlerini yönetir.
- `GameManager.java` — Balık tutma ve oyun içi etkileşimleri yönetir.
- `handleFishing.java` — Balık tutma işlemlerinin detaylarını barındırır.
- `PlayerBase.java` — Oyuncu bilgilerini, envanterini ve istatistiklerini tutar.
- `MarketManager.java` — Oyuncunun marketten alışveriş yapmasını sağlar.
- `ControlManager.java` — Kullanıcı girdilerini işler (örn. menü seçimleri).
- `TestCode.java` — Geliştirme sırasında bazı işlevleri test etmek için kullanılır.

## Kurulum ve Çalıştırma

### 1. Depoyu Klonlayın

```bash
git clone https://github.com/mcanerarslan/balik-tutma-oyunu.git
cd balik-tutma-oyunu
