package ir.atnoosh.plumberassist.database.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.atnoosh.plumberassist.database.models.Problem
import ir.atnoosh.plumberassist.database.repositories.ProblemRepository
import androidx.lifecycle.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class ProblemViewModel (
    private val repository: ProblemRepository
) : ViewModel() {


    val allProblems1 = repository.allProblems
    val allProblems: LiveData<List<Problem>> = allProblems1

    public fun addProblem(problem: Problem) = viewModelScope.launch{
        repository.insert(problem)
    }

}

class ProblemViewModelFactory(private val repository: ProblemRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProblemViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProblemViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
