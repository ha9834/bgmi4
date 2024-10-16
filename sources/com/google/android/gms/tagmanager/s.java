package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.DataLayer;
import java.util.List;

/* loaded from: classes2.dex */
final class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzaq f5151a;
    private final /* synthetic */ q b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, zzaq zzaqVar) {
        this.b = qVar;
        this.f5151a = zzaqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<DataLayer.a> b;
        zzaq zzaqVar = this.f5151a;
        b = this.b.b();
        zzaqVar.zzc(b);
    }
}
