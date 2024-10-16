package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class zzdbx {

    /* renamed from: a, reason: collision with root package name */
    private static final CopyOnWriteArrayList<zzdbw> f3538a = new CopyOnWriteArrayList<>();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzdbw zzgh(String str) throws GeneralSecurityException {
        Iterator<zzdbw> it = f3538a.iterator();
        while (it.hasNext()) {
            zzdbw next = it.next();
            if (next.zzgf(str)) {
                return next;
            }
        }
        String valueOf = String.valueOf(str);
        throw new GeneralSecurityException(valueOf.length() != 0 ? "No KMS client does support: ".concat(valueOf) : new String("No KMS client does support: "));
    }
}
