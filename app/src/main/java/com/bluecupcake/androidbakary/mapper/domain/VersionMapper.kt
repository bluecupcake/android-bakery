package com.bluecupcake.androidbakary.mapper.domain

import com.bluecupcake.androidbakary.domain.model.Version
import com.bluecupcake.androidbakary.infrastructure.model.response.VersionResponse

class VersionMapper {
    operator fun invoke(response: VersionResponse) = with(response) {
        Version(
            id = id,
            codename = codename,
            versionNumber = numbers,
            sdk = sdk,
            apiLevel = api,
            versionCodes = codes,
            year = year,
            usage = usage,
            icon = icon
        )
    }
}