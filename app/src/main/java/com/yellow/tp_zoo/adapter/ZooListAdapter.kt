package com.yellow.tp_zoo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yellow.tp_zoo.DataCapture.GetZooData
import com.yellow.tp_zoo.DataModel.DataZooInfo
import com.yellow.tp_zoo.R

class ZooListAdapter (private val mData: ArrayList<DataZooInfo>) : RecyclerView.Adapter<ZooListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val textView_name: TextView = itemView?.findViewById(R.id.txt_zooname)
        private val textView_category: TextView = itemView?.findViewById(R.id.txt_category)
        private val textView_memo: TextView = itemView?.findViewById(R.id.txt_zoomemo)
        fun bind(value: DataZooInfo) {
            textView_name.text = "${value.E_Name}"
            textView_category.text = "${value.E_Category}"
            textView_memo.text = "${value.E_Memo}"

        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.recycle_item_zoo, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return this.mData.count()
    }

    override fun onBindViewHolder(p0: ViewHolder, position: Int) {
        mData[position]?.let {
            p0?.bind(it)
        }
    }

}