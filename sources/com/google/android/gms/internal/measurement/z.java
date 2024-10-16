package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzz;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class z extends zzz.b {
    private final /* synthetic */ com.google.android.gms.measurement.internal.zzgn c;
    private final /* synthetic */ zzz d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(zzz zzzVar, com.google.android.gms.measurement.internal.zzgn zzgnVar) {
        super(zzzVar);
        this.d = zzzVar;
        this.c = zzgnVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzz.b
    final void a() throws RemoteException {
        List list;
        Pair pair;
        zzk zzkVar;
        List list2;
        String str;
        List list3;
        List list4;
        int i = 0;
        while (true) {
            list = this.d.f;
            if (i >= list.size()) {
                pair = null;
                break;
            }
            com.google.android.gms.measurement.internal.zzgn zzgnVar = this.c;
            list3 = this.d.f;
            if (zzgnVar.equals(((Pair) list3.get(i)).first)) {
                list4 = this.d.f;
                pair = (Pair) list4.get(i);
                break;
            }
            i++;
        }
        if (pair == null) {
            str = this.d.c;
            Log.w(str, "OnEventListener had not been registered.");
        } else {
            zzkVar = this.d.r;
            zzkVar.unregisterOnMeasurementEventListener((zzq) pair.second);
            list2 = this.d.f;
            list2.remove(pair);
        }
    }
}
