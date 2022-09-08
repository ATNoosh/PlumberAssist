package ir.atnoosh.plumberassist.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "desired_sizes")
data class DesiredSize(
    var desiredSize: Double,
    var problemID: Int,
    @PrimaryKey(autoGenerate = true) var id: Int
)
