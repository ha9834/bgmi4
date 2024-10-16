package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    final Resources f5748a;
    final int b;
    final int c;
    final int d;
    final int e;
    final com.nostra13.universalimageloader.core.e.a f;
    final Executor g;
    final Executor h;
    final boolean i;
    final boolean j;
    final int k;
    final int l;
    final QueueProcessingType m;
    final com.nostra13.universalimageloader.a.b.a n;
    final com.nostra13.universalimageloader.a.a.a o;
    final ImageDownloader p;
    final com.nostra13.universalimageloader.core.a.b q;
    final com.nostra13.universalimageloader.core.c r;
    final ImageDownloader s;
    final ImageDownloader t;

    private e(a aVar) {
        this.f5748a = aVar.b.getResources();
        this.b = aVar.c;
        this.c = aVar.d;
        this.d = aVar.e;
        this.e = aVar.f;
        this.f = aVar.g;
        this.g = aVar.h;
        this.h = aVar.i;
        this.k = aVar.l;
        this.l = aVar.m;
        this.m = aVar.o;
        this.o = aVar.t;
        this.n = aVar.s;
        this.r = aVar.x;
        this.p = aVar.v;
        this.q = aVar.w;
        this.i = aVar.j;
        this.j = aVar.k;
        this.s = new b(this.p);
        this.t = new c(this.p);
        com.nostra13.universalimageloader.b.c.a(aVar.y);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.nostra13.universalimageloader.core.assist.c a() {
        DisplayMetrics displayMetrics = this.f5748a.getDisplayMetrics();
        int i = this.b;
        if (i <= 0) {
            i = displayMetrics.widthPixels;
        }
        int i2 = this.c;
        if (i2 <= 0) {
            i2 = displayMetrics.heightPixels;
        }
        return new com.nostra13.universalimageloader.core.assist.c(i, i2);
    }

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final QueueProcessingType f5750a = QueueProcessingType.FIFO;
        private Context b;
        private com.nostra13.universalimageloader.core.a.b w;
        private int c = 0;
        private int d = 0;
        private int e = 0;
        private int f = 0;
        private com.nostra13.universalimageloader.core.e.a g = null;
        private Executor h = null;
        private Executor i = null;
        private boolean j = false;
        private boolean k = false;
        private int l = 3;
        private int m = 3;
        private boolean n = false;
        private QueueProcessingType o = f5750a;
        private int p = 0;
        private long q = 0;
        private int r = 0;
        private com.nostra13.universalimageloader.a.b.a s = null;
        private com.nostra13.universalimageloader.a.a.a t = null;
        private com.nostra13.universalimageloader.a.a.b.a u = null;
        private ImageDownloader v = null;
        private com.nostra13.universalimageloader.core.c x = null;
        private boolean y = false;

        public a(Context context) {
            this.b = context.getApplicationContext();
        }

        public a a(int i, int i2, com.nostra13.universalimageloader.core.e.a aVar) {
            this.e = i;
            this.f = i2;
            this.g = aVar;
            return this;
        }

        public a a(int i) {
            if (this.h != null || this.i != null) {
                com.nostra13.universalimageloader.b.c.c("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
            }
            this.l = i;
            return this;
        }

        public a b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("memoryCacheSize must be a positive number");
            }
            if (this.s != null) {
                com.nostra13.universalimageloader.b.c.c("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
            }
            this.p = i;
            return this;
        }

        public a a(com.nostra13.universalimageloader.a.b.a aVar) {
            if (this.p != 0) {
                com.nostra13.universalimageloader.b.c.c("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
            }
            this.s = aVar;
            return this;
        }

        public a c(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("maxCacheSize must be a positive number");
            }
            if (this.t != null) {
                com.nostra13.universalimageloader.b.c.c("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
            }
            this.q = i;
            return this;
        }

        public a d(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("maxFileCount must be a positive number");
            }
            if (this.t != null) {
                com.nostra13.universalimageloader.b.c.c("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
            }
            this.r = i;
            return this;
        }

        public a a(com.nostra13.universalimageloader.a.a.a aVar) {
            if (this.q > 0 || this.r > 0) {
                com.nostra13.universalimageloader.b.c.c("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
            }
            if (this.u != null) {
                com.nostra13.universalimageloader.b.c.c("diskCache() and diskCacheFileNameGenerator() calls overlap each other", new Object[0]);
            }
            this.t = aVar;
            return this;
        }

        public a a(com.nostra13.universalimageloader.core.c cVar) {
            this.x = cVar;
            return this;
        }

        public e a() {
            b();
            return new e(this);
        }

        private void b() {
            if (this.h == null) {
                this.h = com.nostra13.universalimageloader.core.a.a(this.l, this.m, this.o);
            } else {
                this.j = true;
            }
            if (this.i == null) {
                this.i = com.nostra13.universalimageloader.core.a.a(this.l, this.m, this.o);
            } else {
                this.k = true;
            }
            if (this.t == null) {
                if (this.u == null) {
                    this.u = com.nostra13.universalimageloader.core.a.b();
                }
                this.t = com.nostra13.universalimageloader.core.a.a(this.b, this.u, this.q, this.r);
            }
            if (this.s == null) {
                this.s = com.nostra13.universalimageloader.core.a.a(this.b, this.p);
            }
            if (this.n) {
                this.s = new com.nostra13.universalimageloader.a.b.a.a(this.s, com.nostra13.universalimageloader.b.d.a());
            }
            if (this.v == null) {
                this.v = com.nostra13.universalimageloader.core.a.a(this.b);
            }
            if (this.w == null) {
                this.w = com.nostra13.universalimageloader.core.a.a(this.y);
            }
            if (this.x == null) {
                this.x = com.nostra13.universalimageloader.core.c.t();
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class b implements ImageDownloader {

        /* renamed from: a, reason: collision with root package name */
        private final ImageDownloader f5751a;

        public b(ImageDownloader imageDownloader) {
            this.f5751a = imageDownloader;
        }

        @Override // com.nostra13.universalimageloader.core.download.ImageDownloader
        public InputStream a(String str, Object obj) throws IOException {
            switch (ImageDownloader.Scheme.a(str)) {
                case HTTP:
                case HTTPS:
                    throw new IllegalStateException();
                default:
                    return this.f5751a.a(str, obj);
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class c implements ImageDownloader {

        /* renamed from: a, reason: collision with root package name */
        private final ImageDownloader f5752a;

        public c(ImageDownloader imageDownloader) {
            this.f5752a = imageDownloader;
        }

        @Override // com.nostra13.universalimageloader.core.download.ImageDownloader
        public InputStream a(String str, Object obj) throws IOException {
            InputStream a2 = this.f5752a.a(str, obj);
            switch (ImageDownloader.Scheme.a(str)) {
                case HTTP:
                case HTTPS:
                    return new com.nostra13.universalimageloader.core.assist.b(a2);
                default:
                    return a2;
            }
        }
    }
}
