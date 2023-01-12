@allSalesforceFeatures
@opportunities
Feature: US04 Accounts Navbar Ueberpruefung der Datenfelder

  @opportunities
  Scenario: TC401 Login and Navigate to Sales/Freelancer App Page
    Given I am "salesforceUrl" login page
    When I pass "userName" to "userName" input box
    And I pass "password" to "password" input box
    And I click "anmelden" button
    Then I am at "Sales/Freelancer App" page

  @opportunities
  Scenario Outline: TC402 Verification all fields on Accounts Navbar
    Given I am at "Opportunities" page
    When I click "New" button
    And I select "<recordType>" from record types
    And I click "Next" button
    And All fields should be displayed on "Opportunities" page as "<recordType>"
    When I click "Cancel" button
    Examples:
      | recordType |
      | Jobs       |
      | Projects   |

  @opportunities
  Scenario Outline: TC403 New Opportunities without mandatory fields
    Given I am at "Opportunities" page
    When I click "New" button
    And I select "<recordType>" from record types
    And I click "Next" button
    When I click "Save" button
    Then I should see "We hit a snag." message
    And "We hit a snag." message should be contain mandatory fields of "<recordType>"
    When I click "Cancel" button
    Examples:
      | recordType |
      | Jobs       |
      | Projects   |

  @opportunities
  Scenario Outline: TC404 New opportunity with mandatory fields
    Given I am at "Opportunities" page
    When I click "New" button
    And I select "<recordType>" from record types
    And I click "Next" button
    And I fill out mandatory fields of "New Opportunity" form as "<recordType>"
    When I click "Save" button
    Then New "opportunity" should be "created"
    And New "opportunity" should be created with "<opportunityName>"
    When I click "Delete" button on "Opportunities" Navbar as "<recordType>"
    And I click "Delete" confirm button
    Then New "opportunity" should be "deleted"
    Examples:
      | recordType | opportunityName            |
      | Jobs       | QA Software Tester         |
      | Projects   | Salesforce Testing Project |

  @opportunities
  Scenario Outline: TC405 Create and Edit the new opportunity by filling all the fields
    Given I am at "Opportunities" page
    When I click "New" button
    And I select "<recordType>" from record types
    And I click "Next" button
    And I fill out "New Opportunity" form as "<recordType>"
    When I click "Save" button
    Then New "opportunity" should be "created"
    When I click "Edit" button on "Opportunities" Navbar as "<recordType>"
    And I pass "<editedOpportunityTitle>" to "opportunityTitle" input box
    When I click "Save" button
    Then New "opportunity" should be "saved"
    And New "opportunity" should be created with "<editedOpportunityTitle>"
    When I click "Delete" button on "Opportunities" Navbar as "<recordType>"
    And I click "Delete" confirm button
    Then New "opportunity" should be "deleted"
    Examples:
      | recordType | editedOpportunityTitle   |
      | Jobs       | Java Entwickler          |
      | Projects   | Logistik Testing Project |

  @opportunities
  Scenario Outline: TC406 Visibility of all Statuses, Closed Stages and all options of Lost Reason
    Given I am at "Opportunities" page
    When I click "New" button
    And I select "<recordType>" from record types
    And I click "Next" button
    And I fill out "New Opportunity" form as "<recordType>"
    When I click "Save" button
    Then All Statuses should be exist for "Workflow of Opportunity" on "<recordType>"
    When I click "Closed" on "Workflow of Opportunity"
    And I click "Select Closed Stage" button on "Workflow of Opportunity" subNavbar
    Then All Options should be exist in "Stage" dropdown
    And I select "Closed Lost" from "Stage" dropdown
    When I click "Save" button
    Then I should see "Lost Reason Warning" message
    And I click "lostReasonEdit" on selected "Opportunity" page
    Then All Options should be exist in "Lost Reason" dropdown
    And I select "No Budget / Lost Funding" from "Lost Reason" dropdown
    When I click "Save" button
    And I click "Select Closed Stage" button on "Workflow of Opportunity" subNavbar
    And I select "Closed Lost" from "Stage" dropdown
    When I click "Save" button
    Then I should see "Stage Change Success" message
    When I click "Delete" button on "Opportunities" Navbar as "<recordType>"
    And I click "Delete" confirm button
    Then New "opportunity" should be "deleted"
    Examples:
      | recordType |
      | Jobs       |
      | Projects   |

  @opportunities
  Scenario Outline: TC407 Check link to account in opportunity page
    Given I am at "Opportunities" page
    When I click "New" button
    And I select "<recordType>" from record types
    And I click "Next" button
    And I fill out "New Opportunity" form as "<recordType>"
    And I click "Save" button
    When I click "Edit" button on "Opportunities" Navbar as "<recordType>"
    And I pass "<editedOpportunityTitle>" to "opportunityTitle" input box
    And I click "Save" button
    And I click "accountName" on selected "Opportunity" page
    And I click "Opportunities" on selected "Account" page
    Then The new created "<editedOpportunityTitle>" should be visible in the list of "Accounts > Opportunities"
    When I click "<editedOpportunityTitle>" on selected "Accounts > Opportunities" page
    And I click "Delete" button on "Opportunities" Navbar as "<recordType>"
    And I click "Delete" confirm button
    Then New "opportunity" should be "deleted"
    Examples:
      | recordType | editedOpportunityTitle   |
      | Jobs       | Java Entwickler          |
      | Projects   | Logistik Testing Project |



