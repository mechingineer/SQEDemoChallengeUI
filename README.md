## Demo Challenge

#### Instructions
1. Complete the project setup as listed below
2. Complete the Excerise
3. Email a synopsis of your work and the link to your git repo containing the completed exercise to: vladimir_pokhodnia@epam.com


#### Expectations
We will be evaluating
1. Naming conventions
2. Code readability
3. Code encapsulation
4. Code structure and organization
5. Quality of test cases
6. Variety  of testing types (examples: boundary, happy path, negative, etc) 


#### Technologies
1. Java
2. Selenium
3. TestNG
4. Any other technologies you see fit.
5. Please do not use a BDD framework.

#### Project Setup
1. Clone this project to your git account in a public repo
2. Setup the project in your IDE
3. Open the index.html file from src/test/resource/files in a browser
4. Copy the url from the browser and update the url value in src/test/resource/config.properties to be the copied url.
5. In src/test/resources update the config.properties file platform for your OS.
6. From command line run mvn clean install -U -DskipTests
7. Make sure you can run the DemoTest and chrome launches.  You may need to update the chromedriver in /src/test/resources/chromedriver/ to the version that works with your browser
   https://chromedriver.chromium.org/


#### Exercise
1. Use the site at the index.html
2. There are helper locators provided for you in the src/test/resource/files/locators.txt file.
3. In the Test Cases section below:
  - List all of the test cases you think are necessary to test the sample page
  - Note any defects or issues observed
4. Code up a few examples of:
  - At least one happy path case placing an order
  - At least one error case
5. When complete please check your code into your public git repo

#### Test Cases

 Positive Test Cases:
1. Order Pizza without topping
2. Order pizza with 1 topping
3. Order pizza with 2 topping

1,2,3 X Number of PizzaTypes - Total 15 Test Cases with different combinations of Pizza Types, Toppings and Quantity

Negative Test Cases:
1. Empty Name
2. Empty Mobile Number
3. Empty Name and Empty Mobile Number

#### Issues Found on the Website
1. User is able to select both the Payment options. 
2. Alphabets, Special Characters and negative number and Zero are allowed in the Quanity section. The quantity section should be limited to accept only positive whole numbers. We are getting below success messages on placing order with these values respectively:
Alphabets & Special Characters - Thank you for your order! TOTAL: NaN
Zero - Thank you for your order! TOTAL: 0
Negative Number - Thank you for your order! TOTAL: -27
3. Even without selecting the Payment option, user is able to place the order.
4. Reset button is not resetting the pre-selected Toppings1 and Toppings2

#### Add-ons to the framework:
1. Added WebDriver Manager as a Maven dependency that carries out the management (i.e., download, setup, and maintenance) of the drivers required by Selenium WebDriver. Please refer the doc:
https://github.com/bonigarcia/webdrivermanager
Removed chromedriver folder from src/test/resources

2. Added Apache POI maven dependency to help read the test data from an excel file.

#### Project Architecture:
1. This is a Page Object Model with a pages package present in src/main/java/com/sample/test/demo/pages/. Under this package, we have page class named as PizzaOrderForm.java.
2. Test Case file is present under src/test/java/com/sample/test/demo/tests/
3. Test Data file is present under src/main/java/com/sample/test/demo/testdata/

#### Steps to Execute the Automation Suite
1. Navigate to src/main/java/com/sample/test/demo/testdata and update the Test Data file. As of now, there are 15 positive and 3 negative test cases in the test data file
2. Update the file URL in the config.properties file
3. Open Command prompt from base of the project i.e., where the pom.xml is present.
4. Execute the command "mvn clean install test". The test will take approximately 1min to execute the number of test cases as mentioned in Step #1.
5. Post execution, HTML report will be present under /target/surefire-reports/emailable-report.html