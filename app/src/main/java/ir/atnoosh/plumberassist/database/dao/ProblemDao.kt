package ir.atnoosh.plumberassist.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ir.atnoosh.plumberassist.database.models.Problem
import kotlinx.coroutines.flow.Flow

@Dao
public interface ProblemDao {
    @Insert
    fun insert(problem: Problem)

    @Update
    fun update(problem: Problem)

    @Delete
    fun delete(problem: Problem)

    @Query("select * from problems order by id desc")
    fun getAllProblems(): LiveData<List<Problem>>
}