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
    max: Int = Int.MAX_VALUE,
    min: Int = Int.MIN_VALUE,
    count: Int = 0,
    onIncrement: (min:Int, max:Int) -> Unit = {min,max -> Unit},
    onDecrement: (min:Int, max:Int) -> Unit = {min,max -> Unit},
){
    Surface(modifier = modifier) {
        Row(
            modifier = modifier.padding(horizontal = 20.dp, vertical = 5.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Text(
                text="Número de Cliques: ${count}",
                modifier = Modifier.weight(1f)
            )
            Row(
                modifier = Modifier.weight(0.5f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,

            ){
                ElevatedButton(
                    onClick =  { onDecrement(min,max) },
                ) {
                    Text("-")
                }
                ElevatedButton(
                    onClick = { onIncrement(min,max) },
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
                onIncrement = { min:Int, max:Int -> if(count < max) count++ },
                onDecrement = { min:Int, max:Int -> if(count > min) count-- },
                min=0,
                max=10
            )
        }
    }
}

@Composable
fun RGBCounterScreen(){
    var countR by remember { mutableStateOf(0) }
    var countG by remember { mutableStateOf(0) }
    var countB by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier.weight(0.5f)) {
            Counter(
                min=0,
                max=255,
                count = countR,
                onIncrement = { min:Int, max:Int -> if(countR < max) countR++ },
                onDecrement = { min:Int, max:Int -> if(countR > min) countR-- },
            )
            Counter(
                min=0,
                max=255,
                count = countG,
                onIncrement = { min:Int, max:Int -> if(countG < max) countG++ },
                onDecrement = { min:Int, max:Int -> if(countG > min) countG-- },
            )
            Counter(
                min=0,
                max=255,
                count = countB,
                onIncrement = { min:Int, max:Int -> if(countB < max) countB++ },
                onDecrement = { min:Int, max:Int -> if(countB > min) countB-- },
            )
        }

        Column(modifier = Modifier.weight(0.5f)) {
            Box(
                modifier = Modifier
                    .background(color = Color(countR, countG, countB, 255))
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
