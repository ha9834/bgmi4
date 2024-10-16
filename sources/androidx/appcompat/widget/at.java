package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class at extends al {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<Context> f336a;

    public at(Context context, Resources resources) {
        super(resources);
        this.f336a = new WeakReference<>(context);
    }

    @Override // androidx.appcompat.widget.al, android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Drawable drawable = super.getDrawable(i);
        Context context = this.f336a.get();
        if (drawable != null && context != null) {
            ak.a().a(context, i, drawable);
        }
        return drawable;
    }
}
