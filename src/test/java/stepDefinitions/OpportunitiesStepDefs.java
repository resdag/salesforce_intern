package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import utilities.Driver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utilities.ReusableMethods.*;

public class OpportunitiesStepDefs {

    HomePage homePage = new HomePage();
    AccountsPage accountsPage = new AccountsPage();
    ContactsPage contactsPage = new ContactsPage();
    OpportunitiesPage opportunitiesPage = new OpportunitiesPage();
    PlacementsPage placementsPage = new PlacementsPage();

    Actions actions = new Actions(Driver.getDriver());
    Select select;
    String accountName;
    String placementID;

    @Then("I click {string} on {string}")
    public void iClickOn(String stageName, String arg2) {
        waitFor(1);
        switch (stageName) {
            case "Closed":
                actions.click(opportunitiesPage.workflowOpportunityClosed).perform();
                break;
            case "Qualification":
                actions.click(opportunitiesPage.workflowOpportunityQualification).perform();
                break;
            case "Proposal":
                actions.click(opportunitiesPage.workflowOpportunityProposal).perform();
                break;
            default:
                System.out.println("Please enter valid stageName");
                break;
        }

    }

    @Then("I click {string} button on {string} subNavbar")
    public void iClickButtonOnSubNavbar(String buttonName, String arg2) {
        switch (buttonName) {
            case "Select Closed Stage":
                actions.click(opportunitiesPage.selectClosedStageButton).perform();
                break;
            case "Mark as Current Stage":
                actions.click(opportunitiesPage.markAsCurrentStageButton).perform();
                break;
            case "Mark Stage as Complete":
                actions.click(opportunitiesPage.markStageAsCompleteButton).perform();
                break;
            case "Change Closed Stage":
                actions.click(opportunitiesPage.changeClosedStageButton).perform();
                break;
            default:
                System.out.println("Please enter valid stageName");
                break;
        }
    }

    @Then("All Statuses should be exist for {string} on {string}")
    public void allStatusesShouldBeExistForOn(String pageName, String recordType) {
        switch (pageName) {
            case "Workflow of Opportunity":
                switch (recordType) {
                    case "Jobs":
                        Assert.assertTrue(opportunitiesPage.workflowOpportunityQualification.isDisplayed());
                        Assert.assertTrue(opportunitiesPage.workflowOpportunityProposal.isDisplayed());
                        Assert.assertTrue(opportunitiesPage.workflowOpportunityInterview.isDisplayed());
                        Assert.assertTrue(opportunitiesPage.workflowOpportunityFinalFeedback.isDisplayed());
                        Assert.assertTrue(opportunitiesPage.workflowOpportunityNegotiation.isDisplayed());
                        Assert.assertTrue(opportunitiesPage.workflowOpportunityClosed.isDisplayed());
                        break;
                    case "Projects":

                        break;
                    default:
                        System.out.println("Please enter valid recordType");
                        break;
                }
                break;
            case "new":
                break;
            default:
                System.out.println("Please enter valid stageName");
                break;
        }
    }

    @And("All Options should be exist in {string} dropdown")
    public void allOptionsShouldBeExistInDropdown(String dropdownName) {
        switch (dropdownName) {
            case "Stage":
                select = new Select(opportunitiesPage.selectClosedStageDropdown);
                List<String> allOptionsAsString = new ArrayList<>();

                for (int i = 0; i < select.getOptions().size(); i++) {
                    allOptionsAsString.add(select.getOptions().get(i).getText());
                }

                Assert.assertTrue(allOptionsAsString.contains("Closed Lost"));
                Assert.assertTrue(allOptionsAsString.contains("Closed Won"));
                Assert.assertTrue(allOptionsAsString.contains("Contract Issue"));
                break;
            case "Lost Reason":
                opportunitiesPage.lostReasonDropdown.click();
                Assert.assertTrue(opportunitiesPage.lostReasonOptionLostCompetitor.isDisplayed());
                Assert.assertTrue(opportunitiesPage.lostReasonOptionNoBudget.isDisplayed());
                Assert.assertTrue(opportunitiesPage.lostReasonOptionNoDecision.isDisplayed());
                Assert.assertTrue(opportunitiesPage.lostReasonOptionPrice.isDisplayed());
                Assert.assertTrue(opportunitiesPage.lostReasonOptionOther.isDisplayed());
                break;
            default:
                System.out.println("Please enter valid dropdownName");
                break;
        }
    }

    @Then("The new created {string} should be visible in the list of {string}")
    public void theNewCreatedShouldBeVisibleInTheListOf(String createdObject, String listName) {
        waitFor(1);
        switch (listName) {
            case "Accounts":
                Assert.assertTrue(opportunitiesPage.firstRowOfOpportunities.getText().contains(createdObject));
                break;
            case "Accounts > Opportunities":
                Driver.getDriver().navigate().refresh();
                WebElement lastCreatedOpp = Driver.getDriver().findElement(By.xpath("(//a[@title='" + createdObject + "'])[1]"));
                Assert.assertTrue(lastCreatedOpp.isDisplayed());
                break;
            case "Contacts > Placements":
                Driver.getDriver().navigate().refresh();
                Assert.assertTrue(placementsPage.firstPlacementIDOnContactsPlacementList.getText().contains(placementID));
                break;
            default:
                System.out.println("Please enter valid dropdownName");
                break;
        }

    }

