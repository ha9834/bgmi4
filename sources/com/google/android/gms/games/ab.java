package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.games.internal.zzbu;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class ab extends zzag<Void> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ byte[] f1608a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(RealTimeMultiplayerClient realTimeMultiplayerClient, byte[] bArr, String str, String str2) {
        this.f1608a = bArr;
        this.b = str;
        this.c = str2;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        if (((zzbu) zzeVar.getService()).zzb(this.f1608a, this.b, new String[]{this.c}) == 0) {
            taskCompletionSource.setResult(null);
        } else {
            taskCompletionSource.trySetException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zza(GamesClientStatusCodes.REAL_TIME_MESSAGE_SEND_FAILED)));
        }
    }
}
