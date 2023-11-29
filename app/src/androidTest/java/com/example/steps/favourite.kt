package com.example.steps


import com.example.pokedex.Pokemon
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import testModel

class FavouriteSteps {
    var model = testModel()


    @Given("I am on the Homepage")
    fun i_am_on_the_homepage() {
        // Initialize ViewModel in Compose context



        // Additional setup or assertions can go here
        println("I am on the Homepage")
    }


    @When("I press the favourite logo on a Pokemon")
    fun i_press_the_favourite_logo_on_a_pokemon() {
        // Assuming you have a selected Pokemon, toggle its favorite status
        /* model.toggleFavourite(model.Pokemons.get(0))
if(model.PokemonsFave.isEmpty())
    println("favourite is empty")

        */
    }

    @Then("the pokemon selected should be on the Favouritelist.")
    fun the_pokemon_selected_should_be_on_the_favouritelist() {


        // println("this pokemon added to faveouritlist ${model.PokemonsFave.get(0).name}")

    }


}





