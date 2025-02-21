package com.full.recorder.encrypted.recorder

import android.annotation.SuppressLint
import android.content.Context
import android.media.MediaRecorder
import com.full.recorder.encrypted.extensions.config
import com.full.recorder.encrypted.helpers.SAMPLE_RATE
import java.io.FileDescriptor

class MediaRecorderWrapper(val context: Context) : Recorder {

    private var recorder = MediaRecorder().apply {
        setAudioSource(MediaRecorder.AudioSource.CAMCORDER)
        setOutputFormat(context.config.getOutputFormat())
        setAudioEncoder(context.config.getAudioEncoder())
        setAudioEncodingBitRate(context.config.bitrate)
        setAudioSamplingRate(SAMPLE_RATE)
    }

    override fun setOutputFile(path: String) {
        recorder.setOutputFile(path)
    }

    override fun setOutputFile(fileDescriptor: FileDescriptor) {
        recorder.setOutputFile(fileDescriptor)
    }

    override fun prepare() {
        recorder.prepare()
    }

    override fun start() {
        recorder.start()
    }

    override fun stop() {
        recorder.stop()
    }

    @SuppressLint("NewApi")
    override fun pause() {
        recorder.pause()
    }

    @SuppressLint("NewApi")
    override fun resume() {
        recorder.resume()
    }

    override fun release() {
        recorder.release()
    }

    override fun getMaxAmplitude(): Int {
        return recorder.maxAmplitude
    }
}
