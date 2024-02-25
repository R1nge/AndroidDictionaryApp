package com.r1nge.dictionaryApp.feature_dictionary.presentation

import com.r1nge.dictionaryApp.feature_dictionary.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)
