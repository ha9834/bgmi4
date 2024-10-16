package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;

/* JADX INFO: Add missing generic type declarations: [R, T] */
/* loaded from: classes.dex */
final class h<R, T> implements PendingResultUtil.ResultConverter<R, T> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Response f1471a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Response response) {
        this.f1471a = response;
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ Object convert(Result result) {
        this.f1471a.setResult(result);
        return this.f1471a;
    }
}
