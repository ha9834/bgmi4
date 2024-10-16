package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class bi extends TaskApiCall<zzaw, MetadataBuffer> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Query f3902a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(zzch zzchVar, Query query) {
        this.f3902a = query;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<MetadataBuffer> taskCompletionSource) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzgk(this.f3902a), new zzhh(taskCompletionSource));
    }
}
