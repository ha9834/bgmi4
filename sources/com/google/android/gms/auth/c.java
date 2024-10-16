package com.google.android.gms.auth;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.auth.zzf;
import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements f<List<AccountChangeEvent>> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f1271a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, int i) {
        this.f1271a = str;
        this.b = i;
    }

    @Override // com.google.android.gms.auth.f
    public final /* synthetic */ List<AccountChangeEvent> a(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Object b;
        b = zzd.b(zzf.zza(iBinder).zza(new AccountChangeEventsRequest().setAccountName(this.f1271a).setEventIndex(this.b)));
        return ((AccountChangeEventsResponse) b).getEvents();
    }
}
