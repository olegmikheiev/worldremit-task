# Test automation task for WorldRemit
In order to use proper WebDriver, make necessary changes in serenity.properties file 
(see lines that starts with "`webdriver.*`").

**Framework FAQ**

* *Where tests are located?*

Tests scenarios can be found in the features folder under test resources dir:
`src/test/resources/features`

* *Why my code is not compilable?*

This project uses Lombok for some code generations (in order to make it more readable and so on).
In case if you see errors that getters/setters/constructors are not exist, line that contains `log.info()` 
or similar says that no such class/variable/method found and etc., do following (IntelliJ Idea):

- Open Settings and go to `Build -> Compiler -> Annotation Processors`
- Select the checkbox `"Enable annotation processing"` and save changes

Also it's recommended to install Lombok plugin for IDE. 


* *How can I run tests?*

Default test set can be run using:
 1) Runnable class `com.worldremit.testtask.suits.CareersTestSuite`
 2) Run Gradle task *test*: `gradle clean test`
 2) Maven task *verify*: `mvn clean verify`
 
* *How can I generate test report?*

Run task `aggregate` using Gradle: `gradle aggregate` or Maven: `mvn aggregate`

* *Where I can find generated test report?*

By default test reports are saved in the project folder under `target/site/serenity/index.html`

* *Can I do all the above at once?*

Yes, run one of the following commands:

`gradle clean test aggregate`

`mvn clean verify aggregate `
