package com.devbrackets.android.exomedia.core.a;

import android.net.Uri;
import android.view.View;
import com.devbrackets.android.exomedia.ExoMedia;
import com.devbrackets.android.exomedia.core.b.b;
import com.devbrackets.android.exomedia.core.video.scale.ScaleType;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.util.Map;

/* loaded from: classes.dex */
public interface a {
    void a(int i, boolean z);

    void a(long j);

    void a(boolean z);

    boolean a();

    void b();

    void c();

    void d();

    Map<ExoMedia.RendererType, TrackGroupArray> getAvailableTracks();

    int getBufferedPercent();

    long getCurrentPosition();

    long getDuration();

    float getPlaybackSpeed();

    float getVolume();

    b getWindowInfo();

    void setDrmCallback(MediaDrmCallback mediaDrmCallback);

    void setListenerMux(com.devbrackets.android.exomedia.core.a aVar);

    void setMeasureBasedOnAspectRatioEnabled(boolean z);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setRepeatMode(int i);

    void setScaleType(ScaleType scaleType);

    void setVideoUri(Uri uri);
}
