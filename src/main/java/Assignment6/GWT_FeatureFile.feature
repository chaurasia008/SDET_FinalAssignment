Feature: Get the sum and multiplication of numbers and 
@Smoke
Scenario: The sum of a list of numbers should be calculated

Given a list of numbers
|4|
|5|
|6|

When I Multiply them

Then should I get 120

@Regression
Scenario: Given numbers should be calculate
Given a list of numbers
| 4 | 5 | 6 |
Then Multiply and get result 120