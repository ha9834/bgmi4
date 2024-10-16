package com.google.android.gms.common.internal;

import android.content.Intent;
import androidx.fragment.app.Fragment;

/* loaded from: classes.dex */
final class b extends DialogRedirect {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Intent f1466a;
    private final /* synthetic */ Fragment b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Intent intent, Fragment fragment, int i) {
        this.f1466a = intent;
        this.b = fragment;
        this.c = i;
    }

    @Override // com.google.android.gms.common.internal.DialogRedirect
    public final void a() {
        Intent intent = this.f1466a;
        if (intent != null) {
            this.b.startActivityForResult(intent, this.c);
        }
    }
}
