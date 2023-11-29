import com.example.pokedex.Pokemon

class testModel {
    private var selectedPokemon: Pokemon? = null
    var Pokemons = ArrayList<Pokemon>()
    init {
           Pokemons.add( Pokemon(
                "Pikachu", "em-pty", 25, "fire", "water", arrayListOf()
            ))
            Pokemons.add(Pokemon(
                "Charmander", "em-pty", 25, "fire", "water", arrayListOf()
            ))
    }
    var PokemonsFave = ArrayList<Pokemon>()

    fun getMockData(isFavorite: Boolean): List<Pokemon> {
        if (!isFavorite)
            return Pokemons
        else return PokemonsFave
    }

    fun getPokemon(): Pokemon? {
        return selectedPokemon
    }

    fun setPokemon(pokemon: Pokemon) {
        selectedPokemon = pokemon
    }

    fun toggleFavourite(pokemon: Pokemon) {
        if (PokemonsFave.contains(pokemon))
            PokemonsFave.remove(pokemon)
        else
            PokemonsFave.add(pokemon)
    }
}
