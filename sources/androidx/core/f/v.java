package androidx.core.f;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.a;
import androidx.core.f.a;
import com.amazonaws.event.ProgressEvent;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class v {
    private static Field b;
    private static boolean c;
    private static Field d;
    private static boolean e;
    private static WeakHashMap<View, String> f;
    private static Field h;
    private static ThreadLocal<Rect> j;

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f545a = new AtomicInteger(1);
    private static WeakHashMap<View, z> g = null;
    private static boolean i = false;
    private static final int[] k = {a.c.accessibility_custom_action_0, a.c.accessibility_custom_action_1, a.c.accessibility_custom_action_2, a.c.accessibility_custom_action_3, a.c.accessibility_custom_action_4, a.c.accessibility_custom_action_5, a.c.accessibility_custom_action_6, a.c.accessibility_custom_action_7, a.c.accessibility_custom_action_8, a.c.accessibility_custom_action_9, a.c.accessibility_custom_action_10, a.c.accessibility_custom_action_11, a.c.accessibility_custom_action_12, a.c.accessibility_custom_action_13, a.c.accessibility_custom_action_14, a.c.accessibility_custom_action_15, a.c.accessibility_custom_action_16, a.c.accessibility_custom_action_17, a.c.accessibility_custom_action_18, a.c.accessibility_custom_action_19, a.c.accessibility_custom_action_20, a.c.accessibility_custom_action_21, a.c.accessibility_custom_action_22, a.c.accessibility_custom_action_23, a.c.accessibility_custom_action_24, a.c.accessibility_custom_action_25, a.c.accessibility_custom_action_26, a.c.accessibility_custom_action_27, a.c.accessibility_custom_action_28, a.c.accessibility_custom_action_29, a.c.accessibility_custom_action_30, a.c.accessibility_custom_action_31};
    private static a l = new a();

    /* loaded from: classes.dex */
    public interface c {
        boolean a(View view, KeyEvent keyEvent);
    }

    private static Rect a() {
        if (j == null) {
            j = new ThreadLocal<>();
        }
        Rect rect = j.get();
        if (rect == null) {
            rect = new Rect();
            j.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void a(View view, androidx.core.f.a aVar) {
        if (aVar == null && (G(view) instanceof a.C0047a)) {
            aVar = new androidx.core.f.a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.a());
    }

    @SuppressLint({"InlinedApi"})
    public static int a(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static void a(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i2);
        }
    }

    public static boolean b(View view) {
        return G(view) != null;
    }

    private static View.AccessibilityDelegate G(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        return H(view);
    }

    private static View.AccessibilityDelegate H(View view) {
        if (i) {
            return null;
        }
        if (h == null) {
            try {
                h = View.class.getDeclaredField("mAccessibilityDelegate");
                h.setAccessible(true);
            } catch (Throwable unused) {
                i = true;
                return null;
            }
        }
        try {
            Object obj = h.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            i = true;
            return null;
        }
    }

    public static boolean c(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    public static void a(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z);
        }
    }

    public static void d(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static void a(View view, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation(i2, i3, i4, i5);
        } else {
            view.postInvalidate(i2, i3, i4, i5);
        }
    }

    public static void a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static void a(View view, Runnable runnable, long j2) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j2);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j2);
        }
    }

    public static int e(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    public static void b(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setImportantForAccessibility(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            if (i2 == 4) {
                i2 = 2;
            }
            view.setImportantForAccessibility(i2);
        }
    }

    public static void a(View view, Paint paint) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setLayerPaint(paint);
        } else {
            view.setLayerType(view.getLayerType(), paint);
            view.invalidate();
        }
    }

    public static int f(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static int g(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    public static void c(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i2);
        }
    }

    public static int h(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingStart();
        }
        return view.getPaddingLeft();
    }

    public static int i(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingEnd();
        }
        return view.getPaddingRight();
    }

    public static void b(View view, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i2, i3, i4, i5);
        } else {
            view.setPadding(i2, i3, i4, i5);
        }
    }

    public static int j(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!c) {
            try {
                b = View.class.getDeclaredField("mMinWidth");
                b.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            c = true;
        }
        Field field = b;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static int k(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!e) {
            try {
                d = View.class.getDeclaredField("mMinHeight");
                d.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            e = true;
        }
        Field field = d;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static z l(View view) {
        if (g == null) {
            g = new WeakHashMap<>();
        }
        z zVar = g.get(view);
        if (zVar != null) {
            return zVar;
        }
        z zVar2 = new z(view);
        g.put(view, zVar2);
        return zVar2;
    }

    public static void a(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f2);
        }
    }

    public static float m(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    public static void a(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f == null) {
            f = new WeakHashMap<>();
        }
        f.put(view, str);
    }

    public static String n(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = f;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    public static int o(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static void p(View view) {
        if (Build.VERSION.SDK_INT >= 20) {
            view.requestApplyInsets();
        } else if (Build.VERSION.SDK_INT >= 16) {
            view.requestFitSystemWindows();
        }
    }

    public static boolean q(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    @Deprecated
    public static void b(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static void a(View view, final r rVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (rVar == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: androidx.core.f.v.1
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                        return r.this.a(view2, ad.a(windowInsets)).j();
                    }
                });
            }
        }
    }

    public static ad a(View view, ad adVar) {
        WindowInsets j2;
        if (Build.VERSION.SDK_INT >= 21 && (j2 = adVar.j()) != null) {
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(j2);
            if (!onApplyWindowInsets.equals(j2)) {
                return ad.a(onApplyWindowInsets);
            }
        }
        return adVar;
    }

    public static ad b(View view, ad adVar) {
        WindowInsets j2;
        return (Build.VERSION.SDK_INT < 21 || (j2 = adVar.j()) == null || view.dispatchApplyWindowInsets(j2).equals(j2)) ? adVar : ad.a(j2);
    }

    public static boolean r(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean s(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    public static void a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ColorStateList t(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof u) {
            return ((u) view).getSupportBackgroundTintList();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(View view, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
                return;
            }
            return;
        }
        if (view instanceof u) {
            ((u) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static PorterDuff.Mode u(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof u) {
            return ((u) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(View view, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
                return;
            }
            return;
        }
        if (view instanceof u) {
            ((u) view).setSupportBackgroundTintMode(mode);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean v(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof j) {
            return ((j) view).isNestedScrollingEnabled();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void w(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof j) {
            ((j) view).stopNestedScroll();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(View view, int i2) {
        if (view instanceof k) {
            ((k) view).stopNestedScroll(i2);
        } else if (i2 == 0) {
            w(view);
        }
    }

    public static boolean x(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static float y(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static void e(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i2);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Rect a2 = a();
            boolean z = false;
            Object parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                a2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !a2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            h(view, i2);
            if (z && a2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(a2);
                return;
            }
            return;
        }
        h(view, i2);
    }

    private static void h(View view, int i2) {
        view.offsetTopAndBottom(i2);
        if (view.getVisibility() == 0) {
            I(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                I((View) parent);
            }
        }
    }

    public static void f(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i2);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Rect a2 = a();
            boolean z = false;
            Object parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                a2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !a2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            i(view, i2);
            if (z && a2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(a2);
                return;
            }
            return;
        }
        i(view, i2);
    }

    private static void i(View view, int i2) {
        view.offsetLeftAndRight(i2);
        if (view.getVisibility() == 0) {
            I(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                I((View) parent);
            }
        }
    }

    private static void I(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static void a(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    public static Rect z(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    public static boolean A(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    public static boolean B(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static void a(View view, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i2, i3);
        }
    }

    public static void a(View view, t tVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.setPointerIcon((PointerIcon) (tVar != null ? tVar.a() : null));
        }
    }

    public static Display C(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (A(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return d.a(view).a(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return d.a(view).a(view, keyEvent);
    }

    public static boolean D(View view) {
        Boolean c2 = b().c(view);
        if (c2 == null) {
            return false;
        }
        return c2.booleanValue();
    }

    private static b<Boolean> b() {
        return new b<Boolean>(a.c.tag_screen_reader_focusable, Boolean.class, 28) { // from class: androidx.core.f.v.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.f.v.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(View view) {
                return Boolean.valueOf(view.isScreenReaderFocusable());
            }
        };
    }

    public static CharSequence E(View view) {
        return c().c(view);
    }

    private static b<CharSequence> c() {
        return new b<CharSequence>(a.c.tag_accessibility_pane_title, CharSequence.class, 8, 28) { // from class: androidx.core.f.v.3
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.f.v.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public CharSequence b(View view) {
                return view.getAccessibilityPaneTitle();
            }
        };
    }

    public static boolean F(View view) {
        Boolean c2 = d().c(view);
        if (c2 == null) {
            return false;
        }
        return c2.booleanValue();
    }

    private static b<Boolean> d() {
        return new b<Boolean>(a.c.tag_accessibility_heading, Boolean.class, 28) { // from class: androidx.core.f.v.4
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.f.v.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(View view) {
                return Boolean.valueOf(view.isAccessibilityHeading());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class b<T> {

        /* renamed from: a, reason: collision with root package name */
        private final int f548a;
        private final Class<T> b;
        private final int c;

        abstract T b(View view);

        b(int i, Class<T> cls, int i2) {
            this(i, cls, 0, i2);
        }

        b(int i, Class<T> cls, int i2, int i3) {
            this.f548a = i;
            this.b = cls;
            this.c = i3;
        }

        T c(View view) {
            if (a()) {
                return b(view);
            }
            if (!b()) {
                return null;
            }
            T t = (T) view.getTag(this.f548a);
            if (this.b.isInstance(t)) {
                return t;
            }
            return null;
        }

        private boolean a() {
            return Build.VERSION.SDK_INT >= this.c;
        }

        private boolean b() {
            return Build.VERSION.SDK_INT >= 19;
        }
    }

    static void g(View view, int i2) {
        if (((AccessibilityManager) view.getContext().getSystemService("accessibility")).isEnabled()) {
            boolean z = E(view) != null;
            if (g(view) != 0 || (z && view.getVisibility() == 0)) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z ? 32 : ProgressEvent.PART_COMPLETED_EVENT_CODE);
                obtain.setContentChangeTypes(i2);
                view.sendAccessibilityEventUnchecked(obtain);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    static class a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        private WeakHashMap<View, Boolean> f547a = new WeakHashMap<>();

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }

        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            for (Map.Entry<View, Boolean> entry : this.f547a.entrySet()) {
                a(entry.getKey(), entry.getValue().booleanValue());
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            a(view);
        }

        private void a(View view, boolean z) {
            boolean z2 = view.getVisibility() == 0;
            if (z != z2) {
                if (z2) {
                    v.g(view, 16);
                }
                this.f547a.put(view, Boolean.valueOf(z2));
            }
        }

        private void a(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
    }

    /* loaded from: classes.dex */
    static class d {

        /* renamed from: a, reason: collision with root package name */
        private static final ArrayList<WeakReference<View>> f549a = new ArrayList<>();
        private WeakHashMap<View, Boolean> b = null;
        private SparseArray<WeakReference<View>> c = null;
        private WeakReference<KeyEvent> d = null;

        d() {
        }

        private SparseArray<WeakReference<View>> a() {
            if (this.c == null) {
                this.c = new SparseArray<>();
            }
            return this.c;
        }

        static d a(View view) {
            d dVar = (d) view.getTag(a.c.tag_unhandled_key_event_manager);
            if (dVar != null) {
                return dVar;
            }
            d dVar2 = new d();
            view.setTag(a.c.tag_unhandled_key_event_manager, dVar2);
            return dVar2;
        }

        boolean a(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                b();
            }
            View b = b(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (b != null && !KeyEvent.isModifierKey(keyCode)) {
                    a().put(keyCode, new WeakReference<>(b));
                }
            }
            return b != null;
        }

        private View b(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.b;
            if (weakHashMap == null || !weakHashMap.containsKey(view)) {
                return null;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View b = b(viewGroup.getChildAt(childCount), keyEvent);
                    if (b != null) {
                        return b;
                    }
                }
            }
            if (c(view, keyEvent)) {
                return view;
            }
            return null;
        }

        boolean a(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.d;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.d = new WeakReference<>(keyEvent);
            WeakReference<View> weakReference2 = null;
            SparseArray<WeakReference<View>> a2 = a();
            if (keyEvent.getAction() == 1 && (indexOfKey = a2.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReference2 = a2.valueAt(indexOfKey);
                a2.removeAt(indexOfKey);
            }
            if (weakReference2 == null) {
                weakReference2 = a2.get(keyEvent.getKeyCode());
            }
            if (weakReference2 == null) {
                return false;
            }
            View view = weakReference2.get();
            if (view != null && v.A(view)) {
                c(view, keyEvent);
            }
            return true;
        }

        private boolean c(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(a.c.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((c) arrayList.get(size)).a(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void b() {
            WeakHashMap<View, Boolean> weakHashMap = this.b;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            if (f549a.isEmpty()) {
                return;
            }
            synchronized (f549a) {
                if (this.b == null) {
                    this.b = new WeakHashMap<>();
                }
                for (int size = f549a.size() - 1; size >= 0; size--) {
                    View view = f549a.get(size).get();
                    if (view == null) {
                        f549a.remove(size);
                    } else {
                        this.b.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.b.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }
    }
}
