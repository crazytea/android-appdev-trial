package com.yellow.tp_zoo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yellow.tp_zoo.DataModel.DataZooInfo
import com.yellow.tp_zoo.R
import com.yellow.tp_zoo.ui.home.ItemZooClickListener

class ZooListAdapter (private val mData: ArrayList<DataZooInfo>,
                      private val itemClickListener : ItemZooClickListener<DataZooInfo>? = null) : RecyclerView.Adapter<ZooListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val textView_name: TextView = itemView?.findViewById(R.id.txt_zooname)
        private val textView_category: TextView = itemView?.findViewById(R.id.txt_category)
        private val textView_memo: TextView = itemView?.findViewById(R.id.txt_zoomemo)
        private val imageview_pic: ImageView = itemView?.findViewById(R.id.img_pic)

        fun bind(value: DataZooInfo) {
            textView_name.text = "${value.E_Name}"
            textView_category.text = "${value.E_Category}"
            textView_memo.text = "${value.E_Memo}"
            Glide.with(itemView.context).load(value.E_Pic_URL).centerCrop().into(imageview_pic)
            itemView.setOnClickListener {
                itemClickListener?.onCellClickListener(value)
            }
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