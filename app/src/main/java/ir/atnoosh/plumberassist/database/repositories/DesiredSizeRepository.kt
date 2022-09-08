package ir.atnoosh.plumberassist.database.repositories

import android.app.Application
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import ir.atnoosh.plumberassist.database.AppDatabase
import ir.atnoosh.plumberassist.database.dao.DesiredSizeDao
import ir.atnoosh.plumberassist.database.models.DesiredSize
import ir.atnoosh.plumberassist.database.models.Problem

class DesiredSizeRepository(application: Application) {


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun insert(problem: Problem){
    }
}