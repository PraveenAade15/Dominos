package com.praveene.dominosapp.data.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface ResponseDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(responseEntity: ResponseEntity)

    @Query("SELECT * FROM response_model_table")
    suspend fun getAllLocalData(): ResponseEntity


}