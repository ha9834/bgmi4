package androidx.core.f;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

/* loaded from: classes.dex */
public interface u {
    ColorStateList getSupportBackgroundTintList();

    PorterDuff.Mode getSupportBackgroundTintMode();

    void setSupportBackgroundTintList(ColorStateList colorStateList);

    void setSupportBackgroundTintMode(PorterDuff.Mode mode);
}
