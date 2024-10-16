package androidx.core.f;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Objects;

/* loaded from: classes.dex */
public class ad {

    /* renamed from: a, reason: collision with root package name */
    public static final ad f530a = new a().a().h().g().f();
    private final e b;

    private ad(WindowInsets windowInsets) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.b = new i(this, windowInsets);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            this.b = new h(this, windowInsets);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.b = new g(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 20) {
            this.b = new f(this, windowInsets);
        } else {
            this.b = new e(this);
        }
    }

    public ad(ad adVar) {
        if (adVar != null) {
            e eVar = adVar.b;
            if (Build.VERSION.SDK_INT >= 29 && (eVar instanceof i)) {
                this.b = new i(this, (i) eVar);
                return;
            }
            if (Build.VERSION.SDK_INT >= 28 && (eVar instanceof h)) {
                this.b = new h(this, (h) eVar);
                return;
            }
            if (Build.VERSION.SDK_INT >= 21 && (eVar instanceof g)) {
                this.b = new g(this, (g) eVar);
                return;
            } else if (Build.VERSION.SDK_INT >= 20 && (eVar instanceof f)) {
                this.b = new f(this, (f) eVar);
                return;
            } else {
                this.b = new e(this);
                return;
            }
        }
        this.b = new e(this);
    }

    public static ad a(WindowInsets windowInsets) {
        return new ad((WindowInsets) androidx.core.e.e.a(windowInsets));
    }

    public int a() {
        return i().b;
    }

    public int b() {
        return i().c;
    }

    public int c() {
        return i().d;
    }

    public int d() {
        return i().e;
    }

    public boolean e() {
        return this.b.b();
    }

    public ad f() {
        return this.b.c();
    }

    @Deprecated
    public ad a(int i2, int i3, int i4, int i5) {
        return new a(this).a(androidx.core.graphics.c.a(i2, i3, i4, i5)).a();
    }

    public ad g() {
        return this.b.d();
    }

    public ad h() {
        return this.b.f();
    }

    public androidx.core.graphics.c i() {
        return this.b.g();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ad) {
            return androidx.core.e.b.a(this.b, ((ad) obj).b);
        }
        return false;
    }

    public int hashCode() {
        e eVar = this.b;
        if (eVar == null) {
            return 0;
        }
        return eVar.hashCode();
    }

    public WindowInsets j() {
        e eVar = this.b;
        if (eVar instanceof f) {
            return ((f) eVar).b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        final ad f535a;

        boolean a() {
            return false;
        }

        boolean b() {
            return false;
        }

        androidx.core.f.c e() {
            return null;
        }

        e(ad adVar) {
            this.f535a = adVar;
        }

        ad c() {
            return this.f535a;
        }

        ad d() {
            return this.f535a;
        }

        ad f() {
            return this.f535a;
        }

        androidx.core.graphics.c g() {
            return androidx.core.graphics.c.f556a;
        }

        androidx.core.graphics.c h() {
            return androidx.core.graphics.c.f556a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return a() == eVar.a() && b() == eVar.b() && androidx.core.e.b.a(g(), eVar.g()) && androidx.core.e.b.a(h(), eVar.h()) && androidx.core.e.b.a(e(), eVar.e());
        }

        public int hashCode() {
            return androidx.core.e.b.a(Boolean.valueOf(a()), Boolean.valueOf(b()), g(), h(), e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f extends e {
        final WindowInsets b;
        private androidx.core.graphics.c c;

        f(ad adVar, WindowInsets windowInsets) {
            super(adVar);
            this.c = null;
            this.b = windowInsets;
        }

        f(ad adVar, f fVar) {
            this(adVar, new WindowInsets(fVar.b));
        }

        @Override // androidx.core.f.ad.e
        boolean a() {
            return this.b.isRound();
        }

        @Override // androidx.core.f.ad.e
        final androidx.core.graphics.c g() {
            if (this.c == null) {
                this.c = androidx.core.graphics.c.a(this.b.getSystemWindowInsetLeft(), this.b.getSystemWindowInsetTop(), this.b.getSystemWindowInsetRight(), this.b.getSystemWindowInsetBottom());
            }
            return this.c;
        }
    }

    /* loaded from: classes.dex */
    private static class g extends f {
        private androidx.core.graphics.c c;

        g(ad adVar, WindowInsets windowInsets) {
            super(adVar, windowInsets);
            this.c = null;
        }

        g(ad adVar, g gVar) {
            super(adVar, gVar);
            this.c = null;
        }

        @Override // androidx.core.f.ad.e
        boolean b() {
            return this.b.isConsumed();
        }

        @Override // androidx.core.f.ad.e
        ad d() {
            return ad.a(this.b.consumeStableInsets());
        }

        @Override // androidx.core.f.ad.e
        ad c() {
            return ad.a(this.b.consumeSystemWindowInsets());
        }

        @Override // androidx.core.f.ad.e
        final androidx.core.graphics.c h() {
            if (this.c == null) {
                this.c = androidx.core.graphics.c.a(this.b.getStableInsetLeft(), this.b.getStableInsetTop(), this.b.getStableInsetRight(), this.b.getStableInsetBottom());
            }
            return this.c;
        }
    }

    /* loaded from: classes.dex */
    private static class h extends g {
        h(ad adVar, WindowInsets windowInsets) {
            super(adVar, windowInsets);
        }

        h(ad adVar, h hVar) {
            super(adVar, hVar);
        }

        @Override // androidx.core.f.ad.e
        androidx.core.f.c e() {
            return androidx.core.f.c.a(this.b.getDisplayCutout());
        }

        @Override // androidx.core.f.ad.e
        ad f() {
            return ad.a(this.b.consumeDisplayCutout());
        }

        @Override // androidx.core.f.ad.e
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof h) {
                return Objects.equals(this.b, ((h) obj).b);
            }
            return false;
        }

        @Override // androidx.core.f.ad.e
        public int hashCode() {
            return this.b.hashCode();
        }
    }

    /* loaded from: classes.dex */
    private static class i extends h {
        private androidx.core.graphics.c c;
        private androidx.core.graphics.c d;
        private androidx.core.graphics.c e;

        i(ad adVar, WindowInsets windowInsets) {
            super(adVar, windowInsets);
            this.c = null;
            this.d = null;
            this.e = null;
        }

        i(ad adVar, i iVar) {
            super(adVar, iVar);
            this.c = null;
            this.d = null;
            this.e = null;
        }
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final b f531a;

        public a() {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f531a = new d();
            } else if (Build.VERSION.SDK_INT >= 20) {
                this.f531a = new c();
            } else {
                this.f531a = new b();
            }
        }

        public a(ad adVar) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f531a = new d(adVar);
            } else if (Build.VERSION.SDK_INT >= 20) {
                this.f531a = new c(adVar);
            } else {
                this.f531a = new b(adVar);
            }
        }

        public a a(androidx.core.graphics.c cVar) {
            this.f531a.a(cVar);
            return this;
        }

        public ad a() {
            return this.f531a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final ad f532a;

        void a(androidx.core.graphics.c cVar) {
        }

        b() {
            this(new ad((ad) null));
        }

        b(ad adVar) {
            this.f532a = adVar;
        }

        ad a() {
            return this.f532a;
        }
    }

    /* loaded from: classes.dex */
    private static class c extends b {

        /* renamed from: a, reason: collision with root package name */
        private static Field f533a;
        private static boolean b;
        private static Constructor<WindowInsets> c;
        private static boolean d;
        private WindowInsets e;

        c() {
            this.e = b();
        }

        c(ad adVar) {
            this.e = adVar.j();
        }

        @Override // androidx.core.f.ad.b
        void a(androidx.core.graphics.c cVar) {
            WindowInsets windowInsets = this.e;
            if (windowInsets != null) {
                this.e = windowInsets.replaceSystemWindowInsets(cVar.b, cVar.c, cVar.d, cVar.e);
            }
        }

        @Override // androidx.core.f.ad.b
        ad a() {
            return ad.a(this.e);
        }

        private static WindowInsets b() {
            if (!b) {
                try {
                    f533a = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e);
                }
                b = true;
            }
            Field field = f533a;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e2);
                }
            }
            if (!d) {
                try {
                    c = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e3);
                }
                d = true;
            }
            Constructor<WindowInsets> constructor = c;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e4);
                }
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    private static class d extends b {

        /* renamed from: a, reason: collision with root package name */
        final WindowInsets.Builder f534a;

        d() {
            this.f534a = new WindowInsets.Builder();
        }

        d(ad adVar) {
            WindowInsets.Builder builder;
            WindowInsets j = adVar.j();
            if (j != null) {
                builder = new WindowInsets.Builder(j);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f534a = builder;
        }

        @Override // androidx.core.f.ad.b
        void a(androidx.core.graphics.c cVar) {
            this.f534a.setSystemWindowInsets(cVar.a());
        }

        @Override // androidx.core.f.ad.b
        ad a() {
            return ad.a(this.f534a.build());
        }
    }
}
