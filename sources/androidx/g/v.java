package androidx.g;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* loaded from: classes.dex */
class v implements w {

    /* renamed from: a, reason: collision with root package name */
    private final ViewGroupOverlay f742a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ViewGroup viewGroup) {
        this.f742a = viewGroup.getOverlay();
    }

    @Override // androidx.g.ac
    public void a(Drawable drawable) {
        this.f742a.add(drawable);
    }

    @Override // androidx.g.ac
    public void b(Drawable drawable) {
        this.f742a.remove(drawable);
    }

    @Override // androidx.g.w
    public void a(View view) {
        this.f742a.add(view);
    }

    @Override // androidx.g.w
    public void b(View view) {
        this.f742a.remove(view);
    }
}
