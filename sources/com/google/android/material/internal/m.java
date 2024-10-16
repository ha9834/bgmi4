package com.google.android.material.internal;

import android.widget.ImageButton;

/* loaded from: classes2.dex */
public class m extends ImageButton {

    /* renamed from: a, reason: collision with root package name */
    private int f5301a;

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        a(i, true);
    }

    public final void a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f5301a = i;
        }
    }

    public final int getUserSetVisibility() {
        return this.f5301a;
    }
}
