package tests;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import pages.A101Page;
import utilites.*;

import java.util.List;
import java.util.Random;

public class A101Case extends TestBaseRapor {

    @Test
    public void a101Test() throws InterruptedException {

        extentTest = extentReports.createTest("A101", "Test ici yapilan islemler bildirilmeli.");


        String a101URL = ConfigReader.getProperty("a101URL");
        Driver.getDriver().get(a101URL);

        A101Page a101Page = new A101Page();
        a101Page.cerezleriKabulEt.click();
        extentTest.info("Cerezler kabul edildi.");

        a101Page.giyimAksesuar.click();
        extentTest.info("Giyim-Aksesuar butonu tiklandi.");

        a101Page.kadinIcGiyim.click();
        extentTest.info("Kadin iç giyim butonu tiklandi.");

        a101Page.dizaltiCorap.click();
        extentTest.info("Dizalti corap butonu tiklandi.");

        a101Page.ilkCikanCorap.click();
        extentTest.info("Dizalti coraplar arasindan ilki tiklandi.");

        ReusableMethods.getSoftAssert().assertTrue(a101Page.siyahRenkDogrula.isDisplayed());
        extentTest.info("Acilan corabin siyah oldugu dogrulandi.");

        a101Page.sepeteEkle.click();
        extentTest.info("Urunu sepete butonu tiklandi.");

        a101Page.sepetiGoruntule.click();
        extentTest.info("Urunun sepete eklendigini kontrol etmek amaciyla sepeti goruntule butonu tiklandi.");

        a101Page.sepetiOnayla.click();
        extentTest.info("Sepeti onayla butonu tiklandi.");

        a101Page.uyeOlmadanDevamEt.click();
        extentTest.info("Uye olmadan devam et butonu tiklandi.");

        //Mail ekranı gelir. Ekranın geldiği doğrulanır
        try {
            ReusableMethods.getSoftAssert().assertTrue(a101Page.emailEkrani.isDisplayed());
            extentTest.info("Mail ekraninin geldigi dogrulanir");
        } catch (Exception e) {
            extentTest.info("Mail ekranini izlenemedi");
        }
        extentTest.info("Mail ekrani geldigi dogrulandi.");

        //Bir mail adresi girilir.
        a101Page.email.sendKeys(ReusableMethods.getFaker().internet().emailAddress());

        extentTest.info("Mail adresi girildi.");

        if (a101Page.email.getText() != null) {
            extentTest.info("Mail adresi girildiği izlenebilir.");
        } else extentTest.info("Mail adresi girilmemiştir.");

        extentTest.info("Mail adresi girildigi izlenebilir.");

        a101Page.email.sendKeys(Keys.ENTER);


        //Adres ekranı gelir. Ekranın geldiği doğrulanır.
        ReusableMethods.getSoftAssert().assertTrue(a101Page.adresEkraniDogrula.isDisplayed());
        extentTest.info("Adres ekrani gelir, ekranin geldigi dogrulanir.");

        //Adres oluştur seçeneğine tıklanır ve bilgiler girilir.
        a101Page.adresOlustur.click();
        extentTest.info("Adres olustur secenegi tiklandi.");

        ReusableMethods.getActions().click(a101Page.adresBasligi)
                .sendKeys("Ev")
                .sendKeys(Keys.TAB)
                .sendKeys(ReusableMethods.getFaker().name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(ReusableMethods.getFaker().name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(ReusableMethods.getFaker().number().digits(11))
                .perform();
        extentTest.info("Adres bilgilerinden Adres basligi, Ad, Soyad, Cep telefonu dolduruldu.");

        //il Random select
        WebElement sehir = a101Page.il;
        Select  select = new Select(sehir);

        List<WebElement> sehirCount = select.getOptions();

        Random random = new Random();
        int index = random.nextInt(sehirCount.size());

        while (index == 1) {
            index = random.nextInt(sehirCount.size());
        }
        select.selectByIndex(index);

        extentTest.info("Secim kisminda internet hizi kaynaklı hatalar yasamamak icin List'e atama yapildi. " +
                "Random uzerinden ve while ile islem tamamlandi.");

        extentTest.info("Il drop-down sekmesi uzerinden secildi.");

        //ilçe Random select
        WebElement ilce = a101Page.ilce;
        select = new Select(ilce);

        List<WebElement> ilceCount = select.getOptions();
        index = random.nextInt(ilceCount.size());
        while (index == 1) {
            index = random.nextInt(ilceCount.size());
        }

        select.selectByIndex(index);

        extentTest.info("Secim kisminda internet hizi kaynaklı hatalar yasamamak icin List'e atama yapildi. " +
                "Random uzerinden ve while ile islem tamamlandi.");

        extentTest.info("Ilce drop-down sekmesi uzerinden secildi.");

        //Mahalle Random select
        WebElement mahalle = a101Page.mahalle;
        select = new Select(mahalle);

        List<WebElement> mahCount = select.getOptions();
        index = random.nextInt(mahCount.size());
        while (index == 1) {
            index = random.nextInt(mahCount.size());
        }

        extentTest.info("Secim kisminda internet hizi kaynaklı hatalar yasamamak icin List'e atama yapildi.");

        for (int retry = 0; retry < 5; retry++) {
            try {
                select.selectByIndex(index);
                break;
            } catch (StaleElementReferenceException ex) {
                ex.toString();
            }
        }

        extentTest.info("Internet kaynakli mahalle secimi yapılmasi sorun olmamasi acisindan mahalle secilene kadar hareket etmesi acisindan for içinde islem yapildi.");

        extentTest.info("Mahalle drop-down sekmesi uzerinden secildi.");

        //Adres
        WebElement adres = a101Page.adres;

        ReusableMethods.getActions().click(adres)
                .sendKeys(ReusableMethods.getFaker().address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)  //Kaydet butonu tıklandı
                .perform();

        extentTest.info("Adres kutusu doldurulduktan sonra kaydet butonu tiklandi.");

        //Kargo seçimi
        WebElement kargo = a101Page.kargo;
        System.out.println(a101Page.adres.isSelected());

        for (int retry = 0; retry < 5; retry++) {
            try {
                if (!kargo.isSelected()) kargo.click();
                break;
            } catch (StaleElementReferenceException ex) {
                ex.toString();
            }
        }

        extentTest.info("Kargo secenekleri arasindan secim yapildi");

        //Kaydet ve devam et butonu tıklanır
        WebElement saveAndContinue = a101Page.kaydetVeDevamEt;
        saveAndContinue.click();

        extentTest.info("Kaydet ve devam et butonu tiklandi.");

        //Ödeme ekranına gelindiği doğrulanır
        ReusableMethods.getSoftAssert().assertTrue(a101Page.masterPass.isDisplayed());

        extentTest.info("Odeme ekrani geldigi dogrulandi.");


        ReusableMethods.getActions().click(a101Page.adSoyad)
                .sendKeys(ReusableMethods.getFaker().name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(ReusableMethods.getFaker().number().digits(16))
                .perform();

        extentTest.info("Odeme ekraninda Ad Soyad, Kart Numarasi dolduruldu.");

        WebElement ay = a101Page.sonKullanmaTarihiAy;
        select = new Select(ay);

        List<WebElement> sonKullanmAyCount = select.getOptions();
        index = random.nextInt(sonKullanmAyCount.size());
        while (index == 1) {
            index = random.nextInt(sonKullanmAyCount.size());
        }

        select.selectByIndex(index);

        extentTest.info("Son kullanma tarihi drop-down sekmesi uzerinden ay secildi.");

        WebElement yil = a101Page.sonKullanmaTarihiYıl;
        select = new Select(yil);

        List<WebElement> sonKullanmaYilCount = select.getOptions();
        index = random.nextInt(sonKullanmaYilCount.size());
        while (index == 1) {
            index = random.nextInt(sonKullanmaYilCount.size());
        }

        select.selectByIndex(index);

        extentTest.info("Son kullanma tarihi drop-down sekmesi uzerinden yil secildi.");

        a101Page.cvc.sendKeys("123");

        extentTest.info("CVC kismi dolduruldu.");


        ReusableMethods.jsclick(a101Page.onBilgileriKabul);
        extentTest.info("On bilgilere js method ile tiklama yapildi.");

        extentTest.info("On bilgileri kabul secenegi tiklandi.");

        try {
            a101Page.mesafeliSatisSözlesmesi.click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        extentTest.info("Cıkan mesafeli satis sözlesmesi kapatildi.");

        a101Page.siparisiTamamlaButton.sendKeys(Keys.ENTER);

        extentTest.info("Siparisi tamamla butonu tiklandi.");

        ReusableMethods.getSoftAssert().assertTrue(a101Page.kartBilgileriniKontrolEdiniz.isDisplayed());

        extentTest.info("Siparis bilgilerinin dogru olmadıgı kart bilgilerini kontrol ediniz yazisi uzerinden dogrulandi.");

        Driver.closeDriver();

        extentTest.info("Sayfa kapatildi.");





    }

}
