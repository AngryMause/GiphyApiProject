package com.example.giphytest.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.giphytest.ImageModel

import com.example.giphytest.databinding.RvItemLayoutBinding

class MyAdapter (val context: Context):
    RecyclerView.Adapter<MyAdapter.MyHolder>() {
    private val list = mutableListOf<ImageModel>()

    inner class MyHolder(val binding: RvItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(url: String?) {
       Glide.with(context).load(url).into(binding.giphyIm)
//            Glide.with(context).load(url).into(binding.giphyIm)
//            binding.giphyIm.load(url)
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
        val url = list[position].url?:""
        Log.e("adpter",list.size.toString())
        holder.bind(url)
    }


    fun addItems(newItems: List<ImageModel>) {
        list.addAll(newItems)
        notifyDataSetChanged()
    }

    var onClickListener: ((ImageModel) -> Unit)? = null
    fun setOnItemClickListener(listener: (ImageModel) -> Unit) {
        onClickListener = listener
    }

    override fun getItemCount() = list.size
}









