package com.example.aula05counter.ui.Counter

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.aula05counter.ui.theme.Aula05CounterTheme

@Composable
fun Counter(modifier: Modifier = Modifier){
    var count: MutableState<Int> = remember {  mutableStateOf(0) };
    Surface(modifier = modifier) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Text(
                text="Número de Cliques: ${count.value}",
                modifier = Modifier.weight(1f)
            )
            ElevatedButton(
                onClick = { count.value++ },
            ) {
                Text("+")
            }
        }
    }
}

@Preview(widthDp = 320)
@Composable
fun PreviewCounter(){
    Aula05CounterTheme {
        Counter()
    }
}
