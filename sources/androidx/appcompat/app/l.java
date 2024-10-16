package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.a;
import androidx.appcompat.app.a;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ab;
import androidx.appcompat.widget.an;
import androidx.core.f.aa;
import androidx.core.f.ac;
import androidx.core.f.v;
import androidx.core.f.z;
import com.amazonaws.services.s3.internal.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class l extends androidx.appcompat.app.a implements ActionBarOverlayLayout.a {
    static final /* synthetic */ boolean s = !l.class.desiredAssertionStatus();
    private static final Interpolator t = new AccelerateInterpolator();
    private static final Interpolator u = new DecelerateInterpolator();
    private boolean A;
    private boolean B;
    private boolean D;
    private boolean F;
    private boolean H;

    /* renamed from: a, reason: collision with root package name */
    Context f192a;
    ActionBarOverlayLayout b;
    ActionBarContainer c;
    ab d;
    ActionBarContextView e;
    View f;
    an g;
    a h;
    androidx.appcompat.view.b i;
    b.a j;
    boolean l;
    boolean m;
    androidx.appcompat.view.h n;
    boolean o;
    private Context v;
    private Activity w;
    private Dialog x;
    private ArrayList<Object> y = new ArrayList<>();
    private int z = -1;
    private ArrayList<a.b> C = new ArrayList<>();
    private int E = 0;
    boolean k = true;
    private boolean G = true;
    final aa p = new androidx.core.f.ab() { // from class: androidx.appcompat.app.l.1
        @Override // androidx.core.f.ab, androidx.core.f.aa
        public void b(View view) {
            if (l.this.k && l.this.f != null) {
                l.this.f.setTranslationY(0.0f);
                l.this.c.setTranslationY(0.0f);
            }
            l.this.c.setVisibility(8);
            l.this.c.setTransitioning(false);
            l lVar = l.this;
            lVar.n = null;
            lVar.h();
            if (l.this.b != null) {
                v.p(l.this.b);
            }
        }
    };
    final aa q = new androidx.core.f.ab() { // from class: androidx.appcompat.app.l.2
        @Override // androidx.core.f.ab, androidx.core.f.aa
        public void b(View view) {
            l lVar = l.this;
            lVar.n = null;
            lVar.c.requestLayout();
        }
    };
    final ac r = new ac() { // from class: androidx.appcompat.app.l.3
        @Override // androidx.core.f.ac
        public void a(View view) {
            ((View) l.this.c.getParent()).invalidate();
        }
    };

    static boolean a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void m() {
    }

    public l(Activity activity, boolean z) {
        this.w = activity;
        View decorView = activity.getWindow().getDecorView();
        a(decorView);
        if (z) {
            return;
        }
        this.f = decorView.findViewById(R.id.content);
    }

    public l(Dialog dialog) {
        this.x = dialog;
        a(dialog.getWindow().getDecorView());
    }

    private void a(View view) {
        this.b = (ActionBarOverlayLayout) view.findViewById(a.f.decor_content_parent);
        ActionBarOverlayLayout actionBarOverlayLayout = this.b;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.d = b(view.findViewById(a.f.action_bar));
        this.e = (ActionBarContextView) view.findViewById(a.f.action_context_bar);
        this.c = (ActionBarContainer) view.findViewById(a.f.action_bar_container);
        ab abVar = this.d;
        if (abVar == null || this.e == null || this.c == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f192a = abVar.b();
        boolean z = (this.d.o() & 4) != 0;
        if (z) {
            this.A = true;
        }
        androidx.appcompat.view.a a2 = androidx.appcompat.view.a.a(this.f192a);
        b(a2.f() || z);
        k(a2.d());
        TypedArray obtainStyledAttributes = this.f192a.obtainStyledAttributes(null, a.j.ActionBar, a.C0024a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(a.j.ActionBar_hideOnContentScroll, false)) {
            c(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(a.j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            a(dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ab b(View view) {
        if (view instanceof ab) {
            return (ab) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : Constants.NULL_VERSION_ID);
        throw new IllegalStateException(sb.toString());
    }

    @Override // androidx.appcompat.app.a
    public void a(float f) {
        v.a(this.c, f);
    }

    @Override // androidx.appcompat.app.a
    public void a(Configuration configuration) {
        k(androidx.appcompat.view.a.a(this.f192a).d());
    }

    private void k(boolean z) {
        this.D = z;
        if (!this.D) {
            this.d.a((an) null);
            this.c.setTabContainer(this.g);
        } else {
            this.c.setTabContainer(null);
            this.d.a(this.g);
        }
        boolean z2 = i() == 2;
        an anVar = this.g;
        if (anVar != null) {
            if (z2) {
                anVar.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.b;
                if (actionBarOverlayLayout != null) {
                    v.p(actionBarOverlayLayout);
                }
            } else {
                anVar.setVisibility(8);
            }
        }
        this.d.a(!this.D && z2);
        this.b.setHasNonEmbeddedTabs(!this.D && z2);
    }

    void h() {
        b.a aVar = this.j;
        if (aVar != null) {
            aVar.a(this.i);
            this.i = null;
            this.j = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void b(int i) {
        this.E = i;
    }

    @Override // androidx.appcompat.app.a
    public void e(boolean z) {
        androidx.appcompat.view.h hVar;
        this.H = z;
        if (z || (hVar = this.n) == null) {
            return;
        }
        hVar.c();
    }

    @Override // androidx.appcompat.app.a
    public void f(boolean z) {
        if (z == this.B) {
            return;
        }
        this.B = z;
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            this.C.get(i).a(z);
        }
    }

    @Override // androidx.appcompat.app.a
    public void a(boolean z) {
        a(z ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a
    public void b(boolean z) {
        this.d.b(z);
    }

    @Override // androidx.appcompat.app.a
    public void a(CharSequence charSequence) {
        this.d.b(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public void b(CharSequence charSequence) {
        this.d.a(charSequence);
    }

    public void a(int i, int i2) {
        int o = this.d.o();
        if ((i2 & 4) != 0) {
            this.A = true;
        }
        this.d.c((i & i2) | ((i2 ^ (-1)) & o));
    }

    public int i() {
        return this.d.p();
    }

    @Override // androidx.appcompat.app.a
    public int a() {
        return this.d.o();
    }

    @Override // androidx.appcompat.app.a
    public androidx.appcompat.view.b a(b.a aVar) {
        a aVar2 = this.h;
        if (aVar2 != null) {
            aVar2.c();
        }
        this.b.setHideOnContentScrollEnabled(false);
        this.e.c();
        a aVar3 = new a(this.e.getContext(), aVar);
        if (!aVar3.e()) {
            return null;
        }
        this.h = aVar3;
        aVar3.d();
        this.e.a(aVar3);
        j(true);
        this.e.sendAccessibilityEvent(32);
        return aVar3;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void g(boolean z) {
        this.k = z;
    }

    private void n() {
        if (this.F) {
            return;
        }
        this.F = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.b;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        l(false);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void j() {
        if (this.m) {
            this.m = false;
            l(true);
        }
    }

    private void o() {
        if (this.F) {
            this.F = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.b;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            l(false);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void k() {
        if (this.m) {
            return;
        }
        this.m = true;
        l(true);
    }

    @Override // androidx.appcompat.app.a
    public void c(boolean z) {
        if (z && !this.b.a()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.o = z;
        this.b.setHideOnContentScrollEnabled(z);
    }

    private void l(boolean z) {
        if (a(this.l, this.m, this.F)) {
            if (this.G) {
                return;
            }
            this.G = true;
            h(z);
            return;
        }
        if (this.G) {
            this.G = false;
            i(z);
        }
    }

    public void h(boolean z) {
        View view;
        View view2;
        androidx.appcompat.view.h hVar = this.n;
        if (hVar != null) {
            hVar.c();
        }
        this.c.setVisibility(0);
        if (this.E == 0 && (this.H || z)) {
            this.c.setTranslationY(0.0f);
            float f = -this.c.getHeight();
            if (z) {
                this.c.getLocationInWindow(new int[]{0, 0});
                f -= r5[1];
            }
            this.c.setTranslationY(f);
            androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
            z b = v.l(this.c).b(0.0f);
            b.a(this.r);
            hVar2.a(b);
            if (this.k && (view2 = this.f) != null) {
                view2.setTranslationY(f);
                hVar2.a(v.l(this.f).b(0.0f));
            }
            hVar2.a(u);
            hVar2.a(250L);
            hVar2.a(this.q);
            this.n = hVar2;
            hVar2.a();
        } else {
            this.c.setAlpha(1.0f);
            this.c.setTranslationY(0.0f);
            if (this.k && (view = this.f) != null) {
                view.setTranslationY(0.0f);
            }
            this.q.b(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.b;
        if (actionBarOverlayLayout != null) {
            v.p(actionBarOverlayLayout);
        }
    }

    public void i(boolean z) {
        View view;
        androidx.appcompat.view.h hVar = this.n;
        if (hVar != null) {
            hVar.c();
        }
        if (this.E == 0 && (this.H || z)) {
            this.c.setAlpha(1.0f);
            this.c.setTransitioning(true);
            androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
            float f = -this.c.getHeight();
            if (z) {
                this.c.getLocationInWindow(new int[]{0, 0});
                f -= r5[1];
            }
            z b = v.l(this.c).b(f);
            b.a(this.r);
            hVar2.a(b);
            if (this.k && (view = this.f) != null) {
                hVar2.a(v.l(view).b(f));
            }
            hVar2.a(t);
            hVar2.a(250L);
            hVar2.a(this.p);
            this.n = hVar2;
            hVar2.a();
            return;
        }
        this.p.b(null);
    }

    public void j(boolean z) {
        z a2;
        z a3;
        if (z) {
            n();
        } else {
            o();
        }
        if (!p()) {
            if (z) {
                this.d.e(4);
                this.e.setVisibility(0);
                return;
            } else {
                this.d.e(0);
                this.e.setVisibility(8);
                return;
            }
        }
        if (z) {
            a3 = this.d.a(4, 100L);
            a2 = this.e.a(0, 200L);
        } else {
            a2 = this.d.a(0, 200L);
            a3 = this.e.a(8, 100L);
        }
        androidx.appcompat.view.h hVar = new androidx.appcompat.view.h();
        hVar.a(a3, a2);
        hVar.a();
    }

    private boolean p() {
        return v.x(this.c);
    }

    @Override // androidx.appcompat.app.a
    public Context b() {
        if (this.v == null) {
            TypedValue typedValue = new TypedValue();
            this.f192a.getTheme().resolveAttribute(a.C0024a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.v = new ContextThemeWrapper(this.f192a, i);
            } else {
                this.v = this.f192a;
            }
        }
        return this.v;
    }

    @Override // androidx.appcompat.app.a
    public void a(int i) {
        this.d.d(i);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void l() {
        androidx.appcompat.view.h hVar = this.n;
        if (hVar != null) {
            hVar.c();
            this.n = null;
        }
    }

    @Override // androidx.appcompat.app.a
    public boolean f() {
        ab abVar = this.d;
        if (abVar == null || !abVar.c()) {
            return false;
        }
        this.d.d();
        return true;
    }

    /* loaded from: classes.dex */
    public class a extends androidx.appcompat.view.b implements g.a {
        private final Context b;
        private final androidx.appcompat.view.menu.g c;
        private b.a d;
        private WeakReference<View> e;

        public a(Context context, b.a aVar) {
            this.b = context;
            this.d = aVar;
            this.c = new androidx.appcompat.view.menu.g(context).a(1);
            this.c.a(this);
        }

        @Override // androidx.appcompat.view.b
        public MenuInflater a() {
            return new androidx.appcompat.view.g(this.b);
        }

        @Override // androidx.appcompat.view.b
        public Menu b() {
            return this.c;
        }

        @Override // androidx.appcompat.view.b
        public void c() {
            if (l.this.h != this) {
                return;
            }
            if (!l.a(l.this.l, l.this.m, false)) {
                l lVar = l.this;
                lVar.i = this;
                lVar.j = this.d;
            } else {
                this.d.a(this);
            }
            this.d = null;
            l.this.j(false);
            l.this.e.b();
            l.this.d.a().sendAccessibilityEvent(32);
            l.this.b.setHideOnContentScrollEnabled(l.this.o);
            l.this.h = null;
        }

        @Override // androidx.appcompat.view.b
        public void d() {
            if (l.this.h != this) {
                return;
            }
            this.c.h();
            try {
                this.d.b(this, this.c);
            } finally {
                this.c.i();
            }
        }

        public boolean e() {
            this.c.h();
            try {
                return this.d.a(this, this.c);
            } finally {
                this.c.i();
            }
        }

        @Override // androidx.appcompat.view.b
        public void a(View view) {
            l.this.e.setCustomView(view);
            this.e = new WeakReference<>(view);
        }

        @Override // androidx.appcompat.view.b
        public void a(CharSequence charSequence) {
            l.this.e.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void b(CharSequence charSequence) {
            l.this.e.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void a(int i) {
            b(l.this.f192a.getResources().getString(i));
        }

        @Override // androidx.appcompat.view.b
        public void b(int i) {
            a((CharSequence) l.this.f192a.getResources().getString(i));
        }

        @Override // androidx.appcompat.view.b
        public CharSequence f() {
            return l.this.e.getTitle();
        }

        @Override // androidx.appcompat.view.b
        public CharSequence g() {
            return l.this.e.getSubtitle();
        }

        @Override // androidx.appcompat.view.b
        public void a(boolean z) {
            super.a(z);
            l.this.e.setTitleOptional(z);
        }

        @Override // androidx.appcompat.view.b
        public boolean h() {
            return l.this.e.d();
        }

        @Override // androidx.appcompat.view.b
        public View i() {
            WeakReference<View> weakReference = this.e;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            b.a aVar = this.d;
            if (aVar != null) {
                return aVar.a(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void a(androidx.appcompat.view.menu.g gVar) {
            if (this.d == null) {
                return;
            }
            d();
            l.this.e.a();
        }
    }

    @Override // androidx.appcompat.app.a
    public void d(boolean z) {
        if (this.A) {
            return;
        }
        a(z);
    }

    @Override // androidx.appcompat.app.a
    public boolean a(int i, KeyEvent keyEvent) {
        Menu b;
        a aVar = this.h;
        if (aVar == null || (b = aVar.b()) == null) {
            return false;
        }
        b.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return b.performShortcut(i, keyEvent, 0);
    }
}
