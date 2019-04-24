package com.kserno.bp.translate

import io.reactivex.Single

/**
 *  Created by filipsollar on 2019-03-12
 */
interface TranslateService {

    fun detectLanguage(q: String): Single<LanguageDetectionModel>

}