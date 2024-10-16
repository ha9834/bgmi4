package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.f.a.d;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.nearby.messages.BleSignal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.i implements RecyclerView.s.b {
    private SavedState A;
    private int B;
    private int[] G;

    /* renamed from: a, reason: collision with root package name */
    c[] f868a;
    i b;
    i c;
    private int j;
    private int k;
    private final f l;
    private BitSet m;
    private boolean o;
    private boolean z;
    private int i = -1;
    boolean d = false;
    boolean e = false;
    int f = -1;
    int g = BleSignal.UNKNOWN_TX_POWER;
    LazySpanLookup h = new LazySpanLookup();
    private int n = 2;
    private final Rect C = new Rect();
    private final a D = new a();
    private boolean E = false;
    private boolean F = true;
    private final Runnable H = new Runnable() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.1
        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.b();
        }
    };

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.i.b a2 = a(context, attributeSet, i, i2);
        b(a2.f859a);
        a(a2.b);
        a(a2.c);
        this.l = new f();
        q();
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        this.j = i2;
        a(i);
        this.l = new f();
        q();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean d() {
        return this.n != 0;
    }

    private void q() {
        this.b = i.a(this, this.j);
        this.c = i.a(this, 1 - this.j);
    }

    boolean b() {
        int p;
        int o;
        if (y() == 0 || this.n == 0 || !t()) {
            return false;
        }
        if (this.e) {
            p = o();
            o = p();
        } else {
            p = p();
            o = o();
        }
        if (p == 0 && h() != null) {
            this.h.a();
            M();
            r();
            return true;
        }
        if (!this.E) {
            return false;
        }
        int i = this.e ? -1 : 1;
        int i2 = o + 1;
        LazySpanLookup.FullSpanItem a2 = this.h.a(p, i2, i, true);
        if (a2 == null) {
            this.E = false;
            this.h.a(i2);
            return false;
        }
        LazySpanLookup.FullSpanItem a3 = this.h.a(p, a2.f871a, i * (-1), true);
        if (a3 == null) {
            this.h.a(a2.f871a);
        } else {
            this.h.a(a3.f871a + 1);
        }
        M();
        r();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void l(int i) {
        if (i == 0) {
            b();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, RecyclerView.p pVar) {
        super.a(recyclerView, pVar);
        a(this.H);
        for (int i = 0; i < this.i; i++) {
            this.f868a[i].e();
        }
        recyclerView.requestLayout();
    }

    View h() {
        int i;
        int i2;
        boolean z;
        int y = y() - 1;
        BitSet bitSet = new BitSet(this.i);
        bitSet.set(0, this.i, true);
        char c2 = (this.j == 1 && j()) ? (char) 1 : (char) 65535;
        if (this.e) {
            i = -1;
        } else {
            i = y + 1;
            y = 0;
        }
        int i3 = y < i ? 1 : -1;
        while (y != i) {
            View i4 = i(y);
            b bVar = (b) i4.getLayoutParams();
            if (bitSet.get(bVar.f874a.e)) {
                if (a(bVar.f874a)) {
                    return i4;
                }
                bitSet.clear(bVar.f874a.e);
            }
            if (!bVar.b && (i2 = y + i3) != i) {
                View i5 = i(i2);
                if (this.e) {
                    int b2 = this.b.b(i4);
                    int b3 = this.b.b(i5);
                    if (b2 < b3) {
                        return i4;
                    }
                    z = b2 == b3;
                } else {
                    int a2 = this.b.a(i4);
                    int a3 = this.b.a(i5);
                    if (a2 > a3) {
                        return i4;
                    }
                    z = a2 == a3;
                }
                if (z) {
                    if ((bVar.f874a.e - ((b) i5.getLayoutParams()).f874a.e < 0) != (c2 < 0)) {
                        return i4;
                    }
                } else {
                    continue;
                }
            }
            y += i3;
        }
        return null;
    }

    private boolean a(c cVar) {
        if (this.e) {
            if (cVar.d() < this.b.d()) {
                return !cVar.c(cVar.f875a.get(cVar.f875a.size() - 1)).b;
            }
        } else if (cVar.b() > this.b.c()) {
            return !cVar.c(cVar.f875a.get(0)).b;
        }
        return false;
    }

    public void a(int i) {
        a((String) null);
        if (i != this.i) {
            i();
            this.i = i;
            this.m = new BitSet(this.i);
            this.f868a = new c[this.i];
            for (int i2 = 0; i2 < this.i; i2++) {
                this.f868a[i2] = new c(i2);
            }
            r();
        }
    }

    public void b(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        a((String) null);
        if (i == this.j) {
            return;
        }
        this.j = i;
        i iVar = this.b;
        this.b = this.c;
        this.c = iVar;
        r();
    }

    public void a(boolean z) {
        a((String) null);
        SavedState savedState = this.A;
        if (savedState != null && savedState.h != z) {
            this.A.h = z;
        }
        this.d = z;
        r();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(String str) {
        if (this.A == null) {
            super.a(str);
        }
    }

    public void i() {
        this.h.a();
        r();
    }

    private void O() {
        if (this.j == 1 || !j()) {
            this.e = this.d;
        } else {
            this.e = !this.d;
        }
    }

    boolean j() {
        return w() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(Rect rect, int i, int i2) {
        int a2;
        int a3;
        int D = D() + F();
        int E = E() + G();
        if (this.j == 1) {
            a3 = a(i2, rect.height() + E, K());
            a2 = a(i, (this.k * this.i) + D, J());
        } else {
            a2 = a(i, rect.width() + D, J());
            a3 = a(i2, (this.k * this.i) + E, K());
        }
        g(a2, a3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void c(RecyclerView.p pVar, RecyclerView.t tVar) {
        a(pVar, tVar, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x0161, code lost:
    
        if (b() != false) goto L90;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(androidx.recyclerview.widget.RecyclerView.p r9, androidx.recyclerview.widget.RecyclerView.t r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.a(androidx.recyclerview.widget.RecyclerView$p, androidx.recyclerview.widget.RecyclerView$t, boolean):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView.t tVar) {
        super.a(tVar);
        this.f = -1;
        this.g = BleSignal.UNKNOWN_TX_POWER;
        this.A = null;
        this.D.a();
    }

    private void P() {
        if (this.c.h() == 1073741824) {
            return;
        }
        int y = y();
        float f = 0.0f;
        for (int i = 0; i < y; i++) {
            View i2 = i(i);
            float e = this.c.e(i2);
            if (e >= f) {
                if (((b) i2.getLayoutParams()).a()) {
                    e = (e * 1.0f) / this.i;
                }
                f = Math.max(f, e);
            }
        }
        int i3 = this.k;
        int round = Math.round(f * this.i);
        if (this.c.h() == Integer.MIN_VALUE) {
            round = Math.min(round, this.c.f());
        }
        f(round);
        if (this.k == i3) {
            return;
        }
        for (int i4 = 0; i4 < y; i4++) {
            View i5 = i(i4);
            b bVar = (b) i5.getLayoutParams();
            if (!bVar.b) {
                if (j() && this.j == 1) {
                    i5.offsetLeftAndRight(((-((this.i - 1) - bVar.f874a.e)) * this.k) - ((-((this.i - 1) - bVar.f874a.e)) * i3));
                } else {
                    int i6 = bVar.f874a.e * this.k;
                    int i7 = bVar.f874a.e * i3;
                    if (this.j == 1) {
                        i5.offsetLeftAndRight(i6 - i7);
                    } else {
                        i5.offsetTopAndBottom(i6 - i7);
                    }
                }
            }
        }
    }

    private void a(a aVar) {
        if (this.A.c > 0) {
            if (this.A.c == this.i) {
                for (int i = 0; i < this.i; i++) {
                    this.f868a[i].e();
                    int i2 = this.A.d[i];
                    if (i2 != Integer.MIN_VALUE) {
                        if (this.A.i) {
                            i2 += this.b.d();
                        } else {
                            i2 += this.b.c();
                        }
                    }
                    this.f868a[i].c(i2);
                }
            } else {
                this.A.a();
                SavedState savedState = this.A;
                savedState.f872a = savedState.b;
            }
        }
        this.z = this.A.j;
        a(this.A.h);
        O();
        if (this.A.f872a != -1) {
            this.f = this.A.f872a;
            aVar.c = this.A.i;
        } else {
            aVar.c = this.e;
        }
        if (this.A.e > 1) {
            this.h.f870a = this.A.f;
            this.h.b = this.A.g;
        }
    }

    void a(RecyclerView.t tVar, a aVar) {
        if (b(tVar, aVar) || c(tVar, aVar)) {
            return;
        }
        aVar.b();
        aVar.f873a = 0;
    }

    private boolean c(RecyclerView.t tVar, a aVar) {
        int v;
        if (this.o) {
            v = w(tVar.e());
        } else {
            v = v(tVar.e());
        }
        aVar.f873a = v;
        aVar.b = BleSignal.UNKNOWN_TX_POWER;
        return true;
    }

    boolean b(RecyclerView.t tVar, a aVar) {
        int i;
        int c2;
        if (tVar.a() || (i = this.f) == -1) {
            return false;
        }
        if (i < 0 || i >= tVar.e()) {
            this.f = -1;
            this.g = BleSignal.UNKNOWN_TX_POWER;
            return false;
        }
        SavedState savedState = this.A;
        if (savedState == null || savedState.f872a == -1 || this.A.c < 1) {
            View c3 = c(this.f);
            if (c3 != null) {
                aVar.f873a = this.e ? o() : p();
                if (this.g != Integer.MIN_VALUE) {
                    if (aVar.c) {
                        aVar.b = (this.b.d() - this.g) - this.b.b(c3);
                    } else {
                        aVar.b = (this.b.c() + this.g) - this.b.a(c3);
                    }
                    return true;
                }
                if (this.b.e(c3) > this.b.f()) {
                    if (aVar.c) {
                        c2 = this.b.d();
                    } else {
                        c2 = this.b.c();
                    }
                    aVar.b = c2;
                    return true;
                }
                int a2 = this.b.a(c3) - this.b.c();
                if (a2 < 0) {
                    aVar.b = -a2;
                    return true;
                }
                int d = this.b.d() - this.b.b(c3);
                if (d < 0) {
                    aVar.b = d;
                    return true;
                }
                aVar.b = BleSignal.UNKNOWN_TX_POWER;
            } else {
                aVar.f873a = this.f;
                int i2 = this.g;
                if (i2 == Integer.MIN_VALUE) {
                    aVar.c = u(aVar.f873a) == 1;
                    aVar.b();
                } else {
                    aVar.a(i2);
                }
                aVar.d = true;
            }
        } else {
            aVar.b = BleSignal.UNKNOWN_TX_POWER;
            aVar.f873a = this.f;
        }
        return true;
    }

    void f(int i) {
        this.k = i / this.i;
        this.B = View.MeasureSpec.makeMeasureSpec(i, this.c.h());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean c() {
        return this.A == null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int c(RecyclerView.t tVar) {
        return b(tVar);
    }

    private int b(RecyclerView.t tVar) {
        if (y() == 0) {
            return 0;
        }
        return k.a(tVar, this.b, b(!this.F), d(!this.F), this, this.F, this.e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int d(RecyclerView.t tVar) {
        return b(tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int e(RecyclerView.t tVar) {
        return i(tVar);
    }

    private int i(RecyclerView.t tVar) {
        if (y() == 0) {
            return 0;
        }
        return k.a(tVar, this.b, b(!this.F), d(!this.F), this, this.F);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int f(RecyclerView.t tVar) {
        return i(tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int g(RecyclerView.t tVar) {
        return j(tVar);
    }

    private int j(RecyclerView.t tVar) {
        if (y() == 0) {
            return 0;
        }
        return k.b(tVar, this.b, b(!this.F), d(!this.F), this, this.F);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int h(RecyclerView.t tVar) {
        return j(tVar);
    }

    private void a(View view, b bVar, boolean z) {
        if (bVar.b) {
            if (this.j == 1) {
                a(view, this.B, a(C(), A(), E() + G(), bVar.height, true), z);
                return;
            } else {
                a(view, a(B(), z(), D() + F(), bVar.width, true), this.B, z);
                return;
            }
        }
        if (this.j == 1) {
            a(view, a(this.k, z(), 0, bVar.width, false), a(C(), A(), E() + G(), bVar.height, true), z);
        } else {
            a(view, a(B(), z(), D() + F(), bVar.width, true), a(this.k, A(), 0, bVar.height, false), z);
        }
    }

    private void a(View view, int i, int i2, boolean z) {
        boolean b2;
        b(view, this.C);
        b bVar = (b) view.getLayoutParams();
        int b3 = b(i, bVar.leftMargin + this.C.left, bVar.rightMargin + this.C.right);
        int b4 = b(i2, bVar.topMargin + this.C.top, bVar.bottomMargin + this.C.bottom);
        if (z) {
            b2 = a(view, b3, b4, bVar);
        } else {
            b2 = b(view, b3, b4, bVar);
        }
        if (b2) {
            view.measure(b3, b4);
        }
    }

    private int b(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.A = (SavedState) parcelable;
            r();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public Parcelable e() {
        int a2;
        SavedState savedState = this.A;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        savedState2.h = this.d;
        savedState2.i = this.o;
        savedState2.j = this.z;
        LazySpanLookup lazySpanLookup = this.h;
        if (lazySpanLookup != null && lazySpanLookup.f870a != null) {
            savedState2.f = this.h.f870a;
            savedState2.e = savedState2.f.length;
            savedState2.g = this.h.b;
        } else {
            savedState2.e = 0;
        }
        if (y() > 0) {
            savedState2.f872a = this.o ? o() : p();
            savedState2.b = k();
            int i = this.i;
            savedState2.c = i;
            savedState2.d = new int[i];
            for (int i2 = 0; i2 < this.i; i2++) {
                if (this.o) {
                    a2 = this.f868a[i2].b(BleSignal.UNKNOWN_TX_POWER);
                    if (a2 != Integer.MIN_VALUE) {
                        a2 -= this.b.d();
                    }
                } else {
                    a2 = this.f868a[i2].a(BleSignal.UNKNOWN_TX_POWER);
                    if (a2 != Integer.MIN_VALUE) {
                        a2 -= this.b.c();
                    }
                }
                savedState2.d[i2] = a2;
            }
        } else {
            savedState2.f872a = -1;
            savedState2.b = -1;
            savedState2.c = 0;
        }
        return savedState2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView.p pVar, RecyclerView.t tVar, View view, androidx.core.f.a.d dVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.a(view, dVar);
            return;
        }
        b bVar = (b) layoutParams;
        if (this.j == 0) {
            dVar.b(d.c.a(bVar.b(), bVar.b ? this.i : 1, -1, -1, bVar.b, false));
        } else {
            dVar.b(d.c.a(-1, -1, bVar.b(), bVar.b ? this.i : 1, bVar.b, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (y() > 0) {
            View b2 = b(false);
            View d = d(false);
            if (b2 == null || d == null) {
                return;
            }
            int d2 = d(b2);
            int d3 = d(d);
            if (d2 < d3) {
                accessibilityEvent.setFromIndex(d2);
                accessibilityEvent.setToIndex(d3);
            } else {
                accessibilityEvent.setFromIndex(d3);
                accessibilityEvent.setToIndex(d2);
            }
        }
    }

    int k() {
        View d = this.e ? d(true) : b(true);
        if (d == null) {
            return -1;
        }
        return d(d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int a(RecyclerView.p pVar, RecyclerView.t tVar) {
        if (this.j == 0) {
            return this.i;
        }
        return super.a(pVar, tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int b(RecyclerView.p pVar, RecyclerView.t tVar) {
        if (this.j == 1) {
            return this.i;
        }
        return super.b(pVar, tVar);
    }

    View b(boolean z) {
        int c2 = this.b.c();
        int d = this.b.d();
        int y = y();
        View view = null;
        for (int i = 0; i < y; i++) {
            View i2 = i(i);
            int a2 = this.b.a(i2);
            if (this.b.b(i2) > c2 && a2 < d) {
                if (a2 >= c2 || !z) {
                    return i2;
                }
                if (view == null) {
                    view = i2;
                }
            }
        }
        return view;
    }

    View d(boolean z) {
        int c2 = this.b.c();
        int d = this.b.d();
        View view = null;
        for (int y = y() - 1; y >= 0; y--) {
            View i = i(y);
            int a2 = this.b.a(i);
            int b2 = this.b.b(i);
            if (b2 > c2 && a2 < d) {
                if (b2 <= d || !z) {
                    return i;
                }
                if (view == null) {
                    view = i;
                }
            }
        }
        return view;
    }

    private void b(RecyclerView.p pVar, RecyclerView.t tVar, boolean z) {
        int d;
        int r = r(BleSignal.UNKNOWN_TX_POWER);
        if (r != Integer.MIN_VALUE && (d = this.b.d() - r) > 0) {
            int i = d - (-c(-d, pVar, tVar));
            if (!z || i <= 0) {
                return;
            }
            this.b.a(i);
        }
    }

    private void c(RecyclerView.p pVar, RecyclerView.t tVar, boolean z) {
        int c2;
        int q = q(Integer.MAX_VALUE);
        if (q != Integer.MAX_VALUE && (c2 = q - this.b.c()) > 0) {
            int c3 = c2 - c(c2, pVar, tVar);
            if (!z || c3 <= 0) {
                return;
            }
            this.b.a(-c3);
        }
    }

    private void b(int i, RecyclerView.t tVar) {
        int i2;
        int i3;
        int c2;
        f fVar = this.l;
        boolean z = false;
        fVar.b = 0;
        fVar.c = i;
        if (!v() || (c2 = tVar.c()) == -1) {
            i2 = 0;
            i3 = 0;
        } else {
            if (this.e == (c2 < i)) {
                i2 = this.b.f();
                i3 = 0;
            } else {
                i3 = this.b.f();
                i2 = 0;
            }
        }
        if (u()) {
            this.l.f = this.b.c() - i3;
            this.l.g = this.b.d() + i2;
        } else {
            this.l.g = this.b.e() + i2;
            this.l.f = -i3;
        }
        f fVar2 = this.l;
        fVar2.h = false;
        fVar2.f899a = true;
        if (this.b.h() == 0 && this.b.e() == 0) {
            z = true;
        }
        fVar2.i = z;
    }

    private void m(int i) {
        f fVar = this.l;
        fVar.e = i;
        fVar.d = this.e != (i == -1) ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void j(int i) {
        super.j(i);
        for (int i2 = 0; i2 < this.i; i2++) {
            this.f868a[i2].d(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void k(int i) {
        super.k(i);
        for (int i2 = 0; i2 < this.i; i2++) {
            this.f868a[i2].d(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void b(RecyclerView recyclerView, int i, int i2) {
        c(i, i2, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2) {
        c(i, i2, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView) {
        this.h.a();
        r();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        c(i, i2, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
        c(i, i2, 4);
    }

    private void c(int i, int i2, int i3) {
        int i4;
        int i5;
        int o = this.e ? o() : p();
        if (i3 != 8) {
            i4 = i + i2;
            i5 = i;
        } else if (i < i2) {
            i4 = i2 + 1;
            i5 = i;
        } else {
            i4 = i + 1;
            i5 = i2;
        }
        this.h.b(i5);
        if (i3 != 8) {
            switch (i3) {
                case 1:
                    this.h.b(i, i2);
                    break;
                case 2:
                    this.h.a(i, i2);
                    break;
            }
        } else {
            this.h.a(i, 1);
            this.h.b(i2, 1);
        }
        if (i4 <= o) {
            return;
        }
        if (i5 <= (this.e ? p() : o())) {
            r();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v6 */
    private int a(RecyclerView.p pVar, f fVar, RecyclerView.t tVar) {
        int i;
        int c2;
        int i2;
        int r;
        c cVar;
        int e;
        int i3;
        int i4;
        int e2;
        boolean z;
        ?? r9 = 0;
        this.m.set(0, this.i, true);
        if (this.l.i) {
            i = fVar.e == 1 ? Integer.MAX_VALUE : BleSignal.UNKNOWN_TX_POWER;
        } else if (fVar.e == 1) {
            i = fVar.g + fVar.b;
        } else {
            i = fVar.f - fVar.b;
        }
        a(fVar.e, i);
        if (this.e) {
            c2 = this.b.d();
        } else {
            c2 = this.b.c();
        }
        boolean z2 = false;
        while (true) {
            if (!fVar.a(tVar)) {
                i2 = 0;
                break;
            }
            if (!this.l.i && this.m.isEmpty()) {
                i2 = 0;
                break;
            }
            View a2 = fVar.a(pVar);
            b bVar = (b) a2.getLayoutParams();
            int f = bVar.f();
            int c3 = this.h.c(f);
            boolean z3 = c3 == -1;
            if (z3) {
                c a3 = bVar.b ? this.f868a[r9] : a(fVar);
                this.h.a(f, a3);
                cVar = a3;
            } else {
                cVar = this.f868a[c3];
            }
            bVar.f874a = cVar;
            if (fVar.e == 1) {
                b(a2);
            } else {
                b(a2, (int) r9);
            }
            a(a2, bVar, (boolean) r9);
            if (fVar.e == 1) {
                int r2 = bVar.b ? r(c2) : cVar.b(c2);
                int e3 = this.b.e(a2) + r2;
                if (z3 && bVar.b) {
                    LazySpanLookup.FullSpanItem n = n(r2);
                    n.b = -1;
                    n.f871a = f;
                    this.h.a(n);
                }
                i3 = e3;
                e = r2;
            } else {
                int q = bVar.b ? q(c2) : cVar.a(c2);
                e = q - this.b.e(a2);
                if (z3 && bVar.b) {
                    LazySpanLookup.FullSpanItem o = o(q);
                    o.b = 1;
                    o.f871a = f;
                    this.h.a(o);
                }
                i3 = q;
            }
            if (bVar.b && fVar.d == -1) {
                if (z3) {
                    this.E = true;
                } else {
                    if (fVar.e == 1) {
                        z = !l();
                    } else {
                        z = !n();
                    }
                    if (z) {
                        LazySpanLookup.FullSpanItem f2 = this.h.f(f);
                        if (f2 != null) {
                            f2.d = true;
                        }
                        this.E = true;
                    }
                }
            }
            a(a2, bVar, fVar);
            if (j() && this.j == 1) {
                int d = bVar.b ? this.c.d() : this.c.d() - (((this.i - 1) - cVar.e) * this.k);
                e2 = d;
                i4 = d - this.c.e(a2);
            } else {
                int c4 = bVar.b ? this.c.c() : (cVar.e * this.k) + this.c.c();
                i4 = c4;
                e2 = this.c.e(a2) + c4;
            }
            if (this.j == 1) {
                a(a2, i4, e, e2, i3);
            } else {
                a(a2, e, i4, i3, e2);
            }
            if (bVar.b) {
                a(this.l.e, i);
            } else {
                a(cVar, this.l.e, i);
            }
            a(pVar, this.l);
            if (this.l.h && a2.hasFocusable()) {
                if (bVar.b) {
                    this.m.clear();
                } else {
                    this.m.set(cVar.e, false);
                }
            }
            z2 = true;
            r9 = 0;
        }
        if (!z2) {
            a(pVar, this.l);
        }
        if (this.l.e == -1) {
            r = this.b.c() - q(this.b.c());
        } else {
            r = r(this.b.d()) - this.b.d();
        }
        return r > 0 ? Math.min(fVar.b, r) : i2;
    }

    private LazySpanLookup.FullSpanItem n(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.c = new int[this.i];
        for (int i2 = 0; i2 < this.i; i2++) {
            fullSpanItem.c[i2] = i - this.f868a[i2].b(i);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem o(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.c = new int[this.i];
        for (int i2 = 0; i2 < this.i; i2++) {
            fullSpanItem.c[i2] = this.f868a[i2].a(i) - i;
        }
        return fullSpanItem;
    }

    private void a(View view, b bVar, f fVar) {
        if (fVar.e == 1) {
            if (bVar.b) {
                p(view);
                return;
            } else {
                bVar.f874a.b(view);
                return;
            }
        }
        if (bVar.b) {
            q(view);
        } else {
            bVar.f874a.a(view);
        }
    }

    private void a(RecyclerView.p pVar, f fVar) {
        int min;
        int min2;
        if (!fVar.f899a || fVar.i) {
            return;
        }
        if (fVar.b == 0) {
            if (fVar.e == -1) {
                b(pVar, fVar.g);
                return;
            } else {
                a(pVar, fVar.f);
                return;
            }
        }
        if (fVar.e == -1) {
            int p = fVar.f - p(fVar.f);
            if (p < 0) {
                min2 = fVar.g;
            } else {
                min2 = fVar.g - Math.min(p, fVar.b);
            }
            b(pVar, min2);
            return;
        }
        int s = s(fVar.g) - fVar.g;
        if (s < 0) {
            min = fVar.f;
        } else {
            min = Math.min(s, fVar.b) + fVar.f;
        }
        a(pVar, min);
    }

    private void p(View view) {
        for (int i = this.i - 1; i >= 0; i--) {
            this.f868a[i].b(view);
        }
    }

    private void q(View view) {
        for (int i = this.i - 1; i >= 0; i--) {
            this.f868a[i].a(view);
        }
    }

    private void a(int i, int i2) {
        for (int i3 = 0; i3 < this.i; i3++) {
            if (!this.f868a[i3].f875a.isEmpty()) {
                a(this.f868a[i3], i, i2);
            }
        }
    }

    private void a(c cVar, int i, int i2) {
        int i3 = cVar.i();
        if (i == -1) {
            if (cVar.b() + i3 <= i2) {
                this.m.set(cVar.e, false);
            }
        } else if (cVar.d() - i3 >= i2) {
            this.m.set(cVar.e, false);
        }
    }

    private int p(int i) {
        int a2 = this.f868a[0].a(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int a3 = this.f868a[i2].a(i);
            if (a3 > a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    private int q(int i) {
        int a2 = this.f868a[0].a(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int a3 = this.f868a[i2].a(i);
            if (a3 < a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    boolean l() {
        int b2 = this.f868a[0].b(BleSignal.UNKNOWN_TX_POWER);
        for (int i = 1; i < this.i; i++) {
            if (this.f868a[i].b(BleSignal.UNKNOWN_TX_POWER) != b2) {
                return false;
            }
        }
        return true;
    }

    boolean n() {
        int a2 = this.f868a[0].a(BleSignal.UNKNOWN_TX_POWER);
        for (int i = 1; i < this.i; i++) {
            if (this.f868a[i].a(BleSignal.UNKNOWN_TX_POWER) != a2) {
                return false;
            }
        }
        return true;
    }

    private int r(int i) {
        int b2 = this.f868a[0].b(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int b3 = this.f868a[i2].b(i);
            if (b3 > b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    private int s(int i) {
        int b2 = this.f868a[0].b(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int b3 = this.f868a[i2].b(i);
            if (b3 < b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    private void a(RecyclerView.p pVar, int i) {
        while (y() > 0) {
            View i2 = i(0);
            if (this.b.b(i2) > i || this.b.c(i2) > i) {
                return;
            }
            b bVar = (b) i2.getLayoutParams();
            if (bVar.b) {
                for (int i3 = 0; i3 < this.i; i3++) {
                    if (this.f868a[i3].f875a.size() == 1) {
                        return;
                    }
                }
                for (int i4 = 0; i4 < this.i; i4++) {
                    this.f868a[i4].h();
                }
            } else if (bVar.f874a.f875a.size() == 1) {
                return;
            } else {
                bVar.f874a.h();
            }
            a(i2, pVar);
        }
    }

    private void b(RecyclerView.p pVar, int i) {
        for (int y = y() - 1; y >= 0; y--) {
            View i2 = i(y);
            if (this.b.a(i2) < i || this.b.d(i2) < i) {
                return;
            }
            b bVar = (b) i2.getLayoutParams();
            if (bVar.b) {
                for (int i3 = 0; i3 < this.i; i3++) {
                    if (this.f868a[i3].f875a.size() == 1) {
                        return;
                    }
                }
                for (int i4 = 0; i4 < this.i; i4++) {
                    this.f868a[i4].g();
                }
            } else if (bVar.f874a.f875a.size() == 1) {
                return;
            } else {
                bVar.f874a.g();
            }
            a(i2, pVar);
        }
    }

    private boolean t(int i) {
        if (this.j == 0) {
            return (i == -1) != this.e;
        }
        return ((i == -1) == this.e) == j();
    }

    private c a(f fVar) {
        int i;
        int i2;
        int i3 = -1;
        if (t(fVar.e)) {
            i = this.i - 1;
            i2 = -1;
        } else {
            i = 0;
            i3 = this.i;
            i2 = 1;
        }
        c cVar = null;
        if (fVar.e == 1) {
            int i4 = Integer.MAX_VALUE;
            int c2 = this.b.c();
            while (i != i3) {
                c cVar2 = this.f868a[i];
                int b2 = cVar2.b(c2);
                if (b2 < i4) {
                    cVar = cVar2;
                    i4 = b2;
                }
                i += i2;
            }
            return cVar;
        }
        int i5 = BleSignal.UNKNOWN_TX_POWER;
        int d = this.b.d();
        while (i != i3) {
            c cVar3 = this.f868a[i];
            int a2 = cVar3.a(d);
            if (a2 > i5) {
                cVar = cVar3;
                i5 = a2;
            }
            i += i2;
        }
        return cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean g() {
        return this.j == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean f() {
        return this.j == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int a(int i, RecyclerView.p pVar, RecyclerView.t tVar) {
        return c(i, pVar, tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int b(int i, RecyclerView.p pVar, RecyclerView.t tVar) {
        return c(i, pVar, tVar);
    }

    private int u(int i) {
        if (y() == 0) {
            return this.e ? 1 : -1;
        }
        return (i < p()) != this.e ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s.b
    public PointF d(int i) {
        int u = u(i);
        PointF pointF = new PointF();
        if (u == 0) {
            return null;
        }
        if (this.j == 0) {
            pointF.x = u;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = u;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, RecyclerView.t tVar, int i) {
        g gVar = new g(recyclerView.getContext());
        gVar.c(i);
        a(gVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void e(int i) {
        SavedState savedState = this.A;
        if (savedState != null && savedState.f872a != i) {
            this.A.b();
        }
        this.f = i;
        this.g = BleSignal.UNKNOWN_TX_POWER;
        r();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(int i, int i2, RecyclerView.t tVar, RecyclerView.i.a aVar) {
        int b2;
        if (this.j != 0) {
            i = i2;
        }
        if (y() == 0 || i == 0) {
            return;
        }
        a(i, tVar);
        int[] iArr = this.G;
        if (iArr == null || iArr.length < this.i) {
            this.G = new int[this.i];
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.i; i4++) {
            if (this.l.d == -1) {
                b2 = this.l.f - this.f868a[i4].a(this.l.f);
            } else {
                b2 = this.f868a[i4].b(this.l.g) - this.l.g;
            }
            if (b2 >= 0) {
                this.G[i3] = b2;
                i3++;
            }
        }
        Arrays.sort(this.G, 0, i3);
        for (int i5 = 0; i5 < i3 && this.l.a(tVar); i5++) {
            aVar.b(this.l.c, this.G[i5]);
            this.l.c += this.l.d;
        }
    }

    void a(int i, RecyclerView.t tVar) {
        int p;
        int i2;
        if (i > 0) {
            p = o();
            i2 = 1;
        } else {
            p = p();
            i2 = -1;
        }
        this.l.f899a = true;
        b(p, tVar);
        m(i2);
        f fVar = this.l;
        fVar.c = p + fVar.d;
        this.l.b = Math.abs(i);
    }

    int c(int i, RecyclerView.p pVar, RecyclerView.t tVar) {
        if (y() == 0 || i == 0) {
            return 0;
        }
        a(i, tVar);
        int a2 = a(pVar, this.l, tVar);
        if (this.l.b >= a2) {
            i = i < 0 ? -a2 : a2;
        }
        this.b.a(-i);
        this.o = this.e;
        f fVar = this.l;
        fVar.b = 0;
        a(pVar, fVar);
        return i;
    }

    int o() {
        int y = y();
        if (y == 0) {
            return 0;
        }
        return d(i(y - 1));
    }

    int p() {
        if (y() == 0) {
            return 0;
        }
        return d(i(0));
    }

    private int v(int i) {
        int y = y();
        for (int i2 = 0; i2 < y; i2++) {
            int d = d(i(i2));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    private int w(int i) {
        for (int y = y() - 1; y >= 0; y--) {
            int d = d(i(y));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.j a() {
        if (this.j == 0) {
            return new b(-2, -1);
        }
        return new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.j a(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.j a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean a(RecyclerView.j jVar) {
        return jVar instanceof b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public View a(View view, int i, RecyclerView.p pVar, RecyclerView.t tVar) {
        View e;
        int p;
        int k;
        int k2;
        int k3;
        View a2;
        if (y() == 0 || (e = e(view)) == null) {
            return null;
        }
        O();
        int x = x(i);
        if (x == Integer.MIN_VALUE) {
            return null;
        }
        b bVar = (b) e.getLayoutParams();
        boolean z = bVar.b;
        c cVar = bVar.f874a;
        if (x == 1) {
            p = o();
        } else {
            p = p();
        }
        b(p, tVar);
        m(x);
        f fVar = this.l;
        fVar.c = fVar.d + p;
        this.l.b = (int) (this.b.f() * 0.33333334f);
        f fVar2 = this.l;
        fVar2.h = true;
        fVar2.f899a = false;
        a(pVar, fVar2, tVar);
        this.o = this.e;
        if (!z && (a2 = cVar.a(p, x)) != null && a2 != e) {
            return a2;
        }
        if (t(x)) {
            for (int i2 = this.i - 1; i2 >= 0; i2--) {
                View a3 = this.f868a[i2].a(p, x);
                if (a3 != null && a3 != e) {
                    return a3;
                }
            }
        } else {
            for (int i3 = 0; i3 < this.i; i3++) {
                View a4 = this.f868a[i3].a(p, x);
                if (a4 != null && a4 != e) {
                    return a4;
                }
            }
        }
        boolean z2 = (this.d ^ true) == (x == -1);
        if (!z) {
            if (z2) {
                k3 = cVar.j();
            } else {
                k3 = cVar.k();
            }
            View c2 = c(k3);
            if (c2 != null && c2 != e) {
                return c2;
            }
        }
        if (t(x)) {
            for (int i4 = this.i - 1; i4 >= 0; i4--) {
                if (i4 != cVar.e) {
                    if (z2) {
                        k2 = this.f868a[i4].j();
                    } else {
                        k2 = this.f868a[i4].k();
                    }
                    View c3 = c(k2);
                    if (c3 != null && c3 != e) {
                        return c3;
                    }
                }
            }
        } else {
            for (int i5 = 0; i5 < this.i; i5++) {
                if (z2) {
                    k = this.f868a[i5].j();
                } else {
                    k = this.f868a[i5].k();
                }
                View c4 = c(k);
                if (c4 != null && c4 != e) {
                    return c4;
                }
            }
        }
        return null;
    }

    private int x(int i) {
        if (i == 17) {
            if (this.j == 0) {
                return -1;
            }
            return BleSignal.UNKNOWN_TX_POWER;
        }
        if (i == 33) {
            if (this.j == 1) {
                return -1;
            }
            return BleSignal.UNKNOWN_TX_POWER;
        }
        if (i == 66) {
            if (this.j == 0) {
                return 1;
            }
            return BleSignal.UNKNOWN_TX_POWER;
        }
        if (i == 130) {
            if (this.j == 1) {
                return 1;
            }
            return BleSignal.UNKNOWN_TX_POWER;
        }
        switch (i) {
            case 1:
                return (this.j != 1 && j()) ? 1 : -1;
            case 2:
                return (this.j != 1 && j()) ? -1 : 1;
            default:
                return BleSignal.UNKNOWN_TX_POWER;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends RecyclerView.j {

        /* renamed from: a, reason: collision with root package name */
        c f874a;
        boolean b;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(int i, int i2) {
            super(i, i2);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public boolean a() {
            return this.b;
        }

        public final int b() {
            c cVar = this.f874a;
            if (cVar == null) {
                return -1;
            }
            return cVar.e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        ArrayList<View> f875a = new ArrayList<>();
        int b = BleSignal.UNKNOWN_TX_POWER;
        int c = BleSignal.UNKNOWN_TX_POWER;
        int d = 0;
        final int e;

        c(int i) {
            this.e = i;
        }

        int a(int i) {
            int i2 = this.b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f875a.size() == 0) {
                return i;
            }
            a();
            return this.b;
        }

        void a() {
            LazySpanLookup.FullSpanItem f;
            View view = this.f875a.get(0);
            b c = c(view);
            this.b = StaggeredGridLayoutManager.this.b.a(view);
            if (c.b && (f = StaggeredGridLayoutManager.this.h.f(c.f())) != null && f.b == -1) {
                this.b -= f.a(this.e);
            }
        }

        int b() {
            int i = this.b;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            a();
            return this.b;
        }

        int b(int i) {
            int i2 = this.c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f875a.size() == 0) {
                return i;
            }
            c();
            return this.c;
        }

        void c() {
            LazySpanLookup.FullSpanItem f;
            ArrayList<View> arrayList = this.f875a;
            View view = arrayList.get(arrayList.size() - 1);
            b c = c(view);
            this.c = StaggeredGridLayoutManager.this.b.b(view);
            if (c.b && (f = StaggeredGridLayoutManager.this.h.f(c.f())) != null && f.b == 1) {
                this.c += f.a(this.e);
            }
        }

        int d() {
            int i = this.c;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            c();
            return this.c;
        }

        void a(View view) {
            b c = c(view);
            c.f874a = this;
            this.f875a.add(0, view);
            this.b = BleSignal.UNKNOWN_TX_POWER;
            if (this.f875a.size() == 1) {
                this.c = BleSignal.UNKNOWN_TX_POWER;
            }
            if (c.d() || c.e()) {
                this.d += StaggeredGridLayoutManager.this.b.e(view);
            }
        }

        void b(View view) {
            b c = c(view);
            c.f874a = this;
            this.f875a.add(view);
            this.c = BleSignal.UNKNOWN_TX_POWER;
            if (this.f875a.size() == 1) {
                this.b = BleSignal.UNKNOWN_TX_POWER;
            }
            if (c.d() || c.e()) {
                this.d += StaggeredGridLayoutManager.this.b.e(view);
            }
        }

        void a(boolean z, int i) {
            int a2;
            if (z) {
                a2 = b(BleSignal.UNKNOWN_TX_POWER);
            } else {
                a2 = a(BleSignal.UNKNOWN_TX_POWER);
            }
            e();
            if (a2 == Integer.MIN_VALUE) {
                return;
            }
            if (!z || a2 >= StaggeredGridLayoutManager.this.b.d()) {
                if (z || a2 <= StaggeredGridLayoutManager.this.b.c()) {
                    if (i != Integer.MIN_VALUE) {
                        a2 += i;
                    }
                    this.c = a2;
                    this.b = a2;
                }
            }
        }

        void e() {
            this.f875a.clear();
            f();
            this.d = 0;
        }

        void f() {
            this.b = BleSignal.UNKNOWN_TX_POWER;
            this.c = BleSignal.UNKNOWN_TX_POWER;
        }

        void c(int i) {
            this.b = i;
            this.c = i;
        }

        void g() {
            int size = this.f875a.size();
            View remove = this.f875a.remove(size - 1);
            b c = c(remove);
            c.f874a = null;
            if (c.d() || c.e()) {
                this.d -= StaggeredGridLayoutManager.this.b.e(remove);
            }
            if (size == 1) {
                this.b = BleSignal.UNKNOWN_TX_POWER;
            }
            this.c = BleSignal.UNKNOWN_TX_POWER;
        }

        void h() {
            View remove = this.f875a.remove(0);
            b c = c(remove);
            c.f874a = null;
            if (this.f875a.size() == 0) {
                this.c = BleSignal.UNKNOWN_TX_POWER;
            }
            if (c.d() || c.e()) {
                this.d -= StaggeredGridLayoutManager.this.b.e(remove);
            }
            this.b = BleSignal.UNKNOWN_TX_POWER;
        }

        public int i() {
            return this.d;
        }

        b c(View view) {
            return (b) view.getLayoutParams();
        }

        void d(int i) {
            int i2 = this.b;
            if (i2 != Integer.MIN_VALUE) {
                this.b = i2 + i;
            }
            int i3 = this.c;
            if (i3 != Integer.MIN_VALUE) {
                this.c = i3 + i;
            }
        }

        public int j() {
            if (StaggeredGridLayoutManager.this.d) {
                return a(this.f875a.size() - 1, -1, true);
            }
            return a(0, this.f875a.size(), true);
        }

        public int k() {
            if (StaggeredGridLayoutManager.this.d) {
                return a(0, this.f875a.size(), true);
            }
            return a(this.f875a.size() - 1, -1, true);
        }

        int a(int i, int i2, boolean z, boolean z2, boolean z3) {
            int c = StaggeredGridLayoutManager.this.b.c();
            int d = StaggeredGridLayoutManager.this.b.d();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f875a.get(i);
                int a2 = StaggeredGridLayoutManager.this.b.a(view);
                int b = StaggeredGridLayoutManager.this.b.b(view);
                boolean z4 = false;
                boolean z5 = !z3 ? a2 >= d : a2 > d;
                if (!z3 ? b > c : b >= c) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (z && z2) {
                        if (a2 >= c && b <= d) {
                            return StaggeredGridLayoutManager.this.d(view);
                        }
                    } else {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.d(view);
                        }
                        if (a2 < c || b > d) {
                            return StaggeredGridLayoutManager.this.d(view);
                        }
                    }
                }
                i += i3;
            }
            return -1;
        }

        int a(int i, int i2, boolean z) {
            return a(i, i2, false, false, z);
        }

        public View a(int i, int i2) {
            View view = null;
            if (i2 == -1) {
                int size = this.f875a.size();
                int i3 = 0;
                while (i3 < size) {
                    View view2 = this.f875a.get(i3);
                    if ((StaggeredGridLayoutManager.this.d && StaggeredGridLayoutManager.this.d(view2) <= i) || ((!StaggeredGridLayoutManager.this.d && StaggeredGridLayoutManager.this.d(view2) >= i) || !view2.hasFocusable())) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
            } else {
                int size2 = this.f875a.size() - 1;
                while (size2 >= 0) {
                    View view3 = this.f875a.get(size2);
                    if ((StaggeredGridLayoutManager.this.d && StaggeredGridLayoutManager.this.d(view3) >= i) || ((!StaggeredGridLayoutManager.this.d && StaggeredGridLayoutManager.this.d(view3) <= i) || !view3.hasFocusable())) {
                        break;
                    }
                    size2--;
                    view = view3;
                }
            }
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class LazySpanLookup {

        /* renamed from: a, reason: collision with root package name */
        int[] f870a;
        List<FullSpanItem> b;

        LazySpanLookup() {
        }

        int a(int i) {
            List<FullSpanItem> list = this.b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.b.get(size).f871a >= i) {
                        this.b.remove(size);
                    }
                }
            }
            return b(i);
        }

        int b(int i) {
            int[] iArr = this.f870a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            int g = g(i);
            if (g == -1) {
                int[] iArr2 = this.f870a;
                Arrays.fill(iArr2, i, iArr2.length, -1);
                return this.f870a.length;
            }
            int i2 = g + 1;
            Arrays.fill(this.f870a, i, i2, -1);
            return i2;
        }

        int c(int i) {
            int[] iArr = this.f870a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            return iArr[i];
        }

        void a(int i, c cVar) {
            e(i);
            this.f870a[i] = cVar.e;
        }

        int d(int i) {
            int length = this.f870a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        void e(int i) {
            int[] iArr = this.f870a;
            if (iArr == null) {
                this.f870a = new int[Math.max(i, 10) + 1];
                Arrays.fill(this.f870a, -1);
            } else if (i >= iArr.length) {
                this.f870a = new int[d(i)];
                System.arraycopy(iArr, 0, this.f870a, 0, iArr.length);
                int[] iArr2 = this.f870a;
                Arrays.fill(iArr2, iArr.length, iArr2.length, -1);
            }
        }

        void a() {
            int[] iArr = this.f870a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.b = null;
        }

        void a(int i, int i2) {
            int[] iArr = this.f870a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            e(i3);
            int[] iArr2 = this.f870a;
            System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
            int[] iArr3 = this.f870a;
            Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
            c(i, i2);
        }

        private void c(int i, int i2) {
            List<FullSpanItem> list = this.b;
            if (list == null) {
                return;
            }
            int i3 = i + i2;
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.b.get(size);
                if (fullSpanItem.f871a >= i) {
                    if (fullSpanItem.f871a < i3) {
                        this.b.remove(size);
                    } else {
                        fullSpanItem.f871a -= i2;
                    }
                }
            }
        }

        void b(int i, int i2) {
            int[] iArr = this.f870a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            e(i3);
            int[] iArr2 = this.f870a;
            System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
            Arrays.fill(this.f870a, i, i3, -1);
            d(i, i2);
        }

        private void d(int i, int i2) {
            List<FullSpanItem> list = this.b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.b.get(size);
                if (fullSpanItem.f871a >= i) {
                    fullSpanItem.f871a += i2;
                }
            }
        }

        private int g(int i) {
            if (this.b == null) {
                return -1;
            }
            FullSpanItem f = f(i);
            if (f != null) {
                this.b.remove(f);
            }
            int size = this.b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                }
                if (this.b.get(i2).f871a >= i) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return -1;
            }
            FullSpanItem fullSpanItem = this.b.get(i2);
            this.b.remove(i2);
            return fullSpanItem.f871a;
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = this.b.get(i);
                if (fullSpanItem2.f871a == fullSpanItem.f871a) {
                    this.b.remove(i);
                }
                if (fullSpanItem2.f871a >= fullSpanItem.f871a) {
                    this.b.add(i, fullSpanItem);
                    return;
                }
            }
            this.b.add(fullSpanItem);
        }

        public FullSpanItem f(int i) {
            List<FullSpanItem> list = this.b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.b.get(size);
                if (fullSpanItem.f871a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem a(int i, int i2, int i3, boolean z) {
            List<FullSpanItem> list = this.b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = this.b.get(i4);
                if (fullSpanItem.f871a >= i2) {
                    return null;
                }
                if (fullSpanItem.f871a >= i && (i3 == 0 || fullSpanItem.b == i3 || (z && fullSpanItem.d))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.1
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public FullSpanItem[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            };

            /* renamed from: a, reason: collision with root package name */
            int f871a;
            int b;
            int[] c;
            boolean d;

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            FullSpanItem(Parcel parcel) {
                this.f871a = parcel.readInt();
                this.b = parcel.readInt();
                this.d = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.c = new int[readInt];
                    parcel.readIntArray(this.c);
                }
            }

            FullSpanItem() {
            }

            int a(int i) {
                int[] iArr = this.c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f871a);
                parcel.writeInt(this.b);
                parcel.writeInt(this.d ? 1 : 0);
                int[] iArr = this.c;
                if (iArr != null && iArr.length > 0) {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.c);
                } else {
                    parcel.writeInt(0);
                }
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f871a + ", mGapDir=" + this.b + ", mHasUnwantedGapAfter=" + this.d + ", mGapPerSpan=" + Arrays.toString(this.c) + '}';
            }
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        int f872a;
        int b;
        int c;
        int[] d;
        int e;
        int[] f;
        List<LazySpanLookup.FullSpanItem> g;
        boolean h;
        boolean i;
        boolean j;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f872a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            int i = this.c;
            if (i > 0) {
                this.d = new int[i];
                parcel.readIntArray(this.d);
            }
            this.e = parcel.readInt();
            int i2 = this.e;
            if (i2 > 0) {
                this.f = new int[i2];
                parcel.readIntArray(this.f);
            }
            this.h = parcel.readInt() == 1;
            this.i = parcel.readInt() == 1;
            this.j = parcel.readInt() == 1;
            this.g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.c = savedState.c;
            this.f872a = savedState.f872a;
            this.b = savedState.b;
            this.d = savedState.d;
            this.e = savedState.e;
            this.f = savedState.f;
            this.h = savedState.h;
            this.i = savedState.i;
            this.j = savedState.j;
            this.g = savedState.g;
        }

        void a() {
            this.d = null;
            this.c = 0;
            this.e = 0;
            this.f = null;
            this.g = null;
        }

        void b() {
            this.d = null;
            this.c = 0;
            this.f872a = -1;
            this.b = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f872a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            if (this.c > 0) {
                parcel.writeIntArray(this.d);
            }
            parcel.writeInt(this.e);
            if (this.e > 0) {
                parcel.writeIntArray(this.f);
            }
            parcel.writeInt(this.h ? 1 : 0);
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeList(this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        int f873a;
        int b;
        boolean c;
        boolean d;
        boolean e;
        int[] f;

        a() {
            a();
        }

        void a() {
            this.f873a = -1;
            this.b = BleSignal.UNKNOWN_TX_POWER;
            this.c = false;
            this.d = false;
            this.e = false;
            int[] iArr = this.f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        void a(c[] cVarArr) {
            int length = cVarArr.length;
            int[] iArr = this.f;
            if (iArr == null || iArr.length < length) {
                this.f = new int[StaggeredGridLayoutManager.this.f868a.length];
            }
            for (int i = 0; i < length; i++) {
                this.f[i] = cVarArr[i].a(BleSignal.UNKNOWN_TX_POWER);
            }
        }

        void b() {
            this.b = this.c ? StaggeredGridLayoutManager.this.b.d() : StaggeredGridLayoutManager.this.b.c();
        }

        void a(int i) {
            if (this.c) {
                this.b = StaggeredGridLayoutManager.this.b.d() - i;
            } else {
                this.b = StaggeredGridLayoutManager.this.b.c() + i;
            }
        }
    }
}
