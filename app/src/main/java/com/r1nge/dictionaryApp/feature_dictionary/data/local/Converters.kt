package com.r1nge.dictionaryApp.feature_dictionary.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.r1nge.dictionaryApp.feature_dictionary.data.util.JsonParser
import com.r1nge.dictionaryApp.feature_dictionary.domain.model.Meaning

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromMeaningJson(json: String): List<Meaning> {
        return jsonParser.fromJson<ArrayList<Meaning>>(
            json,
            object : TypeToken<ArrayList<Meaning>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toMeaningsJson(meaning: List<Meaning>): String {
        return jsonParser.toJson(
            meaning,
            object : TypeToken<ArrayList<Meaning>>() {}.type
        ) ?: "[]"
    }
}