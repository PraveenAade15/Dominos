package com.praveene.dominosapp.ui.adapter

import com.praveene.dominosapp.data.model.ResponseItem

interface ItemClickListener {
    fun onItemClicked(responseItem: ResponseItem)
}