Feature: SmartBear order functionality

  @wip
   Scenario: SmartBear successfully order process and verify if it is displayed
  When User is on the SmartBear login page
  And User successfully logs in
  And User navigates to the Order Page
  And User selects "FamilyAlbum" from product dropdown
  And User enters "4" to quantity
  And User enters "John Wick" to costumer name
  And User enters "Kinzie Ave" to street
  And User enters "Chicago" to city
  And User enters "IL" to state
  And User enters "60056"
  And User selects "Visa" as card type
  And User enters "1111222233334444" to card number
  And User enters "12/22" to expiration date
  And User clicks process button
  Then User verifies "John Wick" is in the list