package com.bluecupcake.androidbakary.domain.model

data class Version(
    val id: Int,
    val codename: String,
    val versionNumber: String?,
    val sdk: String?,
    val apiLevel: String?,
    val versionCodes: String?,
    val year: String?,
    val usage: Float?,
    val icon: String?
)