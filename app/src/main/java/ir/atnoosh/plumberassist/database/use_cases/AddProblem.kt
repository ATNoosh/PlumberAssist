package ir.atnoosh.plumberassist.database.use_cases

import ir.atnoosh.plumberassist.database.models.InvalidProblemException
import ir.atnoosh.plumberassist.database.models.Problem
import ir.atnoosh.plumberassist.database.repositories.ProblemRepository
import kotlin.jvm.Throws

class AddProblem(
    private val repository: ProblemRepository
) {

    @Throws(InvalidProblemException::class)
    suspend operator fun invoke(problem: Problem) {

        if (problem.title?.isBlank() == true) {
            throw InvalidProblemException("The title of the note can't be empty.")
        }
        repository.insert(problem = problem)
    }
}