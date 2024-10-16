package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ae;

/* loaded from: classes.dex */
public class FitWindowsFrameLayout extends FrameLayout implements ae {

    /* renamed from: a, reason: collision with root package name */
    private ae.a f283a;

    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.appcompat.widget.ae
    public void setOnFitSystemWindowsListener(ae.a aVar) {
        this.f283a = aVar;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        ae.a aVar = this.f283a;
        if (aVar != null) {
            aVar.a(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
