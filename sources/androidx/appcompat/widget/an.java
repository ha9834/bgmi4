package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.ag;

/* loaded from: classes.dex */
public class an extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    private static final Interpolator j = new DecelerateInterpolator();

    /* renamed from: a, reason: collision with root package name */
    Runnable f327a;
    ag b;
    int c;
    int d;
    private b e;
    private Spinner f;
    private boolean g;
    private int h;
    private int i;

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.b.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.c = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.c = View.MeasureSpec.getSize(i) / 2;
            }
            this.c = Math.min(this.c, this.d);
        } else {
            this.c = -1;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.h, 1073741824);
        if (!z && this.g) {
            this.b.measure(0, makeMeasureSpec);
            if (this.b.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                b();
            } else {
                c();
            }
        } else {
            c();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.i);
    }

    private boolean a() {
        Spinner spinner = this.f;
        return spinner != null && spinner.getParent() == this;
    }

    public void setAllowCollapse(boolean z) {
        this.g = z;
    }

    private void b() {
        if (a()) {
            return;
        }
        if (this.f == null) {
            this.f = d();
        }
        removeView(this.b);
        addView(this.f, new ViewGroup.LayoutParams(-2, -1));
        if (this.f.getAdapter() == null) {
            this.f.setAdapter((SpinnerAdapter) new a());
        }
        Runnable runnable = this.f327a;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f327a = null;
        }
        this.f.setSelection(this.i);
    }

    private boolean c() {
        if (!a()) {
            return false;
        }
        removeView(this.f);
        addView(this.b, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f.getSelectedItemPosition());
        return false;
    }

    public void setTabSelected(int i) {
        this.i = i;
        int childCount = this.b.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.b.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                a(i);
            }
            i2++;
        }
        Spinner spinner = this.f;
        if (spinner == null || i < 0) {
            return;
        }
        spinner.setSelection(i);
    }

    public void setContentHeight(int i) {
        this.h = i;
        requestLayout();
    }

    private Spinner d() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, a.C0024a.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new ag.a(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.view.a a2 = androidx.appcompat.view.a.a(getContext());
        setContentHeight(a2.e());
        this.d = a2.g();
    }

    public void a(int i) {
        final View childAt = this.b.getChildAt(i);
        Runnable runnable = this.f327a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.f327a = new Runnable() { // from class: androidx.appcompat.widget.an.1
            @Override // java.lang.Runnable
            public void run() {
                an.this.smoothScrollTo(childAt.getLeft() - ((an.this.getWidth() - childAt.getWidth()) / 2), 0);
                an.this.f327a = null;
            }
        };
        post(this.f327a);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f327a;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f327a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    c a(a.c cVar, boolean z) {
        c cVar2 = new c(getContext(), cVar, z);
        if (z) {
            cVar2.setBackgroundDrawable(null);
            cVar2.setLayoutParams(new AbsListView.LayoutParams(-1, this.h));
        } else {
            cVar2.setFocusable(true);
            if (this.e == null) {
                this.e = new b();
            }
            cVar2.setOnClickListener(this.e);
        }
        return cVar2;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j2) {
        ((c) view).b().d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends LinearLayout {
        private final int[] b;
        private a.c c;
        private TextView d;
        private ImageView e;
        private View f;

        public c(Context context, a.c cVar, boolean z) {
            super(context, null, a.C0024a.actionBarTabStyle);
            this.b = new int[]{R.attr.background};
            this.c = cVar;
            au a2 = au.a(context, null, this.b, a.C0024a.actionBarTabStyle, 0);
            if (a2.g(0)) {
                setBackgroundDrawable(a2.a(0));
            }
            a2.a();
            if (z) {
                setGravity(8388627);
            }
            a();
        }

        public void a(a.c cVar) {
            this.c = cVar;
            a();
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (an.this.c <= 0 || getMeasuredWidth() <= an.this.c) {
                return;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(an.this.c, 1073741824), i2);
        }

        public void a() {
            a.c cVar = this.c;
            View c = cVar.c();
            if (c != null) {
                ViewParent parent = c.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(c);
                    }
                    addView(c);
                }
                this.f = c;
                TextView textView = this.d;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.e;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.e.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f;
            if (view != null) {
                removeView(view);
                this.f = null;
            }
            Drawable a2 = cVar.a();
            CharSequence b = cVar.b();
            if (a2 != null) {
                if (this.e == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.e = appCompatImageView;
                }
                this.e.setImageDrawable(a2);
                this.e.setVisibility(0);
            } else {
                ImageView imageView2 = this.e;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.e.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(b);
            if (z) {
                if (this.d == null) {
                    x xVar = new x(getContext(), null, a.C0024a.actionBarTabTextStyle);
                    xVar.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    xVar.setLayoutParams(layoutParams2);
                    addView(xVar);
                    this.d = xVar;
                }
                this.d.setText(b);
                this.d.setVisibility(0);
            } else {
                TextView textView2 = this.d;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.d.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.e;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.e());
            }
            aw.a(this, z ? null : cVar.e());
        }

        public a.c b() {
            return this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        a() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return an.this.b.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ((c) an.this.b.getChildAt(i)).b();
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return an.this.a((a.c) getItem(i), true);
            }
            ((c) view).a((a.c) getItem(i));
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((c) view).b().d();
            int childCount = an.this.b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = an.this.b.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }
}
