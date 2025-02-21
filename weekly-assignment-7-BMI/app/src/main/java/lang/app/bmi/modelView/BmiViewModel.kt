package lang.app.bmi.modelView

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BmiViewModel : ViewModel() {
    var heightInput by mutableStateOf("")
    var weightInput by mutableStateOf("")
    var bmiResult by mutableStateOf("0.0")


    private val height: Double
        get(){
            return heightInput.toDoubleOrNull() ?: 0.0;
        }


    private val weight: Int
        get(){
            return weightInput.toIntOrNull() ?: 0;
        }


    fun setHeight(newHeight:String){
        heightInput = newHeight
        calculateBMI()
    }

    fun setWeight(newWeight:String){
        weightInput = newWeight
        calculateBMI()
    }

    private fun calculateBMI(){
        val bmi = "%.1f".format(if(height > 0) weight / (height * height) else 0.0)
        bmiResult = bmi
    }



}