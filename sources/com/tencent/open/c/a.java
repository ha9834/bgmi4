package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;

/* loaded from: classes.dex */
public class a extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6379a = "com.tencent.open.c.a";
    private Rect b;
    private boolean c;
    private InterfaceC0210a d;

    /* renamed from: com.tencent.open.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0210a {
        void a();

        void a(int i);
    }

    public a(Context context) {
        super(context);
        this.b = null;
        this.c = false;
        this.d = null;
        if (this.b == null) {
            this.b = new Rect();
        }
    }

    public void a(InterfaceC0210a interfaceC0210a) {
        this.d = interfaceC0210a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.b.top) - size;
        InterfaceC0210a interfaceC0210a = this.d;
        if (interfaceC0210a != null && size != 0) {
            if (height > 100) {
                interfaceC0210a.a((Math.abs(this.b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC0210a.a();
            }
        }
        super.onMeasure(i, i2);
    }
}
