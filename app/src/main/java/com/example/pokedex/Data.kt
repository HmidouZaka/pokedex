package com.example.pokedex

class Data {

    var pokeList = ArrayList<Pokemon>();
    fun createPokemons(start:Int,end:Int){
        var i = start;
        while (i <= end){
            pokeList.add(Pokemon(i))
            println(i)
            i++;

        }


    }
}