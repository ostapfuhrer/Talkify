package com.example.talkify.ui.main_screen.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetListUseCase
import com.example.domain.utiles.ItemUI
import com.example.domain.utiles.allItems
import com.example.talkify.ui.main_screen.states.MainScreenState
import com.example.talkify.ui.main_screen.states.MainScreenStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
//    private val   updateListUseCase: UpdateListUseCase,
   private val   getListUseCase: GetListUseCase,
    //private val makeListUseCase: MakeListUseCase
    //


    ) : ViewModel() {

    private var _uiState: MainScreenState by mutableStateOf(MainScreenState())
        private set

    val uiState: MainScreenState
        get() = _uiState



val category ="Fruits"


    fun onEvent(state: MainScreenStates) {
        when (state) {
            MainScreenStates.Edit -> editScreen()
            is MainScreenStates.ChangeList -> {

                    makeList( state.listName)


            }
            MainScreenStates.GoHome -> TODO()
            MainScreenStates.OpenSetting -> TODO()
            else->{}

        }
    }
    init{
        viewModelScope.launch {
            try {
                makeList(category)
            }
            catch (e:Exception){//  при першому створенні бази даних не встигають створитися категорії

                delay(5000)
                makeList(category)

            }
//


        }
    }


    private fun editScreen() {
        val current = _uiState.edit
        val updated = _uiState.copy(edit = !current)
        _uiState = updated

    }
    private  fun makeList(id: String) {
        viewModelScope.launch {
            val idList = getListUseCase(id)?.itemList
            idList?.let {
//                val a = R.drawable.fruits_0// 2131099673
//                Log.d("BLA", a.toString())
                val itemList = it.mapNotNull { allItems.getOrNull(it) }
                updateUIState(itemList)
            } ?: kotlin.run {

                Log.e("TALKIFY", "PROBLEM")
            }
        }

    }

    private fun updateUIState(itemList:List<ItemUI>) {
        _uiState = _uiState.copy(list = itemList )
    }

}