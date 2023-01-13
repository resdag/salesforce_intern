package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class OpportunitiesPage {

    public OpportunitiesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //----------Job record Type-------
    //----------Opportunities Info-------
    @FindBy(xpath = "//input[@name='Name']")
    public WebElement opportunitiesTitleInputBox;

    @FindBy(xpath = "//input[@name='CloseDate']")
    public WebElement closeDateInputBox;

    @FindBy(xpath = "//input[@name='Probability']")
    public WebElement probabilityInputBox;

    @FindBy(xpath = "//input[@placeholder='Search People...']")
    public WebElement hiringManagerSearchBox;

    @FindBy(xpath = "(//button[@aria-label='Stage, --None--'])[1]")
    public WebElement stageDropdown;

    @FindBy(xpath = "(//div[@class='slds-rich-text-area__content slds-grow slds-text-color-weak standin'])[1]")
    public WebElement jobDescriptionTextBox;

    @FindBy(xpath = "(//div[@role='textbox'])[1]")
    public WebElement jobDescriptionTextField;

    @FindBy(xpath = "(//button[@aria-label='Category, --None--'])[1]")
    public WebElement categoryDropdown;

    @FindBy(xpath = "//input[@name='Daily_Hours__c']")
    public WebElement dailyHoursInputBox;

    @FindBy(xpath = "//input[@name='Salary_Range_Minimum__c']")
    public WebElement salaryRangeMinumumInputBox;

    @FindBy(xpath = "//input[@name='Salary_Range_Maximum__c']")
    public WebElement salaryRangeMaximumInputBox;

    @FindBy(xpath = "//input[@name='Required_Hardware__c']")
    public WebElement requiredHardwareInputBox;

    @FindBy(xpath = "//input[@name='Hardware_Technical_Details__c']")
    public WebElement hardwareTechnicalDetailsInputBox;

    @FindBy(xpath = "(//button[@aria-label='Commitment, --None--'])[1]")
    public WebElement commitmentDropdown;

    @FindBy(xpath = "(//button[@aria-label='Job Status, --None--'])[1]")
    public WebElement jobStatusDropdown;

    //----------Lost Reason

    @FindBy(xpath = "(//button[@aria-label='Lost Reason, --None--'])[1]")
    public WebElement lostReasonDropdown;

    @FindBy(xpath = "//span[@title='Lost to Competitor']")
    public WebElement lostReasonOptionLostCompetitor;


    @FindBy(xpath = "//span[@title='No Budget / Lost Funding']")
    public WebElement lostReasonOptionNoBudget;


    @FindBy(xpath = "//span[@title='No Decision / Non-Responsive']")
    public WebElement lostReasonOptionNoDecision;


    @FindBy(xpath = "//span[@title='Price']")
    public WebElement lostReasonOptionPrice;


    @FindBy(xpath = "//span[@title='Other']")
    public WebElement lostReasonOptionOther;



    //----------Projekt RecordType

    @FindBy(xpath = "//input[@placeholder='Search Contacts...']")
    public WebElement endClientManagerSearchBox;

    @FindBy(xpath = "(//div[@class='slds-rich-text-area__content slds-grow slds-text-color-weak standin'])[1]")
    public WebElement projectDescriptionTextBox;

    @FindBy(xpath = "(//div[@role='textbox'])[1]")
    public WebElement projectDescriptionTextField;

    @FindBy(xpath = "(//button[@aria-label='Project Source, --None--'])[1]")
    public WebElement projectSourceDropdown;

    @FindBy(xpath = "(//button[@aria-label='Project Status, --None--'])[1]")
    public WebElement projectStatusDropdown;

    @FindBy(xpath = "(//button[@aria-label='Rate Cycle, --None--'])[1]")
    public WebElement rateCycleDropdown;

    @FindBy(xpath = "//input[@name='Daily_Rate__c']")
    public WebElement dailyRateInputBox;

    @FindBy(xpath = "//input[@name='Hourly_Rate__c']")
    public WebElement hourlyRateInputBox;

    @FindBy(xpath = "//lightning-formatted-text[@slot='primaryField']")
    public WebElement createdOpportunityName;

    @FindBy(xpath = "//a[@title='Qualification']")
    public WebElement workflowOpportunityQualification;

    @FindBy(xpath = "//a[@title='Proposal']")
    public WebElement workflowOpportunityProposal;

    @FindBy(xpath = "//a[@title='Interview']")
    public WebElement workflowOpportunityInterview;

    @FindBy(xpath = "//a[@title='Final Feedback']")
    public WebElement workflowOpportunityFinalFeedback;

    @FindBy(xpath = "//a[@title='Negotiation']")
    public WebElement workflowOpportunityNegotiation;

    @FindBy(xpath = "//a[@title='Closed']")
    public WebElement workflowOpportunityClosed;

    @FindBy(xpath = "//span[text()='Mark as Current Stage']")
    public WebElement markAsCurrentStageButton;

    @FindBy(xpath = "//span[text()='Mark Stage as Complete']")
    public WebElement markStageAsCompleteButton;

    @FindBy(xpath = "//span[text()='Change Closed Stage']")
    public WebElement changeClosedStageButton;

    @FindBy(xpath = "//span[text()='Select Closed Stage']")
    public WebElement selectClosedStageButton;

    @FindBy(xpath = "//select[@class='stepAction required-field select']")
    public WebElement selectClosedStageDropdown;

    //-------Opportunities

    @FindBy(xpath = "//tbody/tr[1]")
    public WebElement firstRowOfOpportunities;

    @FindBy(xpath = "(//span[@title='Opportunities'])[1]")
    public WebElement opportunitiesOnAccountRelated;

    @FindBy(xpath = "(//span[@title='Related Contacts'])[1]")
    public WebElement relatedContactsOnAccountRelated;

    @FindBy(xpath = "(//a[@class='flex-wrap-ie11 slds-truncate'])[1]")
    public WebElement selectedOpportunityAccountName;

    @FindBy(xpath = "//button[@title='Edit Lost Reason']")
    public WebElement editLostReasonButton;

    @FindBy(xpath = "//tbody/tr[1]/th[1]")
    public WebElement firstOpportunityTitleOnOpportunities;















}
