package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.gcloudsdk.gcloud.voice.GCloudVoiceErrorCode;
import com.google.android.gms.nearby.messages.BleSignal;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.i implements RecyclerView.s.b {

    /* renamed from: a, reason: collision with root package name */
    private c f842a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private final b g;
    private int h;
    int i;
    i j;
    boolean k;
    int l;
    int m;
    SavedState n;
    final a o;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView.p pVar, RecyclerView.t tVar, a aVar, int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean d() {
        return true;
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.i = 1;
        this.c = false;
        this.k = false;
        this.d = false;
        this.e = true;
        this.l = -1;
        this.m = BleSignal.UNKNOWN_TX_POWER;
        this.n = null;
        this.o = new a();
        this.g = new b();
        this.h = 2;
        b(i);
        b(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.i = 1;
        this.c = false;
        this.k = false;
        this.d = false;
        this.e = true;
        this.l = -1;
        this.m = BleSignal.UNKNOWN_TX_POWER;
        this.n = null;
        this.o = new a();
        this.g = new b();
        this.h = 2;
        RecyclerView.i.b a2 = a(context, attributeSet, i, i2);
        b(a2.f859a);
        b(a2.c);
        a(a2.d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.j a() {
        return new RecyclerView.j(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, RecyclerView.p pVar) {
        super.a(recyclerView, pVar);
        if (this.f) {
            c(pVar);
            pVar.a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (y() > 0) {
            accessibilityEvent.setFromIndex(n());
            accessibilityEvent.setToIndex(p());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public Parcelable e() {
        SavedState savedState = this.n;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        if (y() > 0) {
            j();
            boolean z = this.b ^ this.k;
            savedState2.c = z;
            if (z) {
                View P = P();
                savedState2.b = this.j.d() - this.j.b(P);
                savedState2.f843a = d(P);
            } else {
                View O = O();
                savedState2.f843a = d(O);
                savedState2.b = this.j.a(O) - this.j.c();
            }
        } else {
            savedState2.b();
        }
        return savedState2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.n = (SavedState) parcelable;
            r();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean f() {
        return this.i == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean g() {
        return this.i == 1;
    }

    public void a(boolean z) {
        a((String) null);
        if (this.d == z) {
            return;
        }
        this.d = z;
        r();
    }

    public int h() {
        return this.i;
    }

    public void b(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        a((String) null);
        if (i != this.i || this.j == null) {
            this.j = i.a(this, i);
            this.o.f844a = this.j;
            this.i = i;
            r();
        }
    }

    private void b() {
        if (this.i == 1 || !i()) {
            this.k = this.c;
        } else {
            this.k = !this.c;
        }
    }

    public void b(boolean z) {
        a((String) null);
        if (z == this.c) {
            return;
        }
        this.c = z;
        r();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public View c(int i) {
        int y = y();
        if (y == 0) {
            return null;
        }
        int d = i - d(i(0));
        if (d >= 0 && d < y) {
            View i2 = i(d);
            if (d(i2) == i) {
                return i2;
            }
        }
        return super.c(i);
    }

    protected int b(RecyclerView.t tVar) {
        if (tVar.d()) {
            return this.j.f();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, RecyclerView.t tVar, int i) {
        g gVar = new g(recyclerView.getContext());
        gVar.c(i);
        a(gVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s.b
    public PointF d(int i) {
        if (y() == 0) {
            return null;
        }
        int i2 = (i < d(i(0))) != this.k ? -1 : 1;
        if (this.i == 0) {
            return new PointF(i2, 0.0f);
        }
        return new PointF(0.0f, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void c(RecyclerView.p pVar, RecyclerView.t tVar) {
        int i;
        int i2;
        int i3;
        int i4;
        View c2;
        int a2;
        int i5 = -1;
        if ((this.n != null || this.l != -1) && tVar.e() == 0) {
            c(pVar);
            return;
        }
        SavedState savedState = this.n;
        if (savedState != null && savedState.a()) {
            this.l = this.n.f843a;
        }
        j();
        this.f842a.f846a = false;
        b();
        View H = H();
        if (!this.o.e || this.l != -1 || this.n != null) {
            this.o.a();
            a aVar = this.o;
            aVar.d = this.k ^ this.d;
            a(pVar, tVar, aVar);
            this.o.e = true;
        } else if (H != null && (this.j.a(H) >= this.j.d() || this.j.b(H) <= this.j.c())) {
            this.o.a(H, d(H));
        }
        int b2 = b(tVar);
        if (this.f842a.j >= 0) {
            i = b2;
            b2 = 0;
        } else {
            i = 0;
        }
        int c3 = b2 + this.j.c();
        int g = i + this.j.g();
        if (tVar.a() && (i4 = this.l) != -1 && this.m != Integer.MIN_VALUE && (c2 = c(i4)) != null) {
            if (this.k) {
                a2 = (this.j.d() - this.j.b(c2)) - this.m;
            } else {
                a2 = this.m - (this.j.a(c2) - this.j.c());
            }
            if (a2 > 0) {
                c3 += a2;
            } else {
                g -= a2;
            }
        }
        if (this.o.d) {
            if (this.k) {
                i5 = 1;
            }
        } else if (!this.k) {
            i5 = 1;
        }
        a(pVar, tVar, this.o, i5);
        a(pVar);
        this.f842a.l = l();
        this.f842a.i = tVar.a();
        if (this.o.d) {
            b(this.o);
            c cVar = this.f842a;
            cVar.h = c3;
            a(pVar, cVar, tVar, false);
            i3 = this.f842a.b;
            int i6 = this.f842a.d;
            if (this.f842a.c > 0) {
                g += this.f842a.c;
            }
            a(this.o);
            c cVar2 = this.f842a;
            cVar2.h = g;
            cVar2.d += this.f842a.e;
            a(pVar, this.f842a, tVar, false);
            i2 = this.f842a.b;
            if (this.f842a.c > 0) {
                int i7 = this.f842a.c;
                h(i6, i3);
                c cVar3 = this.f842a;
                cVar3.h = i7;
                a(pVar, cVar3, tVar, false);
                i3 = this.f842a.b;
            }
        } else {
            a(this.o);
            c cVar4 = this.f842a;
            cVar4.h = g;
            a(pVar, cVar4, tVar, false);
            i2 = this.f842a.b;
            int i8 = this.f842a.d;
            if (this.f842a.c > 0) {
                c3 += this.f842a.c;
            }
            b(this.o);
            c cVar5 = this.f842a;
            cVar5.h = c3;
            cVar5.d += this.f842a.e;
            a(pVar, this.f842a, tVar, false);
            i3 = this.f842a.b;
            if (this.f842a.c > 0) {
                int i9 = this.f842a.c;
                a(i8, i2);
                c cVar6 = this.f842a;
                cVar6.h = i9;
                a(pVar, cVar6, tVar, false);
                i2 = this.f842a.b;
            }
        }
        if (y() > 0) {
            if (this.k ^ this.d) {
                int a3 = a(i2, pVar, tVar, true);
                int i10 = i3 + a3;
                int i11 = i2 + a3;
                int b3 = b(i10, pVar, tVar, false);
                i3 = i10 + b3;
                i2 = i11 + b3;
            } else {
                int b4 = b(i3, pVar, tVar, true);
                int i12 = i3 + b4;
                int i13 = i2 + b4;
                int a4 = a(i13, pVar, tVar, false);
                i3 = i12 + a4;
                i2 = i13 + a4;
            }
        }
        b(pVar, tVar, i3, i2);
        if (!tVar.a()) {
            this.j.a();
        } else {
            this.o.a();
        }
        this.b = this.d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView.t tVar) {
        super.a(tVar);
        this.n = null;
        this.l = -1;
        this.m = BleSignal.UNKNOWN_TX_POWER;
        this.o.a();
    }

    private void b(RecyclerView.p pVar, RecyclerView.t tVar, int i, int i2) {
        if (!tVar.b() || y() == 0 || tVar.a() || !c()) {
            return;
        }
        List<RecyclerView.w> c2 = pVar.c();
        int size = c2.size();
        int d = d(i(0));
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView.w wVar = c2.get(i5);
            if (!wVar.isRemoved()) {
                if (((wVar.getLayoutPosition() < d) != this.k ? (char) 65535 : (char) 1) == 65535) {
                    i3 += this.j.e(wVar.itemView);
                } else {
                    i4 += this.j.e(wVar.itemView);
                }
            }
        }
        this.f842a.k = c2;
        if (i3 > 0) {
            h(d(O()), i);
            c cVar = this.f842a;
            cVar.h = i3;
            cVar.c = 0;
            cVar.a();
            a(pVar, this.f842a, tVar, false);
        }
        if (i4 > 0) {
            a(d(P()), i2);
            c cVar2 = this.f842a;
            cVar2.h = i4;
            cVar2.c = 0;
            cVar2.a();
            a(pVar, this.f842a, tVar, false);
        }
        this.f842a.k = null;
    }

    private void a(RecyclerView.p pVar, RecyclerView.t tVar, a aVar) {
        if (a(tVar, aVar) || b(pVar, tVar, aVar)) {
            return;
        }
        aVar.b();
        aVar.b = this.d ? tVar.e() - 1 : 0;
    }

    private boolean b(RecyclerView.p pVar, RecyclerView.t tVar, a aVar) {
        View g;
        int c2;
        if (y() == 0) {
            return false;
        }
        View H = H();
        if (H != null && aVar.a(H, tVar)) {
            aVar.a(H, d(H));
            return true;
        }
        if (this.b != this.d) {
            return false;
        }
        if (aVar.d) {
            g = f(pVar, tVar);
        } else {
            g = g(pVar, tVar);
        }
        if (g == null) {
            return false;
        }
        aVar.b(g, d(g));
        if (!tVar.a() && c()) {
            if (this.j.a(g) >= this.j.d() || this.j.b(g) < this.j.c()) {
                if (aVar.d) {
                    c2 = this.j.d();
                } else {
                    c2 = this.j.c();
                }
                aVar.c = c2;
            }
        }
        return true;
    }

    private boolean a(RecyclerView.t tVar, a aVar) {
        int i;
        int a2;
        if (tVar.a() || (i = this.l) == -1) {
            return false;
        }
        if (i < 0 || i >= tVar.e()) {
            this.l = -1;
            this.m = BleSignal.UNKNOWN_TX_POWER;
            return false;
        }
        aVar.b = this.l;
        SavedState savedState = this.n;
        if (savedState != null && savedState.a()) {
            aVar.d = this.n.c;
            if (aVar.d) {
                aVar.c = this.j.d() - this.n.b;
            } else {
                aVar.c = this.j.c() + this.n.b;
            }
            return true;
        }
        if (this.m == Integer.MIN_VALUE) {
            View c2 = c(this.l);
            if (c2 != null) {
                if (this.j.e(c2) > this.j.f()) {
                    aVar.b();
                    return true;
                }
                if (this.j.a(c2) - this.j.c() < 0) {
                    aVar.c = this.j.c();
                    aVar.d = false;
                    return true;
                }
                if (this.j.d() - this.j.b(c2) < 0) {
                    aVar.c = this.j.d();
                    aVar.d = true;
                    return true;
                }
                if (aVar.d) {
                    a2 = this.j.b(c2) + this.j.b();
                } else {
                    a2 = this.j.a(c2);
                }
                aVar.c = a2;
            } else {
                if (y() > 0) {
                    aVar.d = (this.l < d(i(0))) == this.k;
                }
                aVar.b();
            }
            return true;
        }
        boolean z = this.k;
        aVar.d = z;
        if (z) {
            aVar.c = this.j.d() - this.m;
        } else {
            aVar.c = this.j.c() + this.m;
        }
        return true;
    }

    private int a(int i, RecyclerView.p pVar, RecyclerView.t tVar, boolean z) {
        int d;
        int d2 = this.j.d() - i;
        if (d2 <= 0) {
            return 0;
        }
        int i2 = -c(-d2, pVar, tVar);
        int i3 = i + i2;
        if (!z || (d = this.j.d() - i3) <= 0) {
            return i2;
        }
        this.j.a(d);
        return d + i2;
    }

    private int b(int i, RecyclerView.p pVar, RecyclerView.t tVar, boolean z) {
        int c2;
        int c3 = i - this.j.c();
        if (c3 <= 0) {
            return 0;
        }
        int i2 = -c(c3, pVar, tVar);
        int i3 = i + i2;
        if (!z || (c2 = i3 - this.j.c()) <= 0) {
            return i2;
        }
        this.j.a(-c2);
        return i2 - c2;
    }

    private void a(a aVar) {
        a(aVar.b, aVar.c);
    }

    private void a(int i, int i2) {
        this.f842a.c = this.j.d() - i2;
        this.f842a.e = this.k ? -1 : 1;
        c cVar = this.f842a;
        cVar.d = i;
        cVar.f = 1;
        cVar.b = i2;
        cVar.g = BleSignal.UNKNOWN_TX_POWER;
    }

    private void b(a aVar) {
        h(aVar.b, aVar.c);
    }

    private void h(int i, int i2) {
        this.f842a.c = i2 - this.j.c();
        c cVar = this.f842a;
        cVar.d = i;
        cVar.e = this.k ? 1 : -1;
        c cVar2 = this.f842a;
        cVar2.f = -1;
        cVar2.b = i2;
        cVar2.g = BleSignal.UNKNOWN_TX_POWER;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i() {
        return w() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        if (this.f842a == null) {
            this.f842a = k();
        }
    }

    c k() {
        return new c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void e(int i) {
        this.l = i;
        this.m = BleSignal.UNKNOWN_TX_POWER;
        SavedState savedState = this.n;
        if (savedState != null) {
            savedState.b();
        }
        r();
    }

    public void b(int i, int i2) {
        this.l = i;
        this.m = i2;
        SavedState savedState = this.n;
        if (savedState != null) {
            savedState.b();
        }
        r();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int a(int i, RecyclerView.p pVar, RecyclerView.t tVar) {
        if (this.i == 1) {
            return 0;
        }
        return c(i, pVar, tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int b(int i, RecyclerView.p pVar, RecyclerView.t tVar) {
        if (this.i == 0) {
            return 0;
        }
        return c(i, pVar, tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int c(RecyclerView.t tVar) {
        return i(tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int d(RecyclerView.t tVar) {
        return i(tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int e(RecyclerView.t tVar) {
        return j(tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int f(RecyclerView.t tVar) {
        return j(tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int g(RecyclerView.t tVar) {
        return k(tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int h(RecyclerView.t tVar) {
        return k(tVar);
    }

    private int i(RecyclerView.t tVar) {
        if (y() == 0) {
            return 0;
        }
        j();
        return k.a(tVar, this.j, a(!this.e, true), b(!this.e, true), this, this.e, this.k);
    }

    private int j(RecyclerView.t tVar) {
        if (y() == 0) {
            return 0;
        }
        j();
        return k.a(tVar, this.j, a(!this.e, true), b(!this.e, true), this, this.e);
    }

    private int k(RecyclerView.t tVar) {
        if (y() == 0) {
            return 0;
        }
        j();
        return k.b(tVar, this.j, a(!this.e, true), b(!this.e, true), this, this.e);
    }

    private void a(int i, int i2, boolean z, RecyclerView.t tVar) {
        int c2;
        this.f842a.l = l();
        this.f842a.h = b(tVar);
        c cVar = this.f842a;
        cVar.f = i;
        if (i == 1) {
            cVar.h += this.j.g();
            View P = P();
            this.f842a.e = this.k ? -1 : 1;
            this.f842a.d = d(P) + this.f842a.e;
            this.f842a.b = this.j.b(P);
            c2 = this.j.b(P) - this.j.d();
        } else {
            View O = O();
            this.f842a.h += this.j.c();
            this.f842a.e = this.k ? 1 : -1;
            this.f842a.d = d(O) + this.f842a.e;
            this.f842a.b = this.j.a(O);
            c2 = (-this.j.a(O)) + this.j.c();
        }
        c cVar2 = this.f842a;
        cVar2.c = i2;
        if (z) {
            cVar2.c -= c2;
        }
        this.f842a.g = c2;
    }

    boolean l() {
        return this.j.h() == 0 && this.j.e() == 0;
    }

    void a(RecyclerView.t tVar, c cVar, RecyclerView.i.a aVar) {
        int i = cVar.d;
        if (i < 0 || i >= tVar.e()) {
            return;
        }
        aVar.b(i, Math.max(0, cVar.g));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(int i, RecyclerView.i.a aVar) {
        boolean z;
        int i2;
        SavedState savedState = this.n;
        if (savedState != null && savedState.a()) {
            z = this.n.c;
            i2 = this.n.f843a;
        } else {
            b();
            z = this.k;
            i2 = this.l;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.h && i2 >= 0 && i2 < i; i4++) {
            aVar.b(i2, 0);
            i2 += i3;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(int i, int i2, RecyclerView.t tVar, RecyclerView.i.a aVar) {
        if (this.i != 0) {
            i = i2;
        }
        if (y() == 0 || i == 0) {
            return;
        }
        j();
        a(i > 0 ? 1 : -1, Math.abs(i), true, tVar);
        a(tVar, this.f842a, aVar);
    }

    int c(int i, RecyclerView.p pVar, RecyclerView.t tVar) {
        if (y() == 0 || i == 0) {
            return 0;
        }
        this.f842a.f846a = true;
        j();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        a(i2, abs, true, tVar);
        int a2 = this.f842a.g + a(pVar, this.f842a, tVar, false);
        if (a2 < 0) {
            return 0;
        }
        if (abs > a2) {
            i = i2 * a2;
        }
        this.j.a(-i);
        this.f842a.j = i;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(String str) {
        if (this.n == null) {
            super.a(str);
        }
    }

    private void a(RecyclerView.p pVar, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                a(i, pVar);
                i--;
            }
        } else {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                a(i3, pVar);
            }
        }
    }

    private void a(RecyclerView.p pVar, int i) {
        if (i < 0) {
            return;
        }
        int y = y();
        if (!this.k) {
            for (int i2 = 0; i2 < y; i2++) {
                View i3 = i(i2);
                if (this.j.b(i3) > i || this.j.c(i3) > i) {
                    a(pVar, 0, i2);
                    return;
                }
            }
            return;
        }
        int i4 = y - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            View i6 = i(i5);
            if (this.j.b(i6) > i || this.j.c(i6) > i) {
                a(pVar, i4, i5);
                return;
            }
        }
    }

    private void b(RecyclerView.p pVar, int i) {
        int y = y();
        if (i < 0) {
            return;
        }
        int e = this.j.e() - i;
        if (this.k) {
            for (int i2 = 0; i2 < y; i2++) {
                View i3 = i(i2);
                if (this.j.a(i3) < e || this.j.d(i3) < e) {
                    a(pVar, 0, i2);
                    return;
                }
            }
            return;
        }
        int i4 = y - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            View i6 = i(i5);
            if (this.j.a(i6) < e || this.j.d(i6) < e) {
                a(pVar, i4, i5);
                return;
            }
        }
    }

    private void a(RecyclerView.p pVar, c cVar) {
        if (!cVar.f846a || cVar.l) {
            return;
        }
        if (cVar.f == -1) {
            b(pVar, cVar.g);
        } else {
            a(pVar, cVar.g);
        }
    }

    int a(RecyclerView.p pVar, c cVar, RecyclerView.t tVar, boolean z) {
        int i = cVar.c;
        if (cVar.g != Integer.MIN_VALUE) {
            if (cVar.c < 0) {
                cVar.g += cVar.c;
            }
            a(pVar, cVar);
        }
        int i2 = cVar.c + cVar.h;
        b bVar = this.g;
        while (true) {
            if ((!cVar.l && i2 <= 0) || !cVar.a(tVar)) {
                break;
            }
            bVar.a();
            a(pVar, tVar, cVar, bVar);
            if (!bVar.b) {
                cVar.b += bVar.f845a * cVar.f;
                if (!bVar.c || this.f842a.k != null || !tVar.a()) {
                    cVar.c -= bVar.f845a;
                    i2 -= bVar.f845a;
                }
                if (cVar.g != Integer.MIN_VALUE) {
                    cVar.g += bVar.f845a;
                    if (cVar.c < 0) {
                        cVar.g += cVar.c;
                    }
                    a(pVar, cVar);
                }
                if (z && bVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.c;
    }

    void a(RecyclerView.p pVar, RecyclerView.t tVar, c cVar, b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int f;
        View a2 = cVar.a(pVar);
        if (a2 == null) {
            bVar.b = true;
            return;
        }
        RecyclerView.j jVar = (RecyclerView.j) a2.getLayoutParams();
        if (cVar.k == null) {
            if (this.k == (cVar.f == -1)) {
                b(a2);
            } else {
                b(a2, 0);
            }
        } else {
            if (this.k == (cVar.f == -1)) {
                a(a2);
            } else {
                a(a2, 0);
            }
        }
        a(a2, 0, 0);
        bVar.f845a = this.j.e(a2);
        if (this.i == 1) {
            if (i()) {
                f = B() - F();
                i4 = f - this.j.f(a2);
            } else {
                i4 = D();
                f = this.j.f(a2) + i4;
            }
            if (cVar.f == -1) {
                int i5 = cVar.b;
                i2 = cVar.b - bVar.f845a;
                i = f;
                i3 = i5;
            } else {
                int i6 = cVar.b;
                i3 = cVar.b + bVar.f845a;
                i = f;
                i2 = i6;
            }
        } else {
            int E = E();
            int f2 = this.j.f(a2) + E;
            if (cVar.f == -1) {
                i2 = E;
                i = cVar.b;
                i3 = f2;
                i4 = cVar.b - bVar.f845a;
            } else {
                int i7 = cVar.b;
                i = cVar.b + bVar.f845a;
                i2 = E;
                i3 = f2;
                i4 = i7;
            }
        }
        a(a2, i4, i2, i, i3);
        if (jVar.d() || jVar.e()) {
            bVar.c = true;
        }
        bVar.d = a2.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    boolean m() {
        return (A() == 1073741824 || z() == 1073741824 || !N()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f(int i) {
        if (i == 17) {
            if (this.i == 0) {
                return -1;
            }
            return BleSignal.UNKNOWN_TX_POWER;
        }
        if (i == 33) {
            if (this.i == 1) {
                return -1;
            }
            return BleSignal.UNKNOWN_TX_POWER;
        }
        if (i == 66) {
            if (this.i == 0) {
                return 1;
            }
            return BleSignal.UNKNOWN_TX_POWER;
        }
        if (i == 130) {
            if (this.i == 1) {
                return 1;
            }
            return BleSignal.UNKNOWN_TX_POWER;
        }
        switch (i) {
            case 1:
                return (this.i != 1 && i()) ? 1 : -1;
            case 2:
                return (this.i != 1 && i()) ? -1 : 1;
            default:
                return BleSignal.UNKNOWN_TX_POWER;
        }
    }

    private View O() {
        return i(this.k ? y() - 1 : 0);
    }

    private View P() {
        return i(this.k ? 0 : y() - 1);
    }

    private View a(boolean z, boolean z2) {
        if (this.k) {
            return a(y() - 1, -1, z, z2);
        }
        return a(0, y(), z, z2);
    }

    private View b(boolean z, boolean z2) {
        if (this.k) {
            return a(0, y(), z, z2);
        }
        return a(y() - 1, -1, z, z2);
    }

    private View f(RecyclerView.p pVar, RecyclerView.t tVar) {
        return this.k ? h(pVar, tVar) : i(pVar, tVar);
    }

    private View g(RecyclerView.p pVar, RecyclerView.t tVar) {
        return this.k ? i(pVar, tVar) : h(pVar, tVar);
    }

    private View h(RecyclerView.p pVar, RecyclerView.t tVar) {
        return a(pVar, tVar, 0, y(), tVar.e());
    }

    private View i(RecyclerView.p pVar, RecyclerView.t tVar) {
        return a(pVar, tVar, y() - 1, -1, tVar.e());
    }

    View a(RecyclerView.p pVar, RecyclerView.t tVar, int i, int i2, int i3) {
        j();
        int c2 = this.j.c();
        int d = this.j.d();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View i5 = i(i);
            int d2 = d(i5);
            if (d2 >= 0 && d2 < i3) {
                if (((RecyclerView.j) i5.getLayoutParams()).d()) {
                    if (view2 == null) {
                        view2 = i5;
                    }
                } else {
                    if (this.j.a(i5) < d && this.j.b(i5) >= c2) {
                        return i5;
                    }
                    if (view == null) {
                        view = i5;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    private View j(RecyclerView.p pVar, RecyclerView.t tVar) {
        return this.k ? l(pVar, tVar) : m(pVar, tVar);
    }

    private View k(RecyclerView.p pVar, RecyclerView.t tVar) {
        return this.k ? m(pVar, tVar) : l(pVar, tVar);
    }

    private View l(RecyclerView.p pVar, RecyclerView.t tVar) {
        return c(0, y());
    }

    private View m(RecyclerView.p pVar, RecyclerView.t tVar) {
        return c(y() - 1, -1);
    }

    public int n() {
        View a2 = a(0, y(), false, true);
        if (a2 == null) {
            return -1;
        }
        return d(a2);
    }

    public int o() {
        View a2 = a(0, y(), true, false);
        if (a2 == null) {
            return -1;
        }
        return d(a2);
    }

    public int p() {
        View a2 = a(y() - 1, -1, false, true);
        if (a2 == null) {
            return -1;
        }
        return d(a2);
    }

    public int q() {
        View a2 = a(y() - 1, -1, true, false);
        if (a2 == null) {
            return -1;
        }
        return d(a2);
    }

    View a(int i, int i2, boolean z, boolean z2) {
        j();
        int i3 = z ? GCloudVoiceErrorCode.GCloudVoiceCompleteCode.GV_ON_PUNISHED : 320;
        int i4 = z2 ? 320 : 0;
        if (this.i == 0) {
            return this.r.a(i, i2, i3, i4);
        }
        return this.s.a(i, i2, i3, i4);
    }

    View c(int i, int i2) {
        int i3;
        int i4;
        j();
        if ((i2 > i ? (char) 1 : i2 < i ? (char) 65535 : (char) 0) == 0) {
            return i(i);
        }
        if (this.j.a(i(i)) < this.j.c()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        if (this.i == 0) {
            return this.r.a(i, i2, i3, i4);
        }
        return this.s.a(i, i2, i3, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public View a(View view, int i, RecyclerView.p pVar, RecyclerView.t tVar) {
        int f;
        View j;
        View P;
        b();
        if (y() == 0 || (f = f(i)) == Integer.MIN_VALUE) {
            return null;
        }
        j();
        j();
        a(f, (int) (this.j.f() * 0.33333334f), false, tVar);
        c cVar = this.f842a;
        cVar.g = BleSignal.UNKNOWN_TX_POWER;
        cVar.f846a = false;
        a(pVar, cVar, tVar, true);
        if (f == -1) {
            j = k(pVar, tVar);
        } else {
            j = j(pVar, tVar);
        }
        if (f == -1) {
            P = O();
        } else {
            P = P();
        }
        if (!P.hasFocusable()) {
            return j;
        }
        if (j == null) {
            return null;
        }
        return P;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean c() {
        return this.n == null && this.b == this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int j;
        boolean l;

        /* renamed from: a, reason: collision with root package name */
        boolean f846a = true;
        int h = 0;
        boolean i = false;
        List<RecyclerView.w> k = null;

        c() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(RecyclerView.t tVar) {
            int i = this.d;
            return i >= 0 && i < tVar.e();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View a(RecyclerView.p pVar) {
            if (this.k != null) {
                return b();
            }
            View c = pVar.c(this.d);
            this.d += this.e;
            return c;
        }

        private View b() {
            int size = this.k.size();
            for (int i = 0; i < size; i++) {
                View view = this.k.get(i).itemView;
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                if (!jVar.d() && this.d == jVar.f()) {
                    a(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            a((View) null);
        }

        public void a(View view) {
            View b = b(view);
            if (b == null) {
                this.d = -1;
            } else {
                this.d = ((RecyclerView.j) b.getLayoutParams()).f();
            }
        }

        public View b(View view) {
            int f;
            int size = this.k.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.k.get(i2).itemView;
                RecyclerView.j jVar = (RecyclerView.j) view3.getLayoutParams();
                if (view3 != view && !jVar.d() && (f = (jVar.f() - this.d) * this.e) >= 0 && f < i) {
                    if (f == 0) {
                        return view3;
                    }
                    view2 = view3;
                    i = f;
                }
            }
            return view2;
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.recyclerview.widget.LinearLayoutManager.SavedState.1
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
        int f843a;
        int b;
        boolean c;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f843a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.f843a = savedState.f843a;
            this.b = savedState.b;
            this.c = savedState.c;
        }

        boolean a() {
            return this.f843a >= 0;
        }

        void b() {
            this.f843a = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f843a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        i f844a;
        int b;
        int c;
        boolean d;
        boolean e;

        a() {
            a();
        }

        void a() {
            this.b = -1;
            this.c = BleSignal.UNKNOWN_TX_POWER;
            this.d = false;
            this.e = false;
        }

        void b() {
            int c;
            if (this.d) {
                c = this.f844a.d();
            } else {
                c = this.f844a.c();
            }
            this.c = c;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.b + ", mCoordinate=" + this.c + ", mLayoutFromEnd=" + this.d + ", mValid=" + this.e + '}';
        }

        boolean a(View view, RecyclerView.t tVar) {
            RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
            return !jVar.d() && jVar.f() >= 0 && jVar.f() < tVar.e();
        }

        public void a(View view, int i) {
            int b = this.f844a.b();
            if (b >= 0) {
                b(view, i);
                return;
            }
            this.b = i;
            if (this.d) {
                int d = (this.f844a.d() - b) - this.f844a.b(view);
                this.c = this.f844a.d() - d;
                if (d > 0) {
                    int e = this.c - this.f844a.e(view);
                    int c = this.f844a.c();
                    int min = e - (c + Math.min(this.f844a.a(view) - c, 0));
                    if (min < 0) {
                        this.c += Math.min(d, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int a2 = this.f844a.a(view);
            int c2 = a2 - this.f844a.c();
            this.c = a2;
            if (c2 > 0) {
                int d2 = (this.f844a.d() - Math.min(0, (this.f844a.d() - b) - this.f844a.b(view))) - (a2 + this.f844a.e(view));
                if (d2 < 0) {
                    this.c -= Math.min(c2, -d2);
                }
            }
        }

        public void b(View view, int i) {
            if (this.d) {
                this.c = this.f844a.b(view) + this.f844a.b();
            } else {
                this.c = this.f844a.a(view);
            }
            this.b = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f845a;
        public boolean b;
        public boolean c;
        public boolean d;

        protected b() {
        }

        void a() {
            this.f845a = 0;
            this.b = false;
            this.c = false;
            this.d = false;
        }
    }
}
