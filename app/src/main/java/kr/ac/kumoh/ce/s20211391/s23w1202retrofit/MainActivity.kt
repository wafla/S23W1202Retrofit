package kr.ac.kumoh.ce.s20211391.s23w1202retrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kr.ac.kumoh.ce.s20211391.s23w1202retrofit.ui.theme.S23W1202RetrofitTheme

class MainActivity : ComponentActivity() {
    private val viewModel: SongViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(viewModel)
        }
    }
}

@Composable
fun MainScreen(viewModel: SongViewModel){
    val songList by viewModel.songList.observeAsState(emptyList())
    S23W1202RetrofitTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SongList(songList)
        }
    }
}

@Composable
fun SongList(list: List<Song>){
    Column{
        Text(list.toString())
    }
}