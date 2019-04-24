package com.kserno.bp.translate

import io.reactivex.Single
import retrofit2.Retrofit

/**
 *  Created by filipsollar on 2019-03-13
 */
class GoogleTranslateService(
        retrofit: Retrofit
): TranslateService {

    private val api = retrofit.create(GoogleTranslateApi::class.java)

    private val key = ""

    override fun detectLanguage(q: String): Single<LanguageDetectionModel> {
        return api.detectLanguage(q, key)
                .map { it.elementAtOrNull(0) }
    }

}