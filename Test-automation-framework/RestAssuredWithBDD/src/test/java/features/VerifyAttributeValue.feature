Feature: Verify <numViews> attribute (from response) is greater than <value>

  Scenario: numView attribute should be more than 4000
    Given API URL 
    When We send a get request to get response
    Then We will check that value of <attribute> is greater than <value>

    Examples: 
      | attribute   | value   | 
      | numViews    |   4000  |    