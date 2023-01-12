package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#username")
    public WebElement signinUsernameField;

    @FindBy(css = "#password")
    public WebElement signinPasswordField;

    @FindBy(css = "#Login")
    public WebElement loginButton;

    @FindBy(xpath = "//span[@title='Sales/Freelancer App']")
    public WebElement appName;

    @FindBy(xpath = "//div[@class='appLauncher slds-context-bar__icon-action']")
    public WebElement appLauncher;

    @FindBy(css = ".search-button")
    public WebElement searchBox;

    @FindBy(xpath = "//one-app-nav-bar-item-root[@data-id='Account']")
    public WebElement accountsSubNavTab;

    @FindBy(xpath = "//one-app-nav-bar-item-root[@data-id='Contact']")
    public WebElement contactsSubNavTab;

    @FindBy(xpath = "//one-app-nav-bar-item-root[@data-id='Opportunity']")
    public WebElement opportunitiesSubNavTab;

    @FindBy(xpath = "//one-app-nav-bar-item-root[@data-id='0KD7S0000008dy1WAA']")
    public WebElement placementsSubNavTab;


    @FindBy(xpath = "//one-app-nav-bar-item-root[@data-id='0KD7S0000008dy1WAA']")
    public WebElement sendoutsSubNavTab;

    @FindBy(xpath = "//p[text()='Sales/Freelancer App']")
    public WebElement salesFreelancerAppInMenu;

    @FindBy(xpath = "//p[text()='Nelta Recruiting App']")
    public WebElement neltaRecruitingAppInMenu;

    @FindBy(css = ".slds-global-actions__favorites-action")
    public WebElement addFavoriteIcon;

    @FindBy(css = ".slds-global-actions__favorites-more")
    public WebElement favoritesListIcon;

    @FindBy(css = "svg[class='slds-icon slds-icon_x-small']")
    public WebElement globalActionsIcon;

    @FindBy(css = "button[aria-label='Guidance Center']")
    public WebElement guidanceCenterIcon;

    @FindBy(css = ".slds-global-actions__help")
    public WebElement salesforceHelpIcon;

    @FindBy(css = ".slds-global-actions__setup")
    public WebElement setupIcon;

    @FindBy(css = ".slds-global-actions__notifications")
    public WebElement notificationsIcon;

    @FindBy(css = ".userProfileCardTriggerRoot ")
    public WebElement viewProfileIcon;

    @FindBy(css = "button[title='Personalize your nav bar']")
    public WebElement personalizeNavbar;




}
