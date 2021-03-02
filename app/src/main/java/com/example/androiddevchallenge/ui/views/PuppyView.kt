/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun PuppyView(navController: NavController, puppy: Puppy) {
    Surface(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
        shape = RoundedCornerShape(16),
        color = MaterialTheme.colors.surface
    ) {
        Row(
            modifier = Modifier
                .height(96.dp)
                .fillMaxWidth()
                .clickable {
                    navController.navigate("detail/${puppy.id}")
                }
        ) {
            Surface(
                shape = RoundedCornerShape(16),
                modifier = Modifier
                    .size(96.dp)
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = puppy.avatarId),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
            ) {
                Text(text = puppy.name, style = MaterialTheme.typography.h6)
                Text(
                    text = puppy.breed,
                    style = MaterialTheme.typography.body1.copy(color = Color(0xff54a199))
                )
                Text(text = puppy.location, style = MaterialTheme.typography.body2)
            }
        }
    }
}

@Preview
@Composable
fun PuppyView_Preview() {
    MyTheme {
        PuppyView(navController = rememberNavController(), puppy = samplePuppies.first())
    }
}

@Preview
@Composable
fun PuppyVieDark_Preview() {
    MyTheme(darkTheme = true) {
        PuppyView(navController = rememberNavController(), puppy = samplePuppies.first())
    }
}

data class Puppy(
    val id: Int,
    val name: String,
    val avatarId: Int,
    val breed: String,
    val location: String,
    val age: String,
    val gender: String,
    val size: String,
    val about: String
)
