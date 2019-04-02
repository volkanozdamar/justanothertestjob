Feature: Test login scenario


  Scenario: Successful  Login Scenario
    Given Navigate to HomePage
    Then Close PopUp if it is exist
    And Hover to login
    Then Click to login button
    And Enter "kapsujasti@desoz.com" and "Qwerty123"
    And Click to login submit button



  Scenario Outline:Unsuccessful  Login Scenarios
    Given Navigate to HomePage
    Then Close PopUp if it is exist
    And Hover to login
    Then Click to login button
    And Enter "<E-Mail>" and "<Password>"
    And Click to login submit button
    Then Check the "<Message>"
    Examples:
      |E-Mail             |Password     | Message                                             |
      |test@example.com   | password    | Hatalı E-Posta / Şifre. Tekrar Deneyin.             |
      |                   | password    | Lütfen email adresinizi giriniz.                    |
      |test@example.com   |             | Lütfen şifre giriniz.                               |
      |                   |             | Lütfen email adresinizi giriniz.                    |
      |Failed             | Failed      | Failed Scenario                                     |