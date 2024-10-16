package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.auth.zzf;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements f<Void> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f1270a;
    private final /* synthetic */ Bundle b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, Bundle bundle) {
        this.f1270a = str;
        this.b = bundle;
    }

    @Override // com.google.android.gms.auth.f
    public final /* synthetic */ Void a(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Object b;
        b = zzd.b(zzf.zza(iBinder).zza(this.f1270a, this.b));
        Bundle bundle = (Bundle) b;
        String string = bundle.getString("Error");
        if (bundle.getBoolean("booleanResult")) {
            return null;
        }
        throw new GoogleAuthException(string);
    }
}
