package com.kserno.bp.common.api

import com.google.cloud.texttospeech.v1.AudioConfig
import com.google.cloud.texttospeech.v1.AudioEncoding
import com.google.cloud.texttospeech.v1.SsmlVoiceGender
import com.google.cloud.texttospeech.v1.SynthesisInput
import com.google.cloud.texttospeech.v1.TextToSpeechClient
import com.google.cloud.texttospeech.v1.VoiceSelectionParams
import java.io.File

/**
 *  Created by filipsollar on 2019-04-26
 */
class GoogleApi: Api {
    private val textToSpeechClient = TextToSpeechClient.create()

    private val voice = VoiceSelectionParams.newBuilder()
            .setLanguageCode("en-US")
            .setSsmlGender(SsmlVoiceGender.NEUTRAL)
            .build()

    private val audioConfig = AudioConfig.newBuilder()
            .setAudioEncoding(AudioEncoding.MP3)
            .build()

    override fun synthesize(text: String): File {



        // Set the text input to be synthesized
        val input = SynthesisInput.newBuilder()
                .setText(text)
                .build()

        // Perform the text-to-speech request on the text input with the selected voice parameters and
        // audio file type
        val response = textToSpeechClient.synthesizeSpeech(input, voice, audioConfig)

        return File(text)
    }
}