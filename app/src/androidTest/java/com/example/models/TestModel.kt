class testModel {
    private var selectedPokemon: String = "null"
    var Pokemons = ArrayList<String>()
    init {
           Pokemons.add( "Pikachu")
        Pokemons.add( "Charmander")
    }
    var PokemonsFave = ArrayList<String>()

    fun getPokemon():String {
        return selectedPokemon
    }

    fun setPokemon(pokemon:String) {
        selectedPokemon = pokemon
    }

    fun toggleFavourite(pokemon:String) {
        if (PokemonsFave.contains(pokemon))
            PokemonsFave.remove(pokemon)
        else
            PokemonsFave.add(pokemon)
    }


}
