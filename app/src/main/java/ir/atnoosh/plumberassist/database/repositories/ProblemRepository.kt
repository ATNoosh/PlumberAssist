package ir.atnoosh.plumberassist.database.repositories

import android.app.Application
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import ir.atnoosh.plumberassist.database.AppDatabase
import ir.atnoosh.plumberassist.database.dao.ProblemDao
import ir.atnoosh.plumberassist.database.models.Problem
import kotlinx.coroutines.flow.Flow

class ProblemRepository(private val problemDao:ProblemDao) {

    var allProblems: LiveData<List<Problem>> = problemDao.getAllProblems()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(problem: Problem){
        problemDao.insert(problem)
    }
}