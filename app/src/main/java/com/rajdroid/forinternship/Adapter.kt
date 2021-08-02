package com.rajdroid.forinternship

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recycler_view_list_row.view.*

class Adapter(val list: List<ArticlesItem?>?, val clickListener: onitemClick) : RecyclerView.Adapter<viewholder1>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder1 {
        return viewholder1(LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_list_row, parent, false))
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    //    override fun onBindViewHolder(holder: viewholder1, position: Int) {
//        list?.get(position)?.let { holder.bind(it) }
//    }
    override fun onBindViewHolder(holder: viewholder1, position: Int) {
        holder.bind(list?.get(position)!!,position,clickListener)

    }
    interface onitemClick{
        fun onItemClicked(d: Int)
    }
}
class viewholder1(itemView: View) : RecyclerView.ViewHolder(itemView){

    fun bind(data: ArticlesItem, position: Int, clickListener: Adapter.onitemClick) {

        with(itemView){

            news_text.text=data!!.title
            news_source.text=solve(data!!.source.toString())
            if (data.urlToImage!=null){
                Glide.with(context).load(data.urlToImage)
                    .into(itemView.news_image)
            }
            this.cardViewFutureMatch.setOnClickListener {
                clickListener.onItemClicked(position)

            }
//            this.setOnClickListener(object : View.OnClickListener{
//                override fun onClick(p0: View?) {
//
//                    val act = p0!!.context as AppCompatActivity
//                    act.supportFragmentManager.beginTransaction()
//                        .replace(R.id.container,DescriptionFragment()).commit()
//                }
//
//            })

        }


    }

    private fun solve(toString: String): String {
        var s = toString

        s = s.substring(s.indexOf("=") + 1)
        s = s.substring(0, s.indexOf(","))
        return s
    }


}
