package com.example.steps

import com.example.pokedex.UserInterface.SortOption

import com.example.pokedex.viweModel.ApiViewModel
import io.cucumber.java.PendingException
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

        if(model.PokemonsFave.isEmpty())
            println("favourite is empty")

        // model.toggleFavourite(model.Pokemons.get(0))




    }

    @Then("the pokemon selected should be added to the Favouritelist.")
    fun the_pokemon_selected_should_be_on_the_favouritelist() {


         println("this pokemon added to faveouritlist ${model.PokemonsFave.get(0)}")

    }


    @When("I press the favourite logo on a Pokemon once")
    fun i_press_the_favourite_logo_on_a_pokemon_once() {
        // Assuming you have a selected Pokemon, toggle its favorite status
       // model.toggleFavourite(model.Pokemons.get(0))
        if(model.PokemonsFave.isEmpty())
            println("favourite is empty")

       // model.toggleFavourite(model.Pokemons.get(0))




    }

    @Then("the pokemon selected should be removed from  the Favouritelist.")
    fun the_pokemon_selected_should_be_removed_from_the_favouritelist() {
        // Write code here that turns the phrase above into concrete actions
        //throw PendingException()
    }


    @When("I click  on a Pokemon")
    fun i_click_on_a_pokemon() {
        // Write code here that turns the phrase above into concrete actions
        model.setPokemon("Charizard")
    }

    @Then("Then is should see a new screen with selected Pokemon's information.")
    fun then_is_should_see_a_new_screen_with_selected_pokemon_s_information() {
        // Write code here that turns the phrase above into concrete actions
        println(model.getPokemon())
    }


    @When("I start the program")
    fun i_start_the_program() {
       // ApiViewModel().addPokemon(1,40,true,true)

        // Write code here that turns the phrase above into concrete actions
        throw PendingException()
    }

    @Then("Then pokemons should be loaded from API")
    fun then_pokemons_should_be_loaded_from_api() {
        // Write code here that turns the phrase above into concrete actions
        throw PendingException()
    }


}





