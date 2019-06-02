# Linkedin
selenium-cucumber-java
This repository contains a collection of sample selenium-cucumber-java projects and libraries that demonstrate how to use the tool and develop automation script using the Cucumber BDD framework with Java as programming language. It generates  HTML report. 

Installation (pre-requisites)-
1) JDK 1.8+ (make sure Java class path is set)
2) Gradle 
3) Intellij
4) Intellij Plugins for
   . Gradle
   . Cucumber
5) Browser driver (make sure you have your desired browser driver and class path is set)

Framework set up-
. Fork / Clone repository from repsitory or download zip and set it up in your local workspace.

Run Some Sample Tests:
Open Intellij and open the project from the local workspace or open command prompt and navigate to the project directory .

As of now script runs features on chrome browser and the runner class is cucumberRunner.java

To run specific feature if you have multiple feature files ,and you want to run only single feature
     CucumberOptions(
        features = {"src/test/resources"},
        tags = "@asosSearch",// single tag
        
 To run all the features:
 
 CucumberOptions(
        features = {"src/test/resources"},
        tags = {},//runs all the features
        format = {}
        )
        
       

