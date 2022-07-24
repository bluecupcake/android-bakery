package com.bluecupcake.androidbakary.repository.version

import com.bluecupcake.androidbakary.domain.model.Version

interface VersionRepository {
    fun getVersions(): List<Version>
}