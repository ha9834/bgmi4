package com.google.android.gms.internal.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.CreateFileActivityOptions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class v extends TaskApiCall<zzaw, IntentSender> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ CreateFileActivityOptions f3945a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(zzbb zzbbVar, CreateFileActivityOptions createFileActivityOptions) {
        this.f3945a = createFileActivityOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource<IntentSender> taskCompletionSource) throws RemoteException {
        zzaw zzawVar2 = zzawVar;
        zzeo zzeoVar = (zzeo) zzawVar2.getService();
        this.f3945a.zzdc.zza(zzawVar2.getContext());
        taskCompletionSource.setResult(zzeoVar.zza(new zzu(this.f3945a.zzdc, this.f3945a.zzdi.intValue(), this.f3945a.zzay, this.f3945a.zzbb, Integer.valueOf(this.f3945a.zzdj))));
    }
}
