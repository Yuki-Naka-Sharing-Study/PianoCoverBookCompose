package com.example.pianocoverbook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
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