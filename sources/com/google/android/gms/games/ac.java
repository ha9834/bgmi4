package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.internal.zzbu;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* loaded from: classes.dex */
final class ac extends zzag<Void> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ List f1609a;
    private final /* synthetic */ byte[] b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(RealTimeMultiplayerClient realTimeMultiplayerClient, List list, byte[] bArr, String str) {
        this.f1609a = list;
        this.b = bArr;
        this.c = str;
    }

    @Override // com.google.android.gms.internal.games.zzag
    protected final void a(zze zzeVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        Preconditions.checkNotNull(this.f1609a, "Participant IDs must not be null");
        List list = this.f1609a;
        if (((zzbu) zzeVar.getService()).zzb(this.b, this.c, (String[]) list.toArray(new String[list.size()])) == 0) {
            taskCompletionSource.setResult(null);
        } else {
            taskCompletionSource.trySetException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zza(GamesClientStatusCodes.REAL_TIME_MESSAGE_SEND_FAILED)));
        }
    }
}
