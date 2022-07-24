package com.bluecupcake.androidbakary.repository.version

import android.content.Context
import com.bluecupcake.androidbakary.domain.model.Version
import com.bluecupcake.androidbakary.infrastructure.local.JsonLocalDataSource
import com.bluecupcake.androidbakary.mapper.domain.VersionMapper

class RealVersionRepository(
    private val jsonLocal: JsonLocalDataSource,
    private val mapper: VersionMapper,
    private val context: Context
) : VersionRepository {
    override fun getVersions(): List<Version> = jsonLocal.getVersions(context).map {
        mapper(it)
    }
}