package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AccountsPage {

    public AccountsPage() {PageFactory.initElements(Driver.getDriver(), this);}


    //----------Business Account -------
    @FindBy(xpath = "//input[@name='Name']")
    public WebElement accountNameInputBox;

    @FindBy(xpath = "//input[@placeholder='Search Accounts...']")
    public WebElement parentAccountSearchDropdown;

    @FindBy(xpath = "//button[@aria-label='Industry, --None--']")
    public WebElement industryDropdown;

    @FindBy(xpath = "//button[@aria-label='Status, --None--']")
    public WebElement statusDropdown;

    @FindBy(xpath = "//button[@aria-label='Business Terms, --None--']")
    public WebElement businessTermsDropdown;

    @FindBy(xpath = "//button[@aria-label='Business Tier, --None--']")
    public WebElement businessTierDropdown;

    @FindBy(xpath = "//input[@name='Website']")
    public WebElement websiteImputBox;

    @FindBy(xpath = "//input[@placeholder='Search People...']")
    public WebElement pointOfContactSearchDropdown;

    @FindBy(xpath = "//input[@name='Last_Contact_Date__c']")
    public WebElement lastContactDateImputBox;

    @FindBy(xpath = "//input[@name='Last_Meeting_Date__c']")
    public WebElement lastMeetingImputBox;

    @FindBy(xpath = "//input[@name='Last_Interview__c']")
    public WebElement lastInterviewImputBox;

    @FindBy(xpath = "//input[@name='Last_Placement_Date__c']")
    public WebElement lastPlacementDateImputBox;

    //----------Nelta Candidates -------
    @FindBy(xpath = "//div[@data-aura-class='sfaOutputNameWithHierarchyIcon']")
    public WebElement createdAccountName;


}
