package com.benjaminledet.pokedex.data.model

import androidx.room.ColumnInfo
import com.google.gson.JsonObject
import java.util.*

data class PokemonDetail(

    @ColumnInfo(name = WEIGHT)
    val weight: Double,

    @ColumnInfo(name = HEIGHT)
    val height: Double,

    @ColumnInfo(name = TYPES)
    val types: List<String>,

    /*@ColumnInfo(name = SPRITES)
    val sprites: Map<String, String>,*/

    @ColumnInfo(name = MOVES)
    val moves: List<String>
) {

    companion object {
        const val WEIGHT = "weight"
        const val HEIGHT = "height"
        const val TYPES = "types"
        const val SPRITES = "sprites"
        const val MOVES = "moves"
    }
}