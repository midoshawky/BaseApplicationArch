package com.pomac.baseapplicationarch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.pomac.baseapplicationarch.domain.model.ResultState
import com.pomac.baseapplicationarch.ui.theme.BaseApplicationArchTheme
import com.pomac.baseapplicationarch.ui.viewmodels.SampleViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseApplicationArchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    Column(verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally) {
                        Greeting()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(viewModel: SampleViewModel = hiltViewModel()) {
    LaunchedEffect(key1 = null){
        viewModel.getSampleData()
    }
    Text(text = "${viewModel.dataFlow.collectAsState(initial = ResultState.Initial).value}")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BaseApplicationArchTheme {
        Column(verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally) {
            Greeting()
        }
    }
}