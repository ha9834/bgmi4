package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class cn extends zzag<Void> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f1641a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(GamesClient gamesClient, int i) {
        this.f1641a = i;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zzeVar.zzk(this.f1641a);
        taskCompletionSource.setResult(null);
    }
}
