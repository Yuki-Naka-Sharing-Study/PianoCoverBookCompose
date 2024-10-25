package com.example.pianocoverbook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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

    // 以下は「記録無し」のコード
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            NoRecordImageView()
            NoRecordText()
            NoRecordDescriptionText()
        }
    }

    // 以下は「記録あり」のコード
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            SearchScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConfirmScreenPreview() {
    PianoCoverBookTheme {
        ConfirmScreen()
    }
}

@Composable
private fun NoRecordImageView(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.music_note),
        contentDescription = "Description of the image",
        modifier = modifier
            .size(200.dp)
            .aspectRatio(1f)
    )
}

// 以下は「記録無し」のコード

@Preview(showBackground = true)
@Composable
private fun NoRecordImageViewPreview() {
    PianoCoverBookTheme {
        NoRecordImageView(modifier = Modifier)
    }
}

@Composable
private fun NoRecordText(modifier: Modifier = Modifier) {
    androidx.compose.material.Text(
        text = "記録無し",
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
    )
}

@Preview(showBackground = true)
@Composable
private fun NoRecordTextPreview() {
    PianoCoverBookTheme {
        NoRecordText()
    }
}

@Composable
private fun NoRecordDescriptionText(modifier: Modifier = Modifier) {
    androidx.compose.material.Text(
        text = "まだ何も記録されていません。",
        fontWeight = FontWeight.Light,
        color = androidx.compose.ui.graphics.Color.LightGray
    )
}

@Preview(showBackground = true)
@Composable
private fun NoRecordDescriptionTextPreview() {
    PianoCoverBookTheme {
        NoRecordDescriptionText()
    }
}

// 以下は「記録あり」のコード

@Composable
private fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit
) {
    val modifier = Modifier
        .fillMaxWidth()
        .background(
            androidx.compose.ui.graphics.Color.Gray.copy(alpha = 0.1f),
            shape = RoundedCornerShape(12.dp)
        )
        .padding(8.dp)

    Box(modifier = modifier) {
        androidx.compose.material.TextField(
            value = query,
            onValueChange = onQueryChange,
            placeholder = { androidx.compose.material.Text("曲名・アーティスト名で検索") },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "Search Icon")
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun SearchScreen() {
    var searchQuery by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        SearchBar(
            query = searchQuery,
            onQueryChange = { searchQuery = it }
        )
        // 検索結果を表示するためのUIをここに追加。
    }
}