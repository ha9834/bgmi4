package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class y extends zzav {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ MetadataChangeSet f3947a;
    private final /* synthetic */ com.google.android.gms.drive.zzn b;
    private final /* synthetic */ zzbi d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(zzbi zzbiVar, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, com.google.android.gms.drive.zzn zznVar) {
        super(googleApiClient);
        this.d = zzbiVar;
        this.f3947a = metadataChangeSet;
        this.b = zznVar;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) throws RemoteException {
        Contents contents;
        Contents contents2;
        Contents contents3;
        zzaw zzawVar2 = zzawVar;
        this.f3947a.zzp().zza(zzawVar2.getContext());
        zzeo zzeoVar = (zzeo) zzawVar2.getService();
        contents = this.d.b;
        DriveId driveId = contents.getDriveId();
        MetadataBundle zzp = this.f3947a.zzp();
        contents2 = this.d.b;
        int requestId = contents2.getRequestId();
        contents3 = this.d.b;
        zzeoVar.zza(new zzm(driveId, zzp, requestId, contents3.zza(), this.b), new zzgs(this));
    }
}
