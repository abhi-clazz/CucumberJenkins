
Feature: Login Feature
This feature includes scenario that would validate the following logins
1. Admin Login
2. linda.anderson
3. Negative login

Background: 
Given i am able to naviagte on to login page

#Scenario: Admin Login
#Given i am able to naviagte on to login page
#When i update the username as "Admin" 
#And i update the password as "admin123" 
#And i Click on the login button
#Then i should see the username as "Welcome Linda" 
#
#
#Scenario: linda.anderson Login
#Given i am able to naviagte on to login page
#When i update the username as "linda.anderson" 
#And i update the password as "linda.anderson" 
#And i Click on the login button
#Then i should see the username as "Welcome Linda" 

Scenario Outline: Login with different users
When i update the username as "<user>"
And i update the password as "<password>"
And i Click on the login button
Then i should see the username as "<name>"  

Examples: 
|user					 |password			|name					|
|Admin				 |admin123			|Welcome Linda|
|linda.anderson|linda.anderson|Welcome Linda|



Scenario: negative Login
When i update the username as "sunil" 
And i update the password as "sunil" 
And i Click on the login button
Then i should see the error message  as "Invalid credentials" 