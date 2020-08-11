package com.yellow.tp_zoo.ui.home

import com.yellow.tp_zoo.DataModel.DataZooInfo

interface ItemZooClickListener<T> {
    fun onCellClickListener(data: T)
}