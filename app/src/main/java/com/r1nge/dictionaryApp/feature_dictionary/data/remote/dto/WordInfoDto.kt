package com.r1nge.dictionaryApp.feature_dictionary.data.remote.dto

import com.r1nge.dictionaryApp.feature_dictionary.data.local.entity.WordInfoEntity
import com.r1nge.dictionaryApp.feature_dictionary.domain.model.WordInfo

data class WordInfoDto(
    val meanings: List<MeaningDto>,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val word: String
) {
    fun toWordInfoEntity(): WordInfoEntity {
        return WordInfoEntity(
            meanings = meanings.map { it.toMeaning() },
            phonetic = phonetic,
            word = word
        )
    }
}