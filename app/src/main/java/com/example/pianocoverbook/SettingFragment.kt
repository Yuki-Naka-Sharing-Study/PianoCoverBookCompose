package com.example.pianocoverbook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Row {
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SetingTextView()

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                Column(
                    modifier = Modifier
                        .wrapContentHeight(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    AboutThisAppLazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(color = androidx.compose.ui.graphics.Color.LightGray)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingScreenPreview() {
    PianoCoverBookTheme {
        SettingScreen()
    }
}

@Composable
private fun SetingTextView() {
    Text(
        "設定",
        fontWeight = FontWeight.Bold
    )
}

@Preview(showBackground = true)
@Composable
private fun SetingTextViewPreview() {
    PianoCoverBookTheme {
        SetingTextView()
    }
}

@Composable
private fun AboutThisAppLazyColumn(modifier: Modifier) {
    val itemList = listOf(
        "このアプリについて",
        "お問い合わせ",
        "レビューする",
        "このアプリを共有する",
        "バージョン"
    )

    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = androidx.compose.ui.graphics.Color.LightGray)
    ) {
        items(itemList.size) { index ->
            val item = itemList[index]
            BasicText(
                text = item,
                modifier = Modifier.padding(16.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    color = androidx.compose.ui.graphics.Color.Gray
                )
            )
            if (index < itemList.size - 1) {
                Divider(color = androidx.compose.ui.graphics.Color.Black)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AboutThisAppLazyColumnPreview() {
    PianoCoverBookTheme {
        AboutThisAppLazyColumn(modifier = Modifier)
    }
}