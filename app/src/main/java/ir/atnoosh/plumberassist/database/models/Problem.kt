package ir.atnoosh.plumberassist.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "problems")
data class Problem(
    var title: String? = null,
    var branchSize: Float? = 6.0f,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)
class InvalidProblemException(message: String) : Exception(message)