package com.r1nge.dictionaryApp.feature_dictionary.data.remote

import com.r1nge.dictionaryApp.feature_dictionary.data.remote.dto.WordInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi {

    @GET("/api/v2/entries/{lang}/{word}")
    suspend fun getWordInfo(
        @Path("lang") lang: String,
        @Path("word") word: String
    ): List<WordInfoDto>
}