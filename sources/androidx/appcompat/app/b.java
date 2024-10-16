package androidx.appcompat.app;

import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;

/* loaded from: classes.dex */
public class b implements DrawerLayout.b {

    /* renamed from: a, reason: collision with root package name */
    boolean f176a;
    private final a b;
    private androidx.appcompat.b.a.d c;
    private boolean d;
    private final int e;
    private final int f;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.b
    public void a(int i) {
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.b
    public void a(View view, float f) {
        if (this.d) {
            a(Math.min(1.0f, Math.max(0.0f, f)));
        } else {
            a(0.0f);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.b
    public void a(View view) {
        a(1.0f);
        if (this.f176a) {
            b(this.f);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.b
    public void b(View view) {
        a(0.0f);
        if (this.f176a) {
            b(this.e);
        }
    }

    void b(int i) {
        this.b.a(i);
    }

    private void a(float f) {
        if (f == 1.0f) {
            this.c.a(true);
        } else if (f == 0.0f) {
            this.c.a(false);
        }
        this.c.a(f);
    }
}
