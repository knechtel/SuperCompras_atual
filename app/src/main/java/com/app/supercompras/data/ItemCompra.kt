package com.app.supercompras.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "itens_compra")
data class ItemCompra(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val texto: String,
    val foiComprado: Boolean = false,
    val datahora: String
)
