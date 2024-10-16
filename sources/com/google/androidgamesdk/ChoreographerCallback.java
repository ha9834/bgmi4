package com.google.androidgamesdk;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Choreographer;

/* loaded from: classes2.dex */
public class ChoreographerCallback implements Choreographer.FrameCallback {
    private static final String LOG_TAG = "ChoreographerCallback";
    private long mCookie;
    private LooperThread mLooper = new LooperThread();

    public native void nOnChoreographer(long j, long j2);

    /* loaded from: classes2.dex */
    private class LooperThread extends Thread {
        public Handler mHandler;

        private LooperThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Log.i(ChoreographerCallback.LOG_TAG, "Starting looper thread");
            Looper.prepare();
            this.mHandler = new Handler();
            Looper.loop();
            Log.i(ChoreographerCallback.LOG_TAG, "Terminating looper thread");
        }
    }

    public ChoreographerCallback(long j) {
        this.mCookie = j;
        this.mLooper.start();
    }

    public void postFrameCallback() {
        this.mLooper.mHandler.post(new Runnable() { // from class: com.google.androidgamesdk.ChoreographerCallback.1
            @Override // java.lang.Runnable
            public void run() {
                Choreographer.getInstance().postFrameCallback(ChoreographerCallback.this);
            }
        });
    }

    public void postFrameCallbackDelayed(long j) {
        Choreographer.getInstance().postFrameCallbackDelayed(this, j);
    }

    public void terminate() {
        this.mLooper.mHandler.getLooper().quit();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        nOnChoreographer(this.mCookie, j);
    }
}
