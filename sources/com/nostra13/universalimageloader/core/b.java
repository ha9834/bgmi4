package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final Bitmap f5740a;
    private final String b;
    private final com.nostra13.universalimageloader.core.c.a c;
    private final String d;
    private final com.nostra13.universalimageloader.core.b.a e;
    private final com.nostra13.universalimageloader.core.d.a f;
    private final f g;
    private final LoadedFrom h;

    public b(Bitmap bitmap, g gVar, f fVar, LoadedFrom loadedFrom) {
        this.f5740a = bitmap;
        this.b = gVar.f5755a;
        this.c = gVar.c;
        this.d = gVar.b;
        this.e = gVar.e.q();
        this.f = gVar.f;
        this.g = fVar;
        this.h = loadedFrom;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.c.e()) {
            com.nostra13.universalimageloader.b.c.a("ImageAware was collected by GC. Task is cancelled. [%s]", this.d);
            this.f.onLoadingCancelled(this.b, this.c.d());
        } else if (a()) {
            com.nostra13.universalimageloader.b.c.a("ImageAware is reused for another image. Task is cancelled. [%s]", this.d);
            this.f.onLoadingCancelled(this.b, this.c.d());
        } else {
            com.nostra13.universalimageloader.b.c.a("Display image in ImageAware (loaded from %1$s) [%2$s]", this.h, this.d);
            this.e.a(this.f5740a, this.c, this.h);
            this.g.b(this.c);
            this.f.onLoadingComplete(this.b, this.c.d(), this.f5740a);
        }
    }

    private boolean a() {
        return !this.d.equals(this.g.a(this.c));
    }
}
