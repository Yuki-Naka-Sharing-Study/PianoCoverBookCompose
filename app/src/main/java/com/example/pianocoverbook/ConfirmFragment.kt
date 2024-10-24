package com.example.pianocoverbook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.example.pianocoverbook.ui.theme.PianoCoverBookTheme

class ConfirmFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val composeView = ComposeView(requireContext()).apply {
            setContent {
                ConfirmScreen()
            }
        }
        return composeView
    }
}

@Composable
fun ConfirmScreen() {
    // ComposeのUIを定義
    Column {
        Text(text = "記録確認画面です")
    }
}

@Composable
fun NoRecordImageView(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.music_note),
        contentDescription = "Description of the image",
        modifier = modifier
            .size(200.dp)
            .aspectRatio(1f)
    )
}

@Preview(showBackground = true)
@Composable
fun NoRecordImageViewPreview() {
    PianoCoverBookTheme {
        NoRecordImageView(modifier = Modifier)
    }
}

@Composable
fun NoRecordText(modifier: Modifier = Modifier) {
    Text(
        text = "記録無し",
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
    )
}

@Preview(showBackground = true)
@Composable
fun NoRecordTextPreview() {
    PianoCoverBookTheme {
        NoRecordText()
    }
}