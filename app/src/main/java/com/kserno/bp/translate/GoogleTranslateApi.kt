package com.kserno.bp.translate

import com.serjltt.moshi.adapters.Wrapped
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 *  Created by filipsollar on 2019-03-13
 */
interface GoogleTranslateApi {

    @POST("/language/translate/v2/detect")
    @Wrapped(path = ["data", "detections"])
    fun detectLanguage(
        @Query("q") q: String,
        @Query("key") key: String
    ): Single<Array<LanguageDetectionModel>>



}