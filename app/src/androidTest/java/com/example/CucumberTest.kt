package com.example
import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["classpath:Favourite"],
    glue = ["package com.example.steps"],

)

class CucumberTest