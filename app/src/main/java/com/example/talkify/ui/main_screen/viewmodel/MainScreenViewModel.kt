package com.example.talkify.ui.main_screen.viewmodel

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.database.model.ItemList
import com.example.domain.usecase.AddListUseCase
import com.example.domain.usecase.GetListUseCase
import com.example.talkify.ui.main_screen.states.MainScreenState
import com.example.talkify.ui.main_screen.states.MainScreenStates
import com.example.talkify.utils.CATEGORY_KEY
import com.example.talkify.utils.Item
import com.example.talkify.utils.emotions
import com.example.talkify.utils.fruits
import com.example.talkify.utils.transports
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val   addListUseCase: AddListUseCase,
//    private val   updateListUseCase: UpdateListUseCase,
   private val   getListUseCase: GetListUseCase,

    ) : ViewModel() {

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
            else -> {}
        }

    }
    init{
        viewModelScope.launch {
            addListUseCase(ItemList("Fruits", listOf(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)))
            addListUseCase(ItemList("Emotions", listOf(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)))
            addListUseCase(ItemList("Transport", listOf(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)))
            makeList("Transport")
        }
    }

    private fun editScreen() {
        val current = _uiState.edit
        val updated = _uiState.copy(!current)
        _uiState = updated
    }

    private suspend fun getListId(id: String): List<Int> {
        return getListUseCase(id).ItemList
    }
    private  suspend fun makeList(id: String){
        val id_List = getListId(id)
        list.clear()
        when(id) {
            "Fruits" -> {
                for ( n in id_List){
                    list.add(fruits[n])
                    println(list)

                }
            }
            "Emotions" -> {
                for ( n in id_List){
                    list.add(emotions[n])
                    println(list)

                }
            }
            "Transport" -> {
                for ( n in id_List){
                    list.add(transports[n])
                    println(list)

                }
            }
            else -> {

            }
        }


        val updated = _uiState.copy(list = list)
        _uiState = updated

    }

    fun saveCategory(context: Context, category: String) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("Talkify", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(CATEGORY_KEY, category)
        editor.apply()
    }

    fun getCategory(context: Context): String? {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("Talkify", Context.MODE_PRIVATE)
        return sharedPreferences.getString(CATEGORY_KEY, null)
    }


}