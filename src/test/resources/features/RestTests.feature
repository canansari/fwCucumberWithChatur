Feature: Rest Tests

  @gettest
  Scenario: get test
    Given I store parameters in getPath map
    Given I verify getService has status 200 on "get.url" and validate response

  @posttest
  Scenario: post test

    Given I verify postService has status 200 on "post.url" and validate response