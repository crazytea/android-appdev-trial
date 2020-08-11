package com.yellow.tp_zoo.Utils

import android.content.Context
import com.opencsv.CSVReader
import java.io.IOException
import java.io.InputStreamReader

class YellowCSVReader {
    public fun readCSV(context: Context) : ArrayList<Array<String>>? {

        var data: ArrayList<Array<String>>? = null

        try {
            println(">>" + System.getProperty("file.encoding"))

            val reader =
                CSVReader(InputStreamReader(context.assets.open("data_zoo.csv") ,Charsets.UTF_8))
            var nextLine: Array<String>?

            nextLine = reader.readNext()
            while (nextLine != null) {
                if (data == null) {
                    data = ArrayList<Array<String>>()
                }

                data.add(nextLine)
//                println(">>" + data.get(data.size - 1).)
                nextLine = reader.readNext()
            }

            reader.close()
        } catch (e: IOException) {
            // reader在初始化時可能遭遇問題。記得使用try/catch處理例外情形。
            e.printStackTrace()
        }

        return data
    }

}