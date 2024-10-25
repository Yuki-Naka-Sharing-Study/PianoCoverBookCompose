package com.example.pianocoverbook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.border
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.example.pianocoverbook.ui.theme.PianoCoverBookTheme

class RecordFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val composeView = ComposeView(requireContext()).apply {
            setContent {
                RecordScreen()
            }
        }
        return composeView
    }
}

@Composable
fun RecordScreen() {
    // ComposeのUIを定義
    Column(

    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(16.dp))
            SongNameTextView("曲名")
            Spacer(modifier = Modifier.width(16.dp))
            SongNameTextField(Modifier.weight(1f, true))
            Spacer(modifier = Modifier.width(16.dp))
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(16.dp))
            ArtistNameTextView("アーティスト名")
            Spacer(modifier = Modifier.width(16.dp))
            ArtistNameTextField(Modifier.weight(1f, true))
            Spacer(modifier = Modifier.width(16.dp))
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(16.dp))
            MemoTextView("メモ")
            Spacer(modifier = Modifier.width(16.dp))
            MemoTextField(Modifier.weight(1f, true))
            Spacer(modifier = Modifier.width(16.dp))
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                RightHandTextView("右手の習熟度")
                RightHandCircularProgressWithSeekBar()

                LeftHandTextView("左手の習熟度")
                LeftHandCircularProgressWithSeekBar()

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
fun SongNameTextView(songName: String, modifier: Modifier = Modifier) {
    Text(
        text = "曲名",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun SongNameTextViewPreview() {
    PianoCoverBookTheme {
        SongNameTextView("曲名")
    }
}

@Composable
fun SongNameTextField(modifier: Modifier = Modifier) {
    OutlinedTextField(
        modifier = modifier
            .height(52.dp)
            .clip(RoundedCornerShape(10))
            .border(
                width = 2.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(5.dp)
            ),
        value = "",
        onValueChange = { },
        placeholder = {
            Text(
                text = "ラ・カンパネラ",
                style = TextStyle(fontSize = 16.sp),
                color = Color.Gray
            ) },
    )
}

@Preview(showBackground = true)
@Composable
fun SongNameTextFieldPreview() {
    PianoCoverBookTheme {
        SongNameTextField()
    }
}

@Composable
fun ArtistNameTextView(artistName: String, modifier: Modifier = Modifier) {
    Text(
        text = "アーティスト名",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun ArtistNameTextViewPreview() {
    PianoCoverBookTheme {
        ArtistNameTextView("アーティスト名")
    }
}

@Composable
fun ArtistNameTextField(modifier: Modifier = Modifier) {
    OutlinedTextField(
        modifier = modifier
            .height(52.dp)
            .clip(RoundedCornerShape(10))
            .border(
                width = 2.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(5.dp)
            ),
        value = "",
        onValueChange = { },
        placeholder = {
            Text(
                text = "リスト",
                style = TextStyle(fontSize = 16.sp),
                color = Color.Gray
            ) },
    )
}

@Preview(showBackground = true)
@Composable
fun ArtistNameTextFieldPreview() {
    PianoCoverBookTheme {
        ArtistNameTextField()
    }
}

@Composable
fun MemoTextView(memoName: String, modifier: Modifier = Modifier) {
    Text(
        text = "メモ",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun MemoTextViewPreview() {
    PianoCoverBookTheme {
        MemoTextView("メモ")
    }
}

@Composable
fun MemoTextField(modifier: Modifier = Modifier) {
    OutlinedTextField(
        modifier = modifier
            .height(52.dp)
            .clip(RoundedCornerShape(10))
            .border(
                width = 2.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(5.dp)
            ),
        value = "",
        onValueChange = { },
        placeholder = {
            Text(
                text = "アルペジオが上手く弾けない。",
                style = TextStyle(fontSize = 16.sp),
                color = Color.Gray
            ) },
    )
}

@Preview(showBackground = true)
@Composable
fun MemoTextFieldPreview() {
    PianoCoverBookTheme {
        MemoTextField()
    }
}

@Composable
fun RightHandTextView(rightHand: String, modifier: Modifier = Modifier) {
    Text(
        text = "右手の習熟度",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun RightHandTextViewPreview() {
    PianoCoverBookTheme {
        RightHandTextView("右手の習熟度")
    }
}

@Composable
fun LeftHandTextView(leftHand: String, modifier: Modifier = Modifier) {
    Text(
        text = "左手の習熟度",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun LeftHandTextViewPreview() {
    PianoCoverBookTheme {
        LeftHandTextView("左手の習熟度")
    }
}

@Composable
fun RightHandCircularProgressWithSeekBar() {
    val progress = remember { mutableStateOf(0f) }

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.size(180.dp))
    {
        CircularProgressIndicator(
            color = Color.Blue,
            strokeWidth = 4.dp,
            progress = progress.value / 100,
            modifier = Modifier
                .size(180.dp)
                .padding(8.dp))
        Text(
            text = "${progress.value.toInt()}%",
            fontSize = 36.sp
        )
    }

    Slider(
        colors = SliderDefaults.colors(
            activeTrackColor = Color.Blue,
            inactiveTrackColor = Color.Gray,
            thumbColor = Color.Blue
        ),
        value = progress.value,
        onValueChange = { newValue ->
            progress.value = newValue
        },
        valueRange = 0f..100f,
        modifier = Modifier.padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun RightHandCircularProgressWithSeekBarPreview() {
    PianoCoverBookTheme {
        RightHandCircularProgressWithSeekBar()
    }
}

@Composable
fun LeftHandCircularProgressWithSeekBar() {
    val progress = remember { mutableStateOf(0f) }

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.size(180.dp))
    {
        CircularProgressIndicator(
            color = Color.Blue,
            strokeWidth = 4.dp,
            progress = progress.value / 100,
            modifier = Modifier
                .size(180.dp)
                .padding(8.dp))
        Text(
            text = "${progress.value.toInt()}%",
            fontSize = 36.sp
        )
    }

    Slider(
        colors = SliderDefaults.colors(
            activeTrackColor = Color.Blue,
            inactiveTrackColor = Color.Gray,
            thumbColor = Color.Blue
        ),
        value = progress.value,
        onValueChange = { newValue ->
            progress.value = newValue
        },
        valueRange = 0f..100f,
        modifier = Modifier.padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun LeftHandCircularProgressWithSeekBarPreview() {
    PianoCoverBookTheme {
        LeftHandCircularProgressWithSeekBar()
    }
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

@Preview(showBackground = true)
@Composable
fun SaveRecordButtonPreview() {
    PianoCoverBookTheme {
        SaveRecordButton()
    }
}