package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleFragment;

/* loaded from: classes.dex */
final class c extends DialogRedirect {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Intent f1467a;
    private final /* synthetic */ LifecycleFragment b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Intent intent, LifecycleFragment lifecycleFragment, int i) {
        this.f1467a = intent;
        this.b = lifecycleFragment;
        this.c = i;
    }

    @Override // com.google.android.gms.common.internal.DialogRedirect
    public final void a() {
        Intent intent = this.f1467a;
        if (intent != null) {
            this.b.startActivityForResult(intent, this.c);
        }
    }
}
