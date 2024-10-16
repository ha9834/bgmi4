package com.devbrackets.android.exomedia.core.exception;

import android.media.MediaPlayer;

/* loaded from: classes.dex */
public class NativeMediaPlaybackException extends Exception {
    public final int extra;
    public final int what;

    public NativeMediaPlaybackException(int i, int i2) {
        super(MediaPlayer.class.getName() + " has had the error " + i + " with extras " + i2);
        this.what = i;
        this.extra = i2;
    }
}
