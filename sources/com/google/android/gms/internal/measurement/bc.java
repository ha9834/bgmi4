package com.google.android.gms.internal.measurement;

import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class bc extends zzcm<Double> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(zzct zzctVar, String str, Double d) {
        super(zzctVar, str, d, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.zzcm
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Double a(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String zzrm = super.zzrm();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(zzrm).length() + 27 + String.valueOf(valueOf).length());
        sb.append("Invalid double value for ");
        sb.append(zzrm);
        sb.append(": ");
        sb.append(valueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
