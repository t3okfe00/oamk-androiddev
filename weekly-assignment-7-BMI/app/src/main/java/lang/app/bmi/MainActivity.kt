package lang.app.bmi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import lang.app.bmi.modelView.BmiViewModel
import lang.app.bmi.ui.ui.theme.BMITheme
import lang.app.bmi.ui.ui.components.CustomOutlinedTextField

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BMITheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BMICalculator(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun BMICalculator(modifier: Modifier = Modifier,bmiViewModel: BmiViewModel = viewModel()) {
    Column(
        modifier = modifier.padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CustomOutlinedTextField(
            textValue = bmiViewModel.heightInput,
            onValueChange = { bmiViewModel.setHeight(it) },
            label = { Text(text = stringResource(R.string.height_input_label)) },
            modifier = Modifier.fillMaxWidth()
        )
        CustomOutlinedTextField(
            textValue = bmiViewModel.weightInput,
            onValueChange = { bmiViewModel.setWeight(it) },
            label = { Text(text = stringResource(R.string.weight_input_label)) },
            modifier = Modifier.fillMaxWidth()
        )
        Text("Your bmi is ${bmiViewModel.bmiResult}")

    }
}





@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BMITheme {
        BMICalculator()
    }
}