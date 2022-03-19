package com.example.giphytest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.bumptech.glide.Glide
import com.example.giphytest.Data

import com.example.giphytest.databinding.RvItemLayoutBinding

class MyAdapter (val context: Context):
    RecyclerView.Adapter<MyAdapter.MyHolder>() {
    private val list = mutableListOf<Data>()

    inner class MyHolder(val binding: RvItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(url: String?) {
            Glide.with(context).load(url).into(binding.giphyIm)
            binding.giphyIm.load(url)
//            binding.giphyIm.setOnClickListener {
//                onClickListener.let { click ->
//                    click?.let { it1 ->
//                        it1(list.get(position))
//                    }
//                }
//            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {

        return MyHolder(
            RvItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val url = list[position].url
        holder.bind(url)
    }


    fun addItems(newItems: List<Data>) {
        list.addAll(newItems)
        notifyDataSetChanged()
    }

    var onClickListener: ((Data) -> Unit)? = null
    fun setOnItemClickListener(listener: (Data) -> Unit) {
        onClickListener = listener
    }

    override fun getItemCount() = list.size
}









