package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class as implements BaseGmsClient.BaseConnectionCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbbr f2057a;
    private final /* synthetic */ zzaii b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(zzaii zzaiiVar, zzbbr zzbbrVar) {
        this.b = zzaiiVar;
        this.f2057a = zzbbrVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzahz zzahzVar;
        try {
            zzbbr zzbbrVar = this.f2057a;
            zzahzVar = this.b.f2738a;
            zzbbrVar.set(zzahzVar.zzrs());
        } catch (DeadObjectException e) {
            this.f2057a.setException(e);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        zzbbr zzbbrVar = this.f2057a;
        StringBuilder sb = new StringBuilder(34);
        sb.append("onConnectionSuspended: ");
        sb.append(i);
        zzbbrVar.setException(new RuntimeException(sb.toString()));
    }
}
