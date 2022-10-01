package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilites.Driver;

public class A101Page {


    public A101Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Kabul Et']")
    public WebElement cerezleriKabulEt;

    @FindBy(css = ".desktop-menu>:nth-child(4)")
    public WebElement giyimAksesuar;

    @FindBy(xpath = "//a[@data-value='1565']")
    public WebElement kadinIcGiyim;

    @FindBy(xpath = "//a[@data-value='1567']")
    public WebElement dizaltiCorap;

    @FindBy(id = "attributes_integration_colourSİYAH")
    public WebElement siyahRenkFiltre;

    @FindBy(xpath = "//h3[contains(text(),'Penti Kadın 50 Denye Pantolon Çorabı Siyah')]")
    public WebElement ilkCikanCorap;

    @FindBy(xpath = "//*[.='SİYAH']")
    public WebElement siyahRenkDogrula;

    @FindBy(css = ".add-to-basket.button")
    public WebElement sepeteEkle;

    @FindBy(css = "a[class=go-to-shop]")
    public WebElement sepetiGoruntule;

    @FindBy(css = ".button.green.checkout-button")
    public WebElement sepetiOnayla;

    @FindBy(css = ".auth__form__proceed")
    public WebElement uyeOlmadanDevamEt;

    @FindBy(xpath = "//*[@class='page-inner']")
    public WebElement emailEkrani;

    @FindBy(xpath = "//*[@name='user_email']")
    public WebElement email;

    @FindBy(css = ".addresses")
    public WebElement adresEkraniDogrula;

    @FindBy(xpath = "(//*[@class='new-address js-new-address'])[1]")
    public WebElement adresOlustur;

    @FindBy(css = "input[name=title]")
    public WebElement adresBasligi;

    @FindBy(xpath = "//*[@name='city']")
    public WebElement il;

    @FindBy(css = ".js-township")
    public WebElement ilce;

    @FindBy(css = ".js-district")
    public WebElement mahalle;

    @FindBy(css = ".js-address-textarea")
    public WebElement adres;

    @FindBy(xpath = "(//*[@class='js-checkout-cargo-item'])[1]")
    public WebElement kargo;

    @FindBy(css = ".button.block.green.js-proceed-button")
    public WebElement kaydetVeDevamEt;

    @FindBy(xpath = "(//*[@class='section-hero'])[5]")
    public WebElement masterPass;


    //Ödeme ekranı
    @FindBy(xpath = "//div[@class='form-area js-new-creditcard-area']//input[@name='name']")
    public WebElement adSoyad;


    @FindBy(xpath = "//div[@class='form-area js-new-creditcard-area']//select[@name='card_month']")
    public WebElement sonKullanmaTarihiAy;

    @FindBy(xpath = "//div[@class='form-area js-new-creditcard-area']//select[@name='card_year']")
    public WebElement sonKullanmaTarihiYıl;

    @FindBy(xpath = "//div[@class='form-area js-new-creditcard-area']//input[@name='card_cvv']")
    public WebElement cvc;

    @FindBy(xpath = "//label[@for='agrement2']")
    public static WebElement onBilgileriKabul;

    @FindBy(xpath = "//button[@title='Close (Esc)']")
    public WebElement mesafeliSatisSözlesmesi;

    @FindBy(xpath = "//div[@class='payment-area js-payment-tab-content active']//button[@type='submit']")
    public WebElement siparisiTamamlaButton;

    @FindBy(xpath = "(//*[@class='error checkout__error js-error-card_number '])[2]")
    public WebElement kartBilgileriniKontrolEdiniz;

}
