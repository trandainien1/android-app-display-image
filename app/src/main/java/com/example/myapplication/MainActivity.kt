package com.example.myapplication

import android.graphics.Color.rgb
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.model.Topic
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.data.DataSource



@Composable
fun TopicCard(
    topic: Topic,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(120.dp)
            .width(240.dp)
            .background(
                Color(rgb(230, 224, 235)),
                shape = RoundedCornerShape(12.dp)
            )
            .clip(
                shape = RoundedCornerShape(12.dp)

            )
    ) {
       Image(
           painter = painterResource(topic.img),
           contentDescription = null,
           modifier = Modifier
               .width(80.dp)
//               .height(120.dp)
               .fillMaxHeight(),
           contentScale = ContentScale.Crop,

       )
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
           Text(
               text = stringResource(topic.title),
               fontSize = 16.sp,
               modifier = Modifier.padding(bottom = 8.dp)
           )
            Row() {
                Icon(
                    imageVector = Icons.Rounded.ShoppingCart,
                    contentDescription = topic.amount.toString()
                )
                Text(
                    text = topic.amount.toString(),
                    fontSize = 16.sp,
                )
            }
        }
    }
}

@Composable
fun DisplayTopics(
    topicCards: List<Topic>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(12.dp),
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(topicCards) {
            TopicCard(it, Modifier)
        }
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                DisplayTopics(topicCards = DataSource().loadTopics(), Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
      DisplayTopics(topicCards = DataSource().loadTopics(), Modifier.fillMaxSize())
    }
}