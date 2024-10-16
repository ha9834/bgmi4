package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class l extends RecyclerView.f {
    boolean h = true;

    public abstract boolean a(RecyclerView.w wVar);

    public abstract boolean a(RecyclerView.w wVar, int i, int i2, int i3, int i4);

    public abstract boolean a(RecyclerView.w wVar, RecyclerView.w wVar2, int i, int i2, int i3, int i4);

    public abstract boolean b(RecyclerView.w wVar);

    public void c(RecyclerView.w wVar, boolean z) {
    }

    public void d(RecyclerView.w wVar, boolean z) {
    }

    public void o(RecyclerView.w wVar) {
    }

    public void p(RecyclerView.w wVar) {
    }

    public void q(RecyclerView.w wVar) {
    }

    public void r(RecyclerView.w wVar) {
    }

    public void s(RecyclerView.w wVar) {
    }

    public void t(RecyclerView.w wVar) {
    }

    public void a(boolean z) {
        this.h = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean h(RecyclerView.w wVar) {
        return !this.h || wVar.isInvalid();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean a(RecyclerView.w wVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        int i = cVar.f854a;
        int i2 = cVar.b;
        View view = wVar.itemView;
        int left = cVar2 == null ? view.getLeft() : cVar2.f854a;
        int top = cVar2 == null ? view.getTop() : cVar2.b;
        if (!wVar.isRemoved() && (i != left || i2 != top)) {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            return a(wVar, i, i2, left, top);
        }
        return a(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean b(RecyclerView.w wVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        if (cVar != null && (cVar.f854a != cVar2.f854a || cVar.b != cVar2.b)) {
            return a(wVar, cVar.f854a, cVar.b, cVar2.f854a, cVar2.b);
        }
        return b(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean c(RecyclerView.w wVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        if (cVar.f854a != cVar2.f854a || cVar.b != cVar2.b) {
            return a(wVar, cVar.f854a, cVar.b, cVar2.f854a, cVar2.b);
        }
        j(wVar);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean a(RecyclerView.w wVar, RecyclerView.w wVar2, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        int i;
        int i2;
        int i3 = cVar.f854a;
        int i4 = cVar.b;
        if (wVar2.shouldIgnore()) {
            int i5 = cVar.f854a;
            i2 = cVar.b;
            i = i5;
        } else {
            i = cVar2.f854a;
            i2 = cVar2.b;
        }
        return a(wVar, wVar2, i3, i4, i, i2);
    }

    public final void i(RecyclerView.w wVar) {
        p(wVar);
        f(wVar);
    }

    public final void j(RecyclerView.w wVar) {
        t(wVar);
        f(wVar);
    }

    public final void k(RecyclerView.w wVar) {
        r(wVar);
        f(wVar);
    }

    public final void a(RecyclerView.w wVar, boolean z) {
        d(wVar, z);
        f(wVar);
    }

    public final void l(RecyclerView.w wVar) {
        o(wVar);
    }

    public final void m(RecyclerView.w wVar) {
        s(wVar);
    }

    public final void n(RecyclerView.w wVar) {
        q(wVar);
    }

    public final void b(RecyclerView.w wVar, boolean z) {
        c(wVar, z);
    }
}
