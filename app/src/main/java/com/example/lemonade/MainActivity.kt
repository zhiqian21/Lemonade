package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                LemonadeApp()
            }
        }
    }
}

@Preview
@Composable
fun LemonadeApp(){
    LemonadeImageAndText(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun ClickCounter(clicks: Int, onClick: () -> Unit) {

}

@Composable
fun LemonadeImageAndText(modifier: Modifier = Modifier){
    var result by remember { mutableStateOf(1) }
    when (result){
        1 -> {
            Column (modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally)
            {
                Image(
                    painterResource(id = R.drawable.lemon_tree),
                    contentDescription = "lemon tree image",
                    modifier = Modifier
                        .clickable {result = 2}
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = stringResource(id = R.string.LemonTree))
            }
        }

        2 -> {
            Column (modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally)
            {
                Image(
                    painterResource(id = R.drawable.lemon_squeeze),
                    contentDescription = "lemon image",
                    modifier = Modifier.clickable {result = 3}
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = stringResource(id = R.string.Lemon))
            }
        }

        3 -> {
            Column (modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally)
            {
                Image(
                    painterResource(id = R.drawable.lemon_drink),
                    contentDescription = "lemon drink image",
                    modifier = Modifier.clickable {result = 4}
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = stringResource(id = R.string.GlassOfLemonade))
            }
        }

        4 -> {
            Column (modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally)
            {
                Image(
                    painterResource(id = R.drawable.lemon_restart),
                    contentDescription = "empty glass image",
                    modifier = Modifier.clickable {result = 1}
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = stringResource(id = R.string.EmptyGlass))
            }
        }
    }

}