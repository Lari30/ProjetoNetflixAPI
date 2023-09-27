package com.larisantos.projetonetflixapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick
import androidx.recyclerview.widget.RecyclerView
import com.larisantos.projetonetflixapi.api.RetrofitService
import com.larisantos.projetonetflixapi.databinding.ItemFilmeBinding
import com.larisantos.projetonetflixapi.model.Filme
import com.squareup.picasso.Picasso


class FilmeAdapter (val onClick:(Filme) -> Unit
) : RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder>() {

    private var listaFilmes =  mutableListOf<Filme>()

    fun adicionarLista(lista: List<Filme>){
        this.listaFilmes.addAll(lista) //20 + 20 + 20 + 20
        notifyDataSetChanged()
    }

    inner class FilmeViewHolder(val binding: ItemFilmeBinding)
        : RecyclerView.ViewHolder(binding.root) {

            fun bind(filme: Filme){

                val nomeFilme = filme.backdrop_path   //-> backdrop_path é o caminho do filme
                val tamanhoFilme = "w780"
                val urlBase = RetrofitService.BASE_URL_IMAGEM


                val urlFilme = urlBase + tamanhoFilme + nomeFilme

                Picasso.get()
                    .load(urlFilme)
                    .into(binding.imgItemFilme)

                binding.textTitulo.text = filme.title
                binding.rvPopulares.setOnClickListener{
                    onClick(filme)
                }
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemFilmeBinding.inflate(
            layoutInflater, parent, false

        )
        return FilmeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmeViewHolder, position: Int) {
        val filme = listaFilmes[position]
        holder.bind(filme)
    }

    override fun getItemCount(): Int {
        return listaFilmes.size
    }


}