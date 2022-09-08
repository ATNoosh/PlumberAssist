package ir.atnoosh.plumberassist.database

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.atnoosh.plumberassist.database.repositories.ProblemRepository
import ir.atnoosh.plumberassist.database.use_cases.AddProblem
import ir.atnoosh.plumberassist.database.use_cases.ProblemUseCases
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): ApplicationDatabase {
        return Room.databaseBuilder(
            app,
            ApplicationDatabase::class.java,
            ApplicationDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideProblemRepository(db: ApplicationDatabase): ProblemRepository {
        return ProblemRepository(db.problemDao())
    }

    @Provides
    @Singleton
    fun provideProblemUseCases(repository: ProblemRepository): ProblemUseCases {
        return ProblemUseCases(
            addProblem = AddProblem(repository = repository)
        )
    }
}

