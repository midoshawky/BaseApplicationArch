package com.pomac.baseapplicationarch.ui.view.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.pomac.baseapplicationarch.domain.model.ResultState
import com.pomac.baseapplicationarch.ui.viewmodels.SampleViewModel

@Composable
fun HomeScreen(viewModel: SampleViewModel = hiltViewModel()) {
    LaunchedEffect(key1 = null){
        viewModel.getSampleData()
    }
    Text(text = "${viewModel.dataFlow.collectAsState(initial = ResultState.Initial).value}")
}


@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(viewModel = hiltViewModel())
}