package com.r1nge.dictionaryApp.feature_dictionary.data.repository

import com.r1nge.dictionaryApp.core.util.Resource
import com.r1nge.dictionaryApp.feature_dictionary.data.local.WordInfoDao
import com.r1nge.dictionaryApp.feature_dictionary.data.remote.DictionaryApi
import com.r1nge.dictionaryApp.feature_dictionary.domain.model.WordInfo
import com.r1nge.dictionaryApp.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class WordInfoRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordInfoDao
) : WordInfoRepository {
    override fun getWordInfo(language: String, word: String): Flow<Resource<List<WordInfo>>> =
        flow {
            emit(Resource.Loading())

            val wordInfos = dao.getWordInfos(word).map { it.toWordInfo() }
            emit(Resource.Loading(data = wordInfos))

            try {
                val remoteWordInfos = api.getWordInfo(language, word)
                dao.deleteWordInfos(remoteWordInfos.map { it.word })
                dao.insertWordInfos(remoteWordInfos.map { it.toWordInfoEntity() })
            } catch (e: retrofit2.HttpException) {
                emit(Resource.Error("Something went wrong", wordInfos))
            } catch (e: IOException) {
                emit(Resource.Error("Couldn't reach the server", wordInfos))
            }

            val newWordInfos = dao.getWordInfos(word).map { it.toWordInfo() }
            emit(Resource.Success(newWordInfos))
        }
}