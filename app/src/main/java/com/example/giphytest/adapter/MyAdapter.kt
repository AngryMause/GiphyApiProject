package com.example.giphytest.adapter

import android.content.Context
import android.nfc.Tag
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.giphytest.MyModel

import com.example.giphytest.databinding.RvItemLayoutBinding
import com.example.giphytest.ui.activity.MainActivity
import com.giphy.sdk.analytics.GiphyPingbacks.context

class MyAdapter(
    private val list: List<MyModel>, private var context: Context
) :
    RecyclerView.Adapter<MyAdapter.MyHolder>() {

    inner class MyHolder(val binding: RvItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(myModel: MyModel, pos: Int) {
            binding.giphyIm.setImageResource(myModel.image)
            binding.giphyIm.setOnClickListener {
                Toast.makeText(context,"${list.get(pos)}",Toast.LENGTH_SHORT).show()
                            onClickListener?.invoke(list[pos])
                }

            }

//            itemView.setOnClickListener {
//                onClickListener.let { model ->
//                    model?.let { it1 ->
//                        it1(list.get(position))
//                    }
//
//                }
//
//            }



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
        val image = list[position]
        holder.bind(image, pos = position)
    }


    private var onClickListener: ((MyModel) -> Unit)? = null

    fun setOnItemClickListener(listener: (MyModel)-> Unit) {
        onClickListener = listener
    }

    override fun getItemCount() = list.size
}









