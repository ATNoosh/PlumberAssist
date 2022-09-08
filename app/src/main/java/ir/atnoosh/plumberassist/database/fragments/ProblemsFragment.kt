package ir.atnoosh.plumberassist.database.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ir.atnoosh.plumberassist.PlumberAssistApp
import ir.atnoosh.plumberassist.database.models.Problem
import ir.atnoosh.plumberassist.database.viewmodels.ProblemViewModel
import ir.atnoosh.plumberassist.database.viewmodels.ProblemViewModelFactory

class ProblemsFragment : Fragment() {

    val viewModel: ProblemViewModel by viewModels {
        ProblemViewModelFactory((activity?.application as PlumberAssistApp).problemRep)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        return ComposeView(requireContext()).apply {
            setContent {
                viewModel.allProblems.value?.let { ProblemsList(problems = it) }
            }
        }
    }

    @Composable
    fun ProblemsList(problems: List<Problem>) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(15.dp)
        )
        {
            itemsIndexed(items = problems){
                index,problem ->
                ProblemCard(problem = problem)
            }
        }
    }

    @Composable
    fun ProblemCard(problem: Problem) {
        Card() {
            problem.title?.let { Text(text = it) }
        }
    }

    @Composable
    fun AddProblem()
    {

    }
}