package com.google.android.gms.games;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class j extends zzag<Intent> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f1712a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LeaderboardsClient leaderboardsClient, String str, int i, int i2) {
        this.f1712a = str;
        this.b = i;
        this.c = i2;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Intent> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zzeVar.zza(this.f1712a, this.b, this.c));
    }
}
