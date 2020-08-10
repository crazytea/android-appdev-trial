package com.yellow.tp_zoo.DataCapture

import android.content.Context
import com.yellow.tp_zoo.DataModel.DataZooInfo
import com.yellow.tp_zoo.Unit.YellowCSVReader

class GetZooData {
    var zooData: ArrayList<DataZooInfo>? = null

    init { }
    public fun start(context: Context?) {
        var reader: YellowCSVReader = YellowCSVReader()
        context?.let {
            var data: ArrayList<Array<String>>? = reader.readCSV(it)
            data?.let {
                if (zooData == null) {
                    zooData = ArrayList<DataZooInfo>()
                }
                // CSV資料轉換
                for (i in 1 until data.size) {
//                    println("[" + i + "]" + data[i][1])
                    zooData!!.add(
                        DataZooInfo(
                            data[i][0],
                            data[i][1],
                            data[i][2],
                            data[i][3],
                            data[i][4],
                            data[i][5],
                            data[i][6],
                            data[i][7]
                        )
                    )
                }
            }
        }
    }
}