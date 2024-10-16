package com.nostra13.universalimageloader.core;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final int f5741a;
    private final int b;
    private final int c;
    private final Drawable d;
    private final Drawable e;
    private final Drawable f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final ImageScaleType j;
    private final BitmapFactory.Options k;
    private final int l;
    private final boolean m;
    private final Object n;
    private final com.nostra13.universalimageloader.core.e.a o;
    private final com.nostra13.universalimageloader.core.e.a p;
    private final com.nostra13.universalimageloader.core.b.a q;
    private final Handler r;
    private final boolean s;

    private c(a aVar) {
        this.f5741a = aVar.f5742a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.n;
        this.o = aVar.o;
        this.p = aVar.p;
        this.q = aVar.q;
        this.r = aVar.r;
        this.s = aVar.s;
    }

    public boolean a() {
        return (this.d == null && this.f5741a == 0) ? false : true;
    }

    public boolean b() {
        return (this.e == null && this.b == 0) ? false : true;
    }

    public boolean c() {
        return (this.f == null && this.c == 0) ? false : true;
    }

    public boolean d() {
        return this.o != null;
    }

    public boolean e() {
        return this.p != null;
    }

    public boolean f() {
        return this.l > 0;
    }

    public Drawable a(Resources resources) {
        int i = this.f5741a;
        return i != 0 ? resources.getDrawable(i) : this.d;
    }

    public Drawable b(Resources resources) {
        int i = this.b;
        return i != 0 ? resources.getDrawable(i) : this.e;
    }

    public Drawable c(Resources resources) {
        int i = this.c;
        return i != 0 ? resources.getDrawable(i) : this.f;
    }

    public boolean g() {
        return this.g;
    }

    public boolean h() {
        return this.h;
    }

    public boolean i() {
        return this.i;
    }

    public ImageScaleType j() {
        return this.j;
    }

    public BitmapFactory.Options k() {
        return this.k;
    }

    public int l() {
        return this.l;
    }

    public boolean m() {
        return this.m;
    }

    public Object n() {
        return this.n;
    }

    public com.nostra13.universalimageloader.core.e.a o() {
        return this.o;
    }

    public com.nostra13.universalimageloader.core.e.a p() {
        return this.p;
    }

    public com.nostra13.universalimageloader.core.b.a q() {
        return this.q;
    }

    public Handler r() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s() {
        return this.s;
    }

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f5742a = 0;
        private int b = 0;
        private int c = 0;
        private Drawable d = null;
        private Drawable e = null;
        private Drawable f = null;
        private boolean g = false;
        private boolean h = false;
        private boolean i = false;
        private ImageScaleType j = ImageScaleType.IN_SAMPLE_POWER_OF_2;
        private BitmapFactory.Options k = new BitmapFactory.Options();
        private int l = 0;
        private boolean m = false;
        private Object n = null;
        private com.nostra13.universalimageloader.core.e.a o = null;
        private com.nostra13.universalimageloader.core.e.a p = null;
        private com.nostra13.universalimageloader.core.b.a q = com.nostra13.universalimageloader.core.a.c();
        private Handler r = null;
        private boolean s = false;

        public a a(boolean z) {
            this.h = z;
            return this;
        }

        public a b(boolean z) {
            this.i = z;
            return this;
        }

        public a a(ImageScaleType imageScaleType) {
            this.j = imageScaleType;
            return this;
        }

        public a a(Bitmap.Config config) {
            if (config == null) {
                throw new IllegalArgumentException("bitmapConfig can't be null");
            }
            this.k.inPreferredConfig = config;
            return this;
        }

        public a a(Handler handler) {
            this.r = handler;
            return this;
        }

        public a a(c cVar) {
            this.f5742a = cVar.f5741a;
            this.b = cVar.b;
            this.c = cVar.c;
            this.d = cVar.d;
            this.e = cVar.e;
            this.f = cVar.f;
            this.g = cVar.g;
            this.h = cVar.h;
            this.i = cVar.i;
            this.j = cVar.j;
            this.k = cVar.k;
            this.l = cVar.l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
            this.q = cVar.q;
            this.r = cVar.r;
            this.s = cVar.s;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }

    public static c t() {
        return new a().a();
    }
}
