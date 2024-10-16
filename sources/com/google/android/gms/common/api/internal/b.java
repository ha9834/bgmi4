package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements PendingResult.StatusListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ BasePendingResult f1350a;
    private final /* synthetic */ zaab b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(zaab zaabVar, BasePendingResult basePendingResult) {
        this.b = zaabVar;
        this.f1350a = basePendingResult;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        Map map;
        map = this.b.f1383a;
        map.remove(this.f1350a);
    }
}
