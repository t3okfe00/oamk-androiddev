package lang.app.loginform
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lang.app.loginform.ui.theme.LoginFormTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginFormTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {padding->
                    LoginForm(
                        modifier = Modifier.padding(1.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun LoginForm(modifier: Modifier = Modifier) {
    var usernameInput: String by remember { mutableStateOf("") }
    var passwordInput: String by remember { mutableStateOf("") }



    Column(modifier = modifier.padding(vertical = 5.dp)) {
        Text(
            text = "Login",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(6.dp),
            color = Color(0xFF800080),
            fontSize = 20.sp
        )
        OutlinedTextField(
            value = usernameInput,
            onValueChange = {usernameInput = it},
            modifier = modifier
                .fillMaxWidth()
                .padding(6.dp),
            label = {Text(stringResource(R.string.username))},
            singleLine = true,
            trailingIcon = {
                val icon: Painter = painterResource(R.drawable.loginusernameicon)
                Image(painter =icon,
                    contentDescription = null,
                    modifier.size(24.dp))
            }


        )
        TextField(
            value = passwordInput,
            onValueChange = {passwordInput = it},
            modifier = modifier
                .fillMaxWidth()
                .padding(6.dp),
            visualTransformation = PasswordVisualTransformation(),
            label = {Text(stringResource(R.string.password))},
            singleLine = true,
            trailingIcon = {
                val icon: Painter = painterResource(R.drawable.loginpassword)
                Image(painter =icon,
                    contentDescription = null,
                    modifier.size(24.dp))
            }
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF800080)),
            onClick = {}){
            Text(stringResource(R.string.submit))
        }
    }
}

@Preview(showBackground = true,device = "spec:width=360dp,height=640dp", showSystemUi = true)
@Composable
fun LoginFormPreview() {
    LoginFormTheme {
        LoginForm()
    }
}