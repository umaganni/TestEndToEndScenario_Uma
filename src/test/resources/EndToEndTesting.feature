Feature: end to end feature

  Scenario: Create an order with different billing address and shipping address as a guest

    Given user is in home page
    When user click on login in link
    Then user is in login page
    When user enters email as "uma@testing.com" and password as "testing"
    And user clicks log in button
    Then user is in home page
    When user adds first item into cart
    Then user should go to cart page
    And user should checkout from cart
    And set new billing address and give details
    And set default shipping address
    And set the default shipping method
    And set default payment method
    And set default payment info
    And confirm the order
    Then the order confirmation page with a message "Your order has been successfully processed!" is seen





