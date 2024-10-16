package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String f5744a = "d";
    private static volatile d e;
    private e b;
    private f c;
    private com.nostra13.universalimageloader.core.d.a d = new com.nostra13.universalimageloader.core.d.c();

    public static d a() {
        if (e == null) {
            synchronized (d.class) {
                if (e == null) {
                    e = new d();
                }
            }
        }
        return e;
    }

    protected d() {
    }

    public synchronized void a(e eVar) {
        if (eVar == null) {
            throw new IllegalArgumentException("ImageLoader configuration can not be initialized with null");
        }
        if (this.b == null) {
            com.nostra13.universalimageloader.b.c.a("Initialize ImageLoader with configuration", new Object[0]);
            this.c = new f(eVar);
            this.b = eVar;
        } else {
            com.nostra13.universalimageloader.b.c.c("Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.", new Object[0]);
        }
    }

    public boolean b() {
        return this.b != null;
    }

    public void a(String str, com.nostra13.universalimageloader.core.c.a aVar, c cVar, com.nostra13.universalimageloader.core.d.a aVar2, com.nostra13.universalimageloader.core.d.b bVar) {
        a(str, aVar, cVar, null, aVar2, bVar);
    }

    public void a(String str, com.nostra13.universalimageloader.core.c.a aVar, c cVar, com.nostra13.universalimageloader.core.assist.c cVar2, com.nostra13.universalimageloader.core.d.a aVar2, com.nostra13.universalimageloader.core.d.b bVar) {
        e();
        if (aVar == null) {
            throw new IllegalArgumentException("Wrong arguments were passed to displayImage() method (ImageView reference must not be null)");
        }
        com.nostra13.universalimageloader.core.d.a aVar3 = aVar2 == null ? this.d : aVar2;
        if (cVar == null) {
            cVar = this.b.r;
        }
        if (TextUtils.isEmpty(str)) {
            this.c.b(aVar);
            aVar3.onLoadingStarted(str, aVar.d());
            if (cVar.b()) {
                aVar.a(cVar.b(this.b.f5748a));
            } else {
                aVar.a((Drawable) null);
            }
            aVar3.onLoadingComplete(str, aVar.d(), null);
            return;
        }
        com.nostra13.universalimageloader.core.assist.c a2 = cVar2 == null ? com.nostra13.universalimageloader.b.a.a(aVar, this.b.a()) : cVar2;
        String a3 = com.nostra13.universalimageloader.b.d.a(str, a2);
        this.c.a(aVar, a3);
        aVar3.onLoadingStarted(str, aVar.d());
        Bitmap a4 = this.b.n.a(a3);
        if (a4 != null && !a4.isRecycled()) {
            com.nostra13.universalimageloader.b.c.a("Load image from memory cache [%s]", a3);
            if (cVar.e()) {
                h hVar = new h(this.c, a4, new g(str, aVar, a2, a3, cVar, aVar3, bVar, this.c.a(str)), a(cVar));
                if (cVar.s()) {
                    hVar.run();
                    return;
                } else {
                    this.c.a(hVar);
                    return;
                }
            }
            cVar.q().a(a4, aVar, LoadedFrom.MEMORY_CACHE);
            aVar3.onLoadingComplete(str, aVar.d(), a4);
            return;
        }
        if (cVar.a()) {
            aVar.a(cVar.a(this.b.f5748a));
        } else if (cVar.g()) {
            aVar.a((Drawable) null);
        }
        LoadAndDisplayImageTask loadAndDisplayImageTask = new LoadAndDisplayImageTask(this.c, new g(str, aVar, a2, a3, cVar, aVar3, bVar, this.c.a(str)), a(cVar));
        if (cVar.s()) {
            loadAndDisplayImageTask.run();
        } else {
            this.c.a(loadAndDisplayImageTask);
        }
    }

    public void a(String str, ImageView imageView, com.nostra13.universalimageloader.core.d.a aVar) {
        a(str, new com.nostra13.universalimageloader.core.c.b(imageView), null, aVar, null);
    }

    private void e() {
        if (this.b == null) {
            throw new IllegalStateException("ImageLoader must be init with configuration before using");
        }
    }

    public void c() {
        e();
        this.b.n.b();
    }

    public void d() {
        e();
        this.b.o.a();
    }

    private static Handler a(c cVar) {
        Handler r = cVar.r();
        if (cVar.s()) {
            return null;
        }
        return (r == null && Looper.myLooper() == Looper.getMainLooper()) ? new Handler() : r;
    }
}
