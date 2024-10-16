package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class zzed extends ee {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicReference<String[]> f4930a = new AtomicReference<>();
    private static final AtomicReference<String[]> b = new AtomicReference<>();
    private static final AtomicReference<String[]> c = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzed(zzfj zzfjVar) {
        super(zzfjVar);
    }

    @Override // com.google.android.gms.measurement.internal.ee
    protected final boolean a() {
        return false;
    }

    private final boolean c() {
        zzae();
        return this.v.zzhw() && this.v.zzab().a(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String a(String str) {
        if (str == null) {
            return null;
        }
        return !c() ? str : a(str, zzgj.zzpo, zzgj.zzpn, f4930a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String b(String str) {
        if (str == null) {
            return null;
        }
        return !c() ? str : a(str, zzgi.zzpm, zzgi.zzpl, b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String c(String str) {
        if (str == null) {
            return null;
        }
        if (!c()) {
            return str;
        }
        if (str.startsWith("_exp_")) {
            return "experiment_id(" + str + ")";
        }
        return a(str, zzgl.zzpq, zzgl.zzpp, c);
    }

    private static String a(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        Preconditions.checkNotNull(atomicReference);
        Preconditions.checkArgument(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (zzjs.d(str, strArr[i])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i] == null) {
                        strArr3[i] = strArr2[i] + "(" + strArr[i] + ")";
                    }
                    str2 = strArr3[i];
                }
                return str2;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String a(zzai zzaiVar) {
        if (zzaiVar == null) {
            return null;
        }
        if (!c()) {
            return zzaiVar.toString();
        }
        return "origin=" + zzaiVar.origin + ",name=" + a(zzaiVar.name) + ",params=" + a(zzaiVar.zzfq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String a(zzaf zzafVar) {
        if (zzafVar == null) {
            return null;
        }
        if (!c()) {
            return zzafVar.toString();
        }
        return "Event{appId='" + zzafVar.f4924a + "', name='" + a(zzafVar.b) + "', params=" + a(zzafVar.e) + "}";
    }

    private final String a(zzah zzahVar) {
        if (zzahVar == null) {
            return null;
        }
        if (!c()) {
            return zzahVar.toString();
        }
        return a(zzahVar.zzcv());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!c()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        for (String str : bundle.keySet()) {
            if (sb.length() != 0) {
                sb.append(", ");
            } else {
                sb.append("Bundle[{");
            }
            sb.append(b(str));
            sb.append("=");
            sb.append(bundle.get(str));
        }
        sb.append("}]");
        return sb.toString();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzl() {
        super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzm() {
        super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzn() {
        super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzo() {
        super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzac zzw() {
        return super.zzw();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ Clock zzx() {
        return super.zzx();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzed zzy() {
        return super.zzy();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzjs zzz() {
        return super.zzz();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzfc zzaa() {
        return super.zzaa();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzef zzab() {
        return super.zzab();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ cz zzac() {
        return super.zzac();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzs zzad() {
        return super.zzad();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzr zzae() {
        return super.zzae();
    }
}
