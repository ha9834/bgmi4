package com.google.android.gms.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnFailureListener;

/* loaded from: classes.dex */
final class aj implements OnFailureListener {

    /* renamed from: a, reason: collision with root package name */
    private /* synthetic */ String f3792a;
    private /* synthetic */ zzcpz b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(zzcpz zzcpzVar, String str) {
        this.b = zzcpzVar;
        this.f3792a = str;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        if ((exc instanceof ApiException) && ((ApiException) exc).getStatusCode() == 8003) {
            return;
        }
        this.b.b(this.f3792a);
    }
}
