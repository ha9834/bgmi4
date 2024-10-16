package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class ar extends zzag<Integer> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ListenerHolder f1629a;
    private final /* synthetic */ byte[] b;
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(RealTimeMultiplayerClient realTimeMultiplayerClient, ListenerHolder listenerHolder, byte[] bArr, String str, String str2) {
        this.f1629a = listenerHolder;
        this.b = bArr;
        this.c = str;
        this.d = str2;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Integer> taskCompletionSource) throws RemoteException {
        Integer valueOf = Integer.valueOf(zzeVar.zza(this.f1629a, this.b, this.c, this.d));
        if (valueOf.intValue() == -1) {
            taskCompletionSource.trySetException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zza(GamesClientStatusCodes.REAL_TIME_MESSAGE_SEND_FAILED)));
        } else {
            taskCompletionSource.setResult(valueOf);
        }
    }
}
