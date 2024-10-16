package androidx.browser.browseractions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.browser.a;

/* loaded from: classes.dex */
public class BrowserActionsFallbackMenuView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private final int f386a;
    private final int b;

    public BrowserActionsFallbackMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f386a = getResources().getDimensionPixelOffset(a.C0034a.browser_actions_context_menu_min_padding);
        this.b = getResources().getDimensionPixelOffset(a.C0034a.browser_actions_context_menu_max_width);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(getResources().getDisplayMetrics().widthPixels - (this.f386a * 2), this.b), 1073741824), i2);
    }
}
