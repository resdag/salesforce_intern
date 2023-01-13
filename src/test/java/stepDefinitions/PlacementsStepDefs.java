package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

import static utilities.ReusableMethods.scrollIntoView;
import static utilities.ReusableMethods.waitFor;

public class PlacementsStepDefs {

    AccountsPage accountsPage = new AccountsPage();
    ContactsPage contactsPage = new ContactsPage();
    OpportunitiesPage opportunitiesPage = new OpportunitiesPage();
    PlacementsPage placementsPage = new PlacementsPage();

    Actions actions = new Actions(Driver.getDriver());

    @And("This is only for Test")
    public void thisIsOnlyForTest() {


    }

    @And("I should see {string} in {string} subTitle on selected {string}")
    public void iShouldSeeInSubTitleOnSelected(String selectedElement, String subTitle, String pageName) {
        switch (pageName) {
            case "Opportunity":
                switch (subTitle) {
                    case "Related":
                        Assert.assertTrue(
                                (Driver.getDriver().findElement(By.xpath("(//span[@title='" + selectedElement + "'])[1]"))
                                        .isDisplayed()));
                        break;
                    case "new":
                        break;
                    default:
                        System.out.println("Please enter valid subTitle");
                        break;
                }
                break;
            case "Contact":
                switch (subTitle) {
                    case "Related":
                        scrollIntoView(contactsPage.relatedAccountsOnContactRelated);
                        waitFor(1);
                        scrollIntoView(contactsPage.filesOnContactRelated);
                        waitFor(1);
                        scrollIntoView(contactsPage.notesAttachmentOnContactRelated);
                        waitFor(1);
                        scrollIntoView(contactsPage.interviewsOnContactRelated);
                        waitFor(1);
                        Assert.assertTrue(contactsPage.placementsOnContactRelated.isDisplayed());
                        break;
                    case "alt":
                        break;
                    default:
                        System.out.println("Please enter valid subTitle");
                        break;
                }
                break;
            default:
                System.out.println("Please enter valid pageName");
                break;
        }
    }

    @Then("I should see {string} button on {string} Navbar")
    public void iShouldSeeButtonOnNavbar(String buttonName, String navbarName) {
        switch (navbarName) {
            case "Placements":
                switch (buttonName) {
                    case "New":
                        Assert.assertTrue(contactsPage.newButton.isDisplayed());
                        break;
                    default:
                        System.out.println("Please enter valid buttonName");
                        break;
                }
                break;
            case "new":
                break;
            default:
                System.out.println("Please enter valid navbarName");
                break;
        }

    }
}
