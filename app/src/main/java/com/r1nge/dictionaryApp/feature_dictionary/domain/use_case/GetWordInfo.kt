package com.r1nge.dictionaryApp.feature_dictionary.domain.use_case

import com.r1nge.dictionaryApp.core.util.Resource
import com.r1nge.dictionaryApp.feature_dictionary.domain.model.WordInfo
import com.r1nge.dictionaryApp.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo(
    private val repository: WordInfoRepository
) {

    operator fun invoke(language: String, word: String): Flow<Resource<List<WordInfo>>> {
        if (word.isBlank()) {
            return flow { }
        }

        return repository.getWordInfo(language, word)
    }
}