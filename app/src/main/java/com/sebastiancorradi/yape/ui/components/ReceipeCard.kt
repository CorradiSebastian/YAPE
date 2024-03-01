package com.sebastiancorradi.yape.ui.components

import android.provider.Settings.Global.getString
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.sebastiancorradi.yape.R
import com.sebastiancorradi.yape.data.Recipe

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
//MainScreen(onResumeClicked = {navController.navigate(AppScreens.LocationScreen.route)}
fun ReceipeCard(displayDetails: (receipe: Recipe) -> Unit, recipe: Recipe) {
//fun ReceipeCard(displayDetails: () -> Unit, recipe: Recipe) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 5.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray, //Card background color
            //contentColor = Color.White  //Card content color,e.g.text
        )
    ) {
        Column(modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 5.dp)) {


            Row(modifier = Modifier.fillMaxWidth()) {
                Column(
                    verticalArrangement = Arrangement.Top,

                    ) {
                    Text(
                        text = recipe.name?:context.getString(R.string.receipe_name_not_available),
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                    Button(modifier = Modifier.wrapContentSize(), onClick = {
                        displayDetails(recipe)
                    }) {
                        Text(text = context.getString(R.string.view_receipe_details))
                    }
                }
                Spacer(Modifier.weight(1f))
                //image
                GlideImage(
                    model = recipe.image,
                    contentDescription = context.getString(R.string.image),
                    modifier = Modifier.padding(2.dp).clickable(onClick = {  }).size(50.dp),
                )

            }
        }
    }
}


/*
@Composable
fun DetailsContent() {
    val locations = remember { listOf(LocationData("user1", DBLocation(1.0, 2.0, 1705604793566L, "deviceID")),
        LocationData("user1", DBLocation(1.0, 2.0, 1705604598566L, "deviceID"))) }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            locations
        ) {
            LocationDetailCard(location = it)
        }
    }
}
*/

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    //LocationDetailCard(LocationData("user", DBLocation()))
    ReceipeCard({}, Recipe("receta", "descripcion", latitude = -13.3, longitude = -38.8))
    /*TrackTheme {
        MainContent(MainScreenUIState())
    }*/
}