package com.app.supercompras.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.app.supercompras.data.ItemCompra
import com.app.supercompras.data.ItemCompraRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ItemCompraViewModel(private val repository: ItemCompraRepository) : ViewModel() {

    val listaDeItens: StateFlow<List<ItemCompra>> = repository.todosOsItens
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun adicionarItem(texto: String, dataHora: String) {
        viewModelScope.launch {
            repository.salvarItem(
                ItemCompra(texto = texto, foiComprado = false, datahora = dataHora)
            )
        }
    }

    fun alternarStatusItem(item: ItemCompra) {
        viewModelScope.launch {
            repository.atualizarItem(item.copy(foiComprado = !item.foiComprado))
        }
    }

    fun editarItem(item: ItemCompra, novoTexto: String) {
        viewModelScope.launch {
            repository.atualizarItem(item.copy(texto = novoTexto))
        }
    }

    fun removerItem(item: ItemCompra) {
        viewModelScope.launch {
            repository.removerItem(item)
        }
    }
}

class ItemCompraViewModelFactory(private val repository: ItemCompraRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ItemCompraViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ItemCompraViewModel(repository) as T
        }
        throw IllegalArgumentException("ViewModel Class desconhecida")
    }
}
