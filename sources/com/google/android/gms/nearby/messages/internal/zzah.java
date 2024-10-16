package com.google.android.gms.nearby.messages.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.internal.zzck;
import com.google.android.gms.internal.zzcvi;

/* loaded from: classes2.dex */
public final class zzah extends com.google.android.gms.common.internal.zzab<zzs> {

    /* renamed from: a, reason: collision with root package name */
    private final zzcvi<zzck, IBinder> f5026a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Context context) {
        if (context instanceof Activity) {
            return 1;
        }
        if (context instanceof Application) {
            return 2;
        }
        return context instanceof Service ? 3 : 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void a(int i) throws RemoteException {
        String str;
        switch (i) {
            case 1:
                str = "ACTIVITY_STOPPED";
                break;
            case 2:
                str = "CLIENT_DISCONNECTED";
                break;
            default:
                if (Log.isLoggable("NearbyMessagesClient", 5)) {
                    Log.w("NearbyMessagesClient", String.format("Received unknown/unforeseen client lifecycle event %d, can't do anything with it.", Integer.valueOf(i)));
                    return;
                }
                return;
        }
        if (!isConnected()) {
            if (Log.isLoggable("NearbyMessagesClient", 3)) {
                Log.d("NearbyMessagesClient", String.format("Failed to emit client lifecycle event %s due to GmsClient being disconnected", str));
            }
        } else {
            zzj zzjVar = new zzj(i);
            if (Log.isLoggable("NearbyMessagesClient", 3)) {
                Log.d("NearbyMessagesClient", String.format("Emitting client lifecycle event %s", str));
            }
            ((zzs) zzalw()).zza(zzjVar);
        }
    }

    public final void disconnect() {
        try {
            a(2);
        } catch (RemoteException e) {
            if (Log.isLoggable("NearbyMessagesClient", 2)) {
                Log.v("NearbyMessagesClient", String.format("Failed to emit CLIENT_DISCONNECTED from override of GmsClient#disconnect(): %s", e));
            }
        }
        this.f5026a.clear();
        super.disconnect();
    }
}
