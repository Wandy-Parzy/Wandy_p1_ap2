package com.example.wandy_p1_ap2.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.wandy_p1_ap2.data.local.entity.DividirEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DividirDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(dividirEntity: DividirEntity)
    @Delete
    suspend fun delete(dividirEntity: DividirEntity)
    @Query("""
        SELECT * 
        FROM Dividir
        WHERE dividirId =:dividirid
        LIMIT 1
    """
    )
    suspend fun Find(dividirid:Int):DividirEntity
    @Query("""
        SELECT * 
        FROM Dividir
        ORDER By Nombres
    """)

    fun getAll(): Flow<List<DividirEntity>>
}