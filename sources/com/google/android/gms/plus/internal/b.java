package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.plus.People;

@VisibleForTesting
/* loaded from: classes2.dex */
final class b extends zza {

    /* renamed from: a, reason: collision with root package name */
    private final BaseImplementation.ResultHolder<People.LoadPeopleResult> f5047a;

    public b(BaseImplementation.ResultHolder<People.LoadPeopleResult> resultHolder) {
        this.f5047a = resultHolder;
    }

    @Override // com.google.android.gms.plus.internal.zza, com.google.android.gms.plus.internal.zzb
    public final void zza(DataHolder dataHolder, String str) {
        Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.getMetadata() != null ? (PendingIntent) dataHolder.getMetadata().getParcelable(BaseGmsClient.KEY_PENDING_INTENT) : null);
        if (!status.isSuccess() && dataHolder != null) {
            if (!dataHolder.isClosed()) {
                dataHolder.close();
            }
            dataHolder = null;
        }
        this.f5047a.setResult(new a(status, dataHolder, str));
    }
}
