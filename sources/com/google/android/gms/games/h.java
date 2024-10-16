package com.google.android.gms.games;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class h extends zzag<Intent> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f1645a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(LeaderboardsClient leaderboardsClient, String str) {
        this.f1645a = str;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Intent> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zzeVar.zza(this.f1645a, -1, -1));
    }
}
