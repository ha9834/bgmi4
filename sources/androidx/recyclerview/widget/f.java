package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class f {
    int b;
    int c;
    int d;
    int e;
    boolean h;
    boolean i;

    /* renamed from: a, reason: collision with root package name */
    boolean f899a = true;
    int f = 0;
    int g = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(RecyclerView.t tVar) {
        int i = this.c;
        return i >= 0 && i < tVar.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View a(RecyclerView.p pVar) {
        View c = pVar.c(this.c);
        this.c += this.d;
        return c;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.b + ", mCurrentPosition=" + this.c + ", mItemDirection=" + this.d + ", mLayoutDirection=" + this.e + ", mStartLine=" + this.f + ", mEndLine=" + this.g + '}';
    }
}
