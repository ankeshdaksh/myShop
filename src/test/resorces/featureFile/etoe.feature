Feature: registration
  As a new user i want to register so that I can login

  @registrationForNewUser
  Scenario: I want to register my valid details
    Given I am  on home page
    When I entered my valid detail for registration
    Then I am able to register successfully

  @loginWithAlreadyRegisteredEmailId
  Scenario: I want to login with my existing email id
    Given I am  on home page
    When I enter my existing emails and password
    Then I am able to login successfully


  @loginWithIncorrectEmailId
  Scenario Outline: I want to login with unregistered emailId
    Given I am  on home page
    When I enter unregister "<emailId>" and "<passwd>"
    Then I am unbale to loging and error msg appear "Authentication failed."
    Examples:
      | emailId              | passwd  |
      | daksh123@hotmail.com | pass123 |


  @selectProductFromEaschCategory
  Scenario Outline: select product from each category
    Given I am  on home page
    When I am looking product in "<porductTab>"
    And select the "<productCategory>"
    Then I can see the"<productCount>"
    Examples:
      | porductTab | productCategory | productCount |
      | WOMEN      | Tops            | 2            |
      | WOMEN      | Dresses         | 5            |
      | DRESSES    | Casual Dresses  | 1            |
      | DRESSES    | Evening Dresses | 1            |
      | DRESSES    | Summer Dresses  | 3            |


  @searchProductFromSearchBox
  Scenario Outline:search the product in search box
    Given I am  on home page
    When I search the product by "<itemName>"
    Then search result equal to "<count>" of product is equal
    Examples:
      | itemName              | count |
      | Blouse                | 1     |
      | Printed Chiffon Dress | 2     |



