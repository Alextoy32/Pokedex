package com.benjaminledet.pokedex.ui.pokemon.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.benjaminledet.pokedex.R
import com.benjaminledet.pokedex.data.repository.utils.Status
import com.benjaminledet.pokedex.ui.pokemon.detail.adaptater.MoveListAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pokemon_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonDetailActivity: AppCompatActivity() {

    private val viewModel by viewModel<PokemonDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val recycler = findViewById<RecyclerView>(R.id.movesRecyclerView)

        viewModel.pokemonId.postValue(intent.getIntExtra("pokemonId", 0))

        viewModel.refreshState.observe(this, Observer { refreshState ->
            progressBar.isVisible = refreshState.status == Status.RUNNING
            content.isVisible = refreshState.status != Status.RUNNING
        })

        viewModel.pokemon.observe(this, Observer { pokemon ->
            title = pokemon?.name
            weight.text = getString(R.string.pokemon_weight, pokemon?.detail?.weight.toString())
            height.text = getString(R.string.pokemon_height, pokemon?.detail?.height.toString())
            pokemonDesc.text = "Description"
            var afficheType = ""
            pokemon?.detail?.types?.map {
                afficheType += "$it "
            }
            pokeType.text = afficheType
            Picasso.get().load(pokemon?.iconUrl).into(icon)
            //icon.setOnLongClickListener(View.OnLongClickListener() {})

            val backColor = getTypeColor(pokemon?.detail?.types?.first())
            window.decorView.setBackgroundColor(backColor)
        })

        viewModel.moves.observe(this, Observer { moves ->
            recycler.adapter = MoveListAdapter(moves, this)
            recycler.layoutManager = LinearLayoutManager(this)
        })




    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        android.R.id.home -> {
            finish()
            true
        }
        else -> true
    }

    fun getTypeColor(type: String?): Int {
        return when(type) {
            "normal"    -> getColor(R.color.normal)
            "fire"      -> getColor(R.color.fire)
            "water"     -> getColor(R.color.water)
            "grass"     -> getColor(R.color.grass)
            "electric"  -> getColor(R.color.electric)
            "ice"       -> getColor(R.color.ice)
            "fighting"  -> getColor(R.color.fighting)
            "poison"    -> getColor(R.color.poison)
            "ground"    -> getColor(R.color.ground)
            "flying"    -> getColor(R.color.flying)
            "Psychic"   -> getColor(R.color.Psychic)
            "bug"       -> getColor(R.color.bug)
            "rock"      -> getColor(R.color.rock)
            "ghost"     -> getColor(R.color.ghost)
            "dragon"    -> getColor(R.color.dragon)
            "dark"      -> getColor(R.color.dark)
            "steel"     -> getColor(R.color.steel)
            "fairy"     -> getColor(R.color.fairy)
            else -> -1
        }
    }

}