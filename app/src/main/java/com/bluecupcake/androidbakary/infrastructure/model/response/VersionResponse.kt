package com.bluecupcake.androidbakary.infrastructure.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VersionResponse(
    @Json(name = "api_level")
    val api: String?,
    val codename: String,
    val icon: String?,
    val id: Int,
    val year: String?,
    val sdk: String?,
    val usage: Float?,
    @Json(name = "version_codes")
    val codes: String?,
    @Json(name = "version_numbers")
    val numbers: String?
)