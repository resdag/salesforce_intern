package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PlacementsPage {

    public PlacementsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//input[@placeholder='Search Contacts...'])[1]")
    public WebElement firstSearchContactsInputBox;

    @FindBy(xpath = "//input[@placeholder='Search Opportunities...']")
    public WebElement oppurtunitySearchOpportunitiesInputBox;

    @FindBy(xpath = "//button[@aria-label='Cost Center, --None--']")
    public WebElement costCenterDropdown;

    @FindBy(xpath = "//input[@name='Start_Date__c']")
    public WebElement startDateImputBox;

    @FindBy(xpath = "//input[@name='End_Date__c']")
    public WebElement endDateImputBox;

    @FindBy(xpath = "//input[@name='Cancellation_Period__c']")
    public WebElement cancellationPeriodImputBox;

    @FindBy(xpath = "//textarea[@class='slds-textarea']")
    public WebElement serviceDescriptionTextarea;

    @FindBy(xpath = "//input[@name='Bill_Rate__c']")
    public WebElement billRateImputBox;

    @FindBy(xpath = "//input[@name='Pay_Rate__c']")
    public WebElement payRateImputBox;

   @FindBy(xpath = "(//input[@placeholder='Search Contacts...'])[2]")
   public WebElement secondSearchContactsInputBox;

   //@FindBy(xpath = "(//lightning-formatted-text[@data-output-element-id='output-field'])[3]")
   //public WebElement startDateInPlacementDetailsImputBox;

    @FindBy(xpath = "//tbody/tr[1]//td[3]")
    public WebElement firstStartDateInPlacementTable;

    @FindBy(xpath = "(//tbody/tr//th)[1]")
    public WebElement firstPlacementIDInPlacementTable;

    @FindBy(xpath = "(//force-lookup[@data-output-element-id='output-field'])[1]")
    public WebElement candidateInPlacementDetails;

    @FindBy(xpath = "//lightning-formatted-text[@slot='primaryField']")
    public WebElement selectedPlacementPlacementID;

    @FindBy(xpath = "(//tbody/tr[1]/th[1])[1]")
    public WebElement firstPlacementIDOnContactsPlacementList;

}
