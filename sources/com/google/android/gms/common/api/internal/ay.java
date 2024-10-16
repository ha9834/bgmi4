package com.google.android.gms.common.api.internal;

import android.app.Dialog;

/* loaded from: classes.dex */
final class ay extends zabr {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Dialog f1349a;
    private final /* synthetic */ ax b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar, Dialog dialog) {
        this.b = axVar;
        this.f1349a = dialog;
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final void zas() {
        this.b.f1348a.c();
        if (this.f1349a.isShowing()) {
            this.f1349a.dismiss();
        }
    }
}
