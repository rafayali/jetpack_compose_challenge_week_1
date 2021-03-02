package com.example.androiddevchallenge.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun PuppyDetailView(navController: NavController, id: Int) {
    val scrollState = rememberScrollState()
    val puppy = samplePuppies.first { it.id == id }
    val genderIcon = if (puppy.gender == "Male") {
        R.drawable.ic_male_24dp
    } else {
        R.drawable.ic_female_24dp
    }

    Box {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
        ) {
            Image(
                contentScale = ContentScale.Crop,
                painter = painterResource(id = samplePuppies.first { it.id == id }.avatarId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 4.dp)
            ) {
                Text(
                    text = puppy.name,
                    style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.width(32.dp))
                Icon(painter = painterResource(id = genderIcon), contentDescription = null)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = puppy.gender)
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 4.dp)
            ) {
                Column {
                    Text(
                        text = "Breed",
                        style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
                    )
                    Text(text = puppy.breed)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = "Age",
                        style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
                    )
                    Text(text = puppy.age)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = "Size",
                        style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
                    )
                    Text(text = puppy.size)
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "Location",
                    style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
                )
                Text(text = puppy.location)
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "About",
                    style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
                )
                Text(text = puppy.about)
            }
            Spacer(modifier = Modifier.height(56.dp))
        }
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                contentDescription = null
            )
        }
        Box(
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 32.dp)
                .align(Alignment.BottomCenter)
        ) {
            Button(onClick = { }, modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Adopt Me",
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }

}

@Preview
@Composable
fun PuppyDetailView_Preview() {
    MyTheme(darkTheme = false) {
        Surface(color = MaterialTheme.colors.background) {
            val navController = rememberNavController()
            PuppyDetailView(navController, 1)
        }
    }
}

@Preview
@Composable
fun PuppyDetailViewDark_Preview() {
    MyTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.background) {
            val navController = rememberNavController()
            PuppyDetailView(navController, 1)
        }
    }
}