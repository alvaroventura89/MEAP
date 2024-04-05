Feature: Fleet Status
  As a Protran Safety Manager
  I can view summary of the status of the whole fleet w.r.t. configuration updates
  So that I can manage configs, firmware or take action as needed

  #8166
  Background: 
    Given User is logged in
    And User clicks module

  @tag1
  Scenario: Authorized User can access Fleet Status Page
    Then all Fleet Status Page elements load
    And User is able to access Fleet configuration and firmware repository

  Scenario: Authorized User can view fleet configuration updates
    Then User can see fleet config changes status
    And User can click on fleet to view units
    And User can view unit config changes status
    And User has access to status filter
