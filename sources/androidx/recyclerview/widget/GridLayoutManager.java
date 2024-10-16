package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.f.a.d;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {

    /* renamed from: a, reason: collision with root package name */
    boolean f840a;
    int b;
    int[] c;
    View[] d;
    final SparseIntArray e;
    final SparseIntArray f;
    c g;
    final Rect h;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f840a = false;
        this.b = -1;
        this.e = new SparseIntArray();
        this.f = new SparseIntArray();
        this.g = new a();
        this.h = new Rect();
        a(a(context, attributeSet, i, i2).b);
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        this.f840a = false;
        this.b = -1;
        this.e = new SparseIntArray();
        this.f = new SparseIntArray();
        this.g = new a();
        this.h = new Rect();
        a(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        this.f840a = false;
        this.b = -1;
        this.e = new SparseIntArray();
        this.f = new SparseIntArray();
        this.g = new a();
        this.h = new Rect();
        a(i);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void a(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.a(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int a(RecyclerView.p pVar, RecyclerView.t tVar) {
        if (this.i == 0) {
            return this.b;
        }
        if (tVar.e() < 1) {
            return 0;
        }
        return a(pVar, tVar, tVar.e() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int b(RecyclerView.p pVar, RecyclerView.t tVar) {
        if (this.i == 1) {
            return this.b;
        }
        if (tVar.e() < 1) {
            return 0;
        }
        return a(pVar, tVar, tVar.e() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView.p pVar, RecyclerView.t tVar, View view, androidx.core.f.a.d dVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.a(view, dVar);
            return;
        }
        b bVar = (b) layoutParams;
        int a2 = a(pVar, tVar, bVar.f());
        if (this.i == 0) {
            dVar.b(d.c.a(bVar.a(), bVar.b(), a2, 1, this.b > 1 && bVar.b() == this.b, false));
        } else {
            dVar.b(d.c.a(a2, 1, bVar.a(), bVar.b(), this.b > 1 && bVar.b() == this.b, false));
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public void c(RecyclerView.p pVar, RecyclerView.t tVar) {
        if (tVar.a()) {
            P();
        }
        super.c(pVar, tVar);
        O();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView.t tVar) {
        super.a(tVar);
        this.f840a = false;
    }

    private void O() {
        this.e.clear();
        this.f.clear();
    }

    private void P() {
        int y = y();
        for (int i = 0; i < y; i++) {
            b bVar = (b) i(i).getLayoutParams();
            int f = bVar.f();
            this.e.put(f, bVar.b());
            this.f.put(f, bVar.a());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2) {
        this.g.invalidateSpanIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView) {
        this.g.invalidateSpanIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void b(RecyclerView recyclerView, int i, int i2) {
        this.g.invalidateSpanIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.g.invalidateSpanIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.g.invalidateSpanIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.j a() {
        if (this.i == 0) {
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

    public void a(c cVar) {
        this.g = cVar;
    }

    private void Q() {
        int C;
        if (h() == 1) {
            C = (B() - F()) - D();
        } else {
            C = (C() - G()) - E();
        }
        m(C);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(Rect rect, int i, int i2) {
        int a2;
        int a3;
        if (this.c == null) {
            super.a(rect, i, i2);
        }
        int D = D() + F();
        int E = E() + G();
        if (this.i == 1) {
            a3 = a(i2, rect.height() + E, K());
            int[] iArr = this.c;
            a2 = a(i, iArr[iArr.length - 1] + D, J());
        } else {
            a2 = a(i, rect.width() + D, J());
            int[] iArr2 = this.c;
            a3 = a(i2, iArr2[iArr2.length - 1] + E, K());
        }
        g(a2, a3);
    }

    private void m(int i) {
        this.c = a(this.c, this.b, i);
    }

    static int[] a(int[] iArr, int i, int i2) {
        int i3;
        if (iArr == null || iArr.length != i + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    int a(int i, int i2) {
        if (this.i == 1 && i()) {
            int[] iArr = this.c;
            int i3 = this.b;
            return iArr[i3 - i] - iArr[(i3 - i) - i2];
        }
        int[] iArr2 = this.c;
        return iArr2[i2 + i] - iArr2[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void a(RecyclerView.p pVar, RecyclerView.t tVar, LinearLayoutManager.a aVar, int i) {
        super.a(pVar, tVar, aVar, i);
        Q();
        if (tVar.e() > 0 && !tVar.a()) {
            b(pVar, tVar, aVar, i);
        }
        R();
    }

    private void R() {
        View[] viewArr = this.d;
        if (viewArr == null || viewArr.length != this.b) {
            this.d = new View[this.b];
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public int a(int i, RecyclerView.p pVar, RecyclerView.t tVar) {
        Q();
        R();
        return super.a(i, pVar, tVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public int b(int i, RecyclerView.p pVar, RecyclerView.t tVar) {
        Q();
        R();
        return super.b(i, pVar, tVar);
    }

    private void b(RecyclerView.p pVar, RecyclerView.t tVar, LinearLayoutManager.a aVar, int i) {
        boolean z = i == 1;
        int b2 = b(pVar, tVar, aVar.b);
        if (z) {
            while (b2 > 0 && aVar.b > 0) {
                aVar.b--;
                b2 = b(pVar, tVar, aVar.b);
            }
            return;
        }
        int e = tVar.e() - 1;
        int i2 = aVar.b;
        while (i2 < e) {
            int i3 = i2 + 1;
            int b3 = b(pVar, tVar, i3);
            if (b3 <= b2) {
                break;
            }
            i2 = i3;
            b2 = b3;
        }
        aVar.b = i2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
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
            if (d2 >= 0 && d2 < i3 && b(pVar, tVar, d2) == 0) {
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

    private int a(RecyclerView.p pVar, RecyclerView.t tVar, int i) {
        if (!tVar.a()) {
            return this.g.getSpanGroupIndex(i, this.b);
        }
        int b2 = pVar.b(i);
        if (b2 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
            return 0;
        }
        return this.g.getSpanGroupIndex(b2, this.b);
    }

    private int b(RecyclerView.p pVar, RecyclerView.t tVar, int i) {
        if (!tVar.a()) {
            return this.g.getCachedSpanIndex(i, this.b);
        }
        int i2 = this.f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int b2 = pVar.b(i);
        if (b2 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
            return 0;
        }
        return this.g.getCachedSpanIndex(b2, this.b);
    }

    private int c(RecyclerView.p pVar, RecyclerView.t tVar, int i) {
        if (!tVar.a()) {
            return this.g.getSpanSize(i);
        }
        int i2 = this.e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int b2 = pVar.b(i);
        if (b2 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
            return 1;
        }
        return this.g.getSpanSize(b2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void a(RecyclerView.t tVar, LinearLayoutManager.c cVar, RecyclerView.i.a aVar) {
        int i = this.b;
        for (int i2 = 0; i2 < this.b && cVar.a(tVar) && i > 0; i2++) {
            int i3 = cVar.d;
            aVar.b(i3, Math.max(0, cVar.g));
            i -= this.g.getSpanSize(i3);
            cVar.d += cVar.e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a4, code lost:
    
        r22.b = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a6, code lost:
    
        return;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void a(androidx.recyclerview.widget.RecyclerView.p r19, androidx.recyclerview.widget.RecyclerView.t r20, androidx.recyclerview.widget.LinearLayoutManager.c r21, androidx.recyclerview.widget.LinearLayoutManager.b r22) {
        /*
            Method dump skipped, instructions count: 587
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.a(androidx.recyclerview.widget.RecyclerView$p, androidx.recyclerview.widget.RecyclerView$t, androidx.recyclerview.widget.LinearLayoutManager$c, androidx.recyclerview.widget.LinearLayoutManager$b):void");
    }

    private void a(View view, int i, boolean z) {
        int i2;
        int i3;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.d;
        int i4 = rect.top + rect.bottom + bVar.topMargin + bVar.bottomMargin;
        int i5 = rect.left + rect.right + bVar.leftMargin + bVar.rightMargin;
        int a2 = a(bVar.f841a, bVar.b);
        if (this.i == 1) {
            i3 = a(a2, i, i5, bVar.width, false);
            i2 = a(this.j.f(), A(), i4, bVar.height, true);
        } else {
            int a3 = a(a2, i, i4, bVar.height, false);
            int a4 = a(this.j.f(), z(), i5, bVar.width, true);
            i2 = a3;
            i3 = a4;
        }
        a(view, i3, i2, z);
    }

    private void a(float f, int i) {
        m(Math.max(Math.round(f * this.b), i));
    }

    private void a(View view, int i, int i2, boolean z) {
        boolean b2;
        RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
        if (z) {
            b2 = a(view, i, i2, jVar);
        } else {
            b2 = b(view, i, i2, jVar);
        }
        if (b2) {
            view.measure(i, i2);
        }
    }

    private void a(RecyclerView.p pVar, RecyclerView.t tVar, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = 0;
        int i6 = -1;
        if (z) {
            i6 = i;
            i3 = 0;
            i4 = 1;
        } else {
            i3 = i - 1;
            i4 = -1;
        }
        while (i3 != i6) {
            View view = this.d[i3];
            b bVar = (b) view.getLayoutParams();
            bVar.b = c(pVar, tVar, d(view));
            bVar.f841a = i5;
            i5 += bVar.b;
            i3 += i4;
        }
    }

    public int b() {
        return this.b;
    }

    public void a(int i) {
        if (i == this.b) {
            return;
        }
        this.f840a = true;
        if (i < 1) {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
        this.b = i;
        this.g.invalidateSpanIndexCache();
        r();
    }

    /* loaded from: classes.dex */
    public static abstract class c {
        final SparseIntArray mSpanIndexCache = new SparseIntArray();
        private boolean mCacheSpanIndices = false;

        public abstract int getSpanSize(int i);

        public void setSpanIndexCacheEnabled(boolean z) {
            this.mCacheSpanIndices = z;
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        int getCachedSpanIndex(int i, int i2) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(i, i2);
            }
            int i3 = this.mSpanIndexCache.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int spanIndex = getSpanIndex(i, i2);
            this.mSpanIndexCache.put(i, spanIndex);
            return spanIndex;
        }

        public int getSpanIndex(int i, int i2) {
            int i3;
            int i4;
            int findReferenceIndexFromCache;
            int spanSize = getSpanSize(i);
            if (spanSize == i2) {
                return 0;
            }
            if (!this.mCacheSpanIndices || this.mSpanIndexCache.size() <= 0 || (findReferenceIndexFromCache = findReferenceIndexFromCache(i)) < 0) {
                i3 = 0;
                i4 = 0;
            } else {
                i4 = this.mSpanIndexCache.get(findReferenceIndexFromCache) + getSpanSize(findReferenceIndexFromCache);
                i3 = findReferenceIndexFromCache + 1;
            }
            while (i3 < i) {
                int spanSize2 = getSpanSize(i3);
                i4 += spanSize2;
                if (i4 == i2) {
                    i4 = 0;
                } else if (i4 > i2) {
                    i4 = spanSize2;
                }
                i3++;
            }
            if (spanSize + i4 <= i2) {
                return i4;
            }
            return 0;
        }

        int findReferenceIndexFromCache(int i) {
            int size = this.mSpanIndexCache.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.mSpanIndexCache.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= this.mSpanIndexCache.size()) {
                return -1;
            }
            return this.mSpanIndexCache.keyAt(i4);
        }

        public int getSpanGroupIndex(int i, int i2) {
            int spanSize = getSpanSize(i);
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int spanSize2 = getSpanSize(i5);
                i3 += spanSize2;
                if (i3 == i2) {
                    i4++;
                    i3 = 0;
                } else if (i3 > i2) {
                    i4++;
                    i3 = spanSize2;
                }
            }
            return i3 + spanSize > i2 ? i4 + 1 : i4;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public View a(View view, int i, RecyclerView.p pVar, RecyclerView.t tVar) {
        int y;
        int i2;
        int i3;
        View view2;
        View view3;
        int i4;
        int i5;
        View view4;
        int i6;
        int i7;
        boolean z;
        RecyclerView.p pVar2 = pVar;
        RecyclerView.t tVar2 = tVar;
        View e = e(view);
        View view5 = null;
        if (e == null) {
            return null;
        }
        b bVar = (b) e.getLayoutParams();
        int i8 = bVar.f841a;
        int i9 = bVar.f841a + bVar.b;
        if (super.a(view, i, pVar, tVar) == null) {
            return null;
        }
        if ((f(i) == 1) != this.k) {
            i2 = y() - 1;
            y = -1;
            i3 = -1;
        } else {
            y = y();
            i2 = 0;
            i3 = 1;
        }
        boolean z2 = this.i == 1 && i();
        int a2 = a(pVar2, tVar2, i2);
        View view6 = null;
        int i10 = -1;
        int i11 = 0;
        int i12 = 0;
        int i13 = -1;
        while (true) {
            if (i2 == y) {
                view2 = view6;
                break;
            }
            int a3 = a(pVar2, tVar2, i2);
            View i14 = i(i2);
            if (i14 == e) {
                view2 = view6;
                break;
            }
            if (!i14.hasFocusable() || a3 == a2) {
                b bVar2 = (b) i14.getLayoutParams();
                int i15 = bVar2.f841a;
                view3 = e;
                i4 = y;
                int i16 = bVar2.f841a + bVar2.b;
                if (i14.hasFocusable() && i15 == i8 && i16 == i9) {
                    return i14;
                }
                if (!(i14.hasFocusable() && view5 == null) && (i14.hasFocusable() || view6 != null)) {
                    int min = Math.min(i16, i9) - Math.max(i15, i8);
                    if (!i14.hasFocusable()) {
                        if (view5 == null) {
                            i5 = i10;
                            view4 = view6;
                            if (a(i14, false, true)) {
                                i6 = i12;
                                if (min > i6) {
                                    i7 = i13;
                                    z = true;
                                } else if (min == i6) {
                                    i7 = i13;
                                    if (z2 == (i15 > i7)) {
                                        z = true;
                                    }
                                } else {
                                    i7 = i13;
                                }
                            } else {
                                i6 = i12;
                                i7 = i13;
                            }
                        } else {
                            i5 = i10;
                            view4 = view6;
                            i6 = i12;
                            i7 = i13;
                        }
                        z = false;
                    } else if (min > i11) {
                        i5 = i10;
                        view4 = view6;
                        i6 = i12;
                        i7 = i13;
                        z = true;
                    } else {
                        if (min == i11) {
                            if (z2 == (i15 > i10)) {
                                i5 = i10;
                                view4 = view6;
                                i6 = i12;
                                i7 = i13;
                                z = true;
                            }
                        }
                        i5 = i10;
                        view4 = view6;
                        i6 = i12;
                        i7 = i13;
                        z = false;
                    }
                } else {
                    i5 = i10;
                    view4 = view6;
                    i6 = i12;
                    i7 = i13;
                    z = true;
                }
                if (z) {
                    if (i14.hasFocusable()) {
                        int i17 = bVar2.f841a;
                        view6 = view4;
                        i11 = Math.min(i16, i9) - Math.max(i15, i8);
                        i5 = i17;
                        i13 = i7;
                        view5 = i14;
                    } else {
                        view6 = i14;
                        i13 = bVar2.f841a;
                        i6 = Math.min(i16, i9) - Math.max(i15, i8);
                    }
                    i2 += i3;
                    i12 = i6;
                    e = view3;
                    y = i4;
                    i10 = i5;
                    pVar2 = pVar;
                    tVar2 = tVar;
                }
            } else {
                if (view5 != null) {
                    view2 = view6;
                    break;
                }
                view3 = e;
                i5 = i10;
                view4 = view6;
                i4 = y;
                i6 = i12;
                i7 = i13;
            }
            view6 = view4;
            i13 = i7;
            i2 += i3;
            i12 = i6;
            e = view3;
            y = i4;
            i10 = i5;
            pVar2 = pVar;
            tVar2 = tVar;
        }
        return view5 != null ? view5 : view2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public boolean c() {
        return this.n == null && !this.f840a;
    }

    /* loaded from: classes.dex */
    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanSize(int i) {
            return 1;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanIndex(int i, int i2) {
            return i % i2;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends RecyclerView.j {

        /* renamed from: a, reason: collision with root package name */
        int f841a;
        int b;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f841a = -1;
            this.b = 0;
        }

        public b(int i, int i2) {
            super(i, i2);
            this.f841a = -1;
            this.b = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f841a = -1;
            this.b = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f841a = -1;
            this.b = 0;
        }

        public int a() {
            return this.f841a;
        }

        public int b() {
            return this.b;
        }
    }
}
