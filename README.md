# 🎣 Balık Tutma Oyunu (Java)

Bu proje, Java programlama diliyle geliştirilen bir **balık tutma simülasyon oyunudur**. Menü tabanlı yapısıyla kullanıcıya balık tutma, marketten alışveriş yapma, oyuncu gelişimi gibi temel oyun deneyimleri sunar.

> ⚠️ **Proje hâlen geliştirilmektedir.** Java bilgim ilerledikçe yapıyı sadeleştiriyor, sınıf bağımlılıklarını azaltıyor ve yeni özellikler ekliyorum.  
> 🎯 **Swing konusunda yeterli seviyeye ulaştığımda**, mevcut metin tabanlı menüyü görsel kullanıcı arayüzüne (GUI) dönüştürmeyi planlıyorum.

---

## 🚀 Özellikler

- Menü konsol tabanlı kullanıcı arayüzü
- Balık tutma sistemi (kilogram ve tür farkı ile)
- Oyuncu bakiyesi ve slot yönetimi
- Marketten ekipman satın alma (olta, slot vb.)
- Oyun istatistiklerinin dosyaya kaydedilmesi ve yüklenmesi
- Kodun modüler ve nesne tabanlı yapıda tasarlanması

---

## 🧱 Sınıf Açıklamaları

| Sınıf | Açıklama |
|------|----------|
| `Main.java` | Uygulamanın giriş noktası. Menü akışını başlatır. |
| `MenuManager.java` | Ana menüyü ve kullanıcı seçimlerini yönetir. |
| `MarketManager.java` | Market işlemlerini (satın alma, fiyat gösterimi) gerçekleştirir. |
| `GameManager.java` | Oyuncu bilgilerini ve oyun durumunu tutar. |
| `GameMechanicsBase.java` | Slot limitleri, fiyat katsayıları gibi sabit mekanikleri tanımlar. |
| `PlayerStats.java` | Oyuncuya ait istatistikleri (balık adedi, toplam kg, en iyi balık vb.) tutar. |
| `ControlManager.java` | Kullanıcı girdilerini kontrol eder ve doğrular. |
| `SaveAndQuitTheGame.java` | Oyuncu verilerini dosyaya kaydeder ve geri yükler. |

---

## 🛠️ Kurulum ve Çalıştırma

### 1. Depoyu klonlayın

```bash
git clone https://github.com/mcanerarslan/balik-tutma-oyunu.git
cd balik-tutma-oyunu

javac Main.java
java Main.java
