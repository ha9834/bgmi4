package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
final class b implements Result {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Status f4218a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, Status status) {
        this.f4218a = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f4218a;
    }
}
