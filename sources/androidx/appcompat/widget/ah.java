package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.a;
import com.google.android.gms.nearby.messages.BleSignal;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class ah implements androidx.appcompat.view.menu.p {

    /* renamed from: a, reason: collision with root package name */
    private static Method f315a;
    private static Method b;
    private static Method h;
    private Drawable A;
    private AdapterView.OnItemClickListener B;
    private AdapterView.OnItemSelectedListener C;
    private final d D;
    private final c E;
    private final a F;
    private Runnable G;
    private final Rect H;
    private Rect I;
    private boolean J;
    ad c;
    int d;
    final e e;
    final Handler f;
    PopupWindow g;
    private Context i;
    private ListAdapter j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private int t;
    private boolean u;
    private boolean v;
    private View w;
    private int x;
    private DataSetObserver y;
    private View z;

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f315a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public ah(Context context) {
        this(context, null, a.C0024a.listPopupWindowStyle);
    }

    public ah(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ah(Context context, AttributeSet attributeSet, int i, int i2) {
        this.k = -2;
        this.l = -2;
        this.o = 1002;
        this.q = true;
        this.t = 0;
        this.u = false;
        this.v = false;
        this.d = Integer.MAX_VALUE;
        this.x = 0;
        this.e = new e();
        this.D = new d();
        this.E = new c();
        this.F = new a();
        this.H = new Rect();
        this.i = context;
        this.f = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ListPopupWindow, i, i2);
        this.m = obtainStyledAttributes.getDimensionPixelOffset(a.j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.n = obtainStyledAttributes.getDimensionPixelOffset(a.j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.n != 0) {
            this.p = true;
        }
        obtainStyledAttributes.recycle();
        this.g = new p(context, attributeSet, i, i2);
        this.g.setInputMethodMode(1);
    }

    public void a(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.y;
        if (dataSetObserver == null) {
            this.y = new b();
        } else {
            ListAdapter listAdapter2 = this.j;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.j = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.y);
        }
        ad adVar = this.c;
        if (adVar != null) {
            adVar.setAdapter(this.j);
        }
    }

    public void d(int i) {
        this.x = i;
    }

    public void a(boolean z) {
        this.J = z;
        this.g.setFocusable(z);
    }

    public boolean j() {
        return this.J;
    }

    public Drawable b() {
        return this.g.getBackground();
    }

    public void a(Drawable drawable) {
        this.g.setBackgroundDrawable(drawable);
    }

    public void e(int i) {
        this.g.setAnimationStyle(i);
    }

    public View k() {
        return this.z;
    }

    public void b(View view) {
        this.z = view;
    }

    public int f() {
        return this.m;
    }

    public void b(int i) {
        this.m = i;
    }

    public int c() {
        if (this.p) {
            return this.n;
        }
        return 0;
    }

    public void a(int i) {
        this.n = i;
        this.p = true;
    }

    public void a(Rect rect) {
        this.I = rect != null ? new Rect(rect) : null;
    }

    public void f(int i) {
        this.t = i;
    }

    public int l() {
        return this.l;
    }

    public void g(int i) {
        this.l = i;
    }

    public void h(int i) {
        Drawable background = this.g.getBackground();
        if (background != null) {
            background.getPadding(this.H);
            this.l = this.H.left + this.H.right + i;
        } else {
            g(i);
        }
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.B = onItemClickListener;
    }

    @Override // androidx.appcompat.view.menu.p
    public void d_() {
        int i = i();
        boolean n = n();
        androidx.core.widget.h.a(this.g, this.o);
        if (this.g.isShowing()) {
            if (androidx.core.f.v.A(k())) {
                int i2 = this.l;
                if (i2 == -1) {
                    i2 = -1;
                } else if (i2 == -2) {
                    i2 = k().getWidth();
                }
                int i3 = this.k;
                if (i3 == -1) {
                    if (!n) {
                        i = -1;
                    }
                    if (n) {
                        this.g.setWidth(this.l == -1 ? -1 : 0);
                        this.g.setHeight(0);
                    } else {
                        this.g.setWidth(this.l == -1 ? -1 : 0);
                        this.g.setHeight(-1);
                    }
                } else if (i3 != -2) {
                    i = i3;
                }
                this.g.setOutsideTouchable((this.v || this.u) ? false : true);
                this.g.update(k(), this.m, this.n, i2 < 0 ? -1 : i2, i < 0 ? -1 : i);
                return;
            }
            return;
        }
        int i4 = this.l;
        if (i4 == -1) {
            i4 = -1;
        } else if (i4 == -2) {
            i4 = k().getWidth();
        }
        int i5 = this.k;
        if (i5 == -1) {
            i = -1;
        } else if (i5 != -2) {
            i = i5;
        }
        this.g.setWidth(i4);
        this.g.setHeight(i);
        c(true);
        this.g.setOutsideTouchable((this.v || this.u) ? false : true);
        this.g.setTouchInterceptor(this.D);
        if (this.s) {
            androidx.core.widget.h.a(this.g, this.r);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = h;
            if (method != null) {
                try {
                    method.invoke(this.g, this.I);
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
        } else {
            this.g.setEpicenterBounds(this.I);
        }
        androidx.core.widget.h.a(this.g, k(), this.m, this.n, this.t);
        this.c.setSelection(-1);
        if (!this.J || this.c.isInTouchMode()) {
            m();
        }
        if (this.J) {
            return;
        }
        this.f.post(this.F);
    }

    @Override // androidx.appcompat.view.menu.p
    public void d() {
        this.g.dismiss();
        h();
        this.g.setContentView(null);
        this.c = null;
        this.f.removeCallbacks(this.e);
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.g.setOnDismissListener(onDismissListener);
    }

    private void h() {
        View view = this.w;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.w);
            }
        }
    }

    public void i(int i) {
        this.g.setInputMethodMode(i);
    }

    public void j(int i) {
        ad adVar = this.c;
        if (!e() || adVar == null) {
            return;
        }
        adVar.setListSelectionHidden(false);
        adVar.setSelection(i);
        if (adVar.getChoiceMode() != 0) {
            adVar.setItemChecked(i, true);
        }
    }

    public void m() {
        ad adVar = this.c;
        if (adVar != null) {
            adVar.setListSelectionHidden(true);
            adVar.requestLayout();
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean e() {
        return this.g.isShowing();
    }

    public boolean n() {
        return this.g.getInputMethodMode() == 2;
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView g() {
        return this.c;
    }

    ad a(Context context, boolean z) {
        return new ad(context, z);
    }

    private int i() {
        int i;
        int i2;
        int makeMeasureSpec;
        int i3;
        if (this.c == null) {
            Context context = this.i;
            this.G = new Runnable() { // from class: androidx.appcompat.widget.ah.1
                @Override // java.lang.Runnable
                public void run() {
                    View k = ah.this.k();
                    if (k == null || k.getWindowToken() == null) {
                        return;
                    }
                    ah.this.d_();
                }
            };
            this.c = a(context, !this.J);
            Drawable drawable = this.A;
            if (drawable != null) {
                this.c.setSelector(drawable);
            }
            this.c.setAdapter(this.j);
            this.c.setOnItemClickListener(this.B);
            this.c.setFocusable(true);
            this.c.setFocusableInTouchMode(true);
            this.c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.ah.2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j) {
                    ad adVar;
                    if (i4 == -1 || (adVar = ah.this.c) == null) {
                        return;
                    }
                    adVar.setListSelectionHidden(false);
                }
            });
            this.c.setOnScrollListener(this.E);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.C;
            if (onItemSelectedListener != null) {
                this.c.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view = this.c;
            View view2 = this.w;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.x) {
                    case 0:
                        linearLayout.addView(view2);
                        linearLayout.addView(view, layoutParams);
                        break;
                    case 1:
                        linearLayout.addView(view, layoutParams);
                        linearLayout.addView(view2);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.x);
                        break;
                }
                int i4 = this.l;
                if (i4 >= 0) {
                    i3 = BleSignal.UNKNOWN_TX_POWER;
                } else {
                    i4 = 0;
                    i3 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i4, i3), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                i = 0;
            }
            this.g.setContentView(view);
        } else {
            View view3 = this.w;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                i = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i = 0;
            }
        }
        Drawable background = this.g.getBackground();
        if (background != null) {
            background.getPadding(this.H);
            i2 = this.H.top + this.H.bottom;
            if (!this.p) {
                this.n = -this.H.top;
            }
        } else {
            this.H.setEmpty();
            i2 = 0;
        }
        int a2 = a(k(), this.n, this.g.getInputMethodMode() == 2);
        if (this.u || this.k == -1) {
            return a2 + i2;
        }
        int i5 = this.l;
        switch (i5) {
            case -2:
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.i.getResources().getDisplayMetrics().widthPixels - (this.H.left + this.H.right), BleSignal.UNKNOWN_TX_POWER);
                break;
            case -1:
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.i.getResources().getDisplayMetrics().widthPixels - (this.H.left + this.H.right), 1073741824);
                break;
            default:
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
                break;
        }
        int a3 = this.c.a(makeMeasureSpec, 0, -1, a2 - i, -1);
        if (a3 > 0) {
            i += i2 + this.c.getPaddingTop() + this.c.getPaddingBottom();
        }
        return a3 + i;
    }

    public void b(boolean z) {
        this.s = true;
        this.r = z;
    }

    /* loaded from: classes.dex */
    private class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (ah.this.e()) {
                ah.this.d_();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ah.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ah.this.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ah.this.c == null || !androidx.core.f.v.A(ah.this.c) || ah.this.c.getCount() <= ah.this.c.getChildCount() || ah.this.c.getChildCount() > ah.this.d) {
                return;
            }
            ah.this.g.setInputMethodMode(2);
            ah.this.d_();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && ah.this.g != null && ah.this.g.isShowing() && x >= 0 && x < ah.this.g.getWidth() && y >= 0 && y < ah.this.g.getHeight()) {
                ah.this.f.postDelayed(ah.this.e, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            ah.this.f.removeCallbacks(ah.this.e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements AbsListView.OnScrollListener {
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 1 || ah.this.n() || ah.this.g.getContentView() == null) {
                return;
            }
            ah.this.f.removeCallbacks(ah.this.e);
            ah.this.e.run();
        }
    }

    private void c(boolean z) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f315a;
            if (method != null) {
                try {
                    method.invoke(this.g, Boolean.valueOf(z));
                    return;
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                    return;
                }
            }
            return;
        }
        this.g.setIsClippedToScreen(z);
    }

    private int a(View view, int i, boolean z) {
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = b;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(this.g, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                }
            }
            return this.g.getMaxAvailableHeight(view, i);
        }
        return this.g.getMaxAvailableHeight(view, i, z);
    }
}
