package com.google.android.material.internal;

import android.view.SubMenu;

/* loaded from: classes2.dex */
public class f extends androidx.appcompat.view.menu.g {
    @Override // androidx.appcompat.view.menu.g, android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        androidx.appcompat.view.menu.i iVar = (androidx.appcompat.view.menu.i) a(i, i2, i3, charSequence);
        h hVar = new h(f(), this, iVar);
        iVar.a(hVar);
        return hVar;
    }
}
