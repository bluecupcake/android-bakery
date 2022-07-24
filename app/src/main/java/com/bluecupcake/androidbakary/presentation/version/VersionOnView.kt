package com.bluecupcake.androidbakary.presentation.version

data class VersionOnView (
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