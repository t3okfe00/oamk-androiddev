package lang.app.bmi.ui.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun CustomOutlinedTextField(
    textValue: String,
    onValueChange:(String) -> Unit,
    label: @Composable ()->Unit,
    modifier: Modifier
){
    OutlinedTextField(
        value = textValue,
        onValueChange = { onValueChange(it) },
        label= label,
        keyboardOptions = KeyboardOptions(keyboardType =
        KeyboardType.Number),
        modifier = modifier.fillMaxWidth()
    )
}