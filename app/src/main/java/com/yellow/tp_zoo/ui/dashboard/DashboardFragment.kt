package com.yellow.tp_zoo.ui.dashboard

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.yellow.tp_zoo.DataModel.DataZooInfo
import com.yellow.tp_zoo.R


class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var valueZo: DataZooInfo? = null
    private var textView_info: TextView? = null
    private var textView_category: TextView? = null
    private var textView_memo: TextView? = null
    private var imageView_banner: ImageView? = null


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = ""
        textView_info = root.findViewById(R.id.txt_info_info)
        textView_category = root.findViewById(R.id.txt_info_category)
        textView_memo = root.findViewById(R.id.txt_info_memo)
        imageView_banner = root.findViewById(R.id.img_banner)
        val button: Button = root.findViewById(R.id.btn_info_extent)
        button.setOnClickListener {
            clickExtentOutBrowser()
        }

//        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
//        dashboardViewModel.zoodata.observe(viewLifecycleOwner, Observer {
//            textView.text = it.E_Info
//        })
//        valueZo?.let {
//            this.textView_info!!.text = valueZo!!.E_Info
//        }
        return root
    }

    public fun update_data( zooData: DataZooInfo) {
        valueZo = zooData
        textView_info?.let { textView_info!!.text = zooData.E_Info}
        textView_category?.let { textView_category!!.text = zooData.E_Category}
        textView_memo?.let {
            if (zooData.E_Memo == "") { textView_memo!!.text = "(無備註)"}
            else {textView_memo!!.text = zooData.E_Memo}
        }
        Glide.with(context).load(zooData.E_Pic_URL).centerCrop().into(imageView_banner)
        (activity as AppCompatActivity).supportActionBar?.title = zooData.E_Name
    }

    // 用外部瀏覽器開啟
    private fun clickExtentOutBrowser() {
        val browserIntent =
            Intent(Intent.ACTION_VIEW, Uri.parse(valueZo?.E_URL))
        startActivity(browserIntent)
    }


}