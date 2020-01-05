package com.benjaminledet.pokedex.data.model

import androidx.room.ColumnInfo

data class PokemonSpecies(

    @ColumnInfo(name = CAPTURERATE)
    val captureRate: Double

) {

    companion object {
        const val CAPTURERATE = "captureRate"
    }
}