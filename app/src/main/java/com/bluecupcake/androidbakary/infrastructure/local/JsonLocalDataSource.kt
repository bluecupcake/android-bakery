package com.bluecupcake.androidbakary.infrastructure.local

import android.content.Context
import com.bluecupcake.androidbakary.infrastructure.model.response.VersionResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class JsonLocalDataSource {
    val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    fun getVersions(context: Context): List<VersionResponse> {
        val fileName = "versions.json"

        val jsonFile =  context.assets.open(fileName).bufferedReader().use { it.readText() }

        val versionsList = Types.newParameterizedType(List::class.java, VersionResponse::class.java)
        val adapter: JsonAdapter<List<VersionResponse>> = moshi.adapter(versionsList)

        return adapter.fromJson(jsonFile)!!
    }
}