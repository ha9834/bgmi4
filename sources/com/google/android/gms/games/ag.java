package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zzbu;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class ag extends zzag<String> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f1614a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(RealTimeMultiplayerClient realTimeMultiplayerClient, String str) {
        this.f1614a = str;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<String> taskCompletionSource) throws RemoteException {
        ((zzbu) zzeVar.getService()).zza(new ah(this, taskCompletionSource), this.f1614a);
    }
}
