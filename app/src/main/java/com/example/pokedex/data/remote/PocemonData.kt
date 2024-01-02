package com.example.pokedex.data.remote

import android.util.Log
import com.example.pokedex.model.Pokemon
import com.example.pokedex.utils.PokemonObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.URL

class PokemonData {

    suspend fun addPokemon(start: Int, end: Int, onlyDefaults: Boolean, cleanCopy: Boolean) {
        withContext(Dispatchers.IO) {
            val limit = start + end
            var i: Int = start
            while (i <= end) {
                val jsonData2 = URL("https://pokeapi.co/api/v2/pokemon/$i").readText()
                val jsonDataSpecies = URL("https://pokeapi.co/api/v2/pokemon-species/$i").readText()
                var pokemonJson2 = JSONObject(jsonData2)
                var pokemonJsonSpecies = JSONObject(jsonDataSpecies)
                if (pokemonJson2.getBoolean("is_default") or !onlyDefaults) {
                    var pokeName: String =
                        pokemonJson2.getString("name")
                    var pokeId: Int =
                        pokemonJson2.getInt("id")
                    var pokeDefaultPictureFront: String =
                        pokemonJson2.getJSONObject(
                            "sprites"
                        ).getJSONObject("other").getJSONObject("official-artwork")
                            .getString("front_default")
                    var type1: String =
                        pokemonJson2.getJSONArray("types").getJSONObject(0).getJSONObject("type")
                            .getString("name")


                    var type2: String = "null"
                    if (pokemonJson2.getJSONArray("types").length() > 1) {
                        type2 = pokemonJson2.getJSONArray("types").getJSONObject(1)
                            .getJSONObject("type").getString("name")
                    }
                    var pokedexTextList = ArrayList<String>()
                    pokedexTextList.add(
                        pokemonJsonSpecies.getJSONArray("flavor_text_entries").getJSONObject(0)
                            .getString("flavor_text")
                    )

                    Log.d(
                        "info",
                        "" + pokeName + " " + pokeDefaultPictureFront + " " + pokeId + " " + type1 + " " + type2
                    )

                    PokemonObject.pokeList.add(
                        Pokemon(
                            pokeName.replaceFirstChar { it.uppercase() },
                            pokeDefaultPictureFront,
                            pokeId,
                            type1,
                            type2,
                            pokedexTextList
                        )
                    )
                }
                i++
            }

        }
    }


}