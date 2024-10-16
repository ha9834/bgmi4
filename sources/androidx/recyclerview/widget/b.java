package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    final InterfaceC0066b f878a;
    final a b = new a();
    final List<View> c = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.recyclerview.widget.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0066b {
        int a();

        int a(View view);

        void a(int i);

        void a(View view, int i);

        void a(View view, int i, ViewGroup.LayoutParams layoutParams);

        View b(int i);

        RecyclerView.w b(View view);

        void b();

        void c(int i);

        void c(View view);

        void d(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InterfaceC0066b interfaceC0066b) {
        this.f878a = interfaceC0066b;
    }

    private void g(View view) {
        this.c.add(view);
        this.f878a.c(view);
    }

    private boolean h(View view) {
        if (!this.c.remove(view)) {
            return false;
        }
        this.f878a.d(view);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, boolean z) {
        a(view, -1, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, int i, boolean z) {
        int f;
        if (i < 0) {
            f = this.f878a.a();
        } else {
            f = f(i);
        }
        this.b.a(f, z);
        if (z) {
            g(view);
        }
        this.f878a.a(view, f);
    }

    private int f(int i) {
        if (i < 0) {
            return -1;
        }
        int a2 = this.f878a.a();
        int i2 = i;
        while (i2 < a2) {
            int e = i - (i2 - this.b.e(i2));
            if (e == 0) {
                while (this.b.c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += e;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view) {
        int a2 = this.f878a.a(view);
        if (a2 < 0) {
            return;
        }
        if (this.b.d(a2)) {
            h(view);
        }
        this.f878a.a(a2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        int f = f(i);
        View b = this.f878a.b(f);
        if (b == null) {
            return;
        }
        if (this.b.d(f)) {
            h(b);
        }
        this.f878a.a(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View b(int i) {
        return this.f878a.b(f(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.b.a();
        for (int size = this.c.size() - 1; size >= 0; size--) {
            this.f878a.d(this.c.get(size));
            this.c.remove(size);
        }
        this.f878a.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View c(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.c.get(i2);
            RecyclerView.w b = this.f878a.b(view);
            if (b.getLayoutPosition() == i && !b.isInvalid() && !b.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int f;
        if (i < 0) {
            f = this.f878a.a();
        } else {
            f = f(i);
        }
        this.b.a(f, z);
        if (z) {
            g(view);
        }
        this.f878a.a(view, f, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f878a.a() - this.c.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f878a.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View d(int i) {
        return this.f878a.b(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(int i) {
        int f = f(i);
        this.b.d(f);
        this.f878a.c(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(View view) {
        int a2 = this.f878a.a(view);
        if (a2 == -1 || this.b.c(a2)) {
            return -1;
        }
        return a2 - this.b.e(a2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(View view) {
        return this.c.contains(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(View view) {
        int a2 = this.f878a.a(view);
        if (a2 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.b.a(a2);
        g(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(View view) {
        int a2 = this.f878a.a(view);
        if (a2 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (!this.b.c(a2)) {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
        this.b.b(a2);
        h(view);
    }

    public String toString() {
        return this.b.toString() + ", hidden list:" + this.c.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(View view) {
        int a2 = this.f878a.a(view);
        if (a2 == -1) {
            h(view);
            return true;
        }
        if (!this.b.c(a2)) {
            return false;
        }
        this.b.d(a2);
        h(view);
        this.f878a.a(a2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        long f879a = 0;
        a b;

        a() {
        }

        void a(int i) {
            if (i >= 64) {
                b();
                this.b.a(i - 64);
            } else {
                this.f879a |= 1 << i;
            }
        }

        private void b() {
            if (this.b == null) {
                this.b = new a();
            }
        }

        void b(int i) {
            if (i >= 64) {
                a aVar = this.b;
                if (aVar != null) {
                    aVar.b(i - 64);
                    return;
                }
                return;
            }
            this.f879a &= (1 << i) ^ (-1);
        }

        boolean c(int i) {
            if (i < 64) {
                return (this.f879a & (1 << i)) != 0;
            }
            b();
            return this.b.c(i - 64);
        }

        void a() {
            this.f879a = 0L;
            a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
        }

        void a(int i, boolean z) {
            if (i >= 64) {
                b();
                this.b.a(i - 64, z);
                return;
            }
            boolean z2 = (this.f879a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            long j2 = this.f879a;
            this.f879a = ((j2 & (j ^ (-1))) << 1) | (j2 & j);
            if (z) {
                a(i);
            } else {
                b(i);
            }
            if (z2 || this.b != null) {
                b();
                this.b.a(0, z2);
            }
        }

        boolean d(int i) {
            if (i >= 64) {
                b();
                return this.b.d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f879a & j) != 0;
            this.f879a &= j ^ (-1);
            long j2 = j - 1;
            long j3 = this.f879a;
            this.f879a = Long.rotateRight(j3 & (j2 ^ (-1)), 1) | (j3 & j2);
            a aVar = this.b;
            if (aVar != null) {
                if (aVar.c(0)) {
                    a(63);
                }
                this.b.d(0);
            }
            return z;
        }

        int e(int i) {
            a aVar = this.b;
            if (aVar == null) {
                if (i >= 64) {
                    return Long.bitCount(this.f879a);
                }
                return Long.bitCount(this.f879a & ((1 << i) - 1));
            }
            if (i < 64) {
                return Long.bitCount(this.f879a & ((1 << i) - 1));
            }
            return aVar.e(i - 64) + Long.bitCount(this.f879a);
        }

        public String toString() {
            if (this.b == null) {
                return Long.toBinaryString(this.f879a);
            }
            return this.b.toString() + "xx" + Long.toBinaryString(this.f879a);
        }
    }
}
