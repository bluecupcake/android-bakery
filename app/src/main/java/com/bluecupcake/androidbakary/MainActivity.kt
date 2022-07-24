package com.bluecupcake.androidbakary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bluecupcake.androidbakary.presentation.application.ApplicationViewModel

class MainActivity : AppCompatActivity() {

    private val sharedViewModel: ApplicationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //println(JsonUtils.getVersions(this)[0].codename)
        //Toast.makeText(this, JsonUtils.getVersions(this).toString(), Toast.LENGTH_SHORT).show()

        sharedViewModel.actionBarTitle.observe(this, Observer{ it ->
            when (it) {
                null -> supportActionBar?.hide()
                else -> {
                    supportActionBar?.title = it
                    supportActionBar?.show()
                }
            }
        })
    }
}