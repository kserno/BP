package com.kserno.bp.translate

/**
 *  Created by filipsollar on 2019-03-12
 */
data class LanguageDetectionModel(
    val language: String,
    val isReliable: Boolean?,
    val confidence: Float?
)