package ngga.ring.indochord.ui.view.home.componen

import android.content.Intent
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.takeOrElse
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import ngga.ring.indochord.R
import ngga.ring.indochord.ui.theme.IndoChordTheme
import ngga.ring.indochord.ui.view.home.activity.DetailMusikChordActivity
import ngga.ring.remote.data.todo.ChordModel
import ngga.ring.remote.data.todo.chort.marjinalCortList
import ngga.ring.remote.extensions.toJson

class HomeComponent(private val modifier: Modifier) {

    @Composable
    fun View() {
        val data = marjinalCortList

        Column(modifier = modifier.fillMaxSize()) {
            val ctx = LocalContext.current
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Home",
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.W900,
                    modifier = Modifier.weight(1f).padding(start = 20.dp, top = 10.dp, bottom = 10.dp)
                )
                Image(
                    modifier = Modifier
                        .padding(end = 20.dp, top = 10.dp, bottom = 10.dp)
                        .size(24.dp),
                    painter = painterResource(id = R.drawable.ic_info),
                    colorFilter = ColorFilter.tint(Color.Cyan),
                    contentDescription = null
                )
            }

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                items(data.size) {
                    ItemCardMusic(index = it + 1, data[it]) {
                        val i = Intent(ctx, DetailMusikChordActivity::class.java)
                        i.putExtra("chord", it.toJson())
                        ctx.startActivity(i)
                    }
                }
            }

        }
    }

    @Composable
    fun ItemCardMusic(
        index: Int = 0,
        data: ChordModel,
        onClick: (ChordModel) -> Unit
    ) {
        Row(
            modifier = Modifier
                .padding(top = 3.dp)
                .fillMaxWidth()
                .background(color = Color.White)
                .clickable {
                    onClick.invoke(data)
                },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 20.dp, end = 10.dp, top = 10.dp, bottom = 10.dp)
                    .weight(1f)
            ) {

                Text(
                    text = "${index}. ${data.name}",
                    fontSize = 16.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.W700
                )

                Text(
                    text = "${data.artis}",
                    fontSize = 12.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.W400
                )

            }
            Image(
                modifier = Modifier
                    .padding(end = 20.dp)
                    .size(24.dp),
                painter = painterResource(id = R.drawable.ic_arrow_forward),
                contentDescription = null
            )
        }
    }


    @Composable
    fun ViewChordDetail(
        data: ChordModel,
        onBackData: ()-> Unit
    ) {
        val modifier = Modifier // Pastikan modifier dideklarasikan
        Column(modifier = modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .padding(20.dp)
                        .size(24.dp).clickable {
                            onBackData.invoke()
                        },
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = null
                )
                Text(
                    text = "Detail music",
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.W900,
                    modifier = Modifier.weight(1f).padding(start = 20.dp, top = 10.dp, bottom = 10.dp)
                )
                Image(
                    modifier = Modifier
                        .padding(end = 20.dp, top = 10.dp, bottom = 10.dp)
                        .size(24.dp),
                    painter = painterResource(id = R.drawable.ic_info),
                    colorFilter = ColorFilter.tint(Color.Cyan),
                    contentDescription = null
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .background(color = Color.White)
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
            ) {
                // Menampilkan chord menggunakan HTML content
                HtmlContentView(data.description.toString(), modifier = modifier)
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IndoChordTheme {
        HomeComponent(modifier = Modifier).View()
    }
}



@Composable
fun HtmlContentView(htmlContent: String, modifier: Modifier) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
        WebView(context).apply {
            webViewClient = WebViewClient() // Agar konten HTML ditampilkan dalam WebView
            loadDataWithBaseURL(null, htmlContent, "text/html", "UTF-8", null)
        }
    })
}