package androidx.appcompat.app;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.app.b;
import androidx.appcompat.view.b;
import androidx.appcompat.view.f;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.aa;
import androidx.appcompat.widget.ae;
import androidx.appcompat.widget.au;
import androidx.appcompat.widget.az;
import androidx.appcompat.widget.ba;
import androidx.core.f.ab;
import androidx.core.f.ad;
import androidx.core.f.e;
import androidx.core.f.r;
import androidx.core.f.v;
import androidx.core.f.z;
import androidx.lifecycle.Lifecycle;
import java.lang.Thread;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AppCompatDelegateImpl extends androidx.appcompat.app.e implements LayoutInflater.Factory2, g.a {
    private static final Map<Class<?>, Integer> t = new androidx.b.a();
    private static final boolean u;
    private static final int[] v;
    private static boolean w;
    private static final boolean x;
    private aa A;
    private b B;
    private i C;
    private boolean D;
    private boolean E;
    private ViewGroup F;
    private TextView G;
    private View H;
    private boolean I;
    private boolean J;
    private boolean K;
    private PanelFeatureState[] L;
    private PanelFeatureState M;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private int R;
    private int S;
    private boolean T;
    private boolean U;
    private f V;
    private f W;
    private final Runnable X;
    private boolean Y;
    private Rect Z;

    /* renamed from: a, reason: collision with root package name */
    final Object f152a;
    private Rect aa;
    private AppCompatViewInflater ab;
    final Context b;
    Window c;
    final androidx.appcompat.app.d d;
    androidx.appcompat.app.a e;
    MenuInflater f;
    androidx.appcompat.view.b g;
    ActionBarContextView h;
    PopupWindow i;
    Runnable j;
    z k;
    boolean l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    boolean r;
    int s;
    private d y;
    private CharSequence z;

    void a(ViewGroup viewGroup) {
    }

    static {
        boolean z = false;
        u = Build.VERSION.SDK_INT < 21;
        v = new int[]{R.attr.windowBackground};
        if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT <= 25) {
            z = true;
        }
        x = z;
        if (!u || w) {
            return;
        }
        final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                if (a(th)) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                    notFoundException.initCause(th.getCause());
                    notFoundException.setStackTrace(th.getStackTrace());
                    defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                    return;
                }
                defaultUncaughtExceptionHandler.uncaughtException(thread, th);
            }

            private boolean a(Throwable th) {
                String message;
                if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                    return false;
                }
                return message.contains("drawable") || message.contains("Drawable");
            }
        });
        w = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatDelegateImpl(Activity activity, androidx.appcompat.app.d dVar) {
        this(activity, null, dVar, activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatDelegateImpl(Dialog dialog, androidx.appcompat.app.d dVar) {
        this(dialog.getContext(), dialog.getWindow(), dVar, dialog);
    }

    private AppCompatDelegateImpl(Context context, Window window, androidx.appcompat.app.d dVar, Object obj) {
        Integer num;
        AppCompatActivity C;
        this.k = null;
        this.D = true;
        this.R = -100;
        this.X = new Runnable() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.2
            @Override // java.lang.Runnable
            public void run() {
                if ((AppCompatDelegateImpl.this.s & 1) != 0) {
                    AppCompatDelegateImpl.this.h(0);
                }
                if ((AppCompatDelegateImpl.this.s & 4096) != 0) {
                    AppCompatDelegateImpl.this.h(108);
                }
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                appCompatDelegateImpl.r = false;
                appCompatDelegateImpl.s = 0;
            }
        };
        this.b = context;
        this.d = dVar;
        this.f152a = obj;
        if (this.R == -100 && (this.f152a instanceof Dialog) && (C = C()) != null) {
            this.R = C.getDelegate().j();
        }
        if (this.R == -100 && (num = t.get(this.f152a.getClass())) != null) {
            this.R = num.intValue();
            t.remove(this.f152a.getClass());
        }
        if (window != null) {
            a(window);
        }
        androidx.appcompat.widget.j.a();
    }

    @Override // androidx.appcompat.app.e
    public void a(Context context) {
        a(false);
        this.O = true;
    }

    @Override // androidx.appcompat.app.e
    public void a(Bundle bundle) {
        this.O = true;
        a(false);
        y();
        Object obj = this.f152a;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = androidx.core.app.f.b((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                androidx.appcompat.app.a l = l();
                if (l == null) {
                    this.Y = true;
                } else {
                    l.d(true);
                }
            }
        }
        this.P = true;
    }

    @Override // androidx.appcompat.app.e
    public void b(Bundle bundle) {
        z();
    }

    @Override // androidx.appcompat.app.e
    public androidx.appcompat.app.a a() {
        w();
        return this.e;
    }

    final androidx.appcompat.app.a l() {
        return this.e;
    }

    final Window.Callback m() {
        return this.c.getCallback();
    }

    private void w() {
        z();
        if (this.l && this.e == null) {
            Object obj = this.f152a;
            if (obj instanceof Activity) {
                this.e = new l((Activity) obj, this.m);
            } else if (obj instanceof Dialog) {
                this.e = new l((Dialog) obj);
            }
            androidx.appcompat.app.a aVar = this.e;
            if (aVar != null) {
                aVar.d(this.Y);
            }
        }
    }

    @Override // androidx.appcompat.app.e
    public void a(Toolbar toolbar) {
        if (this.f152a instanceof Activity) {
            androidx.appcompat.app.a a2 = a();
            if (a2 instanceof l) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.f = null;
            if (a2 != null) {
                a2.g();
            }
            if (toolbar != null) {
                androidx.appcompat.app.i iVar = new androidx.appcompat.app.i(toolbar, o(), this.y);
                this.e = iVar;
                this.c.setCallback(iVar.h());
            } else {
                this.e = null;
                this.c.setCallback(this.y);
            }
            f();
        }
    }

    final Context n() {
        androidx.appcompat.app.a a2 = a();
        Context b2 = a2 != null ? a2.b() : null;
        return b2 == null ? this.b : b2;
    }

    @Override // androidx.appcompat.app.e
    public MenuInflater b() {
        if (this.f == null) {
            w();
            androidx.appcompat.app.a aVar = this.e;
            this.f = new androidx.appcompat.view.g(aVar != null ? aVar.b() : this.b);
        }
        return this.f;
    }

    @Override // androidx.appcompat.app.e
    public <T extends View> T b(int i2) {
        z();
        return (T) this.c.findViewById(i2);
    }

    @Override // androidx.appcompat.app.e
    public void a(Configuration configuration) {
        androidx.appcompat.app.a a2;
        if (this.l && this.E && (a2 = a()) != null) {
            a2.a(configuration);
        }
        androidx.appcompat.widget.j.b().a(this.b);
        a(false);
    }

    @Override // androidx.appcompat.app.e
    public void c() {
        this.Q = true;
        u();
        a(this);
    }

    @Override // androidx.appcompat.app.e
    public void d() {
        this.Q = false;
        b(this);
        androidx.appcompat.app.a a2 = a();
        if (a2 != null) {
            a2.e(false);
        }
        if (this.f152a instanceof Dialog) {
            x();
        }
    }

    @Override // androidx.appcompat.app.e
    public void e() {
        androidx.appcompat.app.a a2 = a();
        if (a2 != null) {
            a2.e(true);
        }
    }

    @Override // androidx.appcompat.app.e
    public void a(View view) {
        z();
        ViewGroup viewGroup = (ViewGroup) this.F.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.y.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.e
    public void c(int i2) {
        z();
        ViewGroup viewGroup = (ViewGroup) this.F.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.b).inflate(i2, viewGroup);
        this.y.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.e
    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        z();
        ViewGroup viewGroup = (ViewGroup) this.F.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.y.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.e
    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        z();
        ((ViewGroup) this.F.findViewById(R.id.content)).addView(view, layoutParams);
        this.y.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.e
    public void c(Bundle bundle) {
        if (this.R != -100) {
            t.put(this.f152a.getClass(), Integer.valueOf(this.R));
        }
    }

    @Override // androidx.appcompat.app.e
    public void g() {
        b(this);
        if (this.r) {
            this.c.getDecorView().removeCallbacks(this.X);
        }
        this.Q = false;
        this.q = true;
        androidx.appcompat.app.a aVar = this.e;
        if (aVar != null) {
            aVar.g();
        }
        x();
    }

    private void x() {
        f fVar = this.V;
        if (fVar != null) {
            fVar.e();
        }
        f fVar2 = this.W;
        if (fVar2 != null) {
            fVar2.e();
        }
    }

    @Override // androidx.appcompat.app.e
    public void a(int i2) {
        this.S = i2;
    }

    private void y() {
        if (this.c == null) {
            Object obj = this.f152a;
            if (obj instanceof Activity) {
                a(((Activity) obj).getWindow());
            }
        }
        if (this.c == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private void a(Window window) {
        if (this.c != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof d) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.y = new d(callback);
        window.setCallback(this.y);
        au a2 = au.a(this.b, (AttributeSet) null, v);
        Drawable b2 = a2.b(0);
        if (b2 != null) {
            window.setBackgroundDrawable(b2);
        }
        a2.a();
        this.c = window;
    }

    private void z() {
        if (this.E) {
            return;
        }
        this.F = A();
        CharSequence o = o();
        if (!TextUtils.isEmpty(o)) {
            aa aaVar = this.A;
            if (aaVar != null) {
                aaVar.setWindowTitle(o);
            } else if (l() != null) {
                l().b(o);
            } else {
                TextView textView = this.G;
                if (textView != null) {
                    textView.setText(o);
                }
            }
        }
        B();
        a(this.F);
        this.E = true;
        PanelFeatureState a2 = a(0, false);
        if (this.q) {
            return;
        }
        if (a2 == null || a2.j == null) {
            k(108);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ViewGroup A() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.b.obtainStyledAttributes(a.j.AppCompatTheme);
        if (!obtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowActionBar)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(a.j.AppCompatTheme_windowNoTitle, false)) {
            d(1);
        } else if (obtainStyledAttributes.getBoolean(a.j.AppCompatTheme_windowActionBar, false)) {
            d(108);
        }
        if (obtainStyledAttributes.getBoolean(a.j.AppCompatTheme_windowActionBarOverlay, false)) {
            d(109);
        }
        if (obtainStyledAttributes.getBoolean(a.j.AppCompatTheme_windowActionModeOverlay, false)) {
            d(10);
        }
        this.o = obtainStyledAttributes.getBoolean(a.j.AppCompatTheme_android_windowIsFloating, false);
        obtainStyledAttributes.recycle();
        y();
        this.c.getDecorView();
        LayoutInflater from = LayoutInflater.from(this.b);
        if (!this.p) {
            if (this.o) {
                viewGroup = (ViewGroup) from.inflate(a.g.abc_dialog_title_material, (ViewGroup) null);
                this.m = false;
                this.l = false;
            } else if (this.l) {
                TypedValue typedValue = new TypedValue();
                this.b.getTheme().resolveAttribute(a.C0024a.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    context = new androidx.appcompat.view.d(this.b, typedValue.resourceId);
                } else {
                    context = this.b;
                }
                viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(a.g.abc_screen_toolbar, (ViewGroup) null);
                this.A = (aa) viewGroup.findViewById(a.f.decor_content_parent);
                this.A.setWindowCallback(m());
                if (this.m) {
                    this.A.a(109);
                }
                if (this.I) {
                    this.A.a(2);
                }
                if (this.J) {
                    this.A.a(5);
                }
            } else {
                viewGroup = null;
            }
        } else {
            if (this.n) {
                viewGroup = (ViewGroup) from.inflate(a.g.abc_screen_simple_overlay_action_mode, (ViewGroup) null);
            } else {
                viewGroup = (ViewGroup) from.inflate(a.g.abc_screen_simple, (ViewGroup) null);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                v.a(viewGroup, new r() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.3
                    @Override // androidx.core.f.r
                    public ad a(View view, ad adVar) {
                        int b2 = adVar.b();
                        int i2 = AppCompatDelegateImpl.this.i(b2);
                        if (b2 != i2) {
                            adVar = adVar.a(adVar.a(), i2, adVar.c(), adVar.d());
                        }
                        return v.a(view, adVar);
                    }
                });
            } else {
                ((ae) viewGroup).setOnFitSystemWindowsListener(new ae.a() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.4
                    @Override // androidx.appcompat.widget.ae.a
                    public void a(Rect rect) {
                        rect.top = AppCompatDelegateImpl.this.i(rect.top);
                    }
                });
            }
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.l + ", windowActionBarOverlay: " + this.m + ", android:windowIsFloating: " + this.o + ", windowActionModeOverlay: " + this.n + ", windowNoTitle: " + this.p + " }");
        }
        if (this.A == null) {
            this.G = (TextView) viewGroup.findViewById(a.f.title);
        }
        ba.b(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(a.f.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.c.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.c.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new ContentFrameLayout.a() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.5
            @Override // androidx.appcompat.widget.ContentFrameLayout.a
            public void a() {
            }

            @Override // androidx.appcompat.widget.ContentFrameLayout.a
            public void b() {
                AppCompatDelegateImpl.this.t();
            }
        });
        return viewGroup;
    }

    private void B() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.F.findViewById(R.id.content);
        View decorView = this.c.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.b.obtainStyledAttributes(a.j.AppCompatTheme);
        obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    @Override // androidx.appcompat.app.e
    public boolean d(int i2) {
        int l = l(i2);
        if (this.p && l == 108) {
            return false;
        }
        if (this.l && l == 1) {
            this.l = false;
        }
        switch (l) {
            case 1:
                D();
                this.p = true;
                return true;
            case 2:
                D();
                this.I = true;
                return true;
            case 5:
                D();
                this.J = true;
                return true;
            case 10:
                D();
                this.n = true;
                return true;
            case 108:
                D();
                this.l = true;
                return true;
            case 109:
                D();
                this.m = true;
                return true;
            default:
                return this.c.requestFeature(l);
        }
    }

    @Override // androidx.appcompat.app.e
    public final void a(CharSequence charSequence) {
        this.z = charSequence;
        aa aaVar = this.A;
        if (aaVar != null) {
            aaVar.setWindowTitle(charSequence);
            return;
        }
        if (l() != null) {
            l().b(charSequence);
            return;
        }
        TextView textView = this.G;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    final CharSequence o() {
        Object obj = this.f152a;
        if (obj instanceof Activity) {
            return ((Activity) obj).getTitle();
        }
        return this.z;
    }

    void e(int i2) {
        if (i2 == 108) {
            androidx.appcompat.app.a a2 = a();
            if (a2 != null) {
                a2.f(false);
                return;
            }
            return;
        }
        if (i2 == 0) {
            PanelFeatureState a3 = a(i2, true);
            if (a3.o) {
                a(a3, false);
            }
        }
    }

    void f(int i2) {
        androidx.appcompat.app.a a2;
        if (i2 != 108 || (a2 = a()) == null) {
            return;
        }
        a2.f(true);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        PanelFeatureState a2;
        Window.Callback m = m();
        if (m == null || this.q || (a2 = a((Menu) gVar.q())) == null) {
            return false;
        }
        return m.onMenuItemSelected(a2.f161a, menuItem);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public void a(androidx.appcompat.view.menu.g gVar) {
        a(gVar, true);
    }

    @Override // androidx.appcompat.app.e
    public androidx.appcompat.view.b a(b.a aVar) {
        androidx.appcompat.app.d dVar;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        androidx.appcompat.view.b bVar = this.g;
        if (bVar != null) {
            bVar.c();
        }
        c cVar = new c(aVar);
        androidx.appcompat.app.a a2 = a();
        if (a2 != null) {
            this.g = a2.a(cVar);
            androidx.appcompat.view.b bVar2 = this.g;
            if (bVar2 != null && (dVar = this.d) != null) {
                dVar.onSupportActionModeStarted(bVar2);
            }
        }
        if (this.g == null) {
            this.g = b(cVar);
        }
        return this.g;
    }

    @Override // androidx.appcompat.app.e
    public void f() {
        androidx.appcompat.app.a a2 = a();
        if (a2 == null || !a2.e()) {
            k(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.appcompat.view.b b(androidx.appcompat.view.b.a r8) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.b(androidx.appcompat.view.b$a):androidx.appcompat.view.b");
    }

    final boolean p() {
        ViewGroup viewGroup;
        return this.E && (viewGroup = this.F) != null && v.x(viewGroup);
    }

    public boolean q() {
        return this.D;
    }

    void r() {
        z zVar = this.k;
        if (zVar != null) {
            zVar.b();
        }
    }

    boolean s() {
        androidx.appcompat.view.b bVar = this.g;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        androidx.appcompat.app.a a2 = a();
        return a2 != null && a2.f();
    }

    boolean a(int i2, KeyEvent keyEvent) {
        androidx.appcompat.app.a a2 = a();
        if (a2 != null && a2.a(i2, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.M;
        if (panelFeatureState != null && a(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            PanelFeatureState panelFeatureState2 = this.M;
            if (panelFeatureState2 != null) {
                panelFeatureState2.n = true;
            }
            return true;
        }
        if (this.M == null) {
            PanelFeatureState a3 = a(0, true);
            b(a3, keyEvent);
            boolean a4 = a(a3, keyEvent.getKeyCode(), keyEvent, 1);
            a3.m = false;
            if (a4) {
                return true;
            }
        }
        return false;
    }

    boolean a(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f152a;
        if (((obj instanceof e.a) || (obj instanceof androidx.appcompat.app.f)) && (decorView = this.c.getDecorView()) != null && androidx.core.f.e.a(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.y.a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? c(keyCode, keyEvent) : b(keyCode, keyEvent);
    }

    boolean b(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            boolean z = this.N;
            this.N = false;
            PanelFeatureState a2 = a(0, false);
            if (a2 != null && a2.o) {
                if (!z) {
                    a(a2, true);
                }
                return true;
            }
            if (s()) {
                return true;
            }
        } else if (i2 == 82) {
            e(0, keyEvent);
            return true;
        }
        return false;
    }

    boolean c(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            this.N = (keyEvent.getFlags() & 128) != 0;
        } else if (i2 == 82) {
            d(0, keyEvent);
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        boolean z2 = false;
        if (this.ab == null) {
            String string = this.b.obtainStyledAttributes(a.j.AppCompatTheme).getString(a.j.AppCompatTheme_viewInflaterClass);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                this.ab = new AppCompatViewInflater();
            } else {
                try {
                    this.ab = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.ab = new AppCompatViewInflater();
                }
            }
        }
        if (u) {
            if (attributeSet instanceof XmlPullParser) {
                if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    z2 = true;
                }
            } else {
                z2 = a((ViewParent) view);
            }
            z = z2;
        } else {
            z = false;
        }
        return this.ab.createView(view, str, context, attributeSet, z, u, true, az.a());
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.c.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || v.A((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    @Override // androidx.appcompat.app.e
    public void i() {
        LayoutInflater from = LayoutInflater.from(this.b);
        if (from.getFactory() == null) {
            androidx.core.f.f.a(from, this);
        } else {
            if (from.getFactory2() instanceof AppCompatDelegateImpl) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return a(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    private AppCompatActivity C() {
        for (Context context = this.b; context != null; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof AppCompatActivity) {
                return (AppCompatActivity) context;
            }
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
        }
        return null;
    }

    private void a(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i2;
        ViewGroup.LayoutParams layoutParams;
        if (panelFeatureState.o || this.q) {
            return;
        }
        if (panelFeatureState.f161a == 0) {
            if ((this.b.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback m = m();
        if (m != null && !m.onMenuOpened(panelFeatureState.f161a, panelFeatureState.j)) {
            a(panelFeatureState, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.b.getSystemService("window");
        if (windowManager != null && b(panelFeatureState, keyEvent)) {
            if (panelFeatureState.g == null || panelFeatureState.q) {
                if (panelFeatureState.g == null) {
                    if (!a(panelFeatureState) || panelFeatureState.g == null) {
                        return;
                    }
                } else if (panelFeatureState.q && panelFeatureState.g.getChildCount() > 0) {
                    panelFeatureState.g.removeAllViews();
                }
                if (!c(panelFeatureState) || !panelFeatureState.a()) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams2 = panelFeatureState.h.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                }
                panelFeatureState.g.setBackgroundResource(panelFeatureState.b);
                ViewParent parent = panelFeatureState.h.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(panelFeatureState.h);
                }
                panelFeatureState.g.addView(panelFeatureState.h, layoutParams2);
                if (!panelFeatureState.h.hasFocus()) {
                    panelFeatureState.h.requestFocus();
                }
            } else if (panelFeatureState.i != null && (layoutParams = panelFeatureState.i.getLayoutParams()) != null && layoutParams.width == -1) {
                i2 = -1;
                panelFeatureState.n = false;
                WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i2, -2, panelFeatureState.d, panelFeatureState.e, 1002, 8519680, -3);
                layoutParams3.gravity = panelFeatureState.c;
                layoutParams3.windowAnimations = panelFeatureState.f;
                windowManager.addView(panelFeatureState.g, layoutParams3);
                panelFeatureState.o = true;
            }
            i2 = -2;
            panelFeatureState.n = false;
            WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i2, -2, panelFeatureState.d, panelFeatureState.e, 1002, 8519680, -3);
            layoutParams32.gravity = panelFeatureState.c;
            layoutParams32.windowAnimations = panelFeatureState.f;
            windowManager.addView(panelFeatureState.g, layoutParams32);
            panelFeatureState.o = true;
        }
    }

    private boolean a(PanelFeatureState panelFeatureState) {
        panelFeatureState.a(n());
        panelFeatureState.g = new h(panelFeatureState.l);
        panelFeatureState.c = 81;
        return true;
    }

    private void a(androidx.appcompat.view.menu.g gVar, boolean z) {
        aa aaVar = this.A;
        if (aaVar != null && aaVar.e() && (!ViewConfiguration.get(this.b).hasPermanentMenuKey() || this.A.g())) {
            Window.Callback m = m();
            if (!this.A.f() || !z) {
                if (m == null || this.q) {
                    return;
                }
                if (this.r && (this.s & 1) != 0) {
                    this.c.getDecorView().removeCallbacks(this.X);
                    this.X.run();
                }
                PanelFeatureState a2 = a(0, true);
                if (a2.j == null || a2.r || !m.onPreparePanel(0, a2.i, a2.j)) {
                    return;
                }
                m.onMenuOpened(108, a2.j);
                this.A.h();
                return;
            }
            this.A.i();
            if (this.q) {
                return;
            }
            m.onPanelClosed(108, a(0, true).j);
            return;
        }
        PanelFeatureState a3 = a(0, true);
        a3.q = true;
        a(a3, false);
        a(a3, (KeyEvent) null);
    }

    private boolean b(PanelFeatureState panelFeatureState) {
        Context context = this.b;
        if ((panelFeatureState.f161a == 0 || panelFeatureState.f161a == 108) && this.A != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(a.C0024a.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(a.C0024a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(a.C0024a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
        gVar.a(this);
        panelFeatureState.a(gVar);
        return true;
    }

    private boolean c(PanelFeatureState panelFeatureState) {
        if (panelFeatureState.i != null) {
            panelFeatureState.h = panelFeatureState.i;
            return true;
        }
        if (panelFeatureState.j == null) {
            return false;
        }
        if (this.C == null) {
            this.C = new i();
        }
        panelFeatureState.h = (View) panelFeatureState.a(this.C);
        return panelFeatureState.h != null;
    }

    private boolean b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        aa aaVar;
        aa aaVar2;
        aa aaVar3;
        if (this.q) {
            return false;
        }
        if (panelFeatureState.m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.M;
        if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
            a(panelFeatureState2, false);
        }
        Window.Callback m = m();
        if (m != null) {
            panelFeatureState.i = m.onCreatePanelView(panelFeatureState.f161a);
        }
        boolean z = panelFeatureState.f161a == 0 || panelFeatureState.f161a == 108;
        if (z && (aaVar3 = this.A) != null) {
            aaVar3.j();
        }
        if (panelFeatureState.i == null && (!z || !(l() instanceof androidx.appcompat.app.i))) {
            if (panelFeatureState.j == null || panelFeatureState.r) {
                if (panelFeatureState.j == null && (!b(panelFeatureState) || panelFeatureState.j == null)) {
                    return false;
                }
                if (z && this.A != null) {
                    if (this.B == null) {
                        this.B = new b();
                    }
                    this.A.a(panelFeatureState.j, this.B);
                }
                panelFeatureState.j.h();
                if (!m.onCreatePanelMenu(panelFeatureState.f161a, panelFeatureState.j)) {
                    panelFeatureState.a((androidx.appcompat.view.menu.g) null);
                    if (z && (aaVar = this.A) != null) {
                        aaVar.a(null, this.B);
                    }
                    return false;
                }
                panelFeatureState.r = false;
            }
            panelFeatureState.j.h();
            if (panelFeatureState.s != null) {
                panelFeatureState.j.d(panelFeatureState.s);
                panelFeatureState.s = null;
            }
            if (!m.onPreparePanel(0, panelFeatureState.i, panelFeatureState.j)) {
                if (z && (aaVar2 = this.A) != null) {
                    aaVar2.a(null, this.B);
                }
                panelFeatureState.j.i();
                return false;
            }
            panelFeatureState.p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.j.setQwertyMode(panelFeatureState.p);
            panelFeatureState.j.i();
        }
        panelFeatureState.m = true;
        panelFeatureState.n = false;
        this.M = panelFeatureState;
        return true;
    }

    void b(androidx.appcompat.view.menu.g gVar) {
        if (this.K) {
            return;
        }
        this.K = true;
        this.A.k();
        Window.Callback m = m();
        if (m != null && !this.q) {
            m.onPanelClosed(108, gVar);
        }
        this.K = false;
    }

    void g(int i2) {
        a(a(i2, true), true);
    }

    void a(PanelFeatureState panelFeatureState, boolean z) {
        aa aaVar;
        if (z && panelFeatureState.f161a == 0 && (aaVar = this.A) != null && aaVar.f()) {
            b(panelFeatureState.j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.b.getSystemService("window");
        if (windowManager != null && panelFeatureState.o && panelFeatureState.g != null) {
            windowManager.removeView(panelFeatureState.g);
            if (z) {
                a(panelFeatureState.f161a, panelFeatureState, null);
            }
        }
        panelFeatureState.m = false;
        panelFeatureState.n = false;
        panelFeatureState.o = false;
        panelFeatureState.h = null;
        panelFeatureState.q = true;
        if (this.M == panelFeatureState) {
            this.M = null;
        }
    }

    private boolean d(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState a2 = a(i2, true);
        if (a2.o) {
            return false;
        }
        return b(a2, keyEvent);
    }

    private boolean e(int i2, KeyEvent keyEvent) {
        boolean z;
        boolean z2;
        aa aaVar;
        if (this.g != null) {
            return false;
        }
        PanelFeatureState a2 = a(i2, true);
        if (i2 == 0 && (aaVar = this.A) != null && aaVar.e() && !ViewConfiguration.get(this.b).hasPermanentMenuKey()) {
            if (!this.A.f()) {
                if (!this.q && b(a2, keyEvent)) {
                    z = this.A.h();
                }
                z = false;
            } else {
                z = this.A.i();
            }
        } else if (a2.o || a2.n) {
            z = a2.o;
            a(a2, true);
        } else {
            if (a2.m) {
                if (a2.r) {
                    a2.m = false;
                    z2 = b(a2, keyEvent);
                } else {
                    z2 = true;
                }
                if (z2) {
                    a(a2, keyEvent);
                    z = true;
                }
            }
            z = false;
        }
        if (z) {
            AudioManager audioManager = (AudioManager) this.b.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z;
    }

    void a(int i2, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i2 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.L;
                if (i2 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i2];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.o) && !this.q) {
            this.y.a().onPanelClosed(i2, menu);
        }
    }

    PanelFeatureState a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.L;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
            if (panelFeatureState != null && panelFeatureState.j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    protected PanelFeatureState a(int i2, boolean z) {
        PanelFeatureState[] panelFeatureStateArr = this.L;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i2) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i2 + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.L = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i2);
        panelFeatureStateArr[i2] = panelFeatureState2;
        return panelFeatureState2;
    }

    private boolean a(PanelFeatureState panelFeatureState, int i2, KeyEvent keyEvent, int i3) {
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.m || b(panelFeatureState, keyEvent)) && panelFeatureState.j != null) {
            z = panelFeatureState.j.performShortcut(i2, keyEvent, i3);
        }
        if (z && (i3 & 1) == 0 && this.A == null) {
            a(panelFeatureState, true);
        }
        return z;
    }

    private void k(int i2) {
        this.s = (1 << i2) | this.s;
        if (this.r) {
            return;
        }
        v.a(this.c.getDecorView(), this.X);
        this.r = true;
    }

    void h(int i2) {
        PanelFeatureState a2;
        PanelFeatureState a3 = a(i2, true);
        if (a3.j != null) {
            Bundle bundle = new Bundle();
            a3.j.c(bundle);
            if (bundle.size() > 0) {
                a3.s = bundle;
            }
            a3.j.h();
            a3.j.clear();
        }
        a3.r = true;
        a3.q = true;
        if ((i2 != 108 && i2 != 0) || this.A == null || (a2 = a(0, false)) == null) {
            return;
        }
        a2.m = false;
        b(a2, (KeyEvent) null);
    }

    int i(int i2) {
        boolean z;
        boolean z2;
        ActionBarContextView actionBarContextView = this.h;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.h.getLayoutParams();
            if (this.h.isShown()) {
                if (this.Z == null) {
                    this.Z = new Rect();
                    this.aa = new Rect();
                }
                Rect rect = this.Z;
                Rect rect2 = this.aa;
                rect.set(0, i2, 0, 0);
                ba.a(this.F, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i2 : 0)) {
                    marginLayoutParams.topMargin = i2;
                    View view = this.H;
                    if (view == null) {
                        this.H = new View(this.b);
                        this.H.setBackgroundColor(this.b.getResources().getColor(a.c.abc_input_method_navigation_guard));
                        this.F.addView(this.H, -1, new ViewGroup.LayoutParams(-1, i2));
                    } else {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i2) {
                            layoutParams.height = i2;
                            this.H.setLayoutParams(layoutParams);
                        }
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = this.H != null;
                if (!this.n && z) {
                    i2 = 0;
                }
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z2 = true;
                z = false;
            } else {
                z2 = false;
                z = false;
            }
            if (z2) {
                this.h.setLayoutParams(marginLayoutParams);
            }
        }
        View view2 = this.H;
        if (view2 != null) {
            view2.setVisibility(z ? 0 : 8);
        }
        return i2;
    }

    private void D() {
        if (this.E) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private int l(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i2 != 9) {
            return i2;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    void t() {
        aa aaVar = this.A;
        if (aaVar != null) {
            aaVar.k();
        }
        if (this.i != null) {
            this.c.getDecorView().removeCallbacks(this.j);
            if (this.i.isShowing()) {
                try {
                    this.i.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.i = null;
        }
        r();
        PanelFeatureState a2 = a(0, false);
        if (a2 == null || a2.j == null) {
            return;
        }
        a2.j.close();
    }

    public boolean u() {
        return a(true);
    }

    private boolean a(boolean z) {
        if (this.q) {
            return false;
        }
        int E = E();
        boolean b2 = b(j(E), z);
        if (E == 0) {
            v().d();
        } else {
            f fVar = this.V;
            if (fVar != null) {
                fVar.e();
            }
        }
        if (E == 3) {
            F().d();
        } else {
            f fVar2 = this.W;
            if (fVar2 != null) {
                fVar2.e();
            }
        }
        return b2;
    }

    @Override // androidx.appcompat.app.e
    public int j() {
        return this.R;
    }

    int j(int i2) {
        if (i2 == -100) {
            return -1;
        }
        switch (i2) {
            case -1:
            case 1:
            case 2:
                return i2;
            case 0:
                if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) this.b.getSystemService(UiModeManager.class)).getNightMode() != 0) {
                    return v().a();
                }
                return -1;
            case 3:
                return F().a();
            default:
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
        }
    }

    private int E() {
        int i2 = this.R;
        return i2 != -100 ? i2 : k();
    }

    private boolean b(int i2, boolean z) {
        int i3;
        int i4 = this.b.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        switch (i2) {
            case 1:
                i3 = 16;
                break;
            case 2:
                i3 = 32;
                break;
            default:
                i3 = i4;
                break;
        }
        boolean G = G();
        boolean z2 = false;
        if ((x || i3 != i4) && !G && Build.VERSION.SDK_INT >= 17 && !this.O && (this.f152a instanceof ContextThemeWrapper)) {
            Configuration configuration = new Configuration();
            configuration.uiMode = (configuration.uiMode & (-49)) | i3;
            try {
                ((ContextThemeWrapper) this.f152a).applyOverrideConfiguration(configuration);
                z2 = true;
            } catch (IllegalStateException e2) {
                Log.e("AppCompatDelegate", "updateForNightMode. Calling applyOverrideConfiguration() failed with an exception. Will fall back to using Resources.updateConfiguration()", e2);
            }
        }
        int i5 = this.b.getResources().getConfiguration().uiMode & 48;
        if (!z2 && i5 != i3 && z && !G && this.O && (Build.VERSION.SDK_INT >= 17 || this.P)) {
            Object obj = this.f152a;
            if (obj instanceof Activity) {
                androidx.core.app.a.e((Activity) obj);
                z2 = true;
            }
        }
        if (!z2 && i5 != i3) {
            c(i3, G);
            z2 = true;
        }
        if (z2) {
            Object obj2 = this.f152a;
            if (obj2 instanceof AppCompatActivity) {
                ((AppCompatActivity) obj2).onNightModeChanged(i2);
            }
        }
        return z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c(int i2, boolean z) {
        Resources resources = this.b.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.uiMode = i2 | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration, null);
        if (Build.VERSION.SDK_INT < 26) {
            androidx.appcompat.app.h.a(resources);
        }
        int i3 = this.S;
        if (i3 != 0) {
            this.b.setTheme(i3);
            if (Build.VERSION.SDK_INT >= 23) {
                this.b.getTheme().applyStyle(this.S, true);
            }
        }
        if (z) {
            Object obj = this.f152a;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof androidx.lifecycle.k) {
                    if (((androidx.lifecycle.k) activity).getLifecycle().a().a(Lifecycle.State.STARTED)) {
                        activity.onConfigurationChanged(configuration);
                    }
                } else if (this.Q) {
                    activity.onConfigurationChanged(configuration);
                }
            }
        }
    }

    final f v() {
        if (this.V == null) {
            this.V = new g(k.a(this.b));
        }
        return this.V;
    }

    private f F() {
        if (this.W == null) {
            this.W = new e(this.b);
        }
        return this.W;
    }

    private boolean G() {
        if (!this.U && (this.f152a instanceof Activity)) {
            PackageManager packageManager = this.b.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.b, this.f152a.getClass()), 0);
                this.T = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                this.T = false;
            }
        }
        this.U = true;
        return this.T;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements b.a {
        private b.a b;

        public c(b.a aVar) {
            this.b = aVar;
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(androidx.appcompat.view.b bVar, Menu menu) {
            return this.b.a(bVar, menu);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean b(androidx.appcompat.view.b bVar, Menu menu) {
            return this.b.b(bVar, menu);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(androidx.appcompat.view.b bVar, MenuItem menuItem) {
            return this.b.a(bVar, menuItem);
        }

        @Override // androidx.appcompat.view.b.a
        public void a(androidx.appcompat.view.b bVar) {
            this.b.a(bVar);
            if (AppCompatDelegateImpl.this.i != null) {
                AppCompatDelegateImpl.this.c.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.j);
            }
            if (AppCompatDelegateImpl.this.h != null) {
                AppCompatDelegateImpl.this.r();
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                appCompatDelegateImpl.k = v.l(appCompatDelegateImpl.h).a(0.0f);
                AppCompatDelegateImpl.this.k.a(new ab() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.c.1
                    @Override // androidx.core.f.ab, androidx.core.f.aa
                    public void b(View view) {
                        AppCompatDelegateImpl.this.h.setVisibility(8);
                        if (AppCompatDelegateImpl.this.i != null) {
                            AppCompatDelegateImpl.this.i.dismiss();
                        } else if (AppCompatDelegateImpl.this.h.getParent() instanceof View) {
                            v.p((View) AppCompatDelegateImpl.this.h.getParent());
                        }
                        AppCompatDelegateImpl.this.h.removeAllViews();
                        AppCompatDelegateImpl.this.k.a((androidx.core.f.aa) null);
                        AppCompatDelegateImpl.this.k = null;
                    }
                });
            }
            if (AppCompatDelegateImpl.this.d != null) {
                AppCompatDelegateImpl.this.d.onSupportActionModeFinished(AppCompatDelegateImpl.this.g);
            }
            AppCompatDelegateImpl.this.g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class i implements m.a {
        i() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
            androidx.appcompat.view.menu.g q = gVar.q();
            boolean z2 = q != gVar;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z2) {
                gVar = q;
            }
            PanelFeatureState a2 = appCompatDelegateImpl.a((Menu) gVar);
            if (a2 != null) {
                if (z2) {
                    AppCompatDelegateImpl.this.a(a2.f161a, a2, q);
                    AppCompatDelegateImpl.this.a(a2, true);
                } else {
                    AppCompatDelegateImpl.this.a(a2, z);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean a(androidx.appcompat.view.menu.g gVar) {
            Window.Callback m;
            if (gVar != null || !AppCompatDelegateImpl.this.l || (m = AppCompatDelegateImpl.this.m()) == null || AppCompatDelegateImpl.this.q) {
                return true;
            }
            m.onMenuOpened(108, gVar);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b implements m.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean a(androidx.appcompat.view.menu.g gVar) {
            Window.Callback m = AppCompatDelegateImpl.this.m();
            if (m == null) {
                return true;
            }
            m.onMenuOpened(108, gVar);
            return true;
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
            AppCompatDelegateImpl.this.b(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class PanelFeatureState {

        /* renamed from: a, reason: collision with root package name */
        int f161a;
        int b;
        int c;
        int d;
        int e;
        int f;
        ViewGroup g;
        View h;
        View i;
        androidx.appcompat.view.menu.g j;
        androidx.appcompat.view.menu.e k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        PanelFeatureState(int i) {
            this.f161a = i;
        }

        public boolean a() {
            if (this.h == null) {
                return false;
            }
            return this.i != null || this.k.a().getCount() > 0;
        }

        void a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(a.C0024a.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(a.C0024a.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(a.i.Theme_AppCompat_CompactMenu, true);
            }
            androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(a.j.AppCompatTheme);
            this.b = obtainStyledAttributes.getResourceId(a.j.AppCompatTheme_panelBackground, 0);
            this.f = obtainStyledAttributes.getResourceId(a.j.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        void a(androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.e eVar;
            androidx.appcompat.view.menu.g gVar2 = this.j;
            if (gVar == gVar2) {
                return;
            }
            if (gVar2 != null) {
                gVar2.b(this.k);
            }
            this.j = gVar;
            if (gVar == null || (eVar = this.k) == null) {
                return;
            }
            gVar.a(eVar);
        }

        n a(m.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                this.k = new androidx.appcompat.view.menu.e(this.l, a.g.abc_list_menu_item_layout);
                this.k.a(aVar);
                this.j.a(this.k);
            }
            return this.k.a(this.g);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @SuppressLint({"BanParcelableUsage"})
        /* loaded from: classes.dex */
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState.SavedState.1
                @Override // android.os.Parcelable.ClassLoaderCreator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.a(parcel, null);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            };

            /* renamed from: a, reason: collision with root package name */
            int f162a;
            boolean b;
            Bundle c;

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            SavedState() {
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f162a);
                parcel.writeInt(this.b ? 1 : 0);
                if (this.b) {
                    parcel.writeBundle(this.c);
                }
            }

            static SavedState a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f162a = parcel.readInt();
                savedState.b = parcel.readInt() == 1;
                if (savedState.b) {
                    savedState.c = parcel.readBundle(classLoader);
                }
                return savedState;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class h extends ContentFrameLayout {
        public h(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                AppCompatDelegateImpl.this.g(0);
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
        }

        private boolean a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends androidx.appcompat.view.i {
        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onContentChanged() {
        }

        d(Window.Callback callback) {
            super(callback);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.a(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof androidx.appcompat.view.menu.g)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            androidx.appcompat.view.menu.g gVar = menu instanceof androidx.appcompat.view.menu.g ? (androidx.appcompat.view.menu.g) menu : null;
            if (i == 0 && gVar == null) {
                return false;
            }
            if (gVar != null) {
                gVar.c(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (gVar != null) {
                gVar.c(false);
            }
            return onPreparePanel;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            AppCompatDelegateImpl.this.f(i);
            return true;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            AppCompatDelegateImpl.this.e(i);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (AppCompatDelegateImpl.this.q()) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        final ActionMode a(ActionMode.Callback callback) {
            f.a aVar = new f.a(AppCompatDelegateImpl.this.b, callback);
            androidx.appcompat.view.b a2 = AppCompatDelegateImpl.this.a(aVar);
            if (a2 != null) {
                return aVar.b(a2);
            }
            return null;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (AppCompatDelegateImpl.this.q() && i == 0) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback, i);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            PanelFeatureState a2 = AppCompatDelegateImpl.this.a(0, true);
            if (a2 != null && a2.j != null) {
                super.onProvideKeyboardShortcuts(list, a2.j, i);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public abstract class f {

        /* renamed from: a, reason: collision with root package name */
        private BroadcastReceiver f169a;

        abstract int a();

        abstract void b();

        abstract IntentFilter c();

        f() {
        }

        void d() {
            e();
            IntentFilter c = c();
            if (c == null || c.countActions() == 0) {
                return;
            }
            if (this.f169a == null) {
                this.f169a = new BroadcastReceiver() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.f.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        f.this.b();
                    }
                };
            }
            AppCompatDelegateImpl.this.b.registerReceiver(this.f169a, c);
        }

        void e() {
            if (this.f169a != null) {
                try {
                    AppCompatDelegateImpl.this.b.unregisterReceiver(this.f169a);
                } catch (IllegalArgumentException unused) {
                }
                this.f169a = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g extends f {
        private final k c;

        g(k kVar) {
            super();
            this.c = kVar;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.f
        public int a() {
            return this.c.a() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.f
        public void b() {
            AppCompatDelegateImpl.this.u();
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.f
        IntentFilter c() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends f {
        private final PowerManager c;

        e(Context context) {
            super();
            this.c = (PowerManager) context.getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.f
        public int a() {
            return (Build.VERSION.SDK_INT < 21 || !this.c.isPowerSaveMode()) ? 1 : 2;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.f
        public void b() {
            AppCompatDelegateImpl.this.u();
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.f
        IntentFilter c() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }
    }

    @Override // androidx.appcompat.app.e
    public final b.a h() {
        return new a();
    }

    /* loaded from: classes.dex */
    private class a implements b.a {
        a() {
        }

        @Override // androidx.appcompat.app.b.a
        public void a(int i) {
            androidx.appcompat.app.a a2 = AppCompatDelegateImpl.this.a();
            if (a2 != null) {
                a2.a(i);
            }
        }
    }
}
