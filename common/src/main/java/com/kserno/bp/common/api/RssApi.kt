package com.kserno.bp.common.api

import com.kserno.bp.common.Constants
import com.voicerss.tts.AudioCodec
import com.voicerss.tts.AudioFormat
import com.voicerss.tts.Languages
import com.voicerss.tts.SpeechDataEvent
import com.voicerss.tts.SpeechDataEventListener
import com.voicerss.tts.VoiceParameters
import com.voicerss.tts.VoiceProvider

/**
 *  Created by filipsollar on 2019-04-25
 */
class RssApi {

    fun getTextToSpeech() {
        val voiceProvider = VoiceProvider(Constants.Rss.API_KEY)
        voiceProvider.addSpeechDataEventListener(object: SpeechDataEventListener() {
            override fun handleSpeechDataEvent(e: SpeechDataEvent<*>?) {
                val data = e?.data as ByteArray
            }
        })
        val params = VoiceParameters("Hello World", Languages.English_UnitedStates)
        params.base64 = false
        params.format = AudioFormat.Format_44KHZ.AF_44khz_16bit_stereo
        params.codec = AudioCodec.MP3
        params.ssml = false
        params.rate = 0

        voiceProvider.speechAsync(params)
    }

}