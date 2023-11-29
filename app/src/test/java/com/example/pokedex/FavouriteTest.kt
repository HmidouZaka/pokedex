package com.example.pokedex

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokedex.viweModel.searchPageViewModel
import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["classpath:com.example.Cucumber.Favourite"], // path to your feature files
    glue = ["com.example.Cucumber.FavouriteTest"], // package where your step definitions are located
    plugin = ["pretty", "html:build/reports/cucumber-report"]
)



class favouriteTest {
    val viewModel = searchPageViewModel()



}