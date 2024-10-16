package com.devbrackets.android.exomedia.core.video.mp;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.devbrackets.android.exomedia.ExoMedia;
import com.devbrackets.android.exomedia.core.b.b;
import com.devbrackets.android.exomedia.core.video.c;
import com.devbrackets.android.exomedia.core.video.mp.NativeVideoDelegate;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.util.Map;

/* loaded from: classes.dex */
public class NativeTextureVideoView extends c implements com.devbrackets.android.exomedia.core.a.a, NativeVideoDelegate.a {
    protected View.OnTouchListener k;
    protected NativeVideoDelegate l;

    @Override // com.devbrackets.android.exomedia.core.a.a
    public void d() {
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public Map<ExoMedia.RendererType, TrackGroupArray> getAvailableTracks() {
        return null;
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public void setDrmCallback(MediaDrmCallback mediaDrmCallback) {
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public void setRepeatMode(int i) {
    }

    public NativeTextureVideoView(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public NativeTextureVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public NativeTextureVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    @TargetApi(21)
    public NativeTextureVideoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet);
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public void b() {
        this.l.a();
        requestFocus();
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public void c() {
        this.l.b();
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public long getDuration() {
        return this.l.c();
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public long getCurrentPosition() {
        return this.l.d();
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public void a(long j) {
        this.l.a(j);
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public boolean a() {
        return this.l.f();
    }

    @Override // com.devbrackets.android.exomedia.core.video.mp.NativeVideoDelegate.a
    public void d(int i, int i2) {
        if (a(i, i2)) {
            requestLayout();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener = this.k;
        return (onTouchListener != null ? onTouchListener.onTouch(this, motionEvent) : false) || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View, com.devbrackets.android.exomedia.core.a.a
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.k = onTouchListener;
        super.setOnTouchListener(onTouchListener);
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public void setVideoUri(Uri uri) {
        a(uri, (MediaSource) null);
    }

    public void a(Uri uri, MediaSource mediaSource) {
        setVideoURI(uri);
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public float getVolume() {
        return this.l.e();
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public int getBufferedPercent() {
        return this.l.g();
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public b getWindowInfo() {
        return this.l.h();
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public void a(boolean z) {
        this.l.a(z);
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public float getPlaybackSpeed() {
        return this.l.i();
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public void setListenerMux(com.devbrackets.android.exomedia.core.a aVar) {
        this.l.a(aVar);
    }

    public void f() {
        this.l.j();
    }

    public void setVideoURI(Uri uri) {
        a(uri, (Map<String, String>) null);
    }

    public void a(Uri uri, Map<String, String> map) {
        this.l.a(uri, map);
        requestLayout();
        invalidate();
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.l.a(onPreparedListener);
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.l.a(onCompletionListener);
    }

    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.l.a(onBufferingUpdateListener);
    }

    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.l.a(onSeekCompleteListener);
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.l.a(onErrorListener);
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.l.a(onInfoListener);
    }

    protected void a(Context context, AttributeSet attributeSet) {
        this.l = new NativeVideoDelegate(context, this, this);
        setSurfaceTextureListener(new a());
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        a(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a implements TextureView.SurfaceTextureListener {
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        protected a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            NativeTextureVideoView.this.l.a(new Surface(surfaceTexture));
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            NativeTextureVideoView.this.l.a(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            surfaceTexture.release();
            NativeTextureVideoView.this.f();
            return true;
        }
    }
}
