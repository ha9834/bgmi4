package androidx.g;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* loaded from: classes.dex */
class ab implements ac {

    /* renamed from: a, reason: collision with root package name */
    private final ViewOverlay f705a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(View view) {
        this.f705a = view.getOverlay();
    }

    @Override // androidx.g.ac
    public void a(Drawable drawable) {
        this.f705a.add(drawable);
    }

    @Override // androidx.g.ac
    public void b(Drawable drawable) {
        this.f705a.remove(drawable);
    }
}
