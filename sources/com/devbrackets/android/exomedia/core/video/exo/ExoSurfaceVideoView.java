package com.devbrackets.android.exomedia.core.video.exo;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.devbrackets.android.exomedia.ExoMedia;
import com.devbrackets.android.exomedia.core.video.b;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.util.Map;

@TargetApi(16)
/* loaded from: classes.dex */
public class ExoSurfaceVideoView extends b implements com.devbrackets.android.exomedia.core.a.a {
    protected com.devbrackets.android.exomedia.core.video.exo.a k;

    public ExoSurfaceVideoView(Context context) {
        super(context);
        f();
    }

    public ExoSurfaceVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f();
    }

    public ExoSurfaceVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        f();
    }

    public ExoSurfaceVideoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        f();
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public void setVideoUri(Uri uri) {
        this.k.a(uri);
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public void setDrmCallback(MediaDrmCallback mediaDrmCallback) {
        this.k.a(mediaDrmCallback);
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public float getVolume() {
        return this.k.a();
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public void a(long j) {
        this.k.a(j);
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public boolean a() {
        return this.k.b();
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public void b() {
        this.k.c();
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public void c() {
        this.k.d();
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public void a(boolean z) {
        this.k.a(z);
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public long getDuration() {
        return this.k.e();
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public long getCurrentPosition() {
        return this.k.f();
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public int getBufferedPercent() {
        return this.k.g();
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public com.devbrackets.android.exomedia.core.b.b getWindowInfo() {
        return this.k.h();
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public float getPlaybackSpeed() {
        return this.k.j();
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public Map<ExoMedia.RendererType, TrackGroupArray> getAvailableTracks() {
        return this.k.i();
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public void d() {
        this.k.k();
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public void setListenerMux(com.devbrackets.android.exomedia.core.a aVar) {
        this.k.a(aVar);
    }

    @Override // com.devbrackets.android.exomedia.core.a.a
    public void setRepeatMode(int i) {
        this.k.a(i);
    }

    protected void f() {
        this.k = new com.devbrackets.android.exomedia.core.video.exo.a(getContext(), this);
        getHolder().addCallback(new a());
        a(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a implements SurfaceHolder.Callback {
        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        protected a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            ExoSurfaceVideoView.this.k.a(surfaceHolder.getSurface());
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            ExoSurfaceVideoView.this.k.l();
            surfaceHolder.getSurface().release();
        }
    }
}
