package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
final class x extends g {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbi f3946a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(zzbi zzbiVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.f3946a = zzbiVar;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) throws RemoteException {
        Contents contents;
        zzeo zzeoVar = (zzeo) zzawVar.getService();
        DriveId driveId = this.f3946a.getDriveId();
        contents = this.f3946a.b;
        zzeoVar.zza(new zzgd(driveId, DriveFile.MODE_WRITE_ONLY, contents.getRequestId()), new cn(this, null));
    }
}