    @And("I am going to {string} page")
    public void iAmGoingToPage(String pageName) {
        switch (pageName) {
            case "previous":
                Driver.getDriver().navigate().back();
                break;
            case "next":
                Driver.getDriver().navigate().forward();
                break;
            case "refresh":
                Driver.getDriver().navigate().refresh();
                break;
            default:
                System.out.println("Please enter valid pageName");
                break;
        }
    }

    @And("I store {string} of {string}")
    public void iStoreOf(String storedText, String storedObjekt) {
        switch (storedText) {
            case "accountName":
                accountName = opportunitiesPage.selectedOpportunityAccountName.getText()
                        .replace("Open ", "")
                        .replace(" Preview", "");
                break;
            case "placementID":
                placementID = placementsPage.selectedPlacementPlacementID.getText();
                break;
            default:
                System.out.println("Please enter valid storedText");
                break;
        }

    }

    @And("I click {string} on selected {string} page")
    public void iClickOnSelectedPage(String clickedText, String pageName) {
        waitFor(1);
        switch (pageName) {
            case "Opportunities":
                switch (clickedText) {
                    case "firstOpportunityTitle":
                        actions.moveToElement(opportunitiesPage.firstOpportunityTitleOnOpportunities).click()
                                .sendKeys(Keys.ENTER)
                                .sendKeys(Keys.ENTER)
                                .perform();
                        break;
                    case "new":
                        break;
                    default:
                        System.out.println("Please enter valid clickedText");
                        break;
                }
                break;
            case "Opportunity":
                switch (clickedText) {
                    case "accountName":
                        actions.click(opportunitiesPage.selectedOpportunityAccountName).perform();
                        break;
                    case "lostReasonEdit":
                        scrollIntoView(opportunitiesPage.editLostReasonButton);
                        actions.click(opportunitiesPage.editLostReasonButton).perform();
                        break;
                    case "new":
                        break;
                    default:
                        System.out.println("Please enter valid clickedText");
                        break;
                }
                break;
            case "Account":
                switch (clickedText) {
                    case "Opportunities":
                        scrollIntoView(opportunitiesPage.relatedContactsOnAccountRelated);
                        actions.click(opportunitiesPage.opportunitiesOnAccountRelated).perform();
                        break;
                    case "new":
                        break;
                    default:
                        System.out.println("Please enter valid clickedText");
                        break;
                }
                break;
            case "Accounts > Opportunities":
                WebElement lastCreatedOpp = Driver.getDriver().findElement(By.xpath("(//a[@title='" + clickedText + "'])[1]"));

                actions.click(lastCreatedOpp)
                        .sendKeys(Keys.ENTER).sendKeys(Keys.ENTER).perform();
                break;
            case "Contacts > Placements":
                actions.moveToElement(placementsPage.firstPlacementIDOnContactsPlacementList).click()
                        .sendKeys(Keys.ENTER)
                        .sendKeys(Keys.ENTER)
                        .perform();
                break;
            case "Placement":
                switch (clickedText) {
                    case "Candidate":
                        actions.click(placementsPage.candidateInPlacementDetails).perform();
                        break;
                    case "new":
                        break;
                    default:
                        System.out.println("Please enter valid clickedText");
                        break;
                }
                break;
            case "Contact":
                switch (clickedText) {
                    case "Placements":
                        scrollIntoView(contactsPage.relatedAccountsOnContactRelated);
                        waitFor(1);
                        scrollIntoView(contactsPage.filesOnContactRelated);
                        waitFor(1);
                        scrollIntoView(contactsPage.notesAttachmentOnContactRelated);
                        waitFor(1);
                        //scrollIntoView(contactsPage.interviewsOnContactRelated);
                        waitFor(1);
                        actions.click(contactsPage.placementsOnContactRelated).perform();
                        waitFor(1);
                        break;
                    case "new":
                        break;
                    default:
                        System.out.println("Please enter valid clickedText");
                        break;
                }
                break;
            case "Contacts":
                switch (clickedText) {
                    case "firstContactName":
                        actions.moveToElement(contactsPage.firstContactNameOnContacts).click()
                                .sendKeys(Keys.ENTER)
                                .sendKeys(Keys.ENTER)
                                .perform();
                        break;
                    case "new":
                        break;
                    default:
                        System.out.println("Please enter valid clickedText");
                        break;
                }
                break;
            default:
                System.out.println("Please enter valid navbarName");
                break;
        }
    }


}

