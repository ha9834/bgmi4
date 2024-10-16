package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzaeg extends zzfm implements zzaee {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaeg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final float getAspectRatio() throws RemoteException {
        Parcel a2 = a(2, a());
        float readFloat = a2.readFloat();
        a2.recycle();
        return readFloat;
    }
}
