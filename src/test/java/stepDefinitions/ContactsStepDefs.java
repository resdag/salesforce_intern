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
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

import static utilities.ReusableMethods.*;

public class ContactsStepDefs {
    HomePage homePage = new HomePage();
    AccountsPage accountsPage = new AccountsPage();
    ContactsPage contactsPage = new ContactsPage();
    OpportunitiesPage opportunitiesPage = new OpportunitiesPage();
    PlacementsPage placementsPage = new PlacementsPage();

    Actions actions = new Actions(Driver.getDriver());
    Select select;


    @When("I click {string} button in Navbar")
    public void iClickButtonInNavbar(String buttonName) throws InterruptedException {
        waitFor(2);
        switch (buttonName) {
            case "Accounts":
                homePage.accountsSubNavTab.click();
                break;
            case "Contacts":
                homePage.contactsSubNavTab.click();
                break;
            case "Opportunities":
                homePage.opportunitiesSubNavTab.click();
                break;
            case "Placements":
                homePage.placementsSubNavTab.click();
                break;
            case "Sendouts":
                homePage.sendoutsSubNavTab.click();
                break;
            default:
                System.out.println("Please enter valid buttonName");
                break;
        }
    }

    @When("I select {string} from Accounts filter")
    public void iSelectFromAccountsDropdown(String accountsName) {
        contactsPage.selectAListViewDropDown.click();
        WebElement selectedAccount = Driver.getDriver().findElement(By.xpath("//span[text()='" + accountsName + "']"));
        selectedAccount.click();
        waitFor(1);

    }

    @Then("I should see {string} title on Accounts subNavbar")
    public void iShouldSeeTitleOnAccountsSubNavbar(String accountsName) {
        Assert.assertTrue(contactsPage.selectListViewTitle.getText().contains(accountsName));
    }

    @When("I select {string} from Contacts filter")
    public void iSelectFromContactsFilter(String contactsName) {
        contactsPage.selectAListViewDropDown.click();
        WebElement selectedContacts = Driver.getDriver().findElement(By.xpath("(//span[text()='" + contactsName + "'])[1]"));
        selectedContacts.click();
        waitFor(1);
    }

    @Then("I should see {string} title on Contacts subNavbar")
    public void iShouldSeeTitleOnContactsSubNavbar(String contactsName) {
        Assert.assertTrue(contactsPage.selectListViewTitle.getText().contains(contactsName));
    }

    @And("I select {string} from record types")
    public void iSelectFromRecordTypes(String recordType) {
        int recordTypesSize = contactsPage.recordTypeOptions.size();

        for (int i = 0; i < recordTypesSize; i++) {
            if (contactsPage.recordTypeOptions.get(i).getText().contains(recordType)) {
                contactsPage.recordTypeOptions.get(i).click();
            }
        }

    }

    @Then("I should see {string} message")
    public void iShouldSeeMesage(String messageType) {
        waitFor(1);
        switch (messageType) {
            case "We hit a snag.":
                Assert.assertTrue(contactsPage.weHitASnagWarning.isDisplayed());
                break;
            case "Lost Reason Warning":
                Assert.assertTrue(contactsPage.lostReasonWarningMessage.isDisplayed());
                break;
            case "Stage Change Success":
                Assert.assertTrue(contactsPage.successMessage.getText().contains("Stage changed successfully."));
                break;
            default:
                System.out.println("Please enter valid messageType");
                break;
        }
    }

