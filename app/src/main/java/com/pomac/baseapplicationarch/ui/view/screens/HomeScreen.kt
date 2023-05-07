package com.pomac.baseapplicationarch.ui.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.pomac.baseapplicationarch.domain.model.ResultState
import com.pomac.baseapplicationarch.ui.viewmodels.SampleViewModel
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(viewModel: SampleViewModel? = hiltViewModel()) {
    LaunchedEffect(key1 = null){
        viewModel?.getSampleData()
    }
    Column(modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(text = "${viewModel?.dataFlow?.collectAsState(initial = ResultState.Initial)?.value}")
    }
}


@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(viewModel = null)
}