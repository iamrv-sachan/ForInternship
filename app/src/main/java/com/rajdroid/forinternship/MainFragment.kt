package com.rajdroid.forinternship

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import retrofit2.Call
import retrofit2.Response
import kotlin.system.exitProcess

class MainFragment : Fragment(),Adapter.onitemClick  {
    lateinit var list:ArrayList<ArticlesItem>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rec.layoutManager= LinearLayoutManager(context)
        list = ArrayList()
        getMatch()
    }

    fun getMatch() {


        val res = RetrofitInstance.cricInstance.getDataFromAPI("cricket")
        res.enqueue(object : retrofit2.Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val result = response.body()!!.articles


                Log.i("luck",result.toString())
                for (i in result!!) {
                    list.add(i!!)



                    }
                    val mAdapter = Adapter(list,this@MainFragment)
                    //rec!!.adapter = mAdapter
                rec.apply {
                    adapter=mAdapter


                }
                }

                override fun onFailure(call: Call<News>, t: Throwable) {

                }

        })


    }

        override fun onItemClicked(position: Int) {
            Log.i("luck",list.get(position).toString())
            Utils.gestDesc=list.get(position)
            view?.findNavController()?.navigate(R.id.descFragment)
        }

}