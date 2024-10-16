package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class dp implements Callable<List<gv>> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzn f4813a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;
    private final /* synthetic */ zzfk d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dp(zzfk zzfkVar, zzn zznVar, String str, String str2) {
        this.d = zzfkVar;
        this.f4813a = zznVar;
        this.b = str;
        this.c = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<gv> call() throws Exception {
        zzjg zzjgVar;
        zzjg zzjgVar2;
        zzjgVar = this.d.f4942a;
        zzjgVar.d();
        zzjgVar2 = this.d.f4942a;
        return zzjgVar2.zzgy().a(this.f4813a.packageName, this.b, this.c);
    }
}
