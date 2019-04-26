package com.kserno.bp.tsstest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kserno.bp.common.api.RssApi
import com.kserno.bp.common.api.ibm.IbmApi

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RssApi().getTextToSpeech()
        IbmApi().synthesize("Hello world")
    }
}
