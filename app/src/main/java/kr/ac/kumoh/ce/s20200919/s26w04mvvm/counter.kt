package kr.ac.kumoh.ce.s20200919.s26w04mvvm

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.retain.retain
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Counter(
    modifier: Modifier = Modifier,
    count: Int,
    onAdd: () -> Unit,
    onSub: () -> Unit,
    onReset: () -> Unit,
) {
    var expanded by retain { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color(0xFFE9F680)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = count.toString(),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFF7F32)),
            textAlign = TextAlign.Center,
            fontSize = 100.sp,
            color = Color.White
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Button(
                onClick = onAdd,
                modifier = Modifier.weight(1f)
            ) {
                Text("+", fontSize = 24.sp)
            }

            if (expanded) {
                Button(onClick = {
                    onSub()
                    expanded = false
                }) {
                    Text("-", fontSize = 24.sp)
                }
                Button(onClick = {
                    onReset()
                    expanded = false
                }) {
                    Text("0", fontSize = 24.sp)
                }
            } else {
                Button(onClick = { expanded = true }) {
                    Text("...", fontSize = 24.sp)
                }
            }
        }
    }
}