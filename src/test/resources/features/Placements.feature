@allSalesforceFeatures
@placements
Feature: US05 Placements Navbar Ueberpruefung der Datenfelder

  @placements
  Scenario: TC501 Login and Navigate to Sales/Freelancer App Page
    Given I am "salesforceUrl" login page
    When I pass "userName" to "userName" input box
    And I pass "password" to "password" input box
    And I click "anmelden" button
    Then I am at "Sales/Freelancer App" page

  @placements
  Scenario Outline: TC502 Verification all fields on Placements Navbar
    Given I am at "Placements" page
    When I click "New" button
    And I select "<recordType>" from record types
    And I click "Next" button
    And All fields should be displayed on "Placements" page as "<recordType>"
    When I click "Cancel" button
    Examples:
      | recordType |
      | Job        |
      | Project    |

  @placements
  Scenario Outline: TC503 New placement without mandatory fields
    Given I am at "Placements" page
    When I click "New" button
    And I select "<recordType>" from record types
    And I click "Next" button
    When I click "Save" button
    Then I should see "We hit a snag." message
    And "We hit a snag." message should be contain mandatory fields of "<recordType>"
    When I click "Cancel" button
    Examples:
      | recordType |
      | Job        |
      | Project    |

  @placements
  Scenario Outline: TC504 New placement with mandatory fields
    Given I am at "Placements" page
    When I click "New" button
    And I select "<recordType>" from record types
    And I click "Next" button
    And I fill out mandatory fields of "New Placement" form as "<recordType>"
    When I click "Save" button
    Then New "placement" should be "created"
    When I click "Delete" button on "Placements" Navbar as "<recordType>"
    And I click "Delete" confirm button
    Then New "placement" should be "deleted"
    Examples:
      | recordType |
      | Job        |
      | Project    |

  @placements
  Scenario Outline: TC505 Create and Edit the new placement by filling all the fields
    Given I am at "Placements" page
    When I click "New" button
    And I select "<recordType>" from record types
    And I click "Next" button
    And I fill out "New Placement" form as "<recordType>"
    When I click "Save" button
    Then New "placement" should be "created"
    When I click "Edit" button on "Placements" Navbar as "<recordType>"
    And I pass "<editedStartDate>" to "startDate" input box
    When I click "Save" button
    Then New "placement" should be "saved"
    And New "placement" should be created with "<editedStartDate>"
    When I click "Delete" button on "Placements" Navbar as "<recordType>"
    And I click "Delete" confirm button
    Then New "placement" should be "deleted"
    Examples:
      | recordType | editedStartDate |
      | Job        | 18.05.2023      |
      | Project    | 24.06.2023      |

  @placements
  Scenario Outline: TC506 Check link for contact
    Given I am at "Placements" page
    When I click "New" button
    And I select "<recordType>" from record types
    And I click "Next" button
    And I fill out "New Placement" form as "<recordType>"
    When I click "Save" button
    Then New "placement" should be "created"
    When I store "placementID" of "Placement"
    And I click "Candidate" on selected "Placement" page
    And I click "Placements" on selected "Contact" page
    Then The new created "Placement" should be visible in the list of "Contacts > Placements"
    When I click "lastPlacement" on selected "Contacts > Placements" page
    And I click "Delete" button on "Placements" Navbar as "<recordType>"
    And I click "Delete" confirm button
    Then New "placement" should be "deleted"
    Examples:
      | recordType |
      | Job        |
      | Project    |

  @placements
  Scenario Outline: TC507 Check for creating placements -1- Opportunities Related
    Given I am at "Opportunities" page
    When I click "New" button
    And I select "<recordType>" from record types
    And I click "Next" button
    And I fill out mandatory fields of "New Opportunity" form as "<recordType>"
    And I click "Save" button
    When I am at "Opportunities" page
    And I click "firstOpportunityTitle" on selected "Opportunities" page
    Then I should see "Placements" in "Related" subTitle on selected "Opportunity"
    When I click "Delete" button on "Opportunities" Navbar as "<recordType>"
    And I click "Delete" confirm button
    Then New "opportunity" should be "deleted"
    Examples:
      | recordType |
      | Jobs       |
      | Projects   |

  @placements
  Scenario: TC508 Check for creating placements -2- Placements Modul
    Given I am at "Placements" page
    Then I should see "New" button on "Placements" Navbar

  @placements
  Scenario: TC509 Check for creating placements -3- Contacts Modul
    Given I am at "Contacts" page
    And I click "firstContactName" on selected "Contacts" page
    Then I should see "Placements" in "Related" subTitle on selected "Contact"