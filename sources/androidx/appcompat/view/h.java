package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.f.aa;
import androidx.core.f.ab;
import androidx.core.f.z;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class h {
    aa b;
    private Interpolator d;
    private boolean e;
    private long c = -1;
    private final ab f = new ab() { // from class: androidx.appcompat.view.h.1
        private boolean b = false;
        private int c = 0;

        @Override // androidx.core.f.ab, androidx.core.f.aa
        public void a(View view) {
            if (this.b) {
                return;
            }
            this.b = true;
            if (h.this.b != null) {
                h.this.b.a(null);
            }
        }

        void a() {
            this.c = 0;
            this.b = false;
            h.this.b();
        }

        @Override // androidx.core.f.ab, androidx.core.f.aa
        public void b(View view) {
            int i = this.c + 1;
            this.c = i;
            if (i == h.this.f218a.size()) {
                if (h.this.b != null) {
                    h.this.b.b(null);
                }
                a();
            }
        }
    };

    /* renamed from: a, reason: collision with root package name */
    final ArrayList<z> f218a = new ArrayList<>();

    public h a(z zVar) {
        if (!this.e) {
            this.f218a.add(zVar);
        }
        return this;
    }

    public h a(z zVar, z zVar2) {
        this.f218a.add(zVar);
        zVar2.b(zVar.a());
        this.f218a.add(zVar2);
        return this;
    }

    public void a() {
        if (this.e) {
            return;
        }
        Iterator<z> it = this.f218a.iterator();
        while (it.hasNext()) {
            z next = it.next();
            long j = this.c;
            if (j >= 0) {
                next.a(j);
            }
            Interpolator interpolator = this.d;
            if (interpolator != null) {
                next.a(interpolator);
            }
            if (this.b != null) {
                next.a(this.f);
            }
            next.c();
        }
        this.e = true;
    }

    void b() {
        this.e = false;
    }

    public void c() {
        if (this.e) {
            Iterator<z> it = this.f218a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.e = false;
        }
    }

    public h a(long j) {
        if (!this.e) {
            this.c = j;
        }
        return this;
    }

    public h a(Interpolator interpolator) {
        if (!this.e) {
            this.d = interpolator;
        }
        return this;
    }

    public h a(aa aaVar) {
        if (!this.e) {
            this.b = aaVar;
        }
        return this;
    }
}
