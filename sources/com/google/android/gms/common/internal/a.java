package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* loaded from: classes.dex */
final class a extends DialogRedirect {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Intent f1465a;
    private final /* synthetic */ Activity b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Intent intent, Activity activity, int i) {
        this.f1465a = intent;
        this.b = activity;
        this.c = i;
    }

    @Override // com.google.android.gms.common.internal.DialogRedirect
    public final void a() {
        Intent intent = this.f1465a;
        if (intent != null) {
            this.b.startActivityForResult(intent, this.c);
        }
    }
}
