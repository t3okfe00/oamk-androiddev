package lang.app.week4theming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lang.app.week4theming.ui.theme.Week4ThemingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week4ThemingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier){
    val appModifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
    Column (modifier = modifier, verticalArrangement = Arrangement.spacedBy(16.dp)){
        Text(
            text="My title theming",
            modifier = appModifier,
            style = MaterialTheme.typography.titleLarge

        )
        OutlinedTextField(
            value="",
            onValueChange = {},
            modifier = appModifier
        )
        Button(
            onClick = {},
            modifier = appModifier
        ) {
            Text("Submit")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Week4ThemingTheme {
        MyApp()
    }
}