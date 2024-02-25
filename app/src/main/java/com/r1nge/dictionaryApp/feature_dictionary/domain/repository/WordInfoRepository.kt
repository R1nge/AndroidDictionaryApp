package com.r1nge.dictionaryApp.feature_dictionary.domain.repository

import com.r1nge.dictionaryApp.core.util.Resource
import com.r1nge.dictionaryApp.feature_dictionary.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

    fun getWordInfo(language: String, word: String): Flow<Resource<List<WordInfo>>>
}