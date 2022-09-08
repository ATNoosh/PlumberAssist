package ir.atnoosh.plumberassist
import android.app.Application
import ir.atnoosh.plumberassist.database.AppDatabase
import ir.atnoosh.plumberassist.database.repositories.ProblemRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class PlumberAssistApp :Application(){
    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy {AppDatabase.getDatabase(this,applicationScope)}
    val problemRep by lazy {ProblemRepository(database.problemDao())}
}