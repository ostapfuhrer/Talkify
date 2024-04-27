package com.example.talkify.ui.main_screen.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.database.model.ItemList
import com.example.data.repository.ItemListRepository
import com.example.talkify.ui.main_screen.states.MainScreenState
import com.example.talkify.ui.main_screen.states.MainScreenStates
import com.example.talkify.utils.Item
import com.example.talkify.utils.fruits
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(private val itemListRepository: ItemListRepository) : ViewModel() {

    private var _uiState: MainScreenState by mutableStateOf(MainScreenState())
        private set

    val uiState: MainScreenState
        get() = _uiState
    val list = mutableListOf<Item>()




    private var listCategory :String = "Fruits"
    fun onEvent(state: MainScreenStates) {
        when (state) {
            MainScreenStates.Edit -> editScreen()
            MainScreenStates.ChangeList -> TODO()
            MainScreenStates.GoHome -> TODO()
            MainScreenStates.OpenSetting -> TODO()
        }

    }
    init{
        viewModelScope.launch {
            itemListRepository.AddList(ItemList("Fruits", listOf(1,2,3,4,5,6,7,8,9,10,11,12,13)))
            itemListRepository.AddList(ItemList("Emotions", listOf(1,12,5,56,1,4)))
            itemListRepository.AddList(ItemList("Cars", listOf(1,12,5,56,1,4)))
            makeList("Fruits")
        }
    }

    private fun editScreen() {
        val current = _uiState.edit
        val updated = _uiState.copy(!current)
        _uiState = updated
    }

    private suspend fun getListId(id: String): List<Int> {
        return itemListRepository.getListByID(id).ItemList
    }
    private  suspend fun makeList(id: String){
        val id = getListId(id)
        for ( n in id){
            list.add(fruits[n])
            println(list)

        }
        val updated = _uiState.copy(list = list)
        _uiState = updated

    }


}