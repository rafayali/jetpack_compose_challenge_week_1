package com.example.androiddevchallenge.ui.views

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun HomeView(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "PuppyCo.") },
                backgroundColor = MaterialTheme.colors.primary,
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_paw),
                        contentDescription = null,
                        tint = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.padding(16.dp)
                    )
                })
        }
    ) {
        LazyColumn {
            items(samplePuppies) { puppy ->
                PuppyView(navController = navController, puppy = puppy)
            }
        }
    }
}

@Preview
@Composable
fun HomeView_Preview() {
    MyTheme {
        HomeView(rememberNavController())
    }
}