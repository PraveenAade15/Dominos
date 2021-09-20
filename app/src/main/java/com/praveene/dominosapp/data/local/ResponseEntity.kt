package com.praveene.dominosapp.data.local

import android.provider.SyncStateContract
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.praveene.dominosapp.data.model.ResponseItem
import com.praveene.dominosapp.util.Constants

@Entity(tableName = Constants.RESPONSE_MODEL_TABLE)

class ResponseEntity (
    val responseItem:MutableList<ResponseItem>
        ){
    @PrimaryKey(autoGenerate = false)
    var id:Int=0
}