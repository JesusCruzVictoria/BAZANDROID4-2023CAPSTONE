package com.jecruzv.capstonewl.data.remote.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LanguageDto(
    val english_name: String,
    val iso_639_1: String,
    val name: String
)