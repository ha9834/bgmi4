package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class ad extends zzag<Void> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ byte[] f1611a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(RealTimeMultiplayerClient realTimeMultiplayerClient, byte[] bArr, String str) {
        this.f1611a = bArr;
        this.b = str;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        if (zzeVar.zza(this.f1611a, this.b) == 0) {
            taskCompletionSource.setResult(null);
        } else {
            taskCompletionSource.trySetException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zza(GamesClientStatusCodes.REAL_TIME_MESSAGE_SEND_FAILED)));
        }
    }
}
