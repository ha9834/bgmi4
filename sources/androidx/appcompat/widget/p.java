package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.a;

/* loaded from: classes.dex */
class p extends PopupWindow {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f362a;
    private boolean b;

    static {
        f362a = Build.VERSION.SDK_INT < 21;
    }

    public p(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet, i, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i, int i2) {
        au a2 = au.a(context, attributeSet, a.j.PopupWindow, i, i2);
        if (a2.g(a.j.PopupWindow_overlapAnchor)) {
            a(a2.a(a.j.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a2.a(a.j.PopupWindow_android_popupBackground));
        a2.a();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (f362a && this.b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f362a && this.b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i, int i2, int i3, int i4) {
        super.update(view, i, (f362a && this.b) ? i2 - view.getHeight() : i2, i3, i4);
    }

    private void a(boolean z) {
        if (f362a) {
            this.b = z;
        } else {
            androidx.core.widget.h.a(this, z);
        }
    }
}
