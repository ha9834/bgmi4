package androidx.core.f;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private int f542a;
    private int b;

    public q(ViewGroup viewGroup) {
    }

    public void a(View view, View view2, int i) {
        a(view, view2, i, 0);
    }

    public void a(View view, View view2, int i, int i2) {
        if (i2 == 1) {
            this.b = i;
        } else {
            this.f542a = i;
        }
    }

    public int a() {
        return this.f542a | this.b;
    }

    public void a(View view, int i) {
        if (i == 1) {
            this.b = 0;
        } else {
            this.f542a = 0;
        }
    }
}
