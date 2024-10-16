package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class dy implements Callable<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzai f4822a;
    private final /* synthetic */ String b;
    private final /* synthetic */ zzfk c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dy(zzfk zzfkVar, zzai zzaiVar, String str) {
        this.c = zzfkVar;
        this.f4822a = zzaiVar;
        this.b = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ byte[] call() throws Exception {
        zzjg zzjgVar;
        zzjg zzjgVar2;
        zzjgVar = this.c.f4942a;
        zzjgVar.d();
        zzjgVar2 = this.c.f4942a;
        return zzjgVar2.zzji().a(this.f4822a, this.b);
    }
}
