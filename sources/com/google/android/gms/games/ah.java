package com.google.android.gms.games;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.games.internal.zza;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class ah extends zza {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ TaskCompletionSource f1615a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar, TaskCompletionSource taskCompletionSource) {
        this.f1615a = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
    public final void onLeftRoom(int i, String str) {
        TaskUtil.setResultOrApiException(GamesClientStatusCodes.zza(GamesClientStatusCodes.zzb(i)), str, this.f1615a);
    }
}
