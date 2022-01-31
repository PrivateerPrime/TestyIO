package Tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

// https://localhost:5001/Wycieczka
public class WycieczkaPage {
    public SelenideElement wycieczkaCreate = Selenide.$x("//a[text()='Create New']");

    public SelenideElement wycieczkaDelete = Selenide.$x("//a[text()='Delete']");

    public SelenideElement wycieczkaAddPerson = Selenide.$x("//a[text()='Dodaj uczestnika']");

    public SelenideElement wycieczkaDeletePerson = Selenide.$x("//a[text()='Usuń uczestnika']");

    public SelenideElement wycieczkaAddAccommodation = Selenide.$x("//a[text()='Dodaj/Edytuj zakwaterowanie']");

    public SelenideElement wycieczkaDeleteAccommodation = Selenide.$x("//a[text()='Usuń zakwaterowanie']");

}