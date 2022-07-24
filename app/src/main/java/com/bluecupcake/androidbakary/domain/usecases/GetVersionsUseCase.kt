package com.bluecupcake.androidbakary.domain.usecases

import android.content.Context
import com.bluecupcake.androidbakary.domain.model.Version
import com.bluecupcake.androidbakary.infrastructure.local.JsonLocalDataSource
import com.bluecupcake.androidbakary.mapper.domain.VersionMapper
import com.bluecupcake.androidbakary.repository.version.RealVersionRepository
import com.bluecupcake.androidbakary.repository.version.VersionRepository

class GetVersionsUseCase(context: Context) {
    private val jsonLocal = JsonLocalDataSource()
    private val mapper = VersionMapper()
    private val repository: VersionRepository = RealVersionRepository(jsonLocal, mapper, context)

    operator fun invoke(): List<Version> = repository.getVersions()
}