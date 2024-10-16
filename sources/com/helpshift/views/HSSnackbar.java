package com.helpshift.views;

import android.view.View;
import com.google.android.material.snackbar.Snackbar;

/* loaded from: classes2.dex */
public class HSSnackbar {
    public static Snackbar make(View view, CharSequence charSequence, int i) {
        Snackbar a2 = Snackbar.a(view, charSequence, i);
        FontApplier.apply(a2.e());
        return a2;
    }

    public static Snackbar make(View view, int i, int i2) {
        return make(view, view.getResources().getText(i), i2);
    }
}
