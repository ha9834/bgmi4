package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import androidx.appcompat.app.g;

/* loaded from: classes2.dex */
public class b extends g {
    @Override // androidx.appcompat.app.g, androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        return new a(getContext(), getTheme());
    }
}
