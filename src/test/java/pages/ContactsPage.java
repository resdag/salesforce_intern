package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ContactsPage {

    public ContactsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "button[class='slds-button slds-button--reset downIcon slds-m-top_xxx-small slds-p-right_xxx-small']")
    public WebElement selectAListViewDropDown;

    @FindBy(css = ".selectedListView")
    public WebElement selectListViewTitle;

    @FindBy(css = "a[title='New']")
    public WebElement newButton;

    @FindBy(css = "a[title='Import']")
    public WebElement importButton;

    @FindBy(css = "a[title='Send List Email']")
    public WebElement sendListEmailButton;

    @FindBy(css = "a[title='Printable View']")
    public WebElement printableViewButton;

    @FindBy(css = ".changeRecordTypeOptionRightColumn")
    public List<WebElement> recordTypeOptions;

    @FindBy(xpath = "//span[text()='Next']")
    public WebElement newContactNextButton;

    @FindBy(xpath = "//button[@class='slds-button slds-button--neutral slds-button slds-button_neutral uiButton']")
    public WebElement newContactCancelButton;

    @FindBy(xpath = "//div[@aria-label='Success']")
    public WebElement successMessage;

    @FindBy(xpath = "//div[text()='You encountered some errors when trying to save this record']")
    public WebElement lostReasonWarningMessage;

    // New Contact: Candidate Locate-----------------------
    @FindBy(xpath = "//div[@data-value='Phone']")
    public WebElement contactPossibilitiesPhone;

    @FindBy(xpath = "//div[@data-value='E-Mail']")
    public WebElement contactPossibilitiesEmail;

    @FindBy(xpath = "//div[@data-value='SMS/WhatsApp']")
    public WebElement contactPossibilitiesSMSWhatsApp;

    @FindBy(xpath = "(//div[@class='slds-dueling-list__options'])[1]")
    public WebElement availableContactPossibilitiesBox;

    @FindBy(xpath = "(//div[@class='slds-dueling-list__options'])[2]")
    public WebElement chosenContactPossibilitiesBox;
    @FindBy(xpath = "(//button[@title='Move selection to Chosen'])[1]")
    public WebElement firstMoveToChosen;

    @FindBy(xpath = "(//button[@title='Move selection to Available'])[1]")
    public WebElement firstMoveToAvailable;
    @FindBy(xpath = "//button[@aria-label='Salutation, --None--']")
    public WebElement salutationInputBoxDropdown;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstNameImputBox;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastNameImputBox;

    @FindBy(xpath = "//input[@name='Email']")
    public WebElement emailImputBox;

    @FindBy(xpath = "//input[@name='MobilePhone']")
    public WebElement mobilePhoneImputBox;

    @FindBy(xpath = "//input[@name='Phone']")
    public WebElement phoneImputBox;

    @FindBy(xpath = "//button[@aria-label='Gender, Male']")
    public WebElement genderInputBoxDropdown;

    @FindBy(xpath = "//input[@name='Birthdate']")
    public WebElement birthdateImputBox;

    @FindBy(xpath = "(//div[@data-value='English'])[1]")
    public WebElement languageEnglish;

    @FindBy(css = "div[data-value='French']")
    public WebElement languageFrench;

    @FindBy(xpath = "(//div[@class='slds-dueling-list__options'])[3]")
    public WebElement availableLanguageBox;

    @FindBy(xpath = "(//div[@class='slds-dueling-list__options'])[4]")
    public WebElement chosenLanguageBox;

    @FindBy(xpath = "(//button[@title='Move selection to Chosen'])[2]")
    public WebElement secondMoveToChosen;

    @FindBy(xpath = "(//button[@title='Move selection to Available'])[2]")
    public WebElement secondMoveToAvailable;

    @FindBy(xpath = "(//button[@aria-label='Source, --None--'])[1]")
    public WebElement sourceInputBoxDropdown;

    @FindBy(xpath = "(//span[text()='XING'])[1]")
    public WebElement sourceInputBoxXING;

    @FindBy(xpath = "//input[@placeholder='Search Contacts...']")
    public WebElement employeeSearchDropdown;

    @FindBy(xpath = "(//button[@data-value='Junior'])[1]")
    public WebElement candidateExperienceDropdown;

    @FindBy(xpath = "//div[@data-value='DEV']")
    public WebElement competencesDEV;

    @FindBy(xpath = "//div[@data-value='QA']")
    public WebElement competencesQA;

    @FindBy(xpath = "//div[@data-value='SAP']")
    public WebElement competencesSAP;

    @FindBy(xpath = "//div[@data-value='SF/CRM']")
    public WebElement competencesSF_CRM;

    @FindBy(xpath = "(//div[@class='slds-dueling-list__options'])[5]")
    public WebElement availableCompetencesBox;

    @FindBy(xpath = "(//div[@class='slds-dueling-list__options'])[6]")
    public WebElement chosenCompetencesBox;

    @FindBy(xpath = "(//button[@title='Move selection to Chosen'])[3]")
    public WebElement thirdMoveToChosen;

    @FindBy(xpath = "(//button[@title='Move selection to Available'])[3]")
    public WebElement thirdMoveToAvailable;

    @FindBy(xpath = "//input[@name='Availability__c']")
    public WebElement availibility;

    @FindBy(xpath = "//button[@aria-label='Status in the Profile, Looking']")
    public WebElement statusInTheProfileDropdown;

    @FindBy(xpath = "//textarea[@name='street']")
    public WebElement streetTextArea;

    @FindBy(xpath = "//input[@name='postalCode']")
    public WebElement zipPostalCodeInputBox;

    @FindBy(xpath = "//input[@name='city']")
    public WebElement cityInputBox;

    @FindBy(xpath = "//input[@name='province']")
    public WebElement provinceInputBox;

    @FindBy(xpath = "//input[@name='country']")
    public WebElement countryInputBox;

    @FindBy(xpath = "(//button[@aria-label='Price Range, --None--'])[1]")
    public WebElement priceRangeDropdown;

    @FindBy(xpath = "//input[@name='Minimum_Salary__c']")
    public WebElement minimumSalaryInputBox;

    @FindBy(xpath = "//input[@name='Current_Salary__c']")
    public WebElement currentSalaryInputBox;

    @FindBy(xpath = "//input[@name='Expected_Salary__c']")
    public WebElement expectedSalaryInputBox;

    @FindBy(xpath = "//input[@placeholder='Search Accounts...']")
    public WebElement accountNameSearchBox;

    @FindBy(xpath = "(//*[text()='Cancel'])[2]")
    public WebElement cancelButton;

    @FindBy(xpath = "//button[text()='Save & New']")
    public WebElement candidateSaveAndNewButton;

    @FindBy(xpath = "(//*[text()='Save'])[2]")
    public WebElement saveButton;

    @FindBy(xpath = "//h2[text()='We hit a snag.']")
    public WebElement weHitASnagWarning;

    @FindBy(xpath = "//div[@class='fieldLevelErrors']")
    public WebElement warningReviewText;

    @FindBy(xpath = "//span[@class='custom-truncate uiOutputText']")
    public WebElement createdContactName;

    @FindBy(xpath = "//button[text()='Delete']")
    public WebElement createdContactDeleteButton;

    @FindBy(xpath = "(//button[@title='Delete'])[1]")
    public WebElement deleteConfirmButton;

    @FindBy(xpath = "//a[@data-label='Details']")
    public WebElement contactDetailsButton;

    @FindBy(xpath = "//span[text()='Source']")
    public WebElement contactDetailsSourceText;

    @FindBy(xpath = "(//div[@class='slds-form-element__control'])[13]")
    public WebElement contactDetailsSourceInput;

    // New Contact: Employee Locate-----------------------

    @FindBy(xpath = "(//button[@aria-label='Employment Type, --None--'])[1]")
    public WebElement employeeTypeDropdown;

    @FindBy(xpath = "//input[@name='Title']")
    public WebElement titleImputBox;

    @FindBy(xpath = "(//button[@aria-label='Can Mailshot, No'])[1]")
    public WebElement canMailshotDropdown;

    @FindBy(xpath = "(//button[@aria-label='Information around a future cooperation, --None--'])[1]")
    public WebElement infoFutureCooperationDropdown;

    @FindBy(xpath = "(//button[@aria-label='Trends and news from your industry, --None--'])[1]")
    public WebElement trendsIndustryDropdown;

    @FindBy(xpath = "(//button[@aria-label='Meetings & events in your industry, --None--'])[1]")
    public WebElement meetingsEventsIndustryDropdown;

    @FindBy(xpath = "(//button[@aria-label='Participation in industry-specific surve, --None--'])[1]")
    public WebElement participationIndustryDropdown;

    @FindBy(xpath = "(//button[@aria-label='Other marketing messages, --None--'])[1]")
    public WebElement otherMarketingMessagesDropdown;

    @FindBy(xpath = "//button[@class='slds-button slds-button_icon-border-filled']")
    public List<WebElement> showMoreActionDropdown;

    public WebElement firstShowMoreActionDropdown() {
        WebElement firstShowMoreActionDropdown = showMoreActionDropdown.get(showMoreActionDropdown.size()-1);
        return firstShowMoreActionDropdown;
    }


    // New Contact: Freelancer Locate-----------------------
    @FindBy(xpath = "//input[@name='Minimum_Hourly_Rate__c']")
    public WebElement minimumHourlyInputBox;

    @FindBy(xpath = "//input[@name='Current_Hourly_Rate__c']")
    public WebElement currentHourlyInputBox;

    @FindBy(xpath = "//input[@name='Expected_Hourly_Rate__c']")
    public WebElement expectedHourlyInputBox;
    // New Contact: Manager Locate-----------------------
    @FindBy(xpath = "//input[@name='Department']")
    public WebElement departmentInputBox;

    @FindBy(xpath = "//button[@name='Edit']")
    public WebElement editButton;

    @FindBy(xpath = "(//span[@title='Related Accounts'])[1]")
    public WebElement relatedAccountsOnContactRelated;

    @FindBy(xpath = "(//span[@title='Files'])[1]")
    public WebElement filesOnContactRelated;

    @FindBy(xpath = "(//span[@title='Notes & Attachments'])[1]")
    public WebElement notesAttachmentOnContactRelated;
    @FindBy(xpath = "(//span[@title='Interviews'])[1]")
    public WebElement interviewsOnContactRelated;

    @FindBy(xpath = "(//span[@title='Placements'])[1]")
    public WebElement placementsOnContactRelated;

    @FindBy(xpath = "(//span[@title='Sendouts'])[1]")
    public WebElement sendoutsOnContactRelated;

    @FindBy(xpath = "(//span[@title='Assigned to Shortlists'])[1]")
    public WebElement assignedToShortlistOnContactRelated;

    @FindBy(xpath = "(//tbody/tr//th)[1]")
    public WebElement firstNameOnContactsList;

    @FindBy(xpath = "//tbody/tr[1]/th[1]")
    public WebElement firstContactNameOnContacts;
}
