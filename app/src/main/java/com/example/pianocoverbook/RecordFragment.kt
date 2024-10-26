package com.example.pianocoverbook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.example.pianocoverbook.ui.theme.PianoCoverBookTheme

// 以下、リファクタリング後のコード
class RecordFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                RecordScreen()
            }
        }
    }
}

@Composable
fun RecordScreen() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Spacer(modifier = Modifier.height(16.dp))
        InputRow(label = "曲名", placeholder = "ラ・カンパネラ")

        Spacer(modifier = Modifier.height(8.dp))
        InputRow(label = "アーティスト名", placeholder = "リスト")

        Spacer(modifier = Modifier.height(8.dp))
        InputRow(label = "メモ", placeholder = "アルペジオが上手く弾けない。")

        Spacer(modifier = Modifier.height(8.dp))
        ProgressSection("右手の習熟度") { RightHandCircularProgressWithSeekBar() }
        ProgressSection("左手の習熟度") { LeftHandCircularProgressWithSeekBar() }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SaveRecordButton()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecordScreenPreview() {
    PianoCoverBookTheme {
        RecordScreen()
    }
}

@Composable
fun InputRow(label: String, placeholder: String) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = label)
        Spacer(modifier = Modifier.width(16.dp))
        androidx.compose.material.OutlinedTextField(
            modifier = Modifier
                .weight(1f)
                .height(52.dp),
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    text = placeholder,
                    style = TextStyle(fontSize = 16.sp),
                    color = Color.Gray
                )
            },
            shape = RoundedCornerShape(10),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.Gray
            )
        )
        Spacer(modifier = Modifier.width(16.dp))
    }
}

@Composable
fun ProgressSection(label: String, progressContent: @Composable () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = label)
        progressContent()
    }
}

@Composable
private fun CircularProgressWithSeekBar(progress: MutableState<Float>) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.size(160.dp)) {
        CircularProgressIndicator(
            color = Color.Blue,
            strokeWidth = 4.dp,
            progress = progress.value / 100,
            modifier = Modifier
                .size(160.dp)
                .padding(8.dp)
        )
        Text(text = "${progress.value.toInt()}%", fontSize = 36.sp)
    }
    Slider(
        colors = SliderDefaults.colors(
            activeTrackColor = Color.Blue,
            inactiveTrackColor = Color.Gray,
            thumbColor = Color.Blue
        ),
        value = progress.value,
        onValueChange = { newValue -> progress.value = newValue },
        valueRange = 0f..100f,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun RightHandCircularProgressWithSeekBar() {
    val rightHandProgress = remember { mutableStateOf(0f) }
    CircularProgressWithSeekBar(progress = rightHandProgress)
}

@Composable
fun LeftHandCircularProgressWithSeekBar() {
    val leftHandProgress = remember { mutableStateOf(0f) }
    CircularProgressWithSeekBar(progress = leftHandProgress)
}

@Composable
fun SaveRecordButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(Color.Blue)
    ) {
        Text("記録する")
    }
}