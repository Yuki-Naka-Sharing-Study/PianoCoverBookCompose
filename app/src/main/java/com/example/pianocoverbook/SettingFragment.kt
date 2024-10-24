package com.example.pianocoverbook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.pianocoverbook.ui.theme.PianoCoverBookTheme

class SettingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val composeView = ComposeView(requireContext()).apply {
            setContent {
                SettingScreen()
            }
        }
        return composeView
    }
}

@Composable
fun SettingScreen() {
    Column {
        Text(text = "設定画面です")
    }
}

@Composable
fun SetingTextView() {
    Text(
        "設定",
        fontWeight = FontWeight.Bold
    )
}

@Preview(showBackground = true)
@Composable
fun SetingTextViewPreview() {
    PianoCoverBookTheme {
        SetingTextView()
    }
}