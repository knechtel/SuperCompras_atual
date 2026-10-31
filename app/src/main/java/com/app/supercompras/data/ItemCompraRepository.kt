package com.app.supercompras.data

import kotlinx.coroutines.flow.Flow

class ItemCompraRepository(private val dao: ItemCompraDao) {
    val todosOsItens: Flow<List<ItemCompra>> = dao.getTodosItens()

    suspend fun salvarItem(item: ItemCompra) {
        dao.inserir(item)
    }

    suspend fun atualizarItem(item: ItemCompra) {
        dao.atualizar(item)
    }

    suspend fun removerItem(item: ItemCompra) {
        dao.deletar(item)
    }
}
