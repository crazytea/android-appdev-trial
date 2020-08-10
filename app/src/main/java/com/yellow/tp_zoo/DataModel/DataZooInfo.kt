package com.yellow.tp_zoo.DataModel

import android.os.Parcel
import android.os.Parcelable

data class DataZooInfo(
    val E_no: String? = "",
    var E_Category: String? = "",
    var E_Name: String? = "",
    var E_Pic_URL: String? = "",
    var E_Info: String? = "",
    var E_Memo: String? = "",
    var E_Geo: String? = "",
    var E_URL: String? = "") : Parcelable {

    constructor(parcel: Parcel) : this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(E_no)
        parcel.writeString(E_Category)
        parcel.writeString(E_Name)
        parcel.writeString(E_Pic_URL)
        parcel.writeString(E_Info)
        parcel.writeString(E_Memo)
        parcel.writeString(E_Geo)
        parcel.writeString(E_URL)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataZooInfo> {
        override fun createFromParcel(parcel: Parcel): DataZooInfo {
            return DataZooInfo(parcel)
        }

        override fun newArray(size: Int): Array<DataZooInfo?> {
            return arrayOfNulls(size)
        }
    }
}