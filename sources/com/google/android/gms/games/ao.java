package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ao extends zzag<Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ an f1620a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar) {
        this.f1620a = anVar;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        this.f1620a.f1619a.notifyListener(new ap(this));
        taskCompletionSource.setResult(null);
    }
}
