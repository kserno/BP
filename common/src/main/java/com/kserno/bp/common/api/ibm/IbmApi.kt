package com.kserno.bp.common.api.ibm

import com.ibm.cloud.sdk.core.service.security.IamOptions
import com.ibm.watson.text_to_speech.v1.TextToSpeech
import com.ibm.watson.text_to_speech.v1.model.SynthesizeOptions
import com.kserno.bp.common.Constants
import com.kserno.bp.common.api.Api
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.io.IOException

/**
 *  Created by filipsollar on 2019-04-25
 */
class IbmApi: Api {



    override fun synthesize(text: String): File {
        val iamOptions = IamOptions.Builder()
                .apiKey(Constants.Ibm.API_KEY)
                .url(Constants.Ibm.URL)
                .build()
        val tts = TextToSpeech(iamOptions)
        val synthesizeOptions = SynthesizeOptions.Builder()
                .accept("audio/mp3")
                .text(text)
                .build()
        val result = tts.synthesize(synthesizeOptions)
                .execute()
                .result



        return File("")
    }


}