package com.google.android.gms.internal.measurement;

import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ba extends zzcm<Long> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(zzct zzctVar, String str, Long l) {
        super(zzctVar, str, l, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.zzcm
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Long a(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String zzrm = super.zzrm();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(zzrm).length() + 25 + String.valueOf(valueOf).length());
        sb.append("Invalid long value for ");
        sb.append(zzrm);
        sb.append(": ");
        sb.append(valueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
