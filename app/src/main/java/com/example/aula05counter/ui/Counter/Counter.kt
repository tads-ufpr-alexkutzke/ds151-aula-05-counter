package com.example.aula05counter.ui.Counter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aula05counter.ui.theme.Aula05CounterTheme

@Composable
fun Counter(
    modifier: Modifier = Modifier,
    text:String = "Número de Cliques",
    max: Int = Int.MAX_VALUE,
    min: Int = Int.MIN_VALUE,
    step: Int = 1,
    count: Int = 0,
    onIncrement: (min:Int, max:Int, step: Int) -> Unit = {min,max,step -> Unit},
    onDecrement: (min:Int, max:Int, step: Int) -> Unit = {min,max,step -> Unit},
){
    Surface(modifier = modifier) {
        Row(
            modifier = modifier.padding(horizontal = 20.dp, vertical = 5.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Text(
                text=text + " ${count}",
                modifier = Modifier.weight(1f)
            )
            Row(
                modifier = Modifier.weight(0.5f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,

            ){
                ElevatedButton(
                    onClick =  { onDecrement(min,max,step) },
                ) {
                    Text("-")
                }
                ElevatedButton(
                    onClick = { onIncrement(min,max,step) },
                ) {
                    Text("+")
                }
            }
        }
    }
}

@Preview(widthDp = 480)
@Composable
fun PreviewCounter(){
    Aula05CounterTheme {
        Column {
            var count by remember { mutableStateOf(0) }
            Counter(
                count = count,
                onIncrement = { min:Int, max:Int, step:Int -> if(count < max) count+=step },
                onDecrement = { min:Int, max:Int,step:Int -> if(count > min) count-=step },
                min=0,
                max=10,
                step=1
            )
        }
    }
}

class RGBCount {
    var count by mutableStateOf(0) ;

    fun update(min:Int, max:Int, step:Int) {
        if(step < 0){
            if(count+step > min) count+=step
            else count = min
        }
        else{
            if(count+step < max) count+=step
            else count = max
        }
    }
}

@Composable
fun RGBCounterScreen(){
    var countR by remember { mutableStateOf(RGBCount()) }
    var countG by remember { mutableStateOf(RGBCount()) }
    var countB by remember { mutableStateOf(RGBCount()) }

    Column(
        modifier = Modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier.weight(0.5f)) {
            Counter(
                text="R",
                min=0,
                max=255,
                step=10,
                count = countR.count,
                onIncrement = { min:Int, max:Int, step:Int -> countR.update(min,max,step) },
                onDecrement = { min:Int, max:Int, step:Int -> countR.update(min,max,-step) },
            )
            Counter(
                text="G",
                min=0,
                max=255,
                step=10,
                count = countG.count,
                onIncrement = { min:Int, max:Int, step:Int -> countG.update(min,max,step) },
                onDecrement = { min:Int, max:Int, step:Int -> countG.update(min,max,-step) },
            )
            Counter(
                text="B",
                min=0,
                max=255,
                step=10,
                count = countB.count,
                onIncrement = { min:Int, max:Int, step:Int -> countB.update(min,max,step) },
                onDecrement = { min:Int, max:Int, step:Int -> countB.update(min,max,-step) },
            )
        }

        Column(modifier = Modifier.weight(0.5f)) {
            Box(
                modifier = Modifier
                    .background(color = Color(countR.count, countG.count, countB.count, 255))
                    .height(100.dp)
                    .width(100.dp)
            )
        }
    }
}


@Preview(widthDp = 480)
@Composable
fun PreviewCounterScreen(){
    Aula05CounterTheme {
        RGBCounterScreen()
    }
}
