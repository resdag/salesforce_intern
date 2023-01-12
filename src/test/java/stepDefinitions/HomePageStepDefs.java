package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.ReusableMethods.*;

public class HomePageStepDefs {
    HomePage homePage = new HomePage();
    AccountsPage accountsPage = new AccountsPage();
    ContactsPage contactsPage = new ContactsPage();
    OpportunitiesPage opportunitiesPage = new OpportunitiesPage();
    PlacementsPage placementsPage = new PlacementsPage();

    Actions actions = new Actions(Driver.getDriver());

    @Given("I am {string} login page")
    public void iAmLoginPage(String salesforceUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(salesforceUrl));
    }

    @When("I pass {string} to {string} input box")
    public void iPassToInputBox(String inputText, String inputBox) {
        switch (inputBox) {
            case "userName":
                homePage.signinUsernameField.click();
                homePage.signinUsernameField.sendKeys(ConfigReader.getProperty(inputText));
                break;
            case "password":
                homePage.signinPasswordField.click();
                homePage.signinPasswordField.sendKeys(ConfigReader.getProperty(inputText));
                break;
            case "accountName":
                accountsPage.accountNameInputBox.clear();
                accountsPage.accountNameInputBox.sendKeys(inputText);
                break;
            case "contactName":
                scrollIntoView(contactsPage.lastNameImputBox);
                contactsPage.lastNameImputBox.clear();
                contactsPage.lastNameImputBox.sendKeys(inputText);
                break;
            case "opportunityTitle":
                opportunitiesPage.opportunitiesTitleInputBox.clear();
                opportunitiesPage.opportunitiesTitleInputBox.sendKeys(inputText);
                break;
            case "startDate":
                scrollIntoView(placementsPage.startDateImputBox);
                placementsPage.startDateImputBox.clear();
                placementsPage.startDateImputBox.sendKeys(inputText);
                break;
            default:
                System.out.println("Please enter valid inputBox");
                break;
        }
    }

    @And("I click {string} button")
    public void iClickButton(String buttonName) {
        waitFor(2);
        switch (buttonName) {
            case "anmelden":
                homePage.loginButton.click();
                break;
            case "New":
                contactsPage.newButton.click();
                break;
            case "Next":
                contactsPage.newContactNextButton.click();
                break;
            case "Save":
                contactsPage.saveButton.click();
                break;
            case "Cancel":
                contactsPage.cancelButton.click();
                break;
            default:
                System.out.println("Please enter valid buttonName");
                break;
        }

    }

    @Then("I am at {string} page")
    public void iAmAtHomePage(String pageName) {
        waitFor(1);
        switch (pageName) {
            case "Sales/Freelancer App":
                homePage.appLauncher.click();
                homePage.salesFreelancerAppInMenu.click();
                Assert.assertTrue(homePage.appName.getText().contains(pageName));
                break;
            case "Nelta Recruiting App":
                homePage.appLauncher.click();
                homePage.neltaRecruitingAppInMenu.click();
                Assert.assertTrue(homePage.appName.getText().contains(pageName));
                break;
            case "Contacts":
                Driver.getDriver().get(ConfigReader.getProperty(pageName));
                break;
            case "Accounts":
                Driver.getDriver().get(ConfigReader.getProperty(pageName));
                break;
            case "Opportunities":
                Driver.getDriver().get(ConfigReader.getProperty(pageName));
                break;
            case "Placements":
                Driver.getDriver().get(ConfigReader.getProperty(pageName));
                break;
            default:
                System.out.println("Please enter valid pageName");
                break;
        }
    }

    @And("I select {string} from Apps")
    public void iSelectFromApps(String appName) {
        waitFor(1);
        switch (appName) {
            case "Sales/Freelancer App":
                homePage.salesFreelancerAppInMenu.click();
                break;
            case "Nelta Recruiting App":
                homePage.neltaRecruitingAppInMenu.click();
                break;
            default:
                System.out.println("Please enter valid pageName");
                break;
        }
    }

    @And("I should see {string} inputbox")
    public void iShouldSeeInputbox(String inputbox) {
        switch (inputbox) {
            case "search":
                Assert.assertTrue(homePage.searchBox.isDisplayed());
                break;
            case "":
                break;
            default:
                System.out.println("Please enter valid inputbox");
                break;
        }
    }

    @And("I should see {string} ikon on Home Page")
    public void iShouldSeeIkonOnHomePage(String iconName) {
        switch (iconName) {
            case "add favorite":
                Assert.assertTrue(homePage.addFavoriteIcon.isDisplayed());
                break;
            case "favorites list":
                Assert.assertTrue(homePage.favoritesListIcon.isDisplayed());
                break;
            case "global actions":
                Assert.assertTrue(homePage.globalActionsIcon.isDisplayed());
                break;
            case "guidance center":
                Assert.assertTrue(homePage.guidanceCenterIcon.isDisplayed());
                break;
            case "salesforce help":
                Assert.assertTrue(homePage.salesforceHelpIcon.isDisplayed());
                break;
            case "setup":
                Assert.assertTrue(homePage.setupIcon.isDisplayed());
                break;
            case "notifications":
                Assert.assertTrue(homePage.notificationsIcon.isDisplayed());
                break;
            case "view profile":
                Assert.assertTrue(homePage.viewProfileIcon.isDisplayed());
                break;
            case "personalize your nav bar":
                Assert.assertTrue(homePage.personalizeNavbar.isDisplayed());
                break;
            default:
                System.out.println("Please enter valid inputbox");
                break;
        }
    }

    @And("I should see {string} button on Page")
    public void iShouldSeeButtonOnPage(String buttonName) {
        switch (buttonName) {
            case "Accounts":
                Assert.assertTrue(homePage.accountsSubNavTab.isDisplayed());
                break;
            case "Contacts":
                Assert.assertTrue(homePage.contactsSubNavTab.isDisplayed());
                break;
            case "Opportunities":
                Assert.assertTrue(homePage.opportunitiesSubNavTab.isDisplayed());
                break;
            case "Placements":
                Assert.assertTrue(homePage.placementsSubNavTab.isDisplayed());
                break;
            default:
                System.out.println("Please enter valid buttonName");
                break;
        }
    }


    @Then("I close Browser")
    public void iCloseBrowser() {
        Driver.closeDriver();
    }

    @And("I wait {int} second")
    public void iWaitSecond(int second) {
        waitFor(second);
    }
}
