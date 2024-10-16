package com.devbrackets.android.exomedia.core.video.exo;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.devbrackets.android.exomedia.ExoMedia;
import com.devbrackets.android.exomedia.core.b.b;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.util.Map;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected com.devbrackets.android.exomedia.core.b.a f1026a;
    protected com.devbrackets.android.exomedia.core.a b;
    protected Context d;
    protected com.devbrackets.android.exomedia.core.video.a e;
    protected boolean c = false;
    protected C0077a f = new C0077a();

    public a(Context context, com.devbrackets.android.exomedia.core.video.a aVar) {
        this.d = context.getApplicationContext();
        this.e = aVar;
        m();
    }

    public void a(Uri uri) {
        a(uri, null);
    }

    public void a(Uri uri, MediaSource mediaSource) {
        this.b.a(false);
        this.f1026a.a(0L);
        if (mediaSource != null) {
            this.f1026a.a(mediaSource);
            this.b.b(false);
        } else if (uri != null) {
            this.f1026a.a(uri);
            this.b.b(false);
        } else {
            this.f1026a.a((MediaSource) null);
        }
    }

    public void a(MediaDrmCallback mediaDrmCallback) {
        this.f1026a.a(mediaDrmCallback);
    }

    public float a() {
        return this.f1026a.c();
    }

    public void a(long j) {
        this.f1026a.a(j);
    }

    public boolean b() {
        return this.f1026a.m();
    }

    public void c() {
        this.f1026a.a(true);
        this.b.b(false);
        this.c = true;
    }

    public void d() {
        this.f1026a.a(false);
        this.c = false;
    }

    public void a(boolean z) {
        this.f1026a.e();
        this.c = false;
        if (z) {
            this.b.a(this.e);
        }
    }

    public long e() {
        if (this.b.b()) {
            return this.f1026a.j();
        }
        return 0L;
    }

    public long f() {
        if (this.b.b()) {
            return this.f1026a.i();
        }
        return 0L;
    }

    public int g() {
        return this.f1026a.k();
    }

    public b h() {
        return this.f1026a.l();
    }

    public Map<ExoMedia.RendererType, TrackGroupArray> i() {
        return this.f1026a.b();
    }

    public float j() {
        return this.f1026a.h();
    }

    public void k() {
        this.f1026a.f();
    }

    public void a(com.devbrackets.android.exomedia.core.a aVar) {
        com.devbrackets.android.exomedia.core.a aVar2 = this.b;
        if (aVar2 != null) {
            this.f1026a.b((com.devbrackets.android.exomedia.core.c.a) aVar2);
            this.f1026a.b((AnalyticsListener) this.b);
        }
        this.b = aVar;
        this.f1026a.a((com.devbrackets.android.exomedia.core.c.a) aVar);
        this.f1026a.a((AnalyticsListener) aVar);
    }

    public void a(int i) {
        this.f1026a.a(i);
    }

    public void a(Surface surface) {
        this.f1026a.a(surface);
        if (this.c) {
            this.f1026a.a(true);
        }
    }

    public void l() {
        this.f1026a.a();
    }

    protected void m() {
        n();
    }

    protected void n() {
        this.f1026a = new com.devbrackets.android.exomedia.core.b.a(this.d);
        this.f1026a.a((com.devbrackets.android.exomedia.core.c.b) this.f);
        this.f1026a.a((com.devbrackets.android.exomedia.a.a) this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.devbrackets.android.exomedia.core.video.exo.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0077a implements com.devbrackets.android.exomedia.a.a, com.devbrackets.android.exomedia.core.c.b {
        protected C0077a() {
        }

        @Override // com.devbrackets.android.exomedia.a.a
        public void a(int i) {
            a.this.b.a(i);
        }
    }
}
