package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.m;
import androidx.core.f.v;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private final Context f245a;
    private final g b;
    private final boolean c;
    private final int d;
    private final int e;
    private View f;
    private int g;
    private boolean h;
    private m.a i;
    private k j;
    private PopupWindow.OnDismissListener k;
    private final PopupWindow.OnDismissListener l;

    public l(Context context, g gVar, View view, boolean z, int i) {
        this(context, gVar, view, z, i, 0);
    }

    public l(Context context, g gVar, View view, boolean z, int i, int i2) {
        this.g = 8388611;
        this.l = new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.view.menu.l.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                l.this.e();
            }
        };
        this.f245a = context;
        this.b = gVar;
        this.f = view;
        this.c = z;
        this.d = i;
        this.e = i2;
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.k = onDismissListener;
    }

    public void a(View view) {
        this.f = view;
    }

    public void a(boolean z) {
        this.h = z;
        k kVar = this.j;
        if (kVar != null) {
            kVar.b(z);
        }
    }

    public void a(int i) {
        this.g = i;
    }

    public void a() {
        if (!c()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public k b() {
        if (this.j == null) {
            this.j = g();
        }
        return this.j;
    }

    public boolean c() {
        if (f()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        a(0, 0, false, false);
        return true;
    }

    public boolean a(int i, int i2) {
        if (f()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        a(i, i2, true, true);
        return true;
    }

    private k g() {
        k qVar;
        Display defaultDisplay = ((WindowManager) this.f245a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        if (Math.min(point.x, point.y) >= this.f245a.getResources().getDimensionPixelSize(a.d.abc_cascading_menus_min_smallest_width)) {
            qVar = new d(this.f245a, this.f, this.d, this.e, this.c);
        } else {
            qVar = new q(this.f245a, this.b, this.f, this.d, this.e, this.c);
        }
        qVar.a(this.b);
        qVar.a(this.l);
        qVar.a(this.f);
        qVar.a(this.i);
        qVar.b(this.h);
        qVar.a(this.g);
        return qVar;
    }

    private void a(int i, int i2, boolean z, boolean z2) {
        k b = b();
        b.c(z2);
        if (z) {
            if ((androidx.core.f.d.a(this.g, v.f(this.f)) & 7) == 5) {
                i -= this.f.getWidth();
            }
            b.b(i);
            b.c(i2);
            int i3 = (int) ((this.f245a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            b.a(new Rect(i - i3, i2 - i3, i + i3, i2 + i3));
        }
        b.d_();
    }

    public void d() {
        if (f()) {
            this.j.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        this.j = null;
        PopupWindow.OnDismissListener onDismissListener = this.k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean f() {
        k kVar = this.j;
        return kVar != null && kVar.e();
    }

    public void a(m.a aVar) {
        this.i = aVar;
        k kVar = this.j;
        if (kVar != null) {
            kVar.a(aVar);
        }
    }
}
