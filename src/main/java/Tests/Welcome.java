package Tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

// https://localhost:5001/
public class Welcome {

    public SelenideElement wycieczkaLink = Selenide.$("a[href='/Wycieczka']");

    public SelenideElement zakwaterowanieLink = Selenide.$("a[href='/Zakwaterowanie']");

    public SelenideElement transportLink = Selenide.$("a[href='/Transport']");

    public SelenideElement atrakcjaLink = Selenide.$("a[href='/Atrakcja']");

    public SelenideElement przewodnikLink = Selenide.$("a[href='/Przewodnik']");

    public SelenideElement adresLink = Selenide.$("a[href='/Adres']");

    public SelenideElement miastoLink = Selenide.$("a[href='/Miasto']");

    public SelenideElement krajLink = Selenide.$("a[href='/Kraj']");

}