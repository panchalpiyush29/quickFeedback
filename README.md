Run test via command line
>> mvn test -Dselenide.browser=chrome

Run test on a separate browser
>> mvn test -Dselenide.browser=marionette

Run test from IntelliJ
>> Right click either testng.xml Or regression.CucumberRunner, under VM type "-Dselenide.browser=chrome"
