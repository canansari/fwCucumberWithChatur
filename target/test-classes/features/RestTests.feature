Feature: Rest Tests

  @gettest
  Scenario: get test
    Given I verify getService has status 200 on "http://restapi.demoqa.com/utilities.weather/cith/Dallas" and validate response