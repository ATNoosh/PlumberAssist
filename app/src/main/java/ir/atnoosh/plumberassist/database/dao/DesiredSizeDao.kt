package ir.atnoosh.plumberassist.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ir.atnoosh.plumberassist.database.models.DesiredSize

@Dao
public interface DesiredSizeDao {
    @Insert
    fun insert(desiredSize: DesiredSize)

    @Update
    fun update(desiredSize: DesiredSize)

    @Delete
    fun delete(desiredSize: DesiredSize)

    @Query("select * from desired_sizes order by id desc")
    fun getAllDesiredSize(): LiveData<List<DesiredSize>>
}