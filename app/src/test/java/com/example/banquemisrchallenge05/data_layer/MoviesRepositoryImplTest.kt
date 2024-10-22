package com.example.banquemisrchallenge05.data_layer

import com.example.banquemisrchallenge05.data_layer.remote.FakeTMDbRemoteDataSourceImpl
import com.example.banquemisrchallenge05.data_layer.remote.TMDbRemoteDataSource
import org.junit.Before


class MoviesRepositoryImplTest {


    lateinit var remoteDataSource: TMDbRemoteDataSource
    lateinit var repository: MoviesRepository

    @Before
    fun createRepository() {
        remoteDataSource = FakeTMDbRemoteDataSourceImpl()
        repository = MoviesRepositoryImpl.getInstance(remoteDataSource)
    }


}