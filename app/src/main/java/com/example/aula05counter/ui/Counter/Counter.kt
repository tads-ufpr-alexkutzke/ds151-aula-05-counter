package com.example.aula05counter.ui.Counter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aula05counter.ui.theme.Aula05CounterTheme

@Composable
fun Counter(modifier: Modifier = Modifier, max: Int = Int.MAX_VALUE, min: Int = Int.MIN_VALUE){
    var count by remember {  mutableStateOf(0) }
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
                    onClick = { if(count > min) count-- },
                ) {
                    Text("-")
                }
                ElevatedButton(
                    onClick = { if(count < max) count++ },
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
        Counter(min=0, max=10)
    }
}
