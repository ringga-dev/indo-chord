package ngga.ring.indochord.ui.view.home.activity

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ngga.ring.indochord.ui.theme.IndoChordTheme
import ngga.ring.indochord.ui.view.home.componen.HomeComponent
import ngga.ring.remote.data.todo.ChordModel
import ngga.ring.remote.extensions.toDataModel
import ngga.ring.remote.extensions.toJson

class DetailMusikChordActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            IndoChordTheme {
                Scaffold(modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.systemBars)) { innerPadding ->
                    val extras = intent.extras
                    val data = extras?.getString("chord").toDataModel(ChordModel::class.java)
                    Log.e(TAG, data.toJson())

                    HomeComponent(modifier = Modifier.padding(innerPadding)).ViewChordDetail(data!!){
                        finish()
                    }
                }
            }
        }
    }
}
