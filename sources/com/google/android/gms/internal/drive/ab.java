package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.drive.DriveFile;

/* loaded from: classes2.dex */
final class ab extends g {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f3872a;
    private final /* synthetic */ DriveFile.DownloadProgressListener b;
    private final /* synthetic */ zzbn d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(zzbn zzbnVar, GoogleApiClient googleApiClient, int i, DriveFile.DownloadProgressListener downloadProgressListener) {
        super(googleApiClient);
        this.d = zzbnVar;
        this.f3872a = i;
        this.b = downloadProgressListener;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void a(zzaw zzawVar) throws RemoteException {
        a(ICancelToken.Stub.asInterface(((zzeo) zzawVar.getService()).zza(new zzgd(this.d.getDriveId(), this.f3872a, 0), new cn(this, this.b)).f3957a));
    }
}
