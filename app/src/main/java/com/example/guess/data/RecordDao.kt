package com.example.guess.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

    @Dao
interface RecordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insert(record:Record)

    @Query(value = "select * from record")
    suspend fun getAll():List<Record>
}