package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.a;
import com.google.android.gms.nearby.messages.BleSignal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class a extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    protected final C0031a f306a;
    protected final Context b;
    protected ActionMenuView c;
    protected ActionMenuPresenter d;
    protected int e;
    protected androidx.core.f.z f;
    private boolean g;
    private boolean h;

    /* JADX INFO: Access modifiers changed from: protected */
    public static int a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    a(Context context) {
        this(context, null);
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f306a = new C0031a();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(a.C0024a.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
            this.b = new ContextThemeWrapper(context, typedValue.resourceId);
        } else {
            this.b = context;
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, a.j.ActionBar, a.C0024a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(a.j.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.a(configuration);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.g = false;
        }
        if (!this.g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.g = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.h = false;
        }
        if (!this.h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.h = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.e = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.e;
    }

    public int getAnimatedVisibility() {
        if (this.f != null) {
            return this.f306a.f307a;
        }
        return getVisibility();
    }

    public androidx.core.f.z a(int i, long j) {
        androidx.core.f.z zVar = this.f;
        if (zVar != null) {
            zVar.b();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            androidx.core.f.z a2 = androidx.core.f.v.l(this).a(1.0f);
            a2.a(j);
            a2.a(this.f306a.a(a2, i));
            return a2;
        }
        androidx.core.f.z a3 = androidx.core.f.v.l(this).a(0.0f);
        a3.a(j);
        a3.a(this.f306a.a(a3, i));
        return a3;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            androidx.core.f.z zVar = this.f;
            if (zVar != null) {
                zVar.b();
            }
            super.setVisibility(i);
        }
    }

    public boolean a() {
        ActionMenuPresenter actionMenuPresenter = this.d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.e();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, BleSignal.UNKNOWN_TX_POWER), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    /* renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    protected class C0031a implements androidx.core.f.aa {

        /* renamed from: a, reason: collision with root package name */
        int f307a;
        private boolean c = false;

        protected C0031a() {
        }

        public C0031a a(androidx.core.f.z zVar, int i) {
            a.this.f = zVar;
            this.f307a = i;
            return this;
        }

        @Override // androidx.core.f.aa
        public void a(View view) {
            a.super.setVisibility(0);
            this.c = false;
        }

        @Override // androidx.core.f.aa
        public void b(View view) {
            if (this.c) {
                return;
            }
            a aVar = a.this;
            aVar.f = null;
            a.super.setVisibility(this.f307a);
        }

        @Override // androidx.core.f.aa
        public void c(View view) {
            this.c = true;
        }
    }
}
