package com.android.billingclient.api;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzd;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bc implements Callable<Integer> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f963a;
    final /* synthetic */ e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(e eVar, String str) {
        this.b = eVar;
        this.f963a = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Integer call() throws Exception {
        zzd zzdVar;
        Context context;
        zzdVar = this.b.g;
        context = this.b.f;
        String packageName = context.getPackageName();
        String str = this.f963a;
        Bundle bundle = new Bundle();
        bundle.putBoolean("vr", true);
        return Integer.valueOf(zzdVar.zzi(7, packageName, str, bundle));
    }
}
