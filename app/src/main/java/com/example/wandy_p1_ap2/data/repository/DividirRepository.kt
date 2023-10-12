package com.example.wandy_p1_ap2.data.repository

import javax.inject.Inject
import com.example.wandy_p1_ap2.data.local.dao.DividirDao
import com.example.wandy_p1_ap2.data.local.entity.DividirEntity
import kotlinx.coroutines.flow.Flow

class DividirRepository @Inject constructor(
Corprivate  val dividirDao: DividirDao
) {
    suspend fun save(dividir: DividirEntity){
        return dividirDao.save(dividir)
    }
    fun getAll(): Flow<List<DividirEntity>> = dividirDao.getAll()
}