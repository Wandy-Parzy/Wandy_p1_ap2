package com.example.wandy_p1_ap2.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.wandy_p1_ap2.data.local.dao.DividirDao
import com.example.wandy_p1_ap2.data.local.entity.DividirEntity
import com.example.wandy_p1_ap2.data.repository.DividirRepository

@Database(
    entities = [
        DividirEntity::class,
    ],
    version = 1
)
abstract class RoomDividirDb: RoomDatabase() {
    abstract val dividirDao : DividirDao
}