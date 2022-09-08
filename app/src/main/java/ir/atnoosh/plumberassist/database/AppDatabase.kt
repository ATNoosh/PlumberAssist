package ir.atnoosh.plumberassist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ir.atnoosh.plumberassist.database.dao.DesiredSizeDao
import ir.atnoosh.plumberassist.database.dao.ProblemDao
import ir.atnoosh.plumberassist.database.models.DesiredSize
import ir.atnoosh.plumberassist.database.models.Problem
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Problem::class, DesiredSize::class], version = 1)
public abstract class AppDatabase : RoomDatabase() {

    abstract fun problemDao(): ProblemDao
    abstract fun desiredSizeDao(): DesiredSizeDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context , scope:CoroutineScope): AppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "prb_db"
                ).addCallback(MyDBCallBack(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }



    private class MyDBCallBack(val scope: CoroutineScope):RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            INSTANCE?.let { myDbItem ->
                scope.launch {

                }
            }
        }
    }

}