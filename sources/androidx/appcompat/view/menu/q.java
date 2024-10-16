package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.aj;
import androidx.core.f.v;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q extends k implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener, m {
    private static final int e = a.g.abc_popup_menu_item_layout;

    /* renamed from: a, reason: collision with root package name */
    final aj f247a;
    View c;
    ViewTreeObserver d;
    private final Context f;
    private final g g;
    private final f h;
    private final boolean i;
    private final int j;
    private final int k;
    private final int l;
    private PopupWindow.OnDismissListener n;
    private View o;
    private m.a p;
    private boolean q;
    private boolean r;
    private int s;
    private boolean u;
    final ViewTreeObserver.OnGlobalLayoutListener b = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.view.menu.q.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!q.this.e() || q.this.f247a.j()) {
                return;
            }
            View view = q.this.c;
            if (view == null || !view.isShown()) {
                q.this.d();
            } else {
                q.this.f247a.d_();
            }
        }
    };
    private final View.OnAttachStateChangeListener m = new View.OnAttachStateChangeListener() { // from class: androidx.appcompat.view.menu.q.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (q.this.d != null) {
                if (!q.this.d.isAlive()) {
                    q.this.d = view.getViewTreeObserver();
                }
                q.this.d.removeGlobalOnLayoutListener(q.this.b);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private int t = 0;

    @Override // androidx.appcompat.view.menu.m
    public void a(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(g gVar) {
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean b() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable f() {
        return null;
    }

    public q(Context context, g gVar, View view, int i, int i2, boolean z) {
        this.f = context;
        this.g = gVar;
        this.i = z;
        this.h = new f(gVar, LayoutInflater.from(context), this.i, e);
        this.k = i;
        this.l = i2;
        Resources resources = context.getResources();
        this.j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
        this.o = view;
        this.f247a = new aj(this.f, null, this.k, this.l);
        gVar.a(this, context);
    }

    @Override // androidx.appcompat.view.menu.k
    public void b(boolean z) {
        this.h.a(z);
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(int i) {
        this.t = i;
    }

    private boolean j() {
        View view;
        if (e()) {
            return true;
        }
        if (this.q || (view = this.o) == null) {
            return false;
        }
        this.c = view;
        this.f247a.a((PopupWindow.OnDismissListener) this);
        this.f247a.a((AdapterView.OnItemClickListener) this);
        this.f247a.a(true);
        View view2 = this.c;
        boolean z = this.d == null;
        this.d = view2.getViewTreeObserver();
        if (z) {
            this.d.addOnGlobalLayoutListener(this.b);
        }
        view2.addOnAttachStateChangeListener(this.m);
        this.f247a.b(view2);
        this.f247a.f(this.t);
        if (!this.r) {
            this.s = a(this.h, null, this.f, this.j);
            this.r = true;
        }
        this.f247a.h(this.s);
        this.f247a.i(2);
        this.f247a.a(i());
        this.f247a.d_();
        ListView g = this.f247a.g();
        g.setOnKeyListener(this);
        if (this.u && this.g.n() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f).inflate(a.g.abc_popup_menu_header_item_layout, (ViewGroup) g, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.g.n());
            }
            frameLayout.setEnabled(false);
            g.addHeaderView(frameLayout, null, false);
        }
        this.f247a.a((ListAdapter) this.h);
        this.f247a.d_();
        return true;
    }

    @Override // androidx.appcompat.view.menu.p
    public void d_() {
        if (!j()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public void d() {
        if (e()) {
            this.f247a.d();
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean e() {
        return !this.q && this.f247a.e();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.q = true;
        this.g.close();
        ViewTreeObserver viewTreeObserver = this.d;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.d = this.c.getViewTreeObserver();
            }
            this.d.removeGlobalOnLayoutListener(this.b);
            this.d = null;
        }
        this.c.removeOnAttachStateChangeListener(this.m);
        PopupWindow.OnDismissListener onDismissListener = this.n;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(boolean z) {
        this.r = false;
        f fVar = this.h;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(m.a aVar) {
        this.p = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean a(r rVar) {
        if (rVar.hasVisibleItems()) {
            l lVar = new l(this.f, rVar, this.c, this.i, this.k, this.l);
            lVar.a(this.p);
            lVar.a(k.b(rVar));
            lVar.a(this.n);
            this.n = null;
            this.g.a(false);
            int f = this.f247a.f();
            int c = this.f247a.c();
            if ((Gravity.getAbsoluteGravity(this.t, v.f(this.o)) & 7) == 5) {
                f += this.o.getWidth();
            }
            if (lVar.a(f, c)) {
                m.a aVar = this.p;
                if (aVar == null) {
                    return true;
                }
                aVar.a(rVar);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(g gVar, boolean z) {
        if (gVar != this.g) {
            return;
        }
        d();
        m.a aVar = this.p;
        if (aVar != null) {
            aVar.a(gVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(View view) {
        this.o = view;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        d();
        return true;
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.n = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView g() {
        return this.f247a.g();
    }

    @Override // androidx.appcompat.view.menu.k
    public void b(int i) {
        this.f247a.b(i);
    }

    @Override // androidx.appcompat.view.menu.k
    public void c(int i) {
        this.f247a.a(i);
    }

    @Override // androidx.appcompat.view.menu.k
    public void c(boolean z) {
        this.u = z;
    }
}
