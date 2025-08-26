package me.tmbmnadim.kotlin_intro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.tmbmnadim.kotlin_intro.ui.theme.IntroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntroTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Quadrants()
                }
            }
        }
    }
}

@Composable
fun Quadrants(child: @Composable () -> Unit = {}) {
    Column(Modifier.fillMaxSize()) {
        Row(Modifier.weight(1f)) {
            Box(Modifier
                .weight(1f)
                .fillMaxHeight()
                .border(
                    1.dp,
                    Color.Black,
                )
            )
            {
                child()
            }
            Box(Modifier
                .weight(1f)
                .fillMaxHeight()
                .border(
                    1.dp,
                    Color.Black,
                )
            )
            {
                child()
            }
        }
        Row(Modifier.weight(1f)) {
            Box(Modifier
                .weight(1f)
                .fillMaxHeight()
                .border(
                    1.dp,
                    Color.Black,
                )
            )
            {
                child()
            }
            Box(Modifier
                .weight(1f)
                .fillMaxHeight()
                .border(
                    1.dp,
                    Color.Black,
                )
            )
            {
                child()
            }
        }
    }
}

@Composable
fun TitleText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.tutorial_title),
        modifier = modifier
            .padding(16.dp),
        fontSize = 24.sp,
        lineHeight = 26.sp,
        textAlign = TextAlign.Start

    )
}

@Composable
fun SubtitleText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.tutorial_subtitle),
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp),
        textAlign = TextAlign.Justify

    )
}

@Composable
fun BodyText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.tutorial_details),
        modifier = modifier
            .padding(16.dp),
        textAlign = TextAlign.Justify

    )
}

@Composable
fun TitleImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background);
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun KotlinIntroPreview() {
    IntroTheme {
        Column {
            Quadrants {
                Column {
                    TitleImage()
                    TitleText()
                    SubtitleText()
                    BodyText()
                }
            }
        }
    }
}