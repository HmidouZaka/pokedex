package com.example.steps

import com.example.pokedex.Presentation.UserInterface.SortOption

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
        println("I am on the Homepage")
    }
    @When("I press the favourite logo on a Pokemon")
    fun i_press_the_favourite_logo_on_a_pokemon() {
        // Assuming you have a selected Pokemon, toggle its favorite status
        model.PokemonsFave.clear()
        if(model.PokemonsFave.isEmpty())
            println("favourite is empty")
        else
            throw PendingException()
         model.toggleFavourite(model.Pokemons.get(0))
    }
    @Then("the pokemon selected should be added to the Favouritelist.")
    fun the_pokemon_selected_should_be_on_the_favouritelist() {
        if(model.PokemonsFave.isNotEmpty())
         println("this pokemon added to faveouritlist ${model.PokemonsFave.get(0)}")
        else
            throw PendingException()
    }



    @Then("the pokemon selected should be removed from  the Favouritelist.")
    fun the_pokemon_selected_should_be_removed_from_the_favouritelist() {
        // Write code here that turns the phrase above into concrete actions
        //throw PendingException()
        model.toggleFavourite(model.Pokemons.get(0))

        if(model.PokemonsFave.isEmpty())
            println("the pokemon was removed")
        else
            throw PendingException()
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




}





