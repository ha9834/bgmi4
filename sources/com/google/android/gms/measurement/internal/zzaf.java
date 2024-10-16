package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class zzaf {

    /* renamed from: a, reason: collision with root package name */
    final String f4924a;
    final String b;
    final long c;
    final long d;
    final zzah e;
    private final String f;

    private zzaf(zzfj zzfjVar, String str, String str2, String str3, long j, long j2, zzah zzahVar) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzahVar);
        this.f4924a = str2;
        this.b = str3;
        this.f = TextUtils.isEmpty(str) ? null : str;
        this.c = j;
        this.d = j2;
        long j3 = this.d;
        if (j3 != 0 && j3 > this.c) {
            zzfjVar.zzab().zzgn().zza("Event created with reverse previous/current timestamps. appId, name", zzef.a(str2), zzef.a(str3));
        }
        this.e = zzahVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaf(zzfj zzfjVar, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzah zzahVar;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.f4924a = str2;
        this.b = str3;
        this.f = TextUtils.isEmpty(str) ? null : str;
        this.c = j;
        this.d = j2;
        long j3 = this.d;
        if (j3 != 0 && j3 > this.c) {
            zzfjVar.zzab().zzgn().zza("Event created with reverse previous/current timestamps. appId", zzef.a(str2));
        }
        if (bundle != null && !bundle.isEmpty()) {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    zzfjVar.zzab().zzgk().zzao("Param name can't be null");
                    it.remove();
                } else {
                    Object a2 = zzfjVar.zzz().a(next, bundle2.get(next));
                    if (a2 == null) {
                        zzfjVar.zzab().zzgn().zza("Param value can't be null", zzfjVar.zzy().b(next));
                        it.remove();
                    } else {
                        zzfjVar.zzz().a(bundle2, next, a2);
                    }
                }
            }
            zzahVar = new zzah(bundle2);
        } else {
            zzahVar = new zzah(new Bundle());
        }
        this.e = zzahVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzaf a(zzfj zzfjVar, long j) {
        return new zzaf(zzfjVar, this.f, this.f4924a, this.b, this.c, j, this.e);
    }

    public final String toString() {
        String str = this.f4924a;
        String str2 = this.b;
        String valueOf = String.valueOf(this.e);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        sb.append("', params=");
        sb.append(valueOf);
        sb.append('}');
        return sb.toString();
    }
}
