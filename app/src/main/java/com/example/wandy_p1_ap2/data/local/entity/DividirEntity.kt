package com.example.wandy_p1_ap2.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Dividir")
data class DividirEntity (
    @PrimaryKey(autoGenerate = true)
    val dividirId : Int?=null,
    val Nombres : String,
    val Dividendo : Double,
    val Divisor : Double,
    val Cociente : Double,
    val Residuo : Double,
)