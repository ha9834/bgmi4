package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DrivePreferencesApi;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class aq extends zzau<DrivePreferencesApi.FileUploadPreferencesResult> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzcb f3885a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(zzcb zzcbVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.f3885a = zzcbVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result createFailedResult(Status status) {
        return new ap(this.f3885a, status, null, 0 == true ? 1 : 0);
    }
}
