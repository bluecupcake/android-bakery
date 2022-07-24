package com.bluecupcake.androidbakary.mapper.view

import com.bluecupcake.androidbakary.domain.model.Version
import com.bluecupcake.androidbakary.presentation.version.VersionOnView

class VersionOnViewMapper() {
    operator fun invoke(version: Version) = with(version) {
        VersionOnView(
            id = id,
            codename = codename,
            versionNumber = versionNumber ?: "lol",
            sdk = sdk ?: "lol",
            apiLevel = apiLevel ?: "lol",
            versionCodes = versionCodes ?: "lol",
            year = year ?: "lol",
            usage = usage ?: 0.0f,
            icon = icon ?: "lol"
        )
    }
}