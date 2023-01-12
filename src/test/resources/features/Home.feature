@general
Feature: US01 Ueberpruefung der Datenfelder

  @general
  Scenario: TC01 Login and Navigate to Sales/Freelancer App Page
    Given I am "salesforceUrl" login page
    When I pass "userName" to "userName" input box
    And I pass "password" to "password" input box
    And I click "anmelden" button
    Then I am at "Sales/Freelancer App" page

  @general
  Scenario: TC02 Varification Header Icons
    Given  I am at "Sales/Freelancer App" page
    Then I should see "search" inputbox
    And I should see "add favorite" ikon on Home Page
    And I should see "favorites list" ikon on Home Page
    And I should see "global actions" ikon on Home Page
    And I should see "guidance center" ikon on Home Page
    And I should see "salesforce help" ikon on Home Page
    And I should see "setup" ikon on Home Page
    And I should see "notifications" ikon on Home Page
    And I should see "view profile" ikon on Home Page

  @general
  Scenario: TC03 Varification NavBar
    Given  I am at "Sales/Freelancer App" page
    Then I should see "Accounts" button on Page
    And I should see "Contacts" button on Page
    And I should see "Opportunities" button on Page
    And I should see "Placements" button on Page
    And I should see "personalize your nav bar" ikon on Home Page

    #----------------Accounts Navbar_________________
  @general
  Scenario Outline: TC04 Accounts Navbar Filter Test
    Given I am at "Sales/Freelancer App" page
    When I click "Accounts" button in Navbar
    When I select "<accountsName>" from Accounts filter
    Then I should see "<accountTitle>" title on Accounts subNavbar
    Examples:
      | accountsName                    | accountTitle                    |
      | All Accounts                    | All Accounts                    |
      | Internal Person Acoounts        | Internal Person Acoounts        |
      | My Accounts                     | My Accounts                     |
      | New Last Week                   | New Last Week                   |
      | New This Week                   | New This Week                   |
      | Platinum and Gold SLA Customers | Platinum and Gold SLA Customers |
      | Recently Viewed                 | Recently Viewed                 |
      | Recently Viewed Accounts        | Recently Viewed Accounts        |

   #----------------Contacts Navbar_________________
  @general
  Scenario Outline: TC05 Contacts Navbar Filter Test
    Given I am at "Sales/Freelancer App" page
    When I click "Contacts" button in Navbar
    When I select "<contactsName>" from Contacts filter
    Then I should see "<contactsTitle>" title on Contacts subNavbar
    Examples:
      | contactsName             | contactsTitle            |
      | All Contacts             | All Contacts             |
      | Candidates               | Candidates               |
      | Employee                 | Employee                 |
      | Freelancer               | Freelancer               |
      | Manager                  | Manager                  |
      | My Contacts              | My Contacts              |
      | Recently Viewed          | Recently Viewed          |
      | Recently Viewed Contacts | Recently Viewed Contacts |






