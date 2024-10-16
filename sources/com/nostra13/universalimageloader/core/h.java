package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final f f5756a;
    private final Bitmap b;
    private final g c;
    private final Handler d;

    public h(f fVar, Bitmap bitmap, g gVar, Handler handler) {
        this.f5756a = fVar;
        this.b = bitmap;
        this.c = gVar;
        this.d = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.nostra13.universalimageloader.b.c.a("PostProcess image before displaying [%s]", this.c.b);
        LoadAndDisplayImageTask.a(new b(this.c.e.p().a(this.b), this.c, this.f5756a, LoadedFrom.MEMORY_CACHE), this.c.e.s(), this.d, this.f5756a);
    }
}
