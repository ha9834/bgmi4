package com.devbrackets.android.exomedia.core.video.mp;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes.dex */
public class NativeVideoDelegate {

    /* renamed from: a, reason: collision with root package name */
    protected Map<String, String> f1030a;
    protected State b;
    protected Context c;
    protected a d;
    protected com.devbrackets.android.exomedia.core.video.a e;
    protected MediaPlayer f;
    protected long h;
    protected int i;
    protected com.devbrackets.android.exomedia.core.a k;
    protected MediaPlayer.OnCompletionListener m;
    protected MediaPlayer.OnPreparedListener n;
    protected MediaPlayer.OnBufferingUpdateListener o;
    protected MediaPlayer.OnSeekCompleteListener p;
    protected MediaPlayer.OnErrorListener q;
    protected MediaPlayer.OnInfoListener r;
    protected boolean g = false;
    protected float j = 1.0f;
    protected b l = new b();

    /* loaded from: classes.dex */
    public enum State {
        ERROR,
        IDLE,
        PREPARING,
        PREPARED,
        PLAYING,
        PAUSED,
        COMPLETED
    }

    /* loaded from: classes.dex */
    public interface a {
        void d(int i, int i2);
    }

    public com.devbrackets.android.exomedia.core.b.b h() {
        return null;
    }

    public NativeVideoDelegate(Context context, a aVar, com.devbrackets.android.exomedia.core.video.a aVar2) {
        this.b = State.IDLE;
        this.c = context;
        this.d = aVar;
        this.e = aVar2;
        k();
        this.b = State.IDLE;
    }

    public void a() {
        if (l()) {
            this.f.start();
            this.b = State.PLAYING;
        }
        this.g = true;
        this.k.b(false);
    }

    public void b() {
        if (l() && this.f.isPlaying()) {
            this.f.pause();
            this.b = State.PAUSED;
        }
        this.g = false;
    }

    public long c() {
        if (this.k.b() && l()) {
            return this.f.getDuration();
        }
        return 0L;
    }

    public long d() {
        if (this.k.b() && l()) {
            return this.f.getCurrentPosition();
        }
        return 0L;
    }

    public float e() {
        return this.j;
    }

    public void a(long j) {
        if (l()) {
            this.f.seekTo((int) j);
            this.h = 0L;
        } else {
            this.h = j;
        }
    }

    public boolean f() {
        return l() && this.f.isPlaying();
    }

    public int g() {
        if (this.f != null) {
            return this.i;
        }
        return 0;
    }

    public float i() {
        if (Build.VERSION.SDK_INT >= 23) {
            return this.f.getPlaybackParams().getSpeed();
        }
        return 1.0f;
    }

    public void a(boolean z) {
        this.b = State.IDLE;
        if (l()) {
            try {
                this.f.stop();
            } catch (Exception e) {
                Log.d("ContentValues", "stopPlayback: error calling mediaPlayer.stop()", e);
            }
        }
        this.g = false;
        if (z) {
            this.k.a(this.e);
        }
    }

    public void j() {
        this.b = State.IDLE;
        try {
            this.f.reset();
            this.f.release();
        } catch (Exception e) {
            Log.d("ContentValues", "stopPlayback: error calling mediaPlayer.reset() or mediaPlayer.release()", e);
        }
        this.g = false;
    }

    public void a(Uri uri, Map<String, String> map) {
        this.f1030a = map;
        this.h = 0L;
        this.g = false;
        a(uri);
    }

    public void a(com.devbrackets.android.exomedia.core.a aVar) {
        this.k = aVar;
        a((MediaPlayer.OnCompletionListener) aVar);
        a((MediaPlayer.OnPreparedListener) aVar);
        a((MediaPlayer.OnBufferingUpdateListener) aVar);
        a((MediaPlayer.OnSeekCompleteListener) aVar);
        a((MediaPlayer.OnErrorListener) aVar);
    }

    public void a(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.n = onPreparedListener;
    }

    public void a(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.m = onCompletionListener;
    }

    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.o = onBufferingUpdateListener;
    }

    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.p = onSeekCompleteListener;
    }

    public void a(MediaPlayer.OnErrorListener onErrorListener) {
        this.q = onErrorListener;
    }

    public void a(MediaPlayer.OnInfoListener onInfoListener) {
        this.r = onInfoListener;
    }

    public void a(int i, int i2) {
        if (this.f == null || i <= 0 || i2 <= 0) {
            return;
        }
        long j = this.h;
        if (j != 0) {
            a(j);
        }
        if (this.g) {
            a();
        }
    }

    public void a(Surface surface) {
        this.f.setSurface(surface);
        if (this.g) {
            a();
        }
    }

    protected void k() {
        this.f = new MediaPlayer();
        this.f.setOnInfoListener(this.l);
        this.f.setOnErrorListener(this.l);
        this.f.setOnPreparedListener(this.l);
        this.f.setOnCompletionListener(this.l);
        this.f.setOnSeekCompleteListener(this.l);
        this.f.setOnBufferingUpdateListener(this.l);
        this.f.setOnVideoSizeChangedListener(this.l);
        this.f.setAudioStreamType(3);
        this.f.setScreenOnWhilePlaying(true);
    }

    protected boolean l() {
        return (this.b == State.ERROR || this.b == State.IDLE || this.b == State.PREPARING) ? false : true;
    }

    protected void a(Uri uri) {
        if (uri == null) {
            return;
        }
        this.i = 0;
        try {
            this.f.reset();
            this.f.setDataSource(this.c.getApplicationContext(), uri, this.f1030a);
            this.f.prepareAsync();
            this.b = State.PREPARING;
        } catch (IOException | IllegalArgumentException e) {
            Log.w("ContentValues", "Unable to open content: " + uri, e);
            this.b = State.ERROR;
            this.l.onError(this.f, 1, 0);
        }
    }

    /* loaded from: classes.dex */
    public class b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            NativeVideoDelegate nativeVideoDelegate = NativeVideoDelegate.this;
            nativeVideoDelegate.i = i;
            if (nativeVideoDelegate.o != null) {
                NativeVideoDelegate.this.o.onBufferingUpdate(mediaPlayer, i);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            NativeVideoDelegate.this.b = State.COMPLETED;
            if (NativeVideoDelegate.this.m != null) {
                NativeVideoDelegate.this.m.onCompletion(NativeVideoDelegate.this.f);
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (NativeVideoDelegate.this.p != null) {
                NativeVideoDelegate.this.p.onSeekComplete(mediaPlayer);
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            Log.d("ContentValues", "Error: " + i + "," + i2);
            NativeVideoDelegate.this.b = State.ERROR;
            return NativeVideoDelegate.this.q == null || NativeVideoDelegate.this.q.onError(NativeVideoDelegate.this.f, i, i2);
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            NativeVideoDelegate.this.b = State.PREPARED;
            if (NativeVideoDelegate.this.n != null) {
                NativeVideoDelegate.this.n.onPrepared(NativeVideoDelegate.this.f);
            }
            NativeVideoDelegate.this.d.d(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            if (NativeVideoDelegate.this.h != 0) {
                NativeVideoDelegate nativeVideoDelegate = NativeVideoDelegate.this;
                nativeVideoDelegate.a(nativeVideoDelegate.h);
            }
            if (NativeVideoDelegate.this.g) {
                NativeVideoDelegate.this.a();
            }
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            return NativeVideoDelegate.this.r == null || NativeVideoDelegate.this.r.onInfo(mediaPlayer, i, i2);
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            NativeVideoDelegate.this.d.d(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
        }
    }
}
