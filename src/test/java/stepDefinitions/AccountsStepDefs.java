package stepDefinitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.*;
import utilities.Driver;

import java.time.Duration;

import static utilities.ReusableMethods.scrollIntoView;

public class AccountsStepDefs {
    AccountsPage accountsPage = new AccountsPage();
    ContactsPage contactsPage = new ContactsPage();
    OpportunitiesPage opportunitiesPage = new OpportunitiesPage();
    PlacementsPage placementsPage = new PlacementsPage();

    Actions actions = new Actions(Driver.getDriver());

    @And("I fill out mandatory fields of {string} form as {string}")
    public void iFillOutMandatoryFieldsOfFormAs(String formName, String recordType) {
        switch (formName) {
            case "New Account":
                //---------Account Information------
                accountsPage.accountNameInputBox.sendKeys("Thomas Müller e.V.");

                actions.click(accountsPage.statusDropdown).pause(Duration.ofMillis(300))
                        .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                        .sendKeys(Keys.ENTER).perform();

                scrollIntoView(accountsPage.businessTermsDropdown);
                actions.click(accountsPage.businessTermsDropdown).pause(Duration.ofMillis(300))
                        .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                        .sendKeys(Keys.ENTER).perform();

                actions.click(accountsPage.businessTierDropdown).pause(Duration.ofMillis(300))
                        .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                        .sendKeys(Keys.ENTER).perform();
                break;
            case "New Contact":
                switch (recordType) {
                    case "Employee":
                        //--employmentType
                        scrollIntoView(contactsPage.employeeTypeDropdown);
                        actions.click(contactsPage.employeeTypeDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        scrollIntoView(contactsPage.lastNameImputBox);
                        contactsPage.lastNameImputBox.clear();
                        contactsPage.lastNameImputBox.sendKeys("Müller");
                        break;
                    default:
                        scrollIntoView(contactsPage.lastNameImputBox);
                        contactsPage.lastNameImputBox.clear();
                        contactsPage.lastNameImputBox.sendKeys("Müller");
                        break;
                }
                break;
            case "New Opportunity":
                switch (recordType) {
                    case "Jobs":
                        opportunitiesPage.opportunitiesTitleInputBox.sendKeys("QA Software Tester");
                        opportunitiesPage.closeDateInputBox.sendKeys("13.12.2022");

                        //---stage
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
                        break;
                    case "Projects":
                        opportunitiesPage.opportunitiesTitleInputBox.sendKeys("Salesforce Testing Project");
                        opportunitiesPage.closeDateInputBox.sendKeys("13.12.2022");

                        //---account name
                        actions.click(contactsPage.accountNameSearchBox).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

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
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_UP).pause(Duration.ofMillis(300))
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
                                .sendKeys(Keys.ARROW_DOWN)
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        placementsPage.startDateImputBox.sendKeys("10.05.2023");
                        break;
                    case "Project":
                        actions.click(placementsPage.firstSearchContactsInputBox).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        actions.click(placementsPage.oppurtunitySearchOpportunitiesInputBox).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();

                        actions.click(placementsPage.costCenterDropdown).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ARROW_DOWN)
                                .sendKeys(Keys.ARROW_DOWN)
                                .sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(300))
                                .sendKeys(Keys.ENTER).perform();
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
