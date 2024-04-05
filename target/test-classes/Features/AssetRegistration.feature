@tag
Feature: Asset Registration Page
  As a Protran Safety Operations
  I want to add/register my installed PT-226 asset
  So that I can identify the unit, view & manage its configurations and firmware

  #8165
  Background: 
    Given User is logged in
    And User clicks module

  @tag1
  Scenario: User can register and view a new asset
    When User clicks the add button
    Then a form displays
    And User can enter required information "serialNumber" "DisplayName" "FleetName"
    And click save
    Then new unit will display
    And User can click on the unit link
    Then unit detail view will display for new device
    And new registered unit will reflect in database

  Scenario: User can configure new asset
    When User navigates to Fleet Configuration View
    * clicks edit
    * selects newly registered asset "FleetName" "DisplayName"
    * edits unit "EditSerialN" "EditName" "EditFleet"
    And clicks submit
    Then changes should display "EditSerialN" "EditName" "EditFleet"

  Scenario: User can configure new asset firmware
    When User navigates to Firmware repository
    * uploads new firmware "fileLocation"
    * selects newly registered "EditName" 
    And clicks apply
    Then a success message displays
