package com.example
import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["classpath:Favourite"], // path to your feature files
    glue = ["package com.example.steps"], // package where your step definitions are located
    plugin = ["pretty", "html:build/reports/cucumber-report"]
)
class CucumberTest