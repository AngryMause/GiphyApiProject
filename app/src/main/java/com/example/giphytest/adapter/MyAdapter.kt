package com.example.giphytest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.giphytest.databinding.RvItemLayoutBinding
import com.example.giphytest.model.ImageModel
import javax.inject.Inject

class MyAdapter @Inject constructor(private var glide: RequestManager) :
    RecyclerView.Adapter<MyAdapter.MyHolder>() {

    private val list = mutableListOf<ImageModel>()

    inner class MyHolder(val binding: RvItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(urlImage: String?, position: Int) {
            glide.load(urlImage).into(binding.giphyIm)
            binding.giphyIm.setOnClickListener {
                onClickListener?.invoke(list[position])

            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
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
        val urlImage = list[position].imageURL
        holder.bind(urlImage, position)
    }


    fun addItems(newItems: List<ImageModel>) {
        list.addAll(newItems)
        notifyItemRangeInserted(list.size - newItems.size - 1, list.size - 1)
    }


    override fun getItemCount() = list.size
    var onClickListener: ((ImageModel) -> Unit)? = null
    fun setOnItemClickListener(listener: (ImageModel) -> Unit) {
        onClickListener = listener
    }
}











