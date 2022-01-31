package Tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.*;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainPageTest {
    Tests.Welcome welcomePage = new Tests.Welcome();
    Tests.WycieczkaPage wycieczkaPage = new Tests.WycieczkaPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }


    @Test
//    @Order(1)
    public void t1CreateWycieczkaSuccess()
    {
        Selenide.open("https://localhost:5001/");
        welcomePage.wycieczkaLink.click();
        wycieczkaPage.wycieczkaCreate.click();
        Selenide.$("input[id='DataRozpoczecia']").sendKeys("10102000");
        Selenide.$("input[id='DataZakonczenia']").sendKeys("17102000");
        Selenide.$("input[id='MiejsceDocelowe']").sendKeys("Rzym");
        Selenide.$("input[type='submit'][value='Create']").click();

        Selenide.$("td[id='Rzym']").shouldBe(Condition.exist);
    }

    @Test
//    @Order(2)
    public void t2CreateWycieczkaFail()
    {
        welcomePage.wycieczkaLink.click();
        wycieczkaPage.wycieczkaCreate.click();
        Selenide.$("input[id='DataRozpoczecia']").sendKeys("10102000");
        Selenide.$("input[id='DataZakonczenia']").sendKeys("09102000");
        Selenide.$("input[id='MiejsceDocelowe']").sendKeys("Temp");
        Selenide.$("input[type='submit'][value='Create']").click();

        Assertions.assertEquals("Create - WycieczkiIO", Selenide.title());

        welcomePage.wycieczkaLink.click();

        Selenide.$("td[id='Temp']").shouldNotBe(Condition.exist);

    }

    @Test
//    @Order(3)
    public void t3AddPersonSuccess()
    {
        welcomePage.wycieczkaLink.click();
        Selenide.$("a[id='Rzym'][class='AddPerson']").click();

        Selenide.$("input[id='Imie']").sendKeys("Super");
        Selenide.$("input[id='Nazwisko']").sendKeys("Uczestnik");
        Selenide.$("input[id='Pesel']").sendKeys("12345678901");
        Selenide.$("input[id='Telefon']").sendKeys("791061555");
        Selenide.$("input[id='Email']").sendKeys("temp@temp.com");

        Selenide.$("input[type='submit'][value='Create']").click();

        Selenide.$("a[id='Rzym'][class='DeletePerson']").click();

        Selenide.$("input[id='12345678901']").shouldBe();
    }

    @Test
//    @Order(4)
    public void t4AddPersonFail()
    {
        welcomePage.wycieczkaLink.click();
        Selenide.$("a[id='Rzym'][class='AddPerson']").click();

        Selenide.$("input[id='Imie']").sendKeys("Zly");
        Selenide.$("input[id='Nazwisko']").sendKeys("Uczestnik");
        Selenide.$("input[id='Telefon']").sendKeys("791061555");
        Selenide.$("input[id='Email']").sendKeys("temp@temp.com");

        Selenide.$("input[type='submit'][value='Create']").click();

        Selenide.$("span[id='Pesel-error']").shouldBe(Condition.exist);
    }

    @Test
//    @Order(5)
    public void t5DeletePerson()
    {
        welcomePage.wycieczkaLink.click();
        Selenide.$("a[id='Rzym'][class='DeletePerson']").click();

        Selenide.$("input[id='12345678901']").shouldBe();
        Selenide.$("a[id='12345678901']").click();

        Selenide.$("input[type='Submit'][value='Delete']").click();
    }

    @Test
//    @Order(6)
    public void t6AddEditAccommodation()
    {
        welcomePage.wycieczkaLink.click();
        Selenide.$("a[id='Rzym'][class='AddAccommodation']").click();

        Selenide.$("select[id='ZakwaterowanieId']").selectOption("Gdzieś na odludziu");
        Selenide.$("input[type='submit'][value='Dodaj zakwaterowanie']").click();

        Assertions.assertEquals("Index - WycieczkiIO", Selenide.title());

        Selenide.$("a[id='Rzym'][class='AddAccommodation']").click();
        Selenide.$("select[id='ZakwaterowanieId']").selectOption("Super fajny hotel");
        Selenide.$("input[type='submit'][value='Dodaj zakwaterowanie']").click();

        Assertions.assertEquals("Index - WycieczkiIO", Selenide.title());
    }

    @Test
//    @Order(7)
    public void t7DeleteAccommodation()
    {
        welcomePage.wycieczkaLink.click();
        Selenide.$("a[id='Rzym'][class='DeleteAccommodation']").click();

        Selenide.$("input[type='Submit'][value='Delete']").click();

        Assertions.assertEquals("Index - WycieczkiIO", Selenide.title());
    }

    @Test
//    @Order(8)
    public void t8DeleteWycieczka()
    {
        welcomePage.wycieczkaLink.click();
        Selenide.$("a[id='Rzym'][class='Delete']").click();

        Selenide.$("input[type='Submit'][value='Delete']").click();

        Selenide.$("td[id='Rzym']").shouldNotBe(Condition.exist);

    }
}
