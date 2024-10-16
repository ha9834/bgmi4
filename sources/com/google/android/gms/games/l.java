package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class l extends zzag<Void> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f1714a;
    private final /* synthetic */ long b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LeaderboardsClient leaderboardsClient, String str, long j, String str2) {
        this.f1714a = str;
        this.b = j;
        this.c = str2;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zzeVar.zza((BaseImplementation.ResultHolder<Leaderboards.SubmitScoreResult>) null, this.f1714a, this.b, this.c);
    }
}
