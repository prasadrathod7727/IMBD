# IMBD

We are accessing the date and country attributes from both imdb and wiki page for the movie Pushpa.Then compare the value are same or different

## Scenario performed
Launch the IMDB page

Using the Selenium extract the country and date value for the movie pushpa

Similarly launch the Wiki page and using the Selenium extract the country and date value for the movie pushpa

Then compare both the country and release date is same or not


## Run the code

Extract the folder to the IDE(for ex eclipse,Intellij)

Right click on the testng.xml file and run as TestNG suite

## Software requirement

Language: Java,Selenium Webdriver,TestNG
IDE:Eclipse


## Brief on Automation Framework used

The framework is a hybrid framework with Page Object Model design.We implemented a maven project. It uses pom.xml file to maintain our dependencies such as selenium-standalone-server, selenium-java, TestNG, Apache poi etc. By default, the framework has two packages to write our script. We have src/main/java which library package that contains configuration class which works as static class and have some final static variable and methods that we can utilize in the project, we have generic function class to store common functionalities that we use in our script,test listener class to listen to different status of tests while executing, annotation transformer class to customize the annotation in runtime. Another package is src/test/java where we write our test script using page object model pattern. Every web page has a different class to store the element. It has some other sub-packages such as PageModel package contains location of the element, PageObject package extends pageModel and contains actions that we want to perform on different elements. PageTest package contains tests for different pages and I define how to execute these tests. For configuring and executing tests we use pom.xml file.The project has a screenshot folder to store screenshots of failed tests. Data folder to store our test data files. browserDriver folder to store drivers. configuration folder that contains properties files to store common data such as url.After the execution of the code we have a test-output folder where testNG reports are generated

