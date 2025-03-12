package oamk.assignment.todo.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import oamk.assignment.todo.model.Todo
import oamk.assignment.todo.model.TodosApi

class TodoViewModel:ViewModel() {
    val todos = mutableStateListOf<Todo>();


    init{
        getTodoList();
    }


    private fun getTodoList(){
        viewModelScope.launch {
            var todosApi: TodosApi? = null
            try {
                todosApi = TodosApi.getInstance()
                todos.clear()
                todos.addAll(todosApi.getTodos())
            } catch (e: Exception) {
                Log.d("ERROR",e.message.toString())
            }
        }

    }
}