package com.benjaminledet.pokedex.ui.pokemon.detail.adaptater

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.benjaminledet.pokedex.R
import com.benjaminledet.pokedex.data.model.Move
import kotlinx.android.synthetic.main.item_move.view.*

/*
Created by Alexis Boutan on 04/01/2020 from the project : Pokedex
*/

class MoveListAdapter(val moves: List<Move>, val context: Context) :
    RecyclerView.Adapter<MoveListAdapter.MyViewHolderMove>() {

    override fun getItemCount(): Int {
        return this.moves.size  //To change body of created functions use File | Settings | File Templates.
    }

    class MyViewHolderMove(val v: LinearLayout) : RecyclerView.ViewHolder(v)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderMove {
        return MyViewHolderMove(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_move,
                parent,
                false
            ) as LinearLayout
        )
    }

    override fun onBindViewHolder(holder: MyViewHolderMove, position: Int) {
        holder.v.moveName.text = moves[position].name
        holder.v.moveType.text = moves[position].type
        holder.v.numberOfPP.text = moves[position].pp.toString()
        holder.v.power.text = moves[position].power.toString()
        holder.v.moveType.setBackgroundColor(getTypeColor(moves[position].type))
    }


    fun getTypeColor(type: String?): Int {
        return when(type) {
            "normal"    -> getColor(context ,R.color.normal)
            "fire"      -> getColor(context ,R.color.fire)
            "water"     -> getColor(context ,R.color.water)
            "grass"     -> getColor(context ,R.color.grass)
            "electric"  -> getColor(context ,R.color.electric)
            "ice"       -> getColor(context ,R.color.ice)
            "fighting"  -> getColor(context ,R.color.fighting)
            "poison"    -> getColor(context ,R.color.poison)
            "ground"    -> getColor(context ,R.color.ground)
            "flying"    -> getColor(context ,R.color.flying)
            "psychic"   -> getColor(context ,R.color.Psychic)
            "bug"       -> getColor(context ,R.color.bug)
            "rock"      -> getColor(context ,R.color.rock)
            "ghost"     -> getColor(context ,R.color.ghost)
            "dragon"    -> getColor(context ,R.color.dragon)
            "dark"      -> getColor(context ,R.color.dark)
            "steel"     -> getColor(context ,R.color.steel)
            "fairy"     -> getColor(context ,R.color.fairy)
            else -> -1
        }
    }
}