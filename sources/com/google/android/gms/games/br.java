package com.google.android.gms.games;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class br extends zzag<Intent> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f1633a;
    private final /* synthetic */ int b;
    private final /* synthetic */ boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(TurnBasedMultiplayerClient turnBasedMultiplayerClient, int i, int i2, boolean z) {
        this.f1633a = i;
        this.b = i2;
        this.c = z;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Intent> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zzeVar.zza(this.f1633a, this.b, this.c));
    }
}
