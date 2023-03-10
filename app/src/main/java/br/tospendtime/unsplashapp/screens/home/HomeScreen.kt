package br.tospendtime.unsplashapp.screens.home

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.collectAsLazyPagingItems
import br.tospendtime.unsplashapp.navigation.Screen
import br.tospendtime.unsplashapp.screens.commom.ListContent
import coil.annotation.ExperimentalCoilApi

@OptIn(ExperimentalCoilApi::class, ExperimentalPagingApi::class)
@Composable
fun HomeScreen(navController: NavHostController, homeViewModel: HomeViewModel = hiltViewModel()){
    val getAllImages = homeViewModel.getAllImages.collectAsLazyPagingItems()
    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = {
                navController.navigate(Screen.Search.route)
            })
        },
        content = {
            ListContent(items = getAllImages)
        }
    )
}