package br.tospendtime.unsplashapp.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.tospendtime.unsplashapp.data.local.UnsplashDatabase
import br.tospendtime.unsplashapp.data.paging.SearchPagingSource
import br.tospendtime.unsplashapp.data.paging.UnsplashRemoteMediator
import br.tospendtime.unsplashapp.data.remote.UnsplashApi
import br.tospendtime.unsplashapp.model.UnsplashImage
import br.tospendtime.unsplashapp.util.Constants
import br.tospendtime.unsplashapp.util.Constants.ITENS_PER_PAGE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
@OptIn(ExperimentalPagingApi::class)
class Repository @Inject constructor(
    private val unsplashApi: UnsplashApi,
    private val unsplashDatabase: UnsplashDatabase
) {
    fun getAllImages(): Flow<PagingData<UnsplashImage>>{
        val pagingSourceFactory = {unsplashDatabase.unsplashImageDao().getAllImages()}

        return Pager(
            config = PagingConfig(pageSize = Constants.ITENS_PER_PAGE),
            remoteMediator = UnsplashRemoteMediator(
                unsplashApi = unsplashApi,
                unsplashDatabase = unsplashDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    fun searchImages(query: String): Flow<PagingData<UnsplashImage>> {
        return Pager(
            config = PagingConfig(pageSize = ITENS_PER_PAGE),
            pagingSourceFactory = {
                SearchPagingSource(unsplashApi = unsplashApi, query = query)
            }
        ).flow
    }
}