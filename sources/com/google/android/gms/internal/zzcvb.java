package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.internal.Update;
import com.google.android.gms.nearby.messages.internal.zzaf;
import com.google.android.gms.nearby.messages.internal.zzn;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class zzcvb extends zzn {

    /* renamed from: a, reason: collision with root package name */
    private final zzci<MessageListener> f4709a;

    public zzcvb(zzci<MessageListener> zzciVar) {
        this.f4709a = zzciVar;
    }

    public static void zza(Intent intent, MessageListener messageListener) {
        Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.nearby.messages.UPDATES");
        zza((Iterable<Update>) (bundleExtra == null ? Collections.emptyList() : bundleExtra.getParcelableArrayList("com.google.android.gms.nearby.messages.UPDATES")), messageListener);
    }

    public static void zza(Iterable<Update> iterable, MessageListener messageListener) {
        for (Update update : iterable) {
            if (update.zzeu(1)) {
                messageListener.onFound(update.zzkda);
            }
            if (update.zzeu(2)) {
                messageListener.onLost(update.zzkda);
            }
            if (update.zzeu(4)) {
                messageListener.onDistanceChanged(update.zzkda, update.zzkeo);
            }
            if (update.zzeu(8)) {
                messageListener.onBleSignalChanged(update.zzkda, update.zzkep);
            }
            if (update.zzeu(16)) {
                Message message = update.zzkda;
                zzcux zzcuxVar = update.zzkeq;
            }
        }
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzm
    public final void zza(zzaf zzafVar) {
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzm
    public final void zzaj(List<Update> list) throws RemoteException {
        this.f4709a.zza(new bo(this, list));
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzm
    public final void zzb(zzaf zzafVar) {
    }
}
