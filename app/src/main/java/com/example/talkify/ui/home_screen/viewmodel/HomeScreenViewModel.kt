package com.example.talkify.ui.home_screen.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.talkify.ui.home_screen.states.HomeScreenEvents
import com.example.talkify.ui.home_screen.states.HomeScreenState
import com.example.talkify.utils.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeScreenViewModel @Inject constructor() : ViewModel() {

    private val _state = mutableStateOf(HomeScreenState())
    val state: State<HomeScreenState> = _state

    fun onEvent(event: HomeScreenEvents) {
        when (event) {
            is HomeScreenEvents.NavigateToCategory -> {
                navigateToCategory(event.category)
            }
        }
    }

    private fun navigateToCategory(category: Category) {
        _state.value = state.value.copy(
            choosenCategory = category
        )
    }

}