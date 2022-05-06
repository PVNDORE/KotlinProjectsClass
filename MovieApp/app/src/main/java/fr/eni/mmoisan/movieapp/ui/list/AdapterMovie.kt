package fr.eni.mmoisan.movieapp.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import fr.eni.mmoisan.movieapp.databinding.MovieLineStyleBinding
import fr.eni.mmoisan.movieapp.entities.Movie

class AdapterMovie: ListAdapter<Movie, AdapterMovie.ViewHolder>(MovieDiffCallback())
{
    //Fonction appelée automatiquement pour changer le contenu d'un conteneur de ligne
    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        //On va chercher la données à afficher, c'est le système qui s'occupe de vous fournir la position
        val item = getItem(position)
        //holder représente un conteneur et on lui donne la donnée à charger
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        return ViewHolder.from(parent)
    }

    //Représente un conteneur de ligne
    class ViewHolder private constructor(val binding: MovieLineStyleBinding) : RecyclerView.ViewHolder(binding.root)
    {
        //Fait le travail de chargement des données dans la ligne
        fun bind(item: Movie)
        {
            //On fournit à la ligne les données, le dataBinding de l'IHM fait le reste
            binding.model = item
            binding.executePendingBindings()
        }

        //Ici c'est toujours pareil
        companion object
        {
            fun from(parent: ViewGroup): ViewHolder
            {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MovieLineStyleBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

//Permet de savoir si on change ou non le contenu d'un ligne
class MovieDiffCallback : DiffUtil.ItemCallback<Movie>()
{
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean
    {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean
    {
        return oldItem == newItem
    }
}