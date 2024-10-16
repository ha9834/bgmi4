package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aqk extends aqo<zzaem> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ FrameLayout f2051a;
    private final /* synthetic */ FrameLayout b;
    private final /* synthetic */ Context c;
    private final /* synthetic */ zzyh d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aqk(zzyh zzyhVar, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.d = zzyhVar;
        this.f2051a = frameLayout;
        this.b = frameLayout2;
        this.c = context;
    }

    @Override // com.google.android.gms.internal.ads.aqo
    protected final /* synthetic */ zzaem a() {
        zzyh.b(this.c, "native_ad_view_delegate");
        return new zzabt();
    }

    @Override // com.google.android.gms.internal.ads.aqo
    public final /* synthetic */ zzaem b() throws RemoteException {
        zzagk zzagkVar;
        zzagkVar = this.d.d;
        return zzagkVar.zzb(this.c, this.f2051a, this.b);
    }

    @Override // com.google.android.gms.internal.ads.aqo
    public final /* synthetic */ zzaem a(zzzv zzzvVar) throws RemoteException {
        return zzzvVar.zzc(ObjectWrapper.wrap(this.f2051a), ObjectWrapper.wrap(this.b));
    }
}
