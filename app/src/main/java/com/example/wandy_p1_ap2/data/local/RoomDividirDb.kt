package com.example.wandy_p1_ap2.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.wandy_p1_ap2.data.local.dao.DividirDao
import com.example.wandy_p1_ap2.data.repository.DividirRepository

@Database(
    entities = [
        DividirRepository::class,
    ],
    version = 1
)
abstract class RoomDividirDb: RoomDatabase() {
    abstract val DividirDao : DividirDao
}