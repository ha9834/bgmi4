package com.devbrackets.android.exomedia.ui.widget;

/* loaded from: classes.dex */
public interface b {
    void finishLoading();

    void hide(boolean z);

    boolean isVisible();

    void onAttachedToView(VideoView videoView);

    void onDetachedFromView(VideoView videoView);

    void setDuration(long j);

    void show();

    void showLoading(boolean z);

    void updatePlaybackState(boolean z);
}
