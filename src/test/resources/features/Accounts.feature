@allSalesforceFeatures
@accounts
Feature: US02 Accounts Navbar Ueberpruefung der Datenfelder

  @accounts
  Scenario: TC201 Login and Navigate to Sales/Freelancer App Page
    Given I am "salesforceUrl" login page
    When I pass "userName" to "userName" input box
    And I pass "password" to "password" input box
    And I click "anmelden" button
    Then I am at "Sales/Freelancer App" page

  @accounts
  Scenario: TC202 Verification all fields on Accounts Navbar
    Given I am at "Accounts" page
    When I click "New" button
    And All fields should be displayed on "Accounts" page as "Business Account"
    When I click "Cancel" button

  @accounts
  Scenario: TC203 New Account without mandatory fields
    Given I am at "Accounts" page
    When I click "New" button
    When I click "Save" button
    Then I should see "We hit a snag." message
    And "We hit a snag." message should be contain mandatory fields of "Business Account"
    When I click "Cancel" button

  @accounts
  Scenario: TC204 New Account with mandatory fields
    Given I am at "Accounts" page
    When I click "New" button
    And I fill out mandatory fields of "New Account" form as "Business Account"
    When I click "Save" button
    Then New "account" should be "created"
    When I click "Delete" button on "Accounts" Navbar as "Business Account"
    And I click "Delete" confirm button
    Then New "account" should be "deleted"


  @accounts
  Scenario Outline: TC205 Create and Edit the new account by filling all the fields
    Given I am at "Accounts" page
    When I click "New" button
    And I fill out "New Account" form as "Business Account"
    When I click "Save" button
    Then New "account" should be "created"
    When I click "Edit" button on "Accounts" Navbar as "Business Account"
    And I pass "<editedAccountName>" to "accountName" input box
    When I click "Save" button
    Then New "account" should be "saved"
    And New "account" should be created with "<editedAccountName>"
    When I click "Delete" button on "Accounts" Navbar as "Business Account"
    And I click "Delete" confirm button
    Then New "account" should be "deleted"
    Examples:
      | editedAccountName   |
      | Hans Schmidt e.V.   |
      | Jürgen Schmidt e.V. |