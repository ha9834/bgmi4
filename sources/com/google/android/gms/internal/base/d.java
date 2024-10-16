package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;

/* loaded from: classes2.dex */
final class d extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    int f3846a;
    int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(d dVar) {
        if (dVar != null) {
            this.f3846a = dVar.f3846a;
            this.b = dVar.b;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new zae(this);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return this.f3846a;
    }
}
