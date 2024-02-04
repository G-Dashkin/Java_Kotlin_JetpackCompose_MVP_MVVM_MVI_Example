package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example3_MVP.models.obj.Leagues
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.R

class LeagueAdapter(val itemList: ArrayList<Leagues>) : RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.viewholder_mahasiswa,parent,false))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = itemList[position]

        holder.txtID.text = data.idLeague
        holder.txtNamaLeague.text = data.strLeague
        holder.txtJenisLeague.text = data.strSport
    }

    class ViewHolder(item : View) : RecyclerView.ViewHolder(item){
        val txtID = item.findViewById<TextView>(R.id.txtID)
        val txtNamaLeague = item.findViewById<TextView>(R.id.txtNamaLeague)
        val txtJenisLeague = item.findViewById<TextView>(R.id.txtJenisLeague)
    }


}