    @And("{string} message should be contain mandatory fields of {string}")
    public void messageShouldBeContainMandatoryFieldsOf(String messageType, String recordType) {
        waitFor(1);
        switch (messageType) {
            case "We hit a snag.":
                switch (recordType) {
                    case "Candidate":
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Name"));
                        break;
                    case "Employee":
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Employment Type"));
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Name"));
                        break;
                    case "Freelancer":
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Name"));
                        break;
                    case "Manager":
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Name"));
                        break;
                    case "Business Account":
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Account Name"));
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Status"));
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Business Terms"));
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Business Tier"));
                        break;
                    case "Nelta Candidates":
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Account Name"));
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Status"));
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Business Terms"));
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Business Tier"));
                        break;
                    case "Jobs":
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Title"));
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Close Date"));
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Stage"));
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Job Description"));
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Category"));
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Required Hardware"));
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Hardware Technical Details"));
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Commitment"));
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Job Status"));
                        break;
                    case "Projects":
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Title"));
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Close Date"));
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Account Name"));
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("End Client Manager"));
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Stage"));
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Project Description"));
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Category"));
                        break;
                    case "Job":
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Candidate"));
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Opportunity"));
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Cost Center"));
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Start Date"));
                        break;
                    case "Project":
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Candidate"));
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Opportunity"));
                        Assert.assertTrue(contactsPage.warningReviewText.getText().contains("Cost Center"));
                        break;
                    default:
                        System.out.println("Please enter valid recordType");
                        break;
                }
                break;
            default:
                System.out.println("Please enter valid messageType");
                break;
        }
    }


    @Then("New {string} should be created with {string}")
    public void newContactShouldBeCreatedWith(String navbarName, String inputText) {
        switch (navbarName) {
            case "account":
                waitFor(1);
                Driver.getDriver().navigate().refresh();
                Assert.assertTrue(accountsPage.createdAccountName.getText().contains(inputText));
                break;
            case "contact":
                waitFor(1);
                Driver.getDriver().navigate().refresh();
                Assert.assertTrue(contactsPage.createdContactName.getText().contains(inputText));
                break;
            case "opportunity":
                waitFor(1);
                Driver.getDriver().navigate().refresh();
                WebElement createdOpportunityName = Driver.getDriver().findElement(By.xpath("//lightning-formatted-text[text()='" + inputText + "']"));
                Assert.assertTrue(createdOpportunityName.getText().contains(inputText));
                break;
            case "placement":
                waitFor(1);
                Driver.getDriver().get(ConfigReader.getProperty("Placements"));
                Assert.assertTrue(placementsPage.firstStartDateInPlacementTable.getText().contains(inputText));
                Driver.getDriver().navigate().back();
                break;
            default:
                System.out.println("Please enter valid navbarName");
                break;
        }
    }

    @When("I click {string} button on {string} Navbar as {string}")
    public void iClickButtonOnNavbarAs(String buttonName, String navbarName, String recordType) {
        waitFor(3);
        contactsPage.firstShowMoreActionDropdown().click();
        Driver.getDriver().findElement(By.xpath("//*[@name='" + buttonName + "']")).click();
    }


    @And("I click {string} confirm button")
    public void iClickConfirmButton(String buttonName) {
        waitFor(1);
        switch (buttonName) {
            case "Delete":
                contactsPage.deleteConfirmButton.click();
                break;
            default:
                System.out.println("Please enter valid buttonName");
                break;
        }
    }

    @And("I select {string} from {string} dropdown")
    public void iSelectFromDropdown(String selectedElement, String dropdownName) {
        waitFor(1);
        switch (dropdownName) {
            case "Employment Type":
                contactsPage.employeeTypeDropdown.click();
                actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//span[text()='" + selectedElement + "'])[1]"))).click().perform();
                break;
            case "Show more actions":
                switch (selectedElement) {
                    case "Delete":
                        contactsPage.firstShowMoreActionDropdown().click();
                        actions.click(contactsPage.firstShowMoreActionDropdown()).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
                        break;
                    default:
                        System.out.println("Please enter valid selectedElement");
                        break;
                }
                break;
            case "Source":

                scrollIntoView(contactsPage.sourceInputBoxDropdown);
                contactsPage.sourceInputBoxDropdown.click();

                scrollIntoView(Driver.getDriver().findElement(By.xpath("(//span[text()='" + selectedElement + "'])[1]")));
                actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//span[text()='" + selectedElement + "'])[1]"))).click().perform();

                if ("Employee to Nelta".equals(selectedElement)) {
                    actions.click(contactsPage.employeeSearchDropdown).pause(Duration.ofMillis(300))
                            .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                            .sendKeys(Keys.ENTER)
                            .perform();
                }
                break;
            case "Stage":
                select = new Select(opportunitiesPage.selectClosedStageDropdown);
                select.selectByVisibleText(selectedElement);
                break;
            case "Lost Reason":
                actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//span[@title='" + selectedElement + "'])[1]"))).click().perform();
                break;
            default:
                System.out.println("Please enter valid dropdownName");
                break;
        }
    }

    @Then("New contact should be created with source {string}")
    public void newContactShouldBeCreatedWithSource(String sourceName) {
        contactsPage.contactDetailsButton.click();
        waitFor(1);
        scrollIntoView(contactsPage.contactDetailsSourceText);
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//lightning-formatted-text[text()='" + sourceName + "']")).isDisplayed());


    }

    @And("I fill out {string} form as {string}")
    public void iFillOutFormAs(String formName, String recordType) {
        switch (formName) {
            case "New Contact":
                switch (recordType) {
                    case "Candidate":
                        //---------Contact Information------
                        contactsPage.contactPossibilitiesPhone.click();
                        contactsPage.firstMoveToChosen.click();
                        waitFor(1);

                        //--salutation
                        actions.click(contactsPage.salutationInputBoxDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        contactsPage.firstNameImputBox.sendKeys("Thomas");
                        contactsPage.lastNameImputBox.sendKeys("Müller");
                        contactsPage.emailImputBox.sendKeys("t.mueller@nelta.de");
                        contactsPage.mobilePhoneImputBox.sendKeys("0176 123456");
                        contactsPage.phoneImputBox.sendKeys("040 123456");

                        //--gender
                        actions.click(contactsPage.genderInputBoxDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_UP).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        contactsPage.birthdateImputBox.sendKeys("11.11.2001");

                        scrollIntoView(contactsPage.languageEnglish);
                        contactsPage.languageEnglish.click();
                        contactsPage.secondMoveToChosen.click();

                        //--source
                        scrollIntoView(contactsPage.sourceInputBoxDropdown);
                        actions.click(contactsPage.sourceInputBoxDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        //--employee
                        scrollIntoView(contactsPage.employeeSearchDropdown);
                        //actions.click(contactsPage.employeeSearchDropdown).pause(Duration.ofMillis(300))
                        //        .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                        //        .sendKeys(Keys.ENTER)
                        //        .perform();

                        //--experience
                        scrollIntoView(contactsPage.candidateExperienceDropdown);
                        actions.click(contactsPage.candidateExperienceDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        scrollIntoView(contactsPage.competencesDEV);
                        contactsPage.competencesQA.click();
                        contactsPage.thirdMoveToChosen.click();

                        scrollIntoView(contactsPage.availibility);
                        contactsPage.availibility.sendKeys("05.05.2023");
                        //--status
                        scrollIntoView(contactsPage.statusInTheProfileDropdown);
                        actions.click(contactsPage.statusInTheProfileDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        //---------Adress Information------
                        contactsPage.streetTextArea.sendKeys("Hamburger Str.");
                        contactsPage.zipPostalCodeInputBox.sendKeys("20027");
                        contactsPage.cityInputBox.sendKeys("Hamburg");
                        contactsPage.provinceInputBox.sendKeys("Hamburg");
                        contactsPage.countryInputBox.sendKeys("Germany");
                        //---price Range
                        scrollIntoView(contactsPage.priceRangeDropdown);
                        actions.click(contactsPage.priceRangeDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        contactsPage.minimumSalaryInputBox.sendKeys("2500");
                        contactsPage.currentSalaryInputBox.sendKeys("3000");
                        contactsPage.expectedSalaryInputBox.sendKeys("3500");
                        //---account name
                        scrollIntoView(contactsPage.accountNameSearchBox);
                        actions.click(contactsPage.accountNameSearchBox).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        break;
                    case "Employee":
                        //--employmentType
                        actions.click(contactsPage.employeeTypeDropdown).pause(Duration.ofMillis(1000))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        //---account name
                        scrollIntoView(contactsPage.accountNameSearchBox);
                        actions.click(contactsPage.accountNameSearchBox).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        //--salutation
                        actions.click(contactsPage.salutationInputBoxDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        contactsPage.firstNameImputBox.sendKeys("Thomas");
                        contactsPage.lastNameImputBox.sendKeys("Müller");
                        contactsPage.titleImputBox.sendKeys("Herr.");
                        contactsPage.emailImputBox.sendKeys("t.mueller@nelta.de");
                        contactsPage.mobilePhoneImputBox.sendKeys("0176 123456");
                        contactsPage.phoneImputBox.sendKeys("040 123456");

                        //--gender
                        scrollIntoView(contactsPage.genderInputBoxDropdown);
                        actions.click(contactsPage.genderInputBoxDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_UP).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        contactsPage.birthdateImputBox.sendKeys("11.11.2001");

                        scrollIntoView(contactsPage.birthdateImputBox);
                        contactsPage.languageEnglish.click();
                        contactsPage.firstMoveToChosen.click();

                        //---------Contact Information------
                        scrollIntoView(contactsPage.contactPossibilitiesPhone);
                        contactsPage.contactPossibilitiesPhone.click();
                        contactsPage.secondMoveToChosen.click();
                        waitFor(1);
                        //---------Can Mailshot------
                        actions.click(contactsPage.canMailshotDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        scrollIntoView(contactsPage.availibility);
                        contactsPage.availibility.sendKeys("05.05.2023");
                        //--experience
                        scrollIntoView(contactsPage.candidateExperienceDropdown);
                        actions.click(contactsPage.candidateExperienceDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        //--competences
                        scrollIntoView(contactsPage.competencesDEV);
                        contactsPage.competencesQA.click();
                        contactsPage.thirdMoveToChosen.click();
                        //--source
                        scrollIntoView(contactsPage.sourceInputBoxDropdown);
                        actions.click(contactsPage.sourceInputBoxDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        //--employee
                        scrollIntoView(contactsPage.employeeSearchDropdown);
                        //actions.click(contactsPage.employeeSearchDropdown).pause(Duration.ofMillis(300))
                        //        //.sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                        //        .sendKeys(Keys.ENTER).perform();

                        //---------Adress Information------
                        scrollIntoView(contactsPage.streetTextArea);
                        contactsPage.streetTextArea.sendKeys("Hamburger Str.");
                        contactsPage.zipPostalCodeInputBox.sendKeys("20027");
                        contactsPage.cityInputBox.sendKeys("Hamburg");
                        contactsPage.provinceInputBox.sendKeys("Hamburg");
                        contactsPage.countryInputBox.sendKeys("Germany");
                        //---price Range
                        scrollIntoView(contactsPage.priceRangeDropdown);
                        actions.click(contactsPage.priceRangeDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        contactsPage.minimumSalaryInputBox.sendKeys("2500");
                        contactsPage.currentSalaryInputBox.sendKeys("3000");
                        contactsPage.expectedSalaryInputBox.sendKeys("3500");
                        //-------marketing
                        scrollIntoView(contactsPage.infoFutureCooperationDropdown);
                        actions.click(contactsPage.infoFutureCooperationDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        actions.click(contactsPage.trendsIndustryDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        actions.click(contactsPage.meetingsEventsIndustryDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        actions.click(contactsPage.participationIndustryDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        scrollIntoView(contactsPage.otherMarketingMessagesDropdown);
                        actions.click(contactsPage.otherMarketingMessagesDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        break;
                    case "Freelancer":
                        //---------Contact Information------
                        contactsPage.contactPossibilitiesPhone.click();
                        contactsPage.firstMoveToChosen.click();
                        waitFor(1);

                        //---account name
                        actions.click(contactsPage.accountNameSearchBox).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        //--salutation
                        actions.click(contactsPage.salutationInputBoxDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        contactsPage.firstNameImputBox.sendKeys("Thomas");
                        contactsPage.lastNameImputBox.sendKeys("Müller");
                        contactsPage.titleImputBox.sendKeys("Herr.");
                        contactsPage.emailImputBox.sendKeys("t.mueller@nelta.de");
                        contactsPage.mobilePhoneImputBox.sendKeys("0176 123456");
                        contactsPage.phoneImputBox.sendKeys("040 123456");

                        //--gender
                        scrollIntoView(contactsPage.genderInputBoxDropdown);
                        actions.click(contactsPage.genderInputBoxDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_UP).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        contactsPage.birthdateImputBox.sendKeys("11.11.2001");

                        scrollIntoView(contactsPage.birthdateImputBox);
                        contactsPage.languageEnglish.click();
                        contactsPage.secondMoveToChosen.click();
                        //--experience
                        scrollIntoView(contactsPage.candidateExperienceDropdown);
                        actions.click(contactsPage.candidateExperienceDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        //--competences
                        scrollIntoView(contactsPage.competencesDEV);
                        contactsPage.competencesQA.click();
                        contactsPage.thirdMoveToChosen.click();

                        scrollIntoView(contactsPage.availibility);
                        contactsPage.availibility.sendKeys("05.05.2023");

                        //---------Can Mailshot------
                        actions.click(contactsPage.canMailshotDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        //--status
                        scrollIntoView(contactsPage.statusInTheProfileDropdown);
                        actions.click(contactsPage.statusInTheProfileDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        //---------Adress Information------
                        scrollIntoView(contactsPage.streetTextArea);
                        contactsPage.streetTextArea.sendKeys("Hamburger Str.");
                        contactsPage.zipPostalCodeInputBox.sendKeys("20027");
                        contactsPage.cityInputBox.sendKeys("Hamburg");
                        contactsPage.provinceInputBox.sendKeys("Hamburg");
                        contactsPage.countryInputBox.sendKeys("Germany");
                        //---price Range
                        scrollIntoView(contactsPage.priceRangeDropdown);
                        actions.click(contactsPage.priceRangeDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        contactsPage.minimumHourlyInputBox.sendKeys("15");
                        contactsPage.currentHourlyInputBox.sendKeys("18");
                        contactsPage.expectedHourlyInputBox.sendKeys("20");

                        //-------marketing
                        scrollIntoView(contactsPage.infoFutureCooperationDropdown);
                        actions.click(contactsPage.infoFutureCooperationDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        actions.click(contactsPage.trendsIndustryDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        actions.click(contactsPage.meetingsEventsIndustryDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        actions.click(contactsPage.participationIndustryDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        scrollIntoView(contactsPage.otherMarketingMessagesDropdown);
                        actions.click(contactsPage.otherMarketingMessagesDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        break;
                    case "Manager":
                        //---------Contact Information------
                        contactsPage.contactPossibilitiesPhone.click();
                        contactsPage.firstMoveToChosen.click();
                        waitFor(1);
                        //---account name
                        actions.click(contactsPage.accountNameSearchBox).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        //--salutation
                        actions.click(contactsPage.salutationInputBoxDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        contactsPage.firstNameImputBox.sendKeys("Thomas");
                        contactsPage.lastNameImputBox.sendKeys("Müller");
                        contactsPage.titleImputBox.sendKeys("Herr.");
                        contactsPage.emailImputBox.sendKeys("t.mueller@nelta.de");
                        contactsPage.mobilePhoneImputBox.sendKeys("0176 123456");
                        contactsPage.phoneImputBox.sendKeys("040 123456");
                        contactsPage.departmentInputBox.sendKeys("HR");

                        //---------Can Mailshot------
                        scrollIntoView(contactsPage.canMailshotDropdown);
                        actions.click(contactsPage.canMailshotDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        //---------Adress Information------
                        scrollIntoView(contactsPage.streetTextArea);
                        contactsPage.streetTextArea.sendKeys("Hamburger Str.");
                        contactsPage.zipPostalCodeInputBox.sendKeys("20027");
                        contactsPage.cityInputBox.sendKeys("Hamburg");
                        contactsPage.provinceInputBox.sendKeys("Hamburg");
                        contactsPage.countryInputBox.sendKeys("Germany");
                        //-------marketing
                        scrollIntoView(contactsPage.infoFutureCooperationDropdown);
                        actions.click(contactsPage.infoFutureCooperationDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        actions.click(contactsPage.trendsIndustryDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        actions.click(contactsPage.meetingsEventsIndustryDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        actions.click(contactsPage.participationIndustryDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        scrollIntoView(contactsPage.otherMarketingMessagesDropdown);
                        actions.click(contactsPage.otherMarketingMessagesDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        break;
                    default:
                        System.out.println("Please enter valid recordType");
                        break;
                }
                break;
            case "New Account":
                //---------Account Information------
                accountsPage.accountNameInputBox.sendKeys("Thomas Müller e.V.");

                actions.click(accountsPage.industryDropdown).pause(Duration.ofMillis(300))
                        .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                        .sendKeys(Keys.ENTER).perform();

                actions.click(accountsPage.statusDropdown).pause(Duration.ofMillis(300))
                        .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                        .sendKeys(Keys.ENTER).perform();

                scrollIntoView(accountsPage.businessTermsDropdown);
                actions.click(accountsPage.businessTermsDropdown).pause(Duration.ofMillis(300))
                        .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                        .sendKeys(Keys.ENTER).perform();

                scrollIntoView(accountsPage.businessTierDropdown);
                actions.click(accountsPage.businessTierDropdown).pause(Duration.ofMillis(300))
                        .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                        .sendKeys(Keys.ENTER).perform();
                contactsPage.phoneImputBox.sendKeys("040 123456");
                accountsPage.websiteImputBox.sendKeys("https://www.thomasmueller.de");
                //---------Adress Information------
                scrollIntoView(contactsPage.streetTextArea);
                contactsPage.streetTextArea.sendKeys("Hamburger Str.");
                contactsPage.zipPostalCodeInputBox.sendKeys("20027");
                contactsPage.cityInputBox.sendKeys("Hamburg");
                contactsPage.provinceInputBox.sendKeys("Hamburg");
                contactsPage.countryInputBox.sendKeys("Germany");
                //---------Activity Summary------
                scrollIntoView(accountsPage.lastContactDateImputBox);
                accountsPage.lastContactDateImputBox.sendKeys("20.10.2022");
                accountsPage.lastMeetingImputBox.sendKeys("01.12.2022");
                accountsPage.lastInterviewImputBox.sendKeys("05.12.2022");
                accountsPage.lastPlacementDateImputBox.sendKeys("12.12.2022");
                break;
            case "New Opportunity":
                switch (recordType) {
                    case "Jobs":
                        opportunitiesPage.opportunitiesTitleInputBox.sendKeys("QA Software Tester");
                        opportunitiesPage.closeDateInputBox.sendKeys("13.12.2022");

                        //---account name
                        actions.click(contactsPage.accountNameSearchBox).pause(Duration.ofMillis(300))
                                //.sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        opportunitiesPage.probabilityInputBox.sendKeys("75");
                        //---hiring Manager
                        actions.click(opportunitiesPage.hiringManagerSearchBox).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        actions.click(opportunitiesPage.stageDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        scrollIntoView(opportunitiesPage.jobDescriptionTextBox);
                        opportunitiesPage.jobDescriptionTextBox.click();
                        opportunitiesPage.jobDescriptionTextField.sendKeys("Das ist eine Job Definition");
                        //---category
                        scrollIntoView(opportunitiesPage.categoryDropdown);
                        actions.click(opportunitiesPage.categoryDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        opportunitiesPage.dailyHoursInputBox.sendKeys("8");
                        opportunitiesPage.salaryRangeMinumumInputBox.sendKeys("2000");
                        opportunitiesPage.salaryRangeMaximumInputBox.sendKeys("5000");

                        scrollIntoView(opportunitiesPage.requiredHardwareInputBox);
                        opportunitiesPage.requiredHardwareInputBox.sendKeys("Laptop and Mause");
                        opportunitiesPage.hardwareTechnicalDetailsInputBox.sendKeys("Microsoft 10 / IOS15 or more");

                        //---commitment
                        scrollIntoView(opportunitiesPage.commitmentDropdown);
                        actions.click(opportunitiesPage.commitmentDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        actions.click(opportunitiesPage.jobStatusDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        //--competences
                        scrollIntoView(contactsPage.competencesQA);
                        contactsPage.competencesQA.click();
                        contactsPage.firstMoveToChosen.click();

                        actions.click(opportunitiesPage.lostReasonDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_UP).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        break;
                    case "Projects":
                        opportunitiesPage.opportunitiesTitleInputBox.sendKeys("Salesforce Testing Project");
                        opportunitiesPage.closeDateInputBox.sendKeys("13.12.2022");

                        //---account name
                        actions.click(contactsPage.accountNameSearchBox).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        opportunitiesPage.probabilityInputBox.sendKeys("80");
                        //---end clint manager
                        scrollIntoView(opportunitiesPage.endClientManagerSearchBox);
                        actions.click(opportunitiesPage.endClientManagerSearchBox).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        actions.click(opportunitiesPage.stageDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN)
                                .sendKeys(Keys.ENTER).perform();

                        //----project description
                        scrollIntoView(opportunitiesPage.projectDescriptionTextBox);
                        opportunitiesPage.projectDescriptionTextBox.click();
                        opportunitiesPage.projectDescriptionTextField.sendKeys("Das ist eine Project Definition");
                        //---category
                        scrollIntoView(opportunitiesPage.categoryDropdown);
                        actions.click(opportunitiesPage.categoryDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN)
                                .sendKeys(Keys.ARROW_DOWN)
                                .sendKeys(Keys.ENTER).perform();
                        actions.click(opportunitiesPage.projectSourceDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN)
                                .sendKeys(Keys.ARROW_DOWN)
                                .sendKeys(Keys.ENTER).perform();
                        actions.click(opportunitiesPage.commitmentDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN)
                                .sendKeys(Keys.ENTER).perform();
                        actions.click(opportunitiesPage.projectStatusDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN)
                                .sendKeys(Keys.ENTER).perform();
                        //--competences
                        scrollIntoView(contactsPage.competencesQA);
                        contactsPage.competencesQA.click();
                        contactsPage.firstMoveToChosen.click();
                        //---rates
                        scrollIntoView(opportunitiesPage.rateCycleDropdown);
                        actions.click(opportunitiesPage.rateCycleDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        opportunitiesPage.dailyRateInputBox.sendKeys("160");
                        opportunitiesPage.hourlyRateInputBox.sendKeys("20");
                        opportunitiesPage.dailyHoursInputBox.sendKeys("8");
                        //---lost reason
                        scrollIntoView(opportunitiesPage.lostReasonDropdown);
                        actions.click(opportunitiesPage.lostReasonDropdown).pause(Duration.ofMillis(300))
                                //.sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                //.sendKeys(Keys.ARROW_UP).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
                        break;
                    default:
                        System.out.println("Please enter valid recordType");
                        break;
                }
                break;
            case "New Placement":
                switch (recordType) {
                    case "Job":
                        actions.click(placementsPage.firstSearchContactsInputBox).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        actions.click(placementsPage.oppurtunitySearchOpportunitiesInputBox).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        actions.click(placementsPage.costCenterDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        placementsPage.startDateImputBox.sendKeys("10.05.2023");

                        scrollIntoView(placementsPage.endDateImputBox);
                        placementsPage.endDateImputBox.sendKeys("10.11.2023");
                        placementsPage.cancellationPeriodImputBox.sendKeys("10.08.2023");
                        placementsPage.serviceDescriptionTextarea.sendKeys("This is a service description");
                        break;
                    case "Project":
                        actions.click(placementsPage.firstSearchContactsInputBox).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        actions.click(placementsPage.oppurtunitySearchOpportunitiesInputBox).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        actions.click(placementsPage.costCenterDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN)
                                .sendKeys(Keys.ARROW_DOWN)
                                .sendKeys(Keys.ARROW_DOWN)
                                .sendKeys(Keys.ENTER).perform();

                        placementsPage.billRateImputBox.sendKeys("20");

                        scrollIntoView(placementsPage.endDateImputBox);
                        placementsPage.payRateImputBox.sendKeys("18");
                        placementsPage.startDateImputBox.sendKeys("10.08.2023");
                        placementsPage.endDateImputBox.sendKeys("10.11.2023");

                        actions.click(placementsPage.firstSearchContactsInputBox).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        placementsPage.serviceDescriptionTextarea.sendKeys("This is a service description");
                        break;
                    default:
                        System.out.println("Please enter valid recordType");
                        break;
                }
                break;
            default:
                System.out.println("Please enter valid formName");
                break;
        }

    }

    @Then("New {string} should be {string}")
    public void newShouldBe(String navbarName, String infoType) {
        waitFor(2);
        switch (infoType) {
            case "created":
                Assert.assertTrue(contactsPage.successMessage.getText().contains("was created"));
                break;
            case "deleted":
                Assert.assertTrue(contactsPage.successMessage.getText().contains("was deleted"));
                break;
            case "saved":
                Assert.assertTrue(contactsPage.successMessage.getText().contains("was saved"));
                break;
            default:
                System.out.println("Please enter valid infoType");
                break;
        }

    }


    @And("All fields should be displayed on {string} page as {string}")
    public void allFieldsShouldBeDisplayedOnPageAs(String navbarName, String recordType) {
        switch (navbarName) {
            case "Contacts":
                switch (recordType) {
                    case "Candidate":
                        //---------Contact Information------
                        Assert.assertTrue(contactsPage.contactPossibilitiesPhone.isDisplayed());
                        //--salutation
                        Assert.assertTrue(contactsPage.salutationInputBoxDropdown.isDisplayed());
                        //name
                        scrollIntoView(contactsPage.firstNameImputBox);
                        Assert.assertTrue(contactsPage.firstNameImputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.lastNameImputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.emailImputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.mobilePhoneImputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.phoneImputBox.isDisplayed());
                        //--gender
                        Assert.assertTrue(contactsPage.genderInputBoxDropdown.isDisplayed());
                        Assert.assertTrue(contactsPage.birthdateImputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.languageEnglish.isDisplayed());
                        //--source
                        Assert.assertTrue(contactsPage.sourceInputBoxDropdown.isDisplayed());
                        //--employee
                        scrollIntoView(contactsPage.employeeSearchDropdown);
                        Assert.assertTrue(contactsPage.employeeSearchDropdown.isDisplayed());
                        //--experience
                        scrollIntoView(contactsPage.candidateExperienceDropdown);
                        Assert.assertTrue(contactsPage.candidateExperienceDropdown.isDisplayed());

                        scrollIntoView(contactsPage.competencesDEV);
                        Assert.assertTrue(contactsPage.competencesDEV.isDisplayed());
                        scrollIntoView(contactsPage.availibility);
                        Assert.assertTrue(contactsPage.availibility.isDisplayed());
                        //--status
                        scrollIntoView(contactsPage.statusInTheProfileDropdown);
                        Assert.assertTrue(contactsPage.statusInTheProfileDropdown.isDisplayed());
                        //---------Adress Information------
                        scrollIntoView(contactsPage.streetTextArea);
                        Assert.assertTrue(contactsPage.streetTextArea.isDisplayed());
                        Assert.assertTrue(contactsPage.zipPostalCodeInputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.cityInputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.provinceInputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.countryInputBox.isDisplayed());
                        //---price Range
                        scrollIntoView(contactsPage.priceRangeDropdown);
                        Assert.assertTrue(contactsPage.priceRangeDropdown.isDisplayed());
                        Assert.assertTrue(contactsPage.minimumSalaryInputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.currentSalaryInputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.expectedSalaryInputBox.isDisplayed());
                        //---account name
                        scrollIntoView(contactsPage.accountNameSearchBox);
                        Assert.assertTrue(contactsPage.accountNameSearchBox.isDisplayed());
                        break;
                    case "Employee":
                        //--employmentType
                        Assert.assertTrue(contactsPage.employeeTypeDropdown.isDisplayed());
                        //---account name
                        scrollIntoView(contactsPage.accountNameSearchBox);
                        Assert.assertTrue(contactsPage.accountNameSearchBox.isDisplayed());
                        //--salutation
                        Assert.assertTrue(contactsPage.salutationInputBoxDropdown.isDisplayed());

                        //name
                        scrollIntoView(contactsPage.firstNameImputBox);
                        Assert.assertTrue(contactsPage.firstNameImputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.lastNameImputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.titleImputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.emailImputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.mobilePhoneImputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.phoneImputBox.isDisplayed());
                        //--gender
                        Assert.assertTrue(contactsPage.genderInputBoxDropdown.isDisplayed());
                        Assert.assertTrue(contactsPage.birthdateImputBox.isDisplayed());

                        scrollIntoView(contactsPage.birthdateImputBox);
                        Assert.assertTrue(contactsPage.languageEnglish.isDisplayed());
                        //---------Contact Information------
                        scrollIntoView(contactsPage.contactPossibilitiesPhone);
                        Assert.assertTrue(contactsPage.contactPossibilitiesPhone.isDisplayed());
                        waitFor(1);
                        //---------Can Mailshot------
                        Assert.assertTrue(contactsPage.canMailshotDropdown.isDisplayed());

                        scrollIntoView(contactsPage.availibility);
                        Assert.assertTrue(contactsPage.availibility.isDisplayed());
                        //--experience
                        scrollIntoView(contactsPage.candidateExperienceDropdown);
                        Assert.assertTrue(contactsPage.candidateExperienceDropdown.isDisplayed());
                        //--competences
                        scrollIntoView(contactsPage.competencesDEV);
                        Assert.assertTrue(contactsPage.competencesQA.isDisplayed());
                        //--source
                        scrollIntoView(contactsPage.sourceInputBoxDropdown);
                        Assert.assertTrue(contactsPage.sourceInputBoxDropdown.isDisplayed());
                        //--employee
                        scrollIntoView(contactsPage.employeeSearchDropdown);
                        Assert.assertTrue(contactsPage.employeeSearchDropdown.isDisplayed());
                        //---------Adress Information------
                        scrollIntoView(contactsPage.streetTextArea);
                        Assert.assertTrue(contactsPage.streetTextArea.isDisplayed());
                        Assert.assertTrue(contactsPage.zipPostalCodeInputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.cityInputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.provinceInputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.countryInputBox.isDisplayed());
                        //---price Range
                        scrollIntoView(contactsPage.priceRangeDropdown);
                        Assert.assertTrue(contactsPage.priceRangeDropdown.isDisplayed());
                        Assert.assertTrue(contactsPage.minimumSalaryInputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.currentSalaryInputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.expectedSalaryInputBox.isDisplayed());
                        //-------marketing
                        scrollIntoView(contactsPage.infoFutureCooperationDropdown);
                        Assert.assertTrue(contactsPage.infoFutureCooperationDropdown.isDisplayed());
                        Assert.assertTrue(contactsPage.trendsIndustryDropdown.isDisplayed());
                        Assert.assertTrue(contactsPage.meetingsEventsIndustryDropdown.isDisplayed());
                        Assert.assertTrue(contactsPage.participationIndustryDropdown.isDisplayed());
                        Assert.assertTrue(contactsPage.otherMarketingMessagesDropdown.isDisplayed());
                        break;
                    case "Freelancer":
                        //---------Contact Information------
                        Assert.assertTrue(contactsPage.contactPossibilitiesPhone.isDisplayed());
                        waitFor(1);

                        //---account name
                        Assert.assertTrue(contactsPage.accountNameSearchBox.isDisplayed());
                        //--salutation
                        Assert.assertTrue(contactsPage.salutationInputBoxDropdown.isDisplayed());
                        //name
                        scrollIntoView(contactsPage.firstNameImputBox);
                        Assert.assertTrue(contactsPage.firstNameImputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.lastNameImputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.titleImputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.emailImputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.mobilePhoneImputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.phoneImputBox.isDisplayed());

                        //--gender
                        Assert.assertTrue(contactsPage.genderInputBoxDropdown.isDisplayed());

                        Assert.assertTrue(contactsPage.birthdateImputBox.isDisplayed());
                        scrollIntoView(contactsPage.birthdateImputBox);
                        Assert.assertTrue(contactsPage.languageEnglish.isDisplayed());
                        //--experience
                        scrollIntoView(contactsPage.candidateExperienceDropdown);
                        Assert.assertTrue(contactsPage.candidateExperienceDropdown.isDisplayed());
                        //--competences
                        scrollIntoView(contactsPage.competencesDEV);
                        Assert.assertTrue(contactsPage.competencesQA.isDisplayed());

                        scrollIntoView(contactsPage.availibility);
                        Assert.assertTrue(contactsPage.availibility.isDisplayed());
                        //---------Can Mailshot------
                        Assert.assertTrue(contactsPage.canMailshotDropdown.isDisplayed());
                        //--status
                        scrollIntoView(contactsPage.statusInTheProfileDropdown);
                        Assert.assertTrue(contactsPage.statusInTheProfileDropdown.isDisplayed());
                        //---------Adress Information------
                        scrollIntoView(contactsPage.streetTextArea);
                        Assert.assertTrue(contactsPage.streetTextArea.isDisplayed());
                        Assert.assertTrue(contactsPage.zipPostalCodeInputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.cityInputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.provinceInputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.countryInputBox.isDisplayed());
                        //---price Range
                        scrollIntoView(contactsPage.priceRangeDropdown);
                        Assert.assertTrue(contactsPage.priceRangeDropdown.isDisplayed());
                        Assert.assertTrue(contactsPage.minimumHourlyInputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.currentHourlyInputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.expectedHourlyInputBox.isDisplayed());
                        //-------marketing
                        scrollIntoView(contactsPage.infoFutureCooperationDropdown);
                        Assert.assertTrue(contactsPage.infoFutureCooperationDropdown.isDisplayed());
                        Assert.assertTrue(contactsPage.trendsIndustryDropdown.isDisplayed());
                        Assert.assertTrue(contactsPage.meetingsEventsIndustryDropdown.isDisplayed());
                        Assert.assertTrue(contactsPage.participationIndustryDropdown.isDisplayed());
                        Assert.assertTrue(contactsPage.otherMarketingMessagesDropdown.isDisplayed());
                        break;
                    case "Manager":
                        //---------Contact Information------
                        Assert.assertTrue(contactsPage.contactPossibilitiesPhone.isDisplayed());
                        waitFor(1);
                        //---account name
                        Assert.assertTrue(contactsPage.accountNameSearchBox.isDisplayed());
                        //--salutation
                        Assert.assertTrue(contactsPage.salutationInputBoxDropdown.isDisplayed());
                        //name
                        scrollIntoView(contactsPage.firstNameImputBox);
                        Assert.assertTrue(contactsPage.firstNameImputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.lastNameImputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.titleImputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.emailImputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.mobilePhoneImputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.phoneImputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.departmentInputBox.isDisplayed());
                        //---------Can Mailshot------
                        scrollIntoView(contactsPage.canMailshotDropdown);
                        Assert.assertTrue(contactsPage.canMailshotDropdown.isDisplayed());
                        //---------Adress Information------
                        scrollIntoView(contactsPage.streetTextArea);
                        Assert.assertTrue(contactsPage.streetTextArea.isDisplayed());
                        Assert.assertTrue(contactsPage.zipPostalCodeInputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.cityInputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.provinceInputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.countryInputBox.isDisplayed());
                        //-------marketing
                        scrollIntoView(contactsPage.infoFutureCooperationDropdown);
                        Assert.assertTrue(contactsPage.infoFutureCooperationDropdown.isDisplayed());
                        Assert.assertTrue(contactsPage.trendsIndustryDropdown.isDisplayed());
                        Assert.assertTrue(contactsPage.meetingsEventsIndustryDropdown.isDisplayed());
                        Assert.assertTrue(contactsPage.participationIndustryDropdown.isDisplayed());
                        Assert.assertTrue(contactsPage.otherMarketingMessagesDropdown.isDisplayed());
                        break;
                    default:
                        System.out.println("Please enter valid recordType");
                        break;
                }
                break;
            case "Accounts":
                switch (recordType) {
                    case "Business Account":
                        //Account Info
                        Assert.assertTrue(accountsPage.accountNameInputBox.isDisplayed());
                        Assert.assertTrue(accountsPage.industryDropdown.isDisplayed());
                        Assert.assertTrue(accountsPage.parentAccountSearchDropdown.isDisplayed());
                        scrollIntoView(accountsPage.statusDropdown);
                        Assert.assertTrue(accountsPage.statusDropdown.isDisplayed());
                        Assert.assertTrue(accountsPage.businessTermsDropdown.isDisplayed());
                        Assert.assertTrue(accountsPage.businessTierDropdown.isDisplayed());
                        Assert.assertTrue(contactsPage.phoneImputBox.isDisplayed());
                        Assert.assertTrue(accountsPage.websiteImputBox.isDisplayed());
                        Assert.assertTrue(accountsPage.pointOfContactSearchDropdown.isDisplayed());
                        //Adsress Info
                        scrollIntoView(contactsPage.streetTextArea);
                        Assert.assertTrue(contactsPage.streetTextArea.isDisplayed());
                        Assert.assertTrue(contactsPage.zipPostalCodeInputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.provinceInputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.cityInputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.countryInputBox.isDisplayed());
                        //Activity
                        scrollIntoView(accountsPage.lastContactDateImputBox);
                        Assert.assertTrue(accountsPage.lastContactDateImputBox.isDisplayed());
                        Assert.assertTrue(accountsPage.lastMeetingImputBox.isDisplayed());
                        Assert.assertTrue(accountsPage.lastInterviewImputBox.isDisplayed());
                        Assert.assertTrue(accountsPage.lastPlacementDateImputBox.isDisplayed());
                        break;
                    case "Nelta Candidates":
                        //Account Info
                        Assert.assertTrue(accountsPage.accountNameInputBox.isDisplayed());
                        Assert.assertTrue(accountsPage.industryDropdown.isDisplayed());
                        Assert.assertTrue(accountsPage.parentAccountSearchDropdown.isDisplayed());
                        Assert.assertTrue(accountsPage.statusDropdown.isDisplayed());
                        scrollIntoView(accountsPage.businessTermsDropdown);
                        Assert.assertTrue(accountsPage.businessTermsDropdown.isDisplayed());
                        Assert.assertTrue(accountsPage.businessTierDropdown.isDisplayed());
                        Assert.assertTrue(contactsPage.phoneImputBox.isDisplayed());
                        Assert.assertTrue(accountsPage.websiteImputBox.isDisplayed());
                        Assert.assertTrue(accountsPage.pointOfContactSearchDropdown.isDisplayed());
                        //Adsress Info
                        scrollIntoView(contactsPage.streetTextArea);
                        Assert.assertTrue(contactsPage.streetTextArea.isDisplayed());
                        Assert.assertTrue(contactsPage.zipPostalCodeInputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.provinceInputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.cityInputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.countryInputBox.isDisplayed());
                        //Activity
                        scrollIntoView(accountsPage.lastContactDateImputBox);
                        Assert.assertTrue(accountsPage.lastContactDateImputBox.isDisplayed());
                        Assert.assertTrue(accountsPage.lastMeetingImputBox.isDisplayed());
                        Assert.assertTrue(accountsPage.lastInterviewImputBox.isDisplayed());
                        Assert.assertTrue(accountsPage.lastPlacementDateImputBox.isDisplayed());
                        break;
                    default:
                        System.out.println("Please enter valid recordType");
                        break;
                }
                break;
            case "Opportunities":
                switch (recordType) {
                    case "Jobs":
                        //Opportunities Info
                        Assert.assertTrue(opportunitiesPage.opportunitiesTitleInputBox.isDisplayed());
                        Assert.assertTrue(opportunitiesPage.closeDateInputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.accountNameSearchBox.isDisplayed());
                        Assert.assertTrue(opportunitiesPage.probabilityInputBox.isDisplayed());
                        Assert.assertTrue(opportunitiesPage.hiringManagerSearchBox.isDisplayed());
                        Assert.assertTrue(opportunitiesPage.stageDropdown.isDisplayed());
                        scrollIntoView(opportunitiesPage.jobDescriptionTextBox);
                        Assert.assertTrue(opportunitiesPage.jobDescriptionTextBox.isDisplayed());

                        scrollIntoView(opportunitiesPage.categoryDropdown);
                        Assert.assertTrue(opportunitiesPage.categoryDropdown.isDisplayed());
                        Assert.assertTrue(opportunitiesPage.dailyHoursInputBox.isDisplayed());
                        Assert.assertTrue(opportunitiesPage.salaryRangeMinumumInputBox.isDisplayed());
                        Assert.assertTrue(opportunitiesPage.salaryRangeMaximumInputBox.isDisplayed());

                        Assert.assertTrue(opportunitiesPage.requiredHardwareInputBox.isDisplayed());
                        Assert.assertTrue(opportunitiesPage.hardwareTechnicalDetailsInputBox.isDisplayed());

                        scrollIntoView(opportunitiesPage.commitmentDropdown);
                        Assert.assertTrue(opportunitiesPage.commitmentDropdown.isDisplayed());
                        Assert.assertTrue(opportunitiesPage.jobStatusDropdown.isDisplayed());
                        scrollIntoView(contactsPage.competencesQA);
                        Assert.assertTrue(contactsPage.competencesQA.isDisplayed());
                        Assert.assertTrue(opportunitiesPage.lostReasonDropdown.isDisplayed());
                        break;
                    case "Projects":
                        //Opportunities Info
                        Assert.assertTrue(opportunitiesPage.opportunitiesTitleInputBox.isDisplayed());
                        Assert.assertTrue(opportunitiesPage.closeDateInputBox.isDisplayed());
                        Assert.assertTrue(contactsPage.accountNameSearchBox.isDisplayed());
                        Assert.assertTrue(opportunitiesPage.probabilityInputBox.isDisplayed());
                        Assert.assertTrue(opportunitiesPage.endClientManagerSearchBox.isDisplayed());
                        Assert.assertTrue(opportunitiesPage.stageDropdown.isDisplayed());

                        scrollIntoView(opportunitiesPage.projectDescriptionTextBox);
                        Assert.assertTrue(opportunitiesPage.projectDescriptionTextBox.isDisplayed());

                        scrollIntoView(opportunitiesPage.categoryDropdown);
                        Assert.assertTrue(opportunitiesPage.categoryDropdown.isDisplayed());
                        Assert.assertTrue(opportunitiesPage.projectSourceDropdown.isDisplayed());
                        scrollIntoView(opportunitiesPage.commitmentDropdown);
                        Assert.assertTrue(opportunitiesPage.projectStatusDropdown.isDisplayed());

                        scrollIntoView(contactsPage.competencesQA);
                        Assert.assertTrue(contactsPage.competencesQA.isDisplayed());

                        scrollIntoView(opportunitiesPage.rateCycleDropdown);
                        Assert.assertTrue(opportunitiesPage.rateCycleDropdown.isDisplayed());
                        Assert.assertTrue(opportunitiesPage.dailyRateInputBox.isDisplayed());
                        Assert.assertTrue(opportunitiesPage.hourlyRateInputBox.isDisplayed());
                        Assert.assertTrue(opportunitiesPage.dailyHoursInputBox.isDisplayed());

                        scrollIntoView(opportunitiesPage.lostReasonDropdown);
                        Assert.assertTrue(opportunitiesPage.lostReasonDropdown.isDisplayed());
                        break;
                    default:
                        System.out.println("Please enter valid recordType");
                        break;
                }
                break;
            case "Placements":
                switch (recordType) {
                    case "Job":
                        Assert.assertTrue(placementsPage.firstSearchContactsInputBox.isDisplayed());
                        Assert.assertTrue(placementsPage.oppurtunitySearchOpportunitiesInputBox.isDisplayed());
                        Assert.assertTrue(placementsPage.costCenterDropdown.isDisplayed());
                        Assert.assertTrue(placementsPage.startDateImputBox.isDisplayed());
                        Assert.assertTrue(placementsPage.endDateImputBox.isDisplayed());


                        scrollIntoView(placementsPage.cancellationPeriodImputBox);
                        Assert.assertTrue(placementsPage.cancellationPeriodImputBox.isDisplayed());
                        Assert.assertTrue(placementsPage.serviceDescriptionTextarea.isDisplayed());
                        break;
                    case "Project":
                        Assert.assertTrue(placementsPage.firstSearchContactsInputBox.isDisplayed());
                        Assert.assertTrue(placementsPage.oppurtunitySearchOpportunitiesInputBox.isDisplayed());
                        Assert.assertTrue(placementsPage.costCenterDropdown.isDisplayed());
                        Assert.assertTrue(placementsPage.billRateImputBox.isDisplayed());

                        scrollIntoView(placementsPage.payRateImputBox);
                        Assert.assertTrue(placementsPage.payRateImputBox.isDisplayed());
                        Assert.assertTrue(placementsPage.startDateImputBox.isDisplayed());
                        Assert.assertTrue(placementsPage.endDateImputBox.isDisplayed());
                        Assert.assertTrue(placementsPage.secondSearchContactsInputBox.isDisplayed());
                        Assert.assertTrue(placementsPage.serviceDescriptionTextarea.isDisplayed());
                        break;
                    default:
                        System.out.println("Please enter valid recordType");
                        break;
                }
                break;
            case "new __":
                switch (recordType) {
                    case "Candidate":
                        break;
                    case "Manager":
                        break;
                    default:
                        System.out.println("Please enter valid recordType");
                        break;
                }
                break;
            default:
                System.out.println("Please enter valid formName");
                break;
        }

    }
}
