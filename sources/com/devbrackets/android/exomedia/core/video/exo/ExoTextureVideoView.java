package com.devbrackets.android.exomedia.core.video.exo;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import com.devbrackets.android.exomedia.ExoMedia;
import com.devbrackets.android.exomedia.core.b.b;
import com.devbrackets.android.exomedia.core.video.c;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.util.Map;

@TargetApi(16)
/* loaded from: classes.dex */
public class ExoTextureVideoView extends c implements com.devbrackets.android.exomedia.core.a.a {
    protected com.devbrackets.android.exomedia.core.video.exo.a k;

    public ExoTextureVideoView(Context context) {
        super(context);
        f();
    }

    public ExoTextureVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f();
    }

    public ExoTextureVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        f();
    }

    public ExoTextureVideoView(Context context, AttributeSet attributeSet, int i, int i2) {
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
    public b getWindowInfo() {
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
        setSurfaceTextureListener(new a());
        a(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a implements TextureView.SurfaceTextureListener {
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        protected a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            ExoTextureVideoView.this.k.a(new Surface(surfaceTexture));
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            ExoTextureVideoView.this.k.l();
            surfaceTexture.release();
            return true;
        }
    }
}
