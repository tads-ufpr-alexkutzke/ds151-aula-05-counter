package com.example.aula05counter.ui.Counter

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.aula05counter.ui.theme.Aula05CounterTheme

@Composable
fun Counter(){
   Text("Counter")
}

@Preview
@Composable
fun PreviewCounter(){
    Aula05CounterTheme {
        Counter()
    }
}
