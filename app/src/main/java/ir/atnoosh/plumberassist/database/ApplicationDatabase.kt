package ir.atnoosh.plumberassist.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.atnoosh.plumberassist.database.dao.DesiredSizeDao
import ir.atnoosh.plumberassist.database.dao.ProblemDao
import ir.atnoosh.plumberassist.database.models.DesiredSize
import ir.atnoosh.plumberassist.database.models.Problem

@Database(
    entities = [Problem::class, DesiredSize::class], version = 1
)
abstract class ApplicationDatabase : RoomDatabase() {


    abstract fun problemDao(): ProblemDao
    abstract fun desiredSizeDao(): DesiredSizeDao

    companion object {
        const val DATABASE_NAME = "plmb_db"
    }

}