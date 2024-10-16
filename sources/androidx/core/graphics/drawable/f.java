package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    int f562a;
    Drawable.ConstantState b;
    ColorStateList c;
    PorterDuff.Mode d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(f fVar) {
        this.c = null;
        this.d = d.f561a;
        if (fVar != null) {
            this.f562a = fVar.f562a;
            this.b = fVar.b;
            this.c = fVar.c;
            this.d = fVar.d;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new e(this, resources);
        }
        return new d(this, resources);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i = this.f562a;
        Drawable.ConstantState constantState = this.b;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.b != null;
    }
}
