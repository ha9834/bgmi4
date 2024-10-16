package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;

@zzard
/* loaded from: classes2.dex */
public class zzapb {
    public static zzaov zzdd(String str) throws RemoteException {
        return new zzapc((RtbAdapter) Class.forName(str, false, zzapb.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
    }
}
