package br.tospendtime.unsplashapp.screens.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeTopBar( onSearchClicked: () -> Unit){
    TopAppBar(
        title = {
            Text(
                text = "Home",
                color = colorScheme.onPrimaryContainer
            )
        },
        backgroundColor = colorScheme.primary,
        actions = {
            IconButton(onClick = onSearchClicked){
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = ""
                )
            }
        }
    )
}


@Composable
@Preview
fun HomeTopBarPreview(){
    HomeTopBar{}
}