package com.yellow.tp_zoo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yellow.tp_zoo.DataCapture.GetZooData
import com.yellow.tp_zoo.R
import com.yellow.tp_zoo.adapter.ZooListAdapter
import com.yellow.tp_zoo.Unit.YellowCSVReader

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var zooData: GetZooData? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        getData()
        setRecyclerView(root)
        return root
    }

    private fun getData() {
        zooData = GetZooData()
        zooData!!.start(context)
    }

    private fun setRecyclerView(root: View) {


        val recycalview: RecyclerView = root.findViewById(R.id.recycler_zoo)
        recycalview.layoutManager = LinearLayoutManager(this.context)
        recycalview.adapter = zooData?.zooData?.let { ZooListAdapter(it) }
//      Toast.makeText(this.context, it, Toast.LENGTH_SHORT).show()

    }

}