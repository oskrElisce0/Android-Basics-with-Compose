package com.example.oaxacalibrerocultural.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.oaxacalibrerocultural.model.Book
import com.example.oaxacalibrerocultural.network.OaxacaLibreroCulturalApiService
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface MarsUiState {
    data class Success(val books: List<Book>) : MarsUiState
    object Error : MarsUiState
    object Loading : MarsUiState
}

class OaxacaLibreroCulturalViewModel : ViewModel() {

    var marsUiState: MarsUiState by mutableStateOf(MarsUiState.Loading)
        private set

    init {
        getBooks()
    }

    fun getBooks(query: String = "gastronomia oaxaca") {
        viewModelScope.launch {
            marsUiState = MarsUiState.Loading
            marsUiState = try {
                val response = OaxacaLibreroCulturalApiService.retrofitService.getBooks(query)
                if (response.items.isEmpty()) {
                    MarsUiState.Error // O podrías crear un estado Empty si prefieres
                } else {
                    MarsUiState.Success(response.items)
                }
            } catch (e: Exception) {
                MarsUiState.Error
            }
        }
    }
}