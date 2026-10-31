package com.app.supercompras.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemCompraDao {
    @Query("SELECT * FROM itens_compra ORDER BY id DESC")
    fun getTodosItens(): Flow<List<ItemCompra>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserir(item: ItemCompra)

    @Update
    suspend fun atualizar(item: ItemCompra)

    @Delete
    suspend fun deletar(item: ItemCompra)
}
