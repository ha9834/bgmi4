package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p extends zzag<Void> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f1732a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(NotificationsClient notificationsClient, int i) {
        this.f1732a = i;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zzeVar.zzl(this.f1732a);
        taskCompletionSource.setResult(null);
    }
}
