package com.rajdroid.forinternship

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_desc.*
import kotlinx.android.synthetic.main.recycler_view_list_row.view.*

class DescFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_desc, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("lkl",Utils.gestDesc!!.title!!)

        if (Utils.gestDesc!!.urlToImage!=null){
            context?.let {
                Glide.with(it).load(Utils.gestDesc!!.urlToImage)
                    .into(img)
            }
        }

        t.text=Utils.gestDesc!!.title
        d.text=Utils.gestDesc!!.description
    }


}