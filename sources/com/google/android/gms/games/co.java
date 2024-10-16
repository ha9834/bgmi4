package com.google.android.gms.games;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class co extends zzag<Void> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ View f1642a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(GamesClient gamesClient, View view) {
        this.f1642a = view;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zzeVar.zza(this.f1642a);
        taskCompletionSource.setResult(null);
    }
}
