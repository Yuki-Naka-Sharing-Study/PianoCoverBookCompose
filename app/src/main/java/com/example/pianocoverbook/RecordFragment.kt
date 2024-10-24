package com.example.pianocoverbook


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    Column {
        Text(text = "記録画面です")
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