package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.Toolbar;

/* loaded from: classes.dex */
public class av implements ab {

    /* renamed from: a, reason: collision with root package name */
    Toolbar f338a;
    CharSequence b;
    Window.Callback c;
    boolean d;
    private int e;
    private View f;
    private View g;
    private Drawable h;
    private Drawable i;
    private Drawable j;
    private boolean k;
    private CharSequence l;
    private CharSequence m;
    private ActionMenuPresenter n;
    private int o;
    private int p;
    private Drawable q;

    @Override // androidx.appcompat.widget.ab
    public void b(boolean z) {
    }

    public av(Toolbar toolbar, boolean z) {
        this(toolbar, z, a.h.abc_action_bar_up_description, a.e.abc_ic_ab_back_material);
    }

    public av(Toolbar toolbar, boolean z, int i, int i2) {
        Drawable drawable;
        this.o = 0;
        this.p = 0;
        this.f338a = toolbar;
        this.b = toolbar.getTitle();
        this.l = toolbar.getSubtitle();
        this.k = this.b != null;
        this.j = toolbar.getNavigationIcon();
        au a2 = au.a(toolbar.getContext(), null, a.j.ActionBar, a.C0024a.actionBarStyle, 0);
        this.q = a2.a(a.j.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence c = a2.c(a.j.ActionBar_title);
            if (!TextUtils.isEmpty(c)) {
                b(c);
            }
            CharSequence c2 = a2.c(a.j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(c2)) {
                c(c2);
            }
            Drawable a3 = a2.a(a.j.ActionBar_logo);
            if (a3 != null) {
                b(a3);
            }
            Drawable a4 = a2.a(a.j.ActionBar_icon);
            if (a4 != null) {
                a(a4);
            }
            if (this.j == null && (drawable = this.q) != null) {
                c(drawable);
            }
            c(a2.a(a.j.ActionBar_displayOptions, 0));
            int g = a2.g(a.j.ActionBar_customNavigationLayout, 0);
            if (g != 0) {
                a(LayoutInflater.from(this.f338a.getContext()).inflate(g, (ViewGroup) this.f338a, false));
                c(this.e | 16);
            }
            int f = a2.f(a.j.ActionBar_height, 0);
            if (f > 0) {
                ViewGroup.LayoutParams layoutParams = this.f338a.getLayoutParams();
                layoutParams.height = f;
                this.f338a.setLayoutParams(layoutParams);
            }
            int d = a2.d(a.j.ActionBar_contentInsetStart, -1);
            int d2 = a2.d(a.j.ActionBar_contentInsetEnd, -1);
            if (d >= 0 || d2 >= 0) {
                this.f338a.setContentInsetsRelative(Math.max(d, 0), Math.max(d2, 0));
            }
            int g2 = a2.g(a.j.ActionBar_titleTextStyle, 0);
            if (g2 != 0) {
                Toolbar toolbar2 = this.f338a;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), g2);
            }
            int g3 = a2.g(a.j.ActionBar_subtitleTextStyle, 0);
            if (g3 != 0) {
                Toolbar toolbar3 = this.f338a;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), g3);
            }
            int g4 = a2.g(a.j.ActionBar_popupTheme, 0);
            if (g4 != 0) {
                this.f338a.setPopupTheme(g4);
            }
        } else {
            this.e = r();
        }
        a2.a();
        f(i);
        this.m = this.f338a.getNavigationContentDescription();
        this.f338a.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.av.1

            /* renamed from: a, reason: collision with root package name */
            final androidx.appcompat.view.menu.a f339a;

            {
                this.f339a = new androidx.appcompat.view.menu.a(av.this.f338a.getContext(), 0, R.id.home, 0, 0, av.this.b);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (av.this.c == null || !av.this.d) {
                    return;
                }
                av.this.c.onMenuItemSelected(0, this.f339a);
            }
        });
    }

    public void f(int i) {
        if (i == this.p) {
            return;
        }
        this.p = i;
        if (TextUtils.isEmpty(this.f338a.getNavigationContentDescription())) {
            d(this.p);
        }
    }

    private int r() {
        if (this.f338a.getNavigationIcon() == null) {
            return 11;
        }
        this.q = this.f338a.getNavigationIcon();
        return 15;
    }

    @Override // androidx.appcompat.widget.ab
    public ViewGroup a() {
        return this.f338a;
    }

    @Override // androidx.appcompat.widget.ab
    public Context b() {
        return this.f338a.getContext();
    }

    @Override // androidx.appcompat.widget.ab
    public boolean c() {
        return this.f338a.hasExpandedActionView();
    }

    @Override // androidx.appcompat.widget.ab
    public void d() {
        this.f338a.collapseActionView();
    }

    @Override // androidx.appcompat.widget.ab
    public void a(Window.Callback callback) {
        this.c = callback;
    }

    @Override // androidx.appcompat.widget.ab
    public void a(CharSequence charSequence) {
        if (this.k) {
            return;
        }
        e(charSequence);
    }

    @Override // androidx.appcompat.widget.ab
    public CharSequence e() {
        return this.f338a.getTitle();
    }

    @Override // androidx.appcompat.widget.ab
    public void b(CharSequence charSequence) {
        this.k = true;
        e(charSequence);
    }

    private void e(CharSequence charSequence) {
        this.b = charSequence;
        if ((this.e & 8) != 0) {
            this.f338a.setTitle(charSequence);
        }
    }

    public void c(CharSequence charSequence) {
        this.l = charSequence;
        if ((this.e & 8) != 0) {
            this.f338a.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.ab
    public void f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.ab
    public void g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.ab
    public void a(int i) {
        a(i != 0 ? androidx.appcompat.a.a.a.b(b(), i) : null);
    }

    @Override // androidx.appcompat.widget.ab
    public void a(Drawable drawable) {
        this.h = drawable;
        s();
    }

    @Override // androidx.appcompat.widget.ab
    public void b(int i) {
        b(i != 0 ? androidx.appcompat.a.a.a.b(b(), i) : null);
    }

    public void b(Drawable drawable) {
        this.i = drawable;
        s();
    }

    private void s() {
        Drawable drawable;
        int i = this.e;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) != 0) {
            drawable = this.i;
            if (drawable == null) {
                drawable = this.h;
            }
        } else {
            drawable = this.h;
        }
        this.f338a.setLogo(drawable);
    }

    @Override // androidx.appcompat.widget.ab
    public boolean h() {
        return this.f338a.canShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.ab
    public boolean i() {
        return this.f338a.isOverflowMenuShowing();
    }

    @Override // androidx.appcompat.widget.ab
    public boolean j() {
        return this.f338a.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.ab
    public boolean k() {
        return this.f338a.showOverflowMenu();
    }

    @Override // androidx.appcompat.widget.ab
    public boolean l() {
        return this.f338a.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.ab
    public void m() {
        this.d = true;
    }

    @Override // androidx.appcompat.widget.ab
    public void a(Menu menu, m.a aVar) {
        if (this.n == null) {
            this.n = new ActionMenuPresenter(this.f338a.getContext());
            this.n.a(a.f.action_menu_presenter);
        }
        this.n.a(aVar);
        this.f338a.setMenu((androidx.appcompat.view.menu.g) menu, this.n);
    }

    @Override // androidx.appcompat.widget.ab
    public void n() {
        this.f338a.dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.ab
    public int o() {
        return this.e;
    }

    @Override // androidx.appcompat.widget.ab
    public void c(int i) {
        View view;
        int i2 = this.e ^ i;
        this.e = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    u();
                }
                t();
            }
            if ((i2 & 3) != 0) {
                s();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f338a.setTitle(this.b);
                    this.f338a.setSubtitle(this.l);
                } else {
                    this.f338a.setTitle((CharSequence) null);
                    this.f338a.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) == 0 || (view = this.g) == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.f338a.addView(view);
            } else {
                this.f338a.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.ab
    public void a(an anVar) {
        View view = this.f;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f338a;
            if (parent == toolbar) {
                toolbar.removeView(this.f);
            }
        }
        this.f = anVar;
        if (anVar == null || this.o != 2) {
            return;
        }
        this.f338a.addView(this.f, 0);
        Toolbar.b bVar = (Toolbar.b) this.f.getLayoutParams();
        bVar.width = -2;
        bVar.height = -2;
        bVar.f175a = 8388691;
        anVar.setAllowCollapse(true);
    }

    @Override // androidx.appcompat.widget.ab
    public void a(boolean z) {
        this.f338a.setCollapsible(z);
    }

    @Override // androidx.appcompat.widget.ab
    public int p() {
        return this.o;
    }

    public void a(View view) {
        View view2 = this.g;
        if (view2 != null && (this.e & 16) != 0) {
            this.f338a.removeView(view2);
        }
        this.g = view;
        if (view == null || (this.e & 16) == 0) {
            return;
        }
        this.f338a.addView(this.g);
    }

    @Override // androidx.appcompat.widget.ab
    public androidx.core.f.z a(final int i, long j) {
        return androidx.core.f.v.l(this.f338a).a(i == 0 ? 1.0f : 0.0f).a(j).a(new androidx.core.f.ab() { // from class: androidx.appcompat.widget.av.2
            private boolean c = false;

            @Override // androidx.core.f.ab, androidx.core.f.aa
            public void a(View view) {
                av.this.f338a.setVisibility(0);
            }

            @Override // androidx.core.f.ab, androidx.core.f.aa
            public void b(View view) {
                if (this.c) {
                    return;
                }
                av.this.f338a.setVisibility(i);
            }

            @Override // androidx.core.f.ab, androidx.core.f.aa
            public void c(View view) {
                this.c = true;
            }
        });
    }

    public void c(Drawable drawable) {
        this.j = drawable;
        t();
    }

    private void t() {
        if ((this.e & 4) != 0) {
            Toolbar toolbar = this.f338a;
            Drawable drawable = this.j;
            if (drawable == null) {
                drawable = this.q;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f338a.setNavigationIcon((Drawable) null);
    }

    public void d(CharSequence charSequence) {
        this.m = charSequence;
        u();
    }

    @Override // androidx.appcompat.widget.ab
    public void d(int i) {
        d(i == 0 ? null : b().getString(i));
    }

    private void u() {
        if ((this.e & 4) != 0) {
            if (TextUtils.isEmpty(this.m)) {
                this.f338a.setNavigationContentDescription(this.p);
            } else {
                this.f338a.setNavigationContentDescription(this.m);
            }
        }
    }

    @Override // androidx.appcompat.widget.ab
    public void e(int i) {
        this.f338a.setVisibility(i);
    }

    @Override // androidx.appcompat.widget.ab
    public void a(m.a aVar, g.a aVar2) {
        this.f338a.setMenuCallbacks(aVar, aVar2);
    }

    @Override // androidx.appcompat.widget.ab
    public Menu q() {
        return this.f338a.getMenu();
    }
}
