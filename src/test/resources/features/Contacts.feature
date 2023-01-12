@allSalesforceFeatures
@contacts
Feature: US03 Contacts Navbar Ueberpruefung der Datenfelder

  @contacts
  Scenario: TC301 Login and Navigate to Sales/Freelancer App Page
    Given I am "salesforceUrl" login page
    When I pass "userName" to "userName" input box
    And I pass "password" to "password" input box
    And I click "anmelden" button
    Then I am at "Sales/Freelancer App" page

  @contacts
  Scenario Outline: TC302 Verification all fields on Contact Navbar
    Given I am at "Contacts" page
    When I click "New" button
    And I select "<recordType>" from record types
    And I click "Next" button
    And All fields should be displayed on "Contacts" page as "<recordType>"
    When I click "Cancel" button
    Examples:
      | recordType |
      | Candidate  |
      | Employee   |
      | Freelancer |
      | Manager    |

  @contacts
  Scenario Outline: TC303 New Contact without mandatory fields
    Given I am at "Contacts" page
    When I click "New" button
    And I select "<recordType>" from record types
    And I click "Next" button
    When I click "Save" button
    Then I should see "We hit a snag." message
    And "We hit a snag." message should be contain mandatory fields of "<recordType>"
    When I click "Cancel" button
    Examples:
      | recordType |
      | Candidate  |
      | Employee   |
      | Freelancer |
      | Manager    |


  @contacts
  Scenario Outline: TC304 New Contact with mandatory fields
    Given I am at "Contacts" page
    When I click "New" button
    And I select "<recordType>" from record types
    And I click "Next" button
    And I fill out mandatory fields of "New Contact" form as "<recordType>"
    When I click "Save" button
    Then New "contact" should be "created"
    When I click "Delete" button on "Contacts" Navbar as "<recordType>"
    And I click "Delete" confirm button
    Then New "contact" should be "deleted"
    Examples:
      | recordType |
      | Candidate  |
      | Employee   |
      | Freelancer |
      | Manager    |


  @contacts
  Scenario Outline: TC305 New Contact as Employee with different Employment Type
    Given I am at "Contacts" page
    When I click "New" button
    And I select "Employee" from record types
    And I click "Next" button
    And I select "<employmentType>" from "Employment Type" dropdown
    And I pass "<contactName>" to "contactName" input box
    When I click "Save" button
    Then New "contact" should be "created"
    And New "contact" should be created with "<contactName>"
    When I click "Delete" button on "Contacts" Navbar as "Employee"
    And I click "Delete" confirm button
    Then New "contact" should be "deleted"
    Examples:
      | employmentType                | contactName |
      | Contracted at Nelta           | Müller      |
      | Contracted at partner company | Horst       |


  @contacts
  Scenario Outline: TC306 New Contact as Candidate with source fields
    Given I am at "Contacts" page
    When I click "New" button
    And I select "Candidate" from record types
    And I click "Next" button
    And I pass "<contactName>" to "contactName" input box
    And I select "<selectedElement>" from "Source" dropdown
    When I click "Save" button
    Then New "contact" should be "created"
    And New "contact" should be created with "<contactName>"
    Then New contact should be created with source "<selectedElement>"
    When I click "Delete" button on "Contacts" Navbar as "Candidate"
    And I click "Delete" confirm button
    Then New "contact" should be "deleted"
    Examples:
      | selectedElement       | contactName |
      | LinkedIn              | Müller      |
      | XING                  | Müller      |
      | GG                    | Müller      |
      | Performance Marketing | Müller      |
      | Employee to Nelta     | Müller      |
      | Employee to GG        | Müller      |
      | Recommandtions to GG  | Müller      |

  @contacts
  Scenario Outline: TC307 Create and Edit the new contact by filling all the fields
    Given I am at "Contacts" page
    When I click "New" button
    And I select "<recordType>" from record types
    And I click "Next" button
    And I fill out "New Contact" form as "<recordType>"
    When I click "Save" button
    Then New "contact" should be "created"
    When I click "Edit" button on "Contacts" Navbar as "<recordType>"
    And I pass "<editedLastName>" to "contactName" input box
    When I click "Save" button
    Then New "contact" should be "saved"
    And New "contact" should be created with "<editedLastName>"
    When I click "Delete" button on "Contacts" Navbar as "<recordType>"
    And I click "Delete" confirm button
    Then New "contact" should be "deleted"
    Examples:
      | recordType | editedLastName |
      | Candidate  | Schmidt        |
      | Employee   | Horst          |
      | Freelancer | Kohl           |
      | Manager    | Maler          |
















