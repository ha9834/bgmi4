package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* loaded from: classes.dex */
public class z extends ToggleButton {

    /* renamed from: a, reason: collision with root package name */
    private final w f373a;

    public z(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyleToggle);
    }

    public z(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f373a = new w(this);
        this.f373a.a(attributeSet, i);
    }
}
