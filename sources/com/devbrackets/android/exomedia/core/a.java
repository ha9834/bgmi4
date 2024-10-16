package com.devbrackets.android.exomedia.core;

import android.media.MediaPlayer;
import android.os.Handler;
import com.devbrackets.android.exomedia.a.c;
import com.devbrackets.android.exomedia.a.d;
import com.devbrackets.android.exomedia.a.e;
import com.devbrackets.android.exomedia.core.c.b;
import com.devbrackets.android.exomedia.core.exception.NativeMediaPlaybackException;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, com.devbrackets.android.exomedia.a.a, com.devbrackets.android.exomedia.core.c.a, b, AnalyticsListener {
    private AbstractC0072a b;
    private d c;
    private com.devbrackets.android.exomedia.a.b d;
    private com.devbrackets.android.exomedia.a.a e;
    private e f;
    private c g;
    private b h;
    private AnalyticsListener i;

    /* renamed from: a, reason: collision with root package name */
    private Handler f1007a = new Handler();
    private WeakReference<com.devbrackets.android.exomedia.core.video.a> j = new WeakReference<>(null);
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;

    /* renamed from: com.devbrackets.android.exomedia.core.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0072a {
        public void a() {
        }

        public void a(int i) {
        }

        public void a(boolean z) {
        }

        public void b() {
        }
    }

    public a(AbstractC0072a abstractC0072a) {
        this.b = abstractC0072a;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        a(i);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        com.devbrackets.android.exomedia.a.b bVar = this.d;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return a(new NativeMediaPlaybackException(i, i2));
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        e eVar = this.f;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        c();
    }

    @Override // com.devbrackets.android.exomedia.a.e
    public void a() {
        this.b.a();
        e eVar = this.f;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // com.devbrackets.android.exomedia.a.a
    public void a(int i) {
        this.b.a(i);
        com.devbrackets.android.exomedia.a.a aVar = this.e;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void a(com.devbrackets.android.exomedia.core.video.a aVar) {
        this.m = true;
        this.j = new WeakReference<>(aVar);
    }

    public void a(d dVar) {
        this.c = dVar;
    }

    public void a(com.devbrackets.android.exomedia.a.b bVar) {
        this.d = bVar;
    }

    public void a(com.devbrackets.android.exomedia.a.a aVar) {
        this.e = aVar;
    }

    public void a(e eVar) {
        this.f = eVar;
    }

    public void a(c cVar) {
        this.g = cVar;
    }

    public void a(b bVar) {
        this.h = bVar;
    }

    public void a(AnalyticsListener analyticsListener) {
        this.i = analyticsListener;
    }

    public void a(boolean z) {
        this.k = z;
        this.b.a(true);
    }

    public boolean b() {
        return this.k;
    }

    public void b(boolean z) {
        this.l = z;
    }

    private boolean a(Exception exc) {
        c cVar = this.g;
        return cVar != null && cVar.a(exc);
    }

    private void c() {
        this.k = true;
        this.f1007a.post(new Runnable() { // from class: com.devbrackets.android.exomedia.core.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.b.b();
        d dVar = this.c;
        if (dVar != null) {
            dVar.onPrepared();
        }
    }
}
