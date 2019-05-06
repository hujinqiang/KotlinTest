package com.tocel.kotlintest;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import okio.Buffer;
import okio.Okio;
import okio.Source;

import java.io.IOException;
import java.io.InputStream;

public class AudioStreamTest {

    private static AudioTrack audioTrack;
    private static int bufferSize;

    Handler handler = null;

    static {

        bufferSize = AudioTrack.getMinBufferSize(44100,AudioFormat.CHANNEL_OUT_MONO,AudioFormat.ENCODING_PCM_16BIT) * 2;

        log("min buffer size:" + bufferSize);

        audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, 44100,
                AudioFormat.CHANNEL_OUT_STEREO, AudioFormat.ENCODING_PCM_16BIT,
                bufferSize,
                AudioTrack.MODE_STREAM);

    }

    public void start(Handler.Callback callback, InputStream in)  {

        if (handler == null) {
            handler = new Handler(Looper.getMainLooper(),callback);
        }
        Source source = null;
        try {
            source = Okio.source(in);
            Buffer buffer = new Buffer();

            audioTrack.play();
            while (source.read(buffer,bufferSize) != -1){
                byte[] data = buffer.readByteArray();
                long start = System.currentTimeMillis();
                audioTrack.write(data,0,bufferSize);
                String costTime = "write data cost:" +(System.currentTimeMillis() - start) + " ms \n";
                Message msg = Message.obtain(handler);
                msg.obj = costTime;
                msg.sendToTarget();
                log(costTime);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                source.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(onPlayFinishListener != null){
                onPlayFinishListener.onPlayFinished();
            }
        }
    }

    private static void log(String costTime) {
        Log.e("Play", costTime);
    }

    public void setOnPlayFinishListener(OnPlayFinishListener onPlayFinishListener) {
        this.onPlayFinishListener = onPlayFinishListener;
    }

    OnPlayFinishListener onPlayFinishListener;

    public void destroy() {
        if (audioTrack.getState() == AudioTrack.STATE_INITIALIZED) {
            audioTrack.stop();
            audioTrack.release();
        }

    }

    public interface OnPlayFinishListener{
        void onPlayFinished();
    }

}
