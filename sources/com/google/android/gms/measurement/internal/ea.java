package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class ea implements Callable<List<gv>> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzn f4825a;
    private final /* synthetic */ zzfk b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ea(zzfk zzfkVar, zzn zznVar) {
        this.b = zzfkVar;
        this.f4825a = zznVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<gv> call() throws Exception {
        zzjg zzjgVar;
        zzjg zzjgVar2;
        zzjgVar = this.b.f4942a;
        zzjgVar.d();
        zzjgVar2 = this.b.f4942a;
        return zzjgVar2.zzgy().a(this.f4825a.packageName);
    }
}